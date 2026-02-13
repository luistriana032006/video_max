-- ============================================
-- IDENTIFICADOR AUTOMÁTICO DE RELACIONES JPA (CORREGIDO)
-- ============================================
-- Te dice qué tipo de relación usar en cada tabla
-- CORRIGE: Solo identifica tablas intermedias REALES (2 FKs + máx 3 columnas)

WITH tabla_fks AS (
    -- Contar cuántas FKs tiene cada tabla
    SELECT 
        tc.table_name,
        COUNT(*) as num_fks
    FROM information_schema.table_constraints tc
    WHERE tc.constraint_type = 'FOREIGN KEY'
      AND tc.table_schema = 'public'
    GROUP BY tc.table_name
),
tablas_intermedias AS (
    -- Identificar tablas intermedias REALES
    -- CORRECCIÓN: Agregar filtro por número de columnas
    SELECT t.table_name
    FROM tabla_fks t
    WHERE t.num_fks = 2
      AND (SELECT COUNT(*) 
           FROM information_schema.columns c 
           WHERE c.table_name = t.table_name 
             AND c.table_schema = 'public') <= 3  -- ← CORRECCIÓN AQUÍ
),
relaciones_base AS (
    SELECT
        tc.table_name AS tabla_origen,
        kcu.column_name AS columna_fk,
        ccu.table_name AS tabla_destino,
        ccu.column_name AS columna_destino,
        -- Verificar si la FK tiene constraint UNIQUE (OneToOne)
        EXISTS(
            SELECT 1 
            FROM information_schema.table_constraints tc2
            JOIN information_schema.key_column_usage kcu2 
                ON tc2.constraint_name = kcu2.constraint_name
            WHERE tc2.constraint_type = 'UNIQUE'
              AND kcu2.table_name = tc.table_name
              AND kcu2.column_name = kcu.column_name
        ) AS es_unique,
        -- Verificar si es tabla intermedia
        EXISTS(
            SELECT 1 
            FROM tablas_intermedias ti
            WHERE ti.table_name = tc.table_name
        ) AS es_intermedia
    FROM information_schema.table_constraints AS tc 
    JOIN information_schema.key_column_usage AS kcu
        ON tc.constraint_name = kcu.constraint_name
    JOIN information_schema.constraint_column_usage AS ccu
        ON ccu.constraint_name = tc.constraint_name
    WHERE tc.constraint_type = 'FOREIGN KEY'
      AND tc.table_schema = 'public'
)
SELECT 
    tabla_origen,
    columna_fk,
    tabla_destino,
    CASE 
        WHEN es_unique THEN '@OneToOne'
        WHEN es_intermedia THEN '@ManyToMany (tabla intermedia)'
        ELSE '@ManyToOne'
    END AS tipo_relacion,
    CASE 
        WHEN es_unique THEN 
            '// En ' || tabla_origen || E':\n@OneToOne\n@JoinColumn(name = "' || columna_fk || '")\nprivate ' || 
            initcap(tabla_destino) || ' ' || tabla_destino || ';'
        WHEN es_intermedia THEN 
            '// Tabla intermedia - Usar @OneToMany en ambas entidades'
        ELSE 
            '// En ' || tabla_origen || E':\n@ManyToOne\n@JoinColumn(name = "' || columna_fk || '")\nprivate ' || 
            initcap(tabla_destino) || ' ' || tabla_destino || ';'
    END AS codigo_sugerido,
    CASE 
        WHEN es_unique THEN 
            '// En ' || tabla_destino || E':\n@OneToOne(mappedBy = "' || tabla_destino || '")\nprivate ' || 
            initcap(tabla_origen) || ' ' || tabla_origen || ';'
        WHEN es_intermedia THEN 
            'Ver código en FilmActor y FilmCategory'
        ELSE 
            '// En ' || tabla_destino || E' (OPCIONAL):\n@OneToMany(mappedBy = "' || tabla_destino || '")\nprivate List<' || 
            initcap(tabla_origen) || '> ' || tabla_origen || 's;'
    END AS relacion_inversa
FROM relaciones_base
ORDER BY 
    CASE 
        WHEN es_intermedia THEN 3
        WHEN es_unique THEN 2
        ELSE 1
    END,
    tabla_origen,
    columna_fk;
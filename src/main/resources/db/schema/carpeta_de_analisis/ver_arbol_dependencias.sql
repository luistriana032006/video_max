-- ======================================
-- SCRIPT: Árbol completo de dependencias
-- Muestra qué tablas necesitas y qué necesitan esas tablas
-- ======================================

WITH RECURSIVE tabla_objetivo AS (
    SELECT 'rental'::text AS nombre_tabla  -- ← CAMBIA AQUÍ
),
dependencias AS (
    -- Nivel 1: Dependencias directas
    SELECT 
        tc.table_name AS tabla_actual,
        ccu.table_name AS tabla_necesaria,
        1 AS nivel,
        ARRAY[tc.table_name, ccu.table_name] AS ruta
    FROM information_schema.table_constraints tc
    JOIN information_schema.key_column_usage kcu 
        ON tc.constraint_name = kcu.constraint_name
    JOIN information_schema.constraint_column_usage ccu 
        ON ccu.constraint_name = tc.constraint_name
    CROSS JOIN tabla_objetivo
    WHERE tc.constraint_type = 'FOREIGN KEY'
      AND tc.table_schema = 'public'
      AND tc.table_name = tabla_objetivo.nombre_tabla
    
    UNION
    
    -- Niveles siguientes: Dependencias de las dependencias
    SELECT 
        tc.table_name,
        ccu.table_name,
        d.nivel + 1,
        d.ruta || ccu.table_name
    FROM dependencias d
    JOIN information_schema.table_constraints tc 
        ON tc.table_name = d.tabla_necesaria
    JOIN information_schema.key_column_usage kcu 
        ON tc.constraint_name = kcu.constraint_name
    JOIN information_schema.constraint_column_usage ccu 
        ON ccu.constraint_name = tc.constraint_name
    WHERE tc.constraint_type = 'FOREIGN KEY'
      AND tc.table_schema = 'public'
      AND d.nivel < 5  -- Límite de profundidad
      AND NOT (ccu.table_name = ANY(d.ruta))  -- Evita ciclos
)
SELECT DISTINCT
    nivel,
    REPEAT('  ', nivel - 1) || '→ ' || tabla_necesaria AS dependencia,
    CASE 
        WHEN nivel = 1 THEN '⚠️ Crear ANTES de tu tabla'
        WHEN nivel = 2 THEN '🔶 Crear antes de las dependencias nivel 1'
        ELSE '🔴 Dependencia profunda'
    END AS prioridad
FROM dependencias
ORDER BY nivel, tabla_necesaria;
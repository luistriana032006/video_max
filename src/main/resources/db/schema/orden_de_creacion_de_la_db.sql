-- Esta query te da el orden de creación (de menos a más dependencias)
WITH tabla_dependencias AS (
    SELECT 
        t.table_name,
        COUNT(tc.constraint_name) as num_fks
    FROM information_schema.tables t
    LEFT JOIN information_schema.table_constraints tc 
        ON t.table_name = tc.table_name 
        AND tc.constraint_type = 'FOREIGN KEY'
        AND tc.table_schema = 'public'
    WHERE t.table_schema = 'public' 
      AND t.table_type = 'BASE TABLE'
    GROUP BY t.table_name
)
SELECT 
    ROW_NUMBER() OVER (ORDER BY num_fks, table_name) as orden_creacion,
    table_name as tabla,
    num_fks as dependencias,
    CASE 
        WHEN num_fks = 0 THEN '✅ Crear PRIMERO'
        WHEN num_fks = 1 THEN '⚠️  Crear SEGUNDO'
        WHEN num_fks = 2 THEN '🔶 Crear TERCERO'
        ELSE '🔴 Crear AL FINAL'
    END as prioridad
FROM tabla_dependencias
ORDER BY num_fks, table_name;
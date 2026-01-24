WITH tabla_objetivo AS (
    SELECT 'staff'::text AS nombre_tabla  -- ← CAMBIA AQUÍ
),
tablas_creadas AS (
    -- Lista las tablas que YA creaste en Java
    SELECT 'actor' AS tabla
    UNION SELECT 'category'
    UNION SELECT 'country'
    UNION SELECT 'language'
    UNION SELECT 'payment'
    UNION SELECT 'address'
    UNION SELECT 'city'
    UNION SELECT 'store'
	UNION SELECT 'film'
	UNION SELECT 'film_actor'
	UNION SELECT 'inventory'
    -- ← AGREGA las que ya tienes
	
),
dependencias_necesarias AS (
    SELECT DISTINCT
        ccu.table_name AS tabla_necesaria
    FROM information_schema.table_constraints tc
    JOIN information_schema.key_column_usage kcu 
        ON tc.constraint_name = kcu.constraint_name
    JOIN information_schema.constraint_column_usage ccu 
        ON ccu.constraint_name = tc.constraint_name
    CROSS JOIN tabla_objetivo
    WHERE tc.constraint_type = 'FOREIGN KEY'
      AND tc.table_schema = 'public'
      AND tc.table_name = tabla_objetivo.nombre_tabla
),
verificacion AS (
    SELECT 
        dn.tabla_necesaria,
        CASE 
            WHEN tc.tabla IS NOT NULL THEN '✅ Ya la tienes'
            ELSE '❌ FALTA - Debes crearla primero'
        END AS estado
    FROM dependencias_necesarias dn
    LEFT JOIN tablas_creadas tc ON dn.tabla_necesaria = tc.tabla
)
SELECT 
    tabla_objetivo.nombre_tabla AS tabla_que_quieres_crear,
    CASE 
        WHEN COUNT(*) FILTER (WHERE estado LIKE '❌%') = 0 
        THEN '✅✅ SÍ PUEDES CREARLA AHORA ✅✅'
        ELSE '❌ NO - Te faltan ' || COUNT(*) FILTER (WHERE estado LIKE '❌%') || ' tabla(s)'
    END AS resultado
FROM tabla_objetivo
LEFT JOIN verificacion ON true
GROUP BY tabla_objetivo.nombre_tabla

UNION ALL

SELECT 
    'Dependencias:' AS detalle,
    STRING_AGG(tabla_necesaria || ' ' || estado, E'\n' ORDER BY tabla_necesaria) AS info
FROM verificacion;
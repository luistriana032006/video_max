-- ======================================
-- SCRIPT: ¿Qué tablas necesito crear ANTES?
-- USO: Cambia 'nombre_tabla' por la tabla que quieres crear
-- ======================================

-- Reemplaza 'film_actor' por la tabla que quieres verificar
WITH tabla_objetivo AS (
    SELECT 'film_actor'::text AS nombre_tabla  -- ← CAMBIA AQUÍ
)
SELECT 
    tc.table_name AS tabla_que_quiero_crear,
    kcu.column_name AS columna_fk,
    ccu.table_name AS tabla_que_necesito_primero,
    ccu.column_name AS columna_referenciada,
    '⚠️ Debes crear esta tabla PRIMERO' AS estado
FROM information_schema.table_constraints tc
JOIN information_schema.key_column_usage kcu 
    ON tc.constraint_name = kcu.constraint_name
JOIN information_schema.constraint_column_usage ccu 
    ON ccu.constraint_name = tc.constraint_name
CROSS JOIN tabla_objetivo
WHERE tc.constraint_type = 'FOREIGN KEY'
  AND tc.table_schema = 'public'
  AND tc.table_name = tabla_objetivo.nombre_tabla
ORDER BY ccu.table_name;
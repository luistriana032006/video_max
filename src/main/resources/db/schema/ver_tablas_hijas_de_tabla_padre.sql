-- ejemplo ver todas las tablas que dependen de "flim"
SELECT DISTINCT
    tc.table_name AS tabla_hija,
    kcu.column_name AS columna_fk
FROM information_schema.table_constraints tc
JOIN information_schema.key_column_usage kcu 
    ON tc.constraint_name = kcu.constraint_name
JOIN information_schema.constraint_column_usage ccu 
    ON ccu.constraint_name = tc.constraint_name
WHERE tc.constraint_type = 'FOREIGN KEY'
  AND ccu.table_name = 'film'  -- ← Cambia 'film' por la tabla que quieras
  AND tc.table_schema = 'public'
ORDER BY tc.table_name;
-- Ver FKs de TODAS las particiones de payment
SELECT DISTINCT
    tc.table_name AS particion,
    kcu.column_name AS columna_fk,
    ccu.table_name AS tabla_referenciada
FROM information_schema.table_constraints tc
JOIN information_schema.key_column_usage kcu 
    ON tc.constraint_name = kcu.constraint_name
JOIN information_schema.constraint_column_usage ccu 
    ON ccu.constraint_name = tc.constraint_name
WHERE tc.constraint_type = 'FOREIGN KEY'
  AND tc.table_name LIKE 'payment%'
ORDER BY tc.table_name, kcu.column_name;
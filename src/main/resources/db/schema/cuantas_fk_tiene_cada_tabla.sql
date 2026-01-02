-- contar cuantas FKs tiene cada tabla (nivel de dependendia)
SELECT 
    t.table_name AS tabla,
    COUNT(tc.constraint_name) AS cantidad_foreign_keys,
    CASE 
        WHEN COUNT(tc.constraint_name) = 0 THEN 'NIVEL 0 - PADRE (Sin dependencias)'
        WHEN COUNT(tc.constraint_name) = 1 THEN 'NIVEL 1 - Depende de 1 tabla'
        WHEN COUNT(tc.constraint_name) = 2 THEN 'NIVEL 2 - Depende de 2 tablas'
        ELSE 'NIVEL 3+ - Alta dependencia'
    END AS nivel_dependencia
FROM information_schema.tables t
LEFT JOIN information_schema.table_constraints tc 
    ON t.table_name = tc.table_name 
    AND tc.constraint_type = 'FOREIGN KEY'
    AND tc.table_schema = 'public'
WHERE t.table_schema = 'public' 
  AND t.table_type = 'BASE TABLE'
GROUP BY t.table_name
ORDER BY cantidad_foreign_keys ASC, t.table_name;
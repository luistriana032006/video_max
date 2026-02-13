-- Identificar tablas intermedias REALES este si es 
SELECT 
    t.table_name,
    COUNT(tc.constraint_name) as num_fks,
    -- Contar columnas totales
    (SELECT COUNT(*) 
     FROM information_schema.columns c 
     WHERE c.table_name = t.table_name 
       AND c.table_schema = 'public') as total_columnas
FROM information_schema.tables t
LEFT JOIN information_schema.table_constraints tc 
    ON t.table_name = tc.table_name 
    AND tc.constraint_type = 'FOREIGN KEY'
    AND tc.table_schema = 'public'
WHERE t.table_schema = 'public' 
  AND t.table_type = 'BASE TABLE'
GROUP BY t.table_name
HAVING COUNT(tc.constraint_name) = 2
   AND (SELECT COUNT(*) 
        FROM information_schema.columns c 
        WHERE c.table_name = t.table_name 
          AND c.table_schema = 'public') <= 3  -- Solo 2 FKs + last_update
ORDER BY t.table_name;

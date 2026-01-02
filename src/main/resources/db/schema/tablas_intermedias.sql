-- identificador de tablas intermedias
SELECT
tc.table_name,
COUNT(*) as cantidad_fks
FROM information_schema.table_constraints tc
WHERE tc.constraint_type = 'FOREIGN KEY'
and tc.table_schema = 'public'
GROUP BY tc.table_name
HAVING COUNT(*) >= 2
ORDER BY cantidad_fks DESC;

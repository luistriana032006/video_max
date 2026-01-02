-- tablas que no tienen foreign keys tablas independientes 
SELECT t.table_name as tabla_padre
FROM information_schema.tables t
WHERE t.table_schema = 'public'
AND t.table_type = 'BASE TABLE'
AND NOT EXISTS(
select 1
FROM information_schema.table_constraints tc
WHERE tc.table_name = t.table_name
and tc.constraint_type = 'FOREIGN KEY'
and tc.table_schema = 'public'
)
ORDER BY t.table_name;
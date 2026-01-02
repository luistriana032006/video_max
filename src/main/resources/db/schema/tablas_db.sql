-- SCRIPT PARA MIRAR TODAS LAS TABLAS
select table_name
FROM information_schema.tables
WHERE table_schema = 'public'
ORDER BY table_name;
/*
este script genera un mapeo de todas las tablas de la DB

*/
-- ver columnas de una tabla especifica
SELECT 
column_name,
data_type,
is_nullable,
column_default
FROM information_schema.columns
WHERE table_name= 'film' -- aca va el nombre de la tabla que queremos ver
ORDER BY ordinal_position;
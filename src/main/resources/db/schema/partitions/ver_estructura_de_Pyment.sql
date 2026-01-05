-- Ver columnas y sus tipos
SELECT 
    column_name,
    data_type,
    is_nullable
FROM information_schema.columns
WHERE table_name = 'payment'
ORDER BY ordinal_position;
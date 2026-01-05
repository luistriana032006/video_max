-- Ver la tabla principal y sus particiones
SELECT 
    schemaname,
    tablename,
    CASE 
        WHEN tablename = 'payment' THEN 'TABLA PADRE (particionada)'
        ELSE 'PARTICIÓN'
    END as tipo
FROM pg_tables
WHERE tablename LIKE 'payment%'
  AND schemaname = 'public'
ORDER BY tablename;
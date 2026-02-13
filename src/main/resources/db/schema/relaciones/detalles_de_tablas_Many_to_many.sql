-- ============================================
-- DETALLES DE RELACIONES MANYTOMANY
-- ============================================
-- Muestra cómo configurar @ManyToMany

WITH tablas_intermedias AS (
    SELECT 
        tc.table_name,
        COUNT(*) as num_fks
    FROM information_schema.table_constraints tc
    WHERE tc.constraint_type = 'FOREIGN KEY'
      AND tc.table_schema = 'public'
    GROUP BY tc.table_name
    HAVING COUNT(*) = 2
)
SELECT 
    ti.table_name AS tabla_intermedia,
    
    -- Primera FK
    (SELECT ccu.table_name 
     FROM information_schema.table_constraints tc
     JOIN information_schema.constraint_column_usage ccu 
         ON tc.constraint_name = ccu.constraint_name
     WHERE tc.table_name = ti.table_name 
       AND tc.constraint_type = 'FOREIGN KEY'
     LIMIT 1) AS tabla_1,
    
    (SELECT kcu.column_name 
     FROM information_schema.table_constraints tc
     JOIN information_schema.key_column_usage kcu 
         ON tc.constraint_name = kcu.constraint_name
     WHERE tc.table_name = ti.table_name 
       AND tc.constraint_type = 'FOREIGN KEY'
     LIMIT 1) AS columna_1,
    
    -- Segunda FK
    (SELECT ccu.table_name 
     FROM information_schema.table_constraints tc
     JOIN information_schema.constraint_column_usage ccu 
         ON tc.constraint_name = ccu.constraint_name
     WHERE tc.table_name = ti.table_name 
       AND tc.constraint_type = 'FOREIGN KEY'
     OFFSET 1 LIMIT 1) AS tabla_2,
    
    (SELECT kcu.column_name 
     FROM information_schema.table_constraints tc
     JOIN information_schema.key_column_usage kcu 
         ON tc.constraint_name = kcu.constraint_name
     WHERE tc.table_name = ti.table_name 
       AND tc.constraint_type = 'FOREIGN KEY'
     OFFSET 1 LIMIT 1) AS columna_2,
    
    '// En una de las entidades principales:
@ManyToMany
@JoinTable(
    name = "' || ti.table_name || '",
    joinColumns = @JoinColumn(name = "..."),
    inverseJoinColumns = @JoinColumn(name = "...")
)
private List<...> ...;' AS codigo_ejemplo

FROM tablas_intermedias ti
ORDER BY ti.table_name;
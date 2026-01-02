"Necesitamos una API REST moderna que permita gestionar nuestro catálogo de películas, clientes, y alquileres. Queremos migrar de nuestro sistema legacy (la BD Pagila que ya tenemos) a una arquitectura de microservicios que permita a nuestros clientes acceder desde web y móvil."

🎯 Objetivos del MVP (Fase 1):

Catálogo de Películas

Los clientes deben poder buscar películas por título, categoría, actor
Ver detalles completos de cada película
Filtrar por rating, año de lanzamiento


Sistema de Alquiler

Clientes pueden rentar películas
Ver su historial de alquileres
Sistema de devoluciones


Gestión de Clientes

Registro de nuevos clientes
Perfil del cliente con datos de contacto
Historial de pagos


Reportes (Bonus)

Top 10 películas más rentadas
Películas disponibles en inventario
Clientes morosos (alquileres sin devolver)




📊 Alcance Técnico:

Backend: API REST en Spring Boot
Base de datos: PostgreSQL (Pagila - ya existente)
Autenticación: Para fase 2 (por ahora endpoints públicos)
Frontend: Para fase 2 (primero solo API)
Documentación: Swagger/OpenAPI obligatorio


🚦 Entregables Esperados:
Sprint 1 (Semana 1-2):

CRUD completo de Películas
Búsqueda y filtros de películas
Endpoint para listar actores

Sprint 2 (Semana 3):

Sistema de alquiler (crear rental)
Consultar disponibilidad de películas
Historial de alquileres por cliente

Sprint 3 (Semana 4):

CRUD de clientes
Sistema de pagos
Reportes básicos

Sprint 4 (Bonus):

Documentación completa
Testing
Deploy en contenedor Docker


💼 Casos de Uso Críticos:

Como cliente, quiero buscar "Matrix" y ver todas las películas relacionadas
Como cliente, quiero rentar "The Godfather" por 3 días
Como administrador, quiero ver qué películas están más solicitadas
Como cliente, quiero ver mi historial de alquileres y cuánto he gastado
Como administrador, quiero saber qué clientes tienen alquileres vencidos


🎨 Reglas de Negocio Importantes:

Una película solo se puede rentar si hay inventario disponible
Período de alquiler: 3-7 días (según categoría)
Multa por retraso: $1.500 COP por día
Un cliente puede tener máximo 5 alquileres activos simultáneos
Las películas se clasifican por rating: G, PG, PG-13, R, NC-17


🔧 Limitaciones Técnicas:

No modificar el schema de la BD Pagila (es legacy)
La BD ya tiene datos de prueba, no borrarlos
Todos los endpoints deben retornar JSON
Códigos HTTP correctos (200, 201, 404, 400, etc.)
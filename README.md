# 🧠 Fórum Hub - API REST con Spring Boot

Fórum Hub es una API REST construida con Spring Boot que simula el backend de un foro educativo, permitiendo gestionar temas (tópicos), usuarios, autenticación con JWT y más.

---

## 🚀 Funcionalidades implementadas

- ✅ Registro de tópicos (POST)
- ✅ Listado paginado y ordenado de tópicos (GET)
- ✅ Actualización de tópicos (PUT)
- ✅ Eliminación de tópicos (DELETE)
- ✅ Consulta de un tópico por ID (GET)
- ✅ Autenticación de usuarios con JWT (POST /login)
- ✅ Seguridad con Spring Security
- ✅ Manejo de errores personalizados
- ✅ Validaciones con Jakarta Bean Validation
- ✅ Control de acceso a endpoints según autenticación

---

## 🛠️ Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Security**
- **Spring Data JPA**
- **Hibernate**
- **JWT (Auth0 Java JWT)**
- **Maven**
- **PostgreSQL**
- **Lombok**
- **MapStruct**
- **Postman (para pruebas)**

---

## 📦 Estructura del proyecto

src
└── main
├── java
│ └── com.foro.hub
│ ├── controller
│ ├── domain
│ ├── repository
│ ├── security
│ ├── service
│ └── dto
└── resources
└── application.properties

---

## 🔐 Seguridad

La seguridad está implementada usando Spring Security y JWT. Solo los usuarios autenticados pueden acceder a los endpoints protegidos. Se aplica control de acceso para que solo ciertos endpoints estén públicos (como `/login`), y todos los demás requieren un token válido.

El token debe incluirse en el header de las peticiones autenticadas como:

Authorization: Bearer <token>

yaml
Copiar
Editar

---

## 🎯 Buenas prácticas aplicadas

- Principios **SOLID** en diseño de servicios y controladores.
- Separación de responsabilidades por capas.
- DTOs para desacoplar el dominio del API.
- Validaciones a nivel de entrada con `@Valid`.
- Uso de MapStruct para transformación de entidades ↔ DTOs.
- Configuración de `ExceptionHandler` para errores limpios y claros.
- Expiración de tokens y validación automática en cada request mediante filtros personalizados.

---

## 🧪 ¿Cómo probar la API?

Usa herramientas como **Postman** o **Insomnia** para enviar solicitudes a los endpoints. 

1. Autenticarse con un usuario válido en `/login`
2. Copiar el token JWT de la respuesta
3. Enviar el token en el header `Authorization` para interactuar con endpoints protegidos.

---

## 👩‍💻 Desarrollado por

Natalia Muñoz – Desarrolladora Java Junior 💛  

---

## 📝 Licencia

Este proyecto es de uso académico y con fines de aprendizaje.

---

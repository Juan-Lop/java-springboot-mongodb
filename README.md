# Demostraciones
## Crear Vehiculo

![WhatsApp Image 2025-11-19 at 5 50 03 PM](https://github.com/user-attachments/assets/a51242b1-fe29-4773-aec9-b248a3cf9323)
## Obtener Todos Los Vehiculos

![WhatsApp Image 2025-11-19 at 5 52 44 PM](https://github.com/user-attachments/assets/742ae1a5-e3e8-4cbb-bf2e-217186b22089)

## Obtener UN Vehículo por ID

![WhatsApp Image 2025-11-19 at 5 53 53 PM](https://github.com/user-attachments/assets/4c755aa4-9609-4570-bd90-5ce374832c9b)

## Actualizar un Vehículo

![WhatsApp Image 2025-11-19 at 5 55 22 PM](https://github.com/user-attachments/assets/6c8b7623-4a6f-4fa5-9762-abb267349d4d)

## Eliminar un Vehículo

![WhatsApp Image 2025-11-19 at 5 56 14 PM](https://github.com/user-attachments/assets/825c9a02-57c1-4929-9fcf-04161b8a1632)

## MongodbAtlas

![WhatsApp Image 2025-11-19 at 5 56 59 PM](https://github.com/user-attachments/assets/6300df92-ee07-4b6e-bea7-2a3f854ee3e7)


# 🚗 API REST de Vehículos

Proyecto académico de una API REST para gestionar un catálogo de vehículos usando Spring Boot y MongoDB Atlas.

## 📋 Descripción

Este es un proyecto CRUD simple que permite crear, leer, actualizar y eliminar vehículos. Fue desarrollado como proyecto académico para practicar Spring Boot y bases de datos NoSQL.

## ✨ Características

- ✅ CRUD completo de vehículos
- 🔐 Validaciones de datos
- 📊 Base de datos MongoDB Atlas
- 🌐 API REST con JSON

## 🛠️ Tecnologías

- Java 17
- Spring Boot 3.2.0
- MongoDB Atlas
- Maven

## 📦 Requisitos

- Java 17 o superior
- Maven
- Cuenta en MongoDB Atlas (gratuita)

## 🚀 Instalación

1. Clonar el repositorio:
```bash
git clone https://github.com/tu-usuario/api-vehiculos-springboot.git
cd api-vehiculos-springboot
```

2. Instalar dependencias:
```bash
mvn clean install
```

## ⚙️ Configuración

### Configurar MongoDB Atlas

1. Crea una cuenta en [MongoDB Atlas](https://www.mongodb.com/cloud/atlas)
2. Crea un cluster gratuito (M0)
3. En **Security → Database Access**: Crea un usuario con contraseña
4. En **Security → Network Access**: Agrega tu IP o `0.0.0.0/0`
5. En **Connect**: Copia tu connection string

### Configurar la aplicación

Edita `src/main/resources/application.properties`:

```properties
server.port=8080
spring.data.mongodb.uri=mongodb+srv://usuario:password@cluster0.xxxxx.mongodb.net/vehiculosDB?retryWrites=true&w=majority
```

Reemplaza `usuario`, `password` y `cluster0.xxxxx` con tus datos.

## 🏃 Ejecutar la aplicación

```bash
mvn spring-boot:run
```

La API estará disponible en: `http://localhost:8080`

## 📡 Endpoints

**URL Base:** `http://localhost:8080/api/vehiculos`

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/vehiculos` | Obtener todos los vehículos |
| GET | `/api/vehiculos/{id}` | Obtener un vehículo |
| POST | `/api/vehiculos` | Crear vehículo |
| PUT | `/api/vehiculos/{id}` | Actualizar vehículo |
| DELETE | `/api/vehiculos/{id}` | Eliminar vehículo |

## 🧪 Ejemplos de Uso

### Crear un Vehículo (POST)

```bash
POST http://localhost:8080/api/vehiculos
Content-Type: application/json

{
  "marca": "Toyota",
  "modelo": "Corolla",
  "año": 2023,
  "color": "Blanco",
  "placa": "ABC123",
  "precio": 25000,
  "estado": "Nuevo"
}
```

### Obtener Todos (GET)

```bash
GET http://localhost:8080/api/vehiculos
```

### Actualizar (PUT)

```bash
PUT http://localhost:8080/api/vehiculos/{id}
Content-Type: application/json

{
  "precio": 23000
}
```

### Eliminar (DELETE)

```bash
DELETE http://localhost:8080/api/vehiculos/{id}
```

## 📁 Estructura del Proyecto

```
src/main/java/com/vehiculos/
├── ApiVehiculosApplication.java    # Clase principal
├── controller/
│   └── VehiculoController.java     # Endpoints REST
├── service/
│   └── VehiculoService.java        # Lógica de negocio
├── repository/
│   └── VehiculoRepository.java     # Acceso a datos
├── model/
│   └── Vehiculo.java               # Modelo/Entidad
└── exception/
    ├── ResourceNotFoundException.java
    ├── DuplicateResourceException.java
    └── GlobalExceptionHandler.java
```

## 👨‍💻 Autor

Juan Camilo - Proyecto Académico

---

⭐ Si te sirvió este proyecto, dale una estrella en GitHub!

# Proyecto de Consulta DPA

Este proyecto está desarrollado utilizando Java 21 y Maven con Spring Boot para el backend, y React Native para el frontend. Se trata de un sistema para la consulta de datos de División Político Administrativa (DPA) por provincia, cantón y parroquia. El frontend consume esta API para mostrar la información correspondiente en función de los selectores utilizados por el usuario.

## Ejecución con Docker

Para ejecutar este proyecto utilizando Docker, asegúrate de tener Docker y Docker Compose instalados en tu sistema. Luego, sigue estos pasos:

1. Clona el repositorio del proyecto.
2. Navega hasta la raíz del proyecto en tu terminal.
3. Ejecuta el comando `docker-compose up`.

Esto construirá y levantará los contenedores necesarios para el backend y el frontend. Una vez completado, podrás acceder a la aplicación a través de tu navegador.

## Despliegue Local con Spring Boot y React

Si prefieres ejecutar el proyecto localmente sin Docker, puedes seguir estos pasos:

### Backend

1. Asegúrate de tener Java 21 y Maven instalados.
2. Navega hasta la carpeta `bcknd-dashboard` en tu terminal.
3. Ejecuta `mvnw spring-boot:run` para iniciar el servidor de backend. El servidor estará disponible en `http://localhost:8080`.

### Frontend

1. Asegúrate de tener Node.js y npm instalados.
2. Navega hasta la carpeta `frntnd-dashboard` en tu terminal.
3. Ejecuta `npm install` para instalar las dependencias del proyecto.
4. Ejecuta `npm start` para iniciar el servidor de desarrollo de React. El frontend estará disponible en `http://localhost:3000`.

Siguiendo estos pasos, tendrás tanto el backend como el frontend ejecutándose localmente en tu máquina.
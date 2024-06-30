# ForoAlura


ForoAlura es una API REST que permite la creación de temas los cuales constan de un mensaje, nombre de curso, título, autor y fecha de creación. La API permine loguearse y crear un JSON Web Token para la verificación de los usuarios y que estos puedan crear, actualizar, ver y borrar los temas una vez autenticados.

## Tabla de Contenidos

- [Uso](#uso)
- [Ejemplo](#ejemplo)
- [Autor](#autor)

### Uso

API Rest
* Abrir IntelliJ IDEA y ejecutar el archivo "Application".
* Ejecutar Postman o Insomnia y crear métodos para acceder a la URL http://localhost:8080/topicos
* Generar el JSON Web Token a través de un POST en la url http://localhost:8080/login con el login y clave.
* Ingresar el Token en cada petición (Ver ejemplo).


#### Ejemplo
**1-Realizar Login**
```bash
-Crear método POST y acceder a http://localhost:8080/login y enviar el JSON: 
{
	"login":"william",
	"clave":"123456"
}
```
**2-Ver Tópicos**
```bash
-Crear método GET y acceder a http://localhost:8080/topicos y enviarla petición.
-Respuesta: 
"content": [
		{
			"id": 1,
			"mensaje": "Programación Funcional",
			"nombreCurso": "Java",
			"titulo": "Java Funcional",
			"autor": "Liam",
			"fechaCreacion": "2024-06-22T15:59:15"
		},
```
**3-Crear Tópico**
```bash
-Crear método POST y acceder a http://localhost:8080/topicos y enviar el JSON:
{
			"mensaje": "Programación Funcional",
			"nombreCurso": "Java",
			"titulo": "Java Funcional",
			"autor": "Liam"
}
```
**4-Actualizar Tópico**
```bash
-Crear método PUT y acceder a http://localhost:8080/topicos/(id a actualizar) y enviar el JSON:
{
			"mensaje": "Programación Funcional (Actualización)",
			"nombreCurso": "Java",
			"titulo": "Java Funcional",
			"autor": "Liam"
}
```
**5-Borrar Tópico**
```bash
-Crear método DELETE y acceder a http://localhost:8080/topicos/(id a borrar) y enviar la petición.
```
**Autor:**
*William Munguia M.*

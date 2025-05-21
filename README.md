



# Prueba Backend

## TABLA USUARIOS
### Descripción
Agregar un nuevo usuario a la base de datos, el cual debe contener los siguientes campos:

```json
{
    "run": "20.790.413-9",
    "nombres": "Bastian Alfredo",
    "apellidos": "Millañir Arce",
    "fechaNacimiento": "2001-11-05",
    "email": "prueba@gmail.com",
    "userId": {
        "id": 1 // DEBE SER UN ID DE UN TIPO DE USUARIO YA CREADO
    }
}
```

## TABLA TIPOS DE USUARIO
### Descripción
Agregar un nuevo tipo de usuario a la base de datos, el cual debe contener los siguientes campos:

```json
{
    "id": 1, // no es necesario enviarlo, porque es autoincremental
    "nombre": "Administrador"
}
```


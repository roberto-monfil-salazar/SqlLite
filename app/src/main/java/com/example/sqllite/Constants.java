package com.example.sqllite;

public class Constants {

    // nombre de la base de datos
    public static final String DB_NAME = "BD01";
    // db version

    public static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "Peliculas";

    // Definir campos de la tabla
    public static final String C_ID = "ID";
    public static final String C_Pelicula = "Pelicula";
    public static final String C_IMAGE = "IMAGE";
    public static final String C_Director = "Director";
    public static final String C_Actor = "Actor";
    public static final String C_Duracion = "Duracion";
    public static final String C_Precio = "Precio";
    public static final String C_DESCRIPTION = "DESCRIPTION";

    // Crear consultas de tabla
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + C_Pelicula + " TEXT,"
            + C_IMAGE + " TEXT,"
            + C_Director+ " TEXT,"
            + C_Actor + " TEXT,"
            + C_Duracion + " TEXT,"
            + C_Precio + " TEXT,"
            + C_DESCRIPTION + " TEXT"
            + ")";

    // CREATE TABLE PRODUCTS(
    //      ID INT NOT NULL AUTO_INCREMENT,
    //        ...
    //        PRIMARY KEY(ID)
    // );
}
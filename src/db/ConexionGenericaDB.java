/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;


/**
 *
 * @author camila
 */
public abstract class ConexionGenericaDB {

    //Parametros que debemos dar a la conexion a cualquier base de datos mediante JDBC
    protected String jdbc;
    protected String driverClass;
    protected String host;
    protected String port;
    protected String database;
    protected String opciones;
    protected String url;
    protected String username;
    protected String password;

    //Objetos conexion a la base de datos
    protected Connection conexion;
    protected DatabaseMetaData databaseMetadata;    
    
    
    public ConexionGenericaDB(String jdbc, String driverClass, String host, String port, String database, String opciones, String username, String password)  throws java.lang.ClassNotFoundException, java.lang.InstantiationException, java.lang.IllegalAccessException, java.sql.SQLException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException
    {
        this.jdbc = jdbc; 
        this.driverClass = driverClass; 
        this.host = host; 
        this.port = port;
        this.database = database; 
        this.opciones = opciones;
        this.url = jdbc + host + ":" + port + "/" + database + opciones;  
        this.username = username; 
        this.password = password;
        Class.forName(driverClass).getDeclaredConstructor().newInstance();
    }
    
    public Connection getConexion()
    {
        return this.conexion;
    }
    
    public abstract void testearSQL();
    
}
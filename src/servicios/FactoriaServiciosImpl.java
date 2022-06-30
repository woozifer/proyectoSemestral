/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import db.ConexionGenericaDB;

/**
 *
 * @author camila
 */
public class FactoriaServiciosImpl implements FactoriaServiciable {
    private String motor;
    private boolean DEBUG = true;

    //Singleton
    private static FactoriaServiciosImpl factoriaServicios; 
    private static ConexionGenericaDB conexionGenericaDB;
    
    
    public void setMotor(String motor)       
    {
        this.motor = motor;
    }
    
 
    public synchronized static FactoriaServiciosImpl getFactoria()
    {
        //patron singleton
        if (factoriaServicios == null)
        {
            factoriaServicios = new FactoriaServiciosImpl();
        }
        return factoriaServicios;
    }
    
     
    @Override
    public synchronized  ConexionGenericaDB getConexionDB() throws java.lang.ClassNotFoundException, java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.Exception
    {
        //patron singleton
        if (conexionGenericaDB == null)
        {
            //Patron factoria
            //"esconde el new a LoginApp.java
            //Controla la creacion de instancias
            switch (this.motor)
            {
                case "mysql"    : conexionGenericaDB = (ConexionGenericaDB) Class.forName("db.ConexionMySql").newInstance();  //Netbeans 8.2
                                  //conexionGenericaDB = (ConexionGenericaDB) Class.forName("db.ConexionMySql").getDeclaredConstructor().newInstance();
                                  break;
                case "oracle"   :               
                                  //conexionGenericaDB = (ConexionGenericaDB) Class.forName("db.ConexionOracleXE").newInstance(); //Netbeans 11
                                  conexionGenericaDB = (ConexionGenericaDB) Class.forName("db.ConexionOracleXE").getDeclaredConstructor().newInstance();
                                  break;
            }
        }
        return conexionGenericaDB;
    }
    
    
    public boolean isDEBUG()
    {
        return this.DEBUG;
    }
}
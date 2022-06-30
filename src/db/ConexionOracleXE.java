/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author camila
 */
public final class ConexionOracleXE extends ConexionGenericaDB
{
    
    public ConexionOracleXE() throws java.lang.ClassNotFoundException, java.lang.InstantiationException, java.lang.IllegalAccessException, java.sql.SQLException, java.lang.Exception
    {
        this("jdbc:oracle:thin:@", "oracle.jdbc.driver.OracleDriver", "localhost", "1521", "XE", "", "leo", "leo");
    } 
    

    public ConexionOracleXE(String jdbc, String driverClass, String host, String port, String database, String opciones, String username, String password) throws java.lang.ClassNotFoundException, java.lang.InstantiationException, java.lang.IllegalAccessException, java.sql.SQLException, java.lang.Exception
    {
        super(jdbc, driverClass, host, port, database, opciones, username, password);
        conexion = DriverManager.getConnection(super.url, username, password);
        databaseMetadata = conexion.getMetaData();
    }
    
    
    public void testearSQL() {
        PreparedStatement ps = null;
        try
        {
            String query = "select ...";
            ps = this.conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            //La idea es hacer select a una tabla del catalog de la BD oracle        
            System.out.println("void ConexionOracleXE.testSqlSelect()");
            System.out.println("-----------------------------------");
            
            while (rs.next())
            {
                String columna = rs.getNString("?");

                System.out.println(columna);
            }
            
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ConexionOracleXE.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
           if (ps != null)
           {
               try
               {
                   ps.close();
               }
               catch (SQLException ex)
               {
                   Logger.getLogger(ConexionOracleXE.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
        }
    }

}

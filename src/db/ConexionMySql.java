/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;


import dao.CrudDAOable;
import dao.UsuarioDAOImpl;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;


/**
 *
 * @author camila
 */
public final class ConexionMySql extends ConexionGenericaDB
{
    
    public ConexionMySql() throws java.lang.ClassNotFoundException, java.lang.InstantiationException, java.lang.IllegalAccessException, java.sql.SQLException, java.lang.Exception
    {
        this("jdbc:mysql://", "com.mysql.jdbc.Driver", "localhost", "3306"     , "proyectoSemestral"        , "?charSet=LATIN1", "root"         , "");
     } 
    

    public ConexionMySql(String jdbc, String driverClass, String host, String port, String database, String opciones, String username, String password) throws java.lang.ClassNotFoundException, java.lang.InstantiationException, java.lang.IllegalAccessException, java.sql.SQLException, java.lang.Exception
    {
        super(jdbc, driverClass, host, port, database, opciones, username, password);
        super.conexion = DriverManager.getConnection(super.url, username, password);
        super.databaseMetadata = conexion.getMetaData();
    }
    
    
    public void testearSQL() {
        String query = "";
        PreparedStatement ps = null;
        try
        {
            //delete all
            System.out.println("Borrando todos los usuarios de la tabla usuario");
            query = "delete from usuario;";
            ps = super.conexion.prepareStatement(query);
            ps.executeUpdate();
            
            //-Inicio CRUD------------------------------------------------------
            
            //Create
            System.out.println("Creando un usuario");
            Usuario usuario = new Usuario();
            usuario.setLogin("lhernandez");
            usuario.setPassword("password");
            
            CrudDAOable<Usuario> usuarioDAO = new UsuarioDAOImpl();
            usuarioDAO.create(usuario);
            
            //Read x 3
            System.out.println("Reads x 3");
            if (usuarioDAO.read(usuario))
            {
                System.out.println("Existe el usuario " + usuario +  " en la base de datos");
            }
            
            
            System.out.println("Todos los usuarios:");
            ArrayList<Usuario> arlst = usuarioDAO.read();
            for (Usuario usuario1 : arlst) {
                System.out.println(usuario1);
            }
            
            System.out.println("Usuarios que cumplen con condicion en el where:");
            arlst = usuarioDAO.readWhere("where login = '" + usuario.getLogin() + "'");
            for (Usuario usuario1 : arlst) {
                System.out.println(usuario1);
            }
            
            //Update
            System.out.println("Update");
            usuario.setPassword("wordpass");
            usuarioDAO.update(usuario);
            
            System.out.println("Probando que el update se haya realizado correctamente");
            arlst = usuarioDAO.readWhere("where login = '" + usuario.getLogin() + "' and password = 'wordpass'");
            for (Usuario usuario1 : arlst) {
                System.out.println(usuario1);
            }
            
            
            //delete
            System.out.println("Probando borrado de un usuario");
            usuarioDAO.delete(usuario);
            
            
            
            //-Fin-CRUD---------------------------------------------------------
            
            //select all
            System.out.println("Mostrando usuarios:");
            query = "select * from usuario;";
            ps = super.conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                String login = rs.getString("login");
                String password = rs.getString("password");
                
                System.out.println(login + " " + password);
            } 
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ConexionMySql.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (InstantiationException | IllegalAccessException ex)
        {
            Logger.getLogger(ConexionMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (Exception ex)
        {
            Logger.getLogger(ConexionMySql.class.getName()).log(Level.SEVERE, null, ex);
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
                   Logger.getLogger(ConexionMySql.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
        }
    }    
    
    
        
    
}

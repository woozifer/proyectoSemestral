/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapp;

import controlador.Controlador;
import db.ConexionMySql;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Usuario;
import servicios.*;
import vista.Login;

/**
 *
 * @author camila
 */
public class LoginApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IllegalAccessException, Exception {
       
        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
            System.out.println("Modo depuracion ON");
        }
        else
        {
            System.out.println("Modo depuracion OFF");
        }
        
        
        try
        {
            //Mysql
            FactoriaServiciosImpl.getFactoria().setMotor("mysql");
            ConexionMySql cbd = (ConexionMySql)FactoriaServiciosImpl.getFactoria().getConexionDB();
            
            //Oracle
            //FactoriaServiciosImpl.getFactoria().setMotor("oracle");
            //ConexionOracleXE cbd = (ConexionOracleXE)FactoriaServiciosImpl.getFactoria().getConexionDB();
            /*
            if (FactoriaServiciosImpl.getFactoria().isDEBUG())
            {
                cbd.testearSQL();
            }*/
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(LoginApp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "LoginApp ERROR", 0, null);
        }
        /*catch (com.mysql.jdbc.exceptions.jdbc4.CommunicationsException | com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException   ex)
        {
            Logger.getLogger(LoginApp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "LoginApp ERROR", 0, null);
            JOptionPane.showMessageDialog(null, "Sistema sale con codigo de error 1, Chequee que el servidor de base de datos este arriba y la base de datos creada.", "LoginApp ERROR", 0, null);
            System.out.println("Sistema sale con codigo de error 1 :" + ex.getMessage());
            System.exit(1);
        }        */
        catch (InstantiationException | IllegalAccessException | java.lang.reflect.InvocationTargetException ex)
        {
            Logger.getLogger(LoginApp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "LoginApp ERROR", 0, null);
        }
        catch (Exception ex)
        {
            Logger.getLogger(LoginApp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "LoginApp ERROR", 0, null);
        }
        
        
        
        /*
        Vista vista = new Vista();
        Usuario modelo = new Usuario();
        
        Controlador c = new Controlador(vista, modelo);
        c.logearse();
        */

        Login vistaLogin = new Login();          
        Usuario modelo = new Usuario();
        Controlador c = new Controlador(vistaLogin, modelo);
        c.inicializar();

    }
    
}

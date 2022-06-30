/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.CrudDAOable;
import dao.UsuarioDAOImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;
import vista.Login;
import vista.Menu;
import vista.Vista;

/**
 *
 * @author camila
 */
public class Controlador {
    Login vista;
    private Usuario modelo;
   
    
    public Controlador(Login v, Usuario m)
    {
        this.vista = v;
        this.modelo = m;        
    }
    
    
     public void inicializar() throws InstantiationException, IllegalAccessException, Exception
    {
        
        this.vista.getjButton1().addActionListener( e-> {
            try {
                login();
            } catch (Exception ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.vista.setVisible(true);
        
        
        
    }
     
     public void login() throws IllegalAccessException, Exception
     {
         String login = this.vista.getjTextField1().getText();
         String pass = this.vista.getjTextField2().getText();
         
         this.modelo.setLogin(login);
         this.modelo.setPassword(pass);
         
         if (this.modelo.logearse())
         {
             this.vista.imprimirExito();
             Menu m = new Menu();    
             m.setVisible(true);
             
         }
         else
         {
             this.vista.imprimirFracaso();  
             Menu m = new Menu(); 
             m.setVisible(false);
         }   
     }

}

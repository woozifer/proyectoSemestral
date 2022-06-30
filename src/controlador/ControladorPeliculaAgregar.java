/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Categoria;
import modelo.Excepcion;
import modelo.Pelicula;
import servicios.FactoriaServiciosImpl;
import vista.PeliculaAgregar;
/**
 *
 * @author sebas
 */
public class ControladorPeliculaAgregar {
    PeliculaAgregar vista;
    private Pelicula modelo;

    public ControladorPeliculaAgregar(PeliculaAgregar v, Pelicula m)
    {
        this.vista = v;
        this.modelo = m;
    }
    
    
    public void inicializar() throws InstantiationException, IllegalAccessException, Exception
    {  
        
        
        Categoria mc = new Categoria();
        ArrayList categorias = mc.read();
        this.vista.cargarCategorias(categorias);
       
        
        this.vista.getjButton1().addActionListener( e-> {
            try {
                System.out.println("Agregando listener y evento");
                create();
            } catch (Exception ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.vista.setVisible(true);
    }
    
    public void create()
    {
        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
            System.out.println(this.getClass().getCanonicalName() + " entrando a create()");
        }

        try
        {
            //int id = Integer.parseInt(this.vista.getjTextField1().getText());
            String nombre = this.vista.getjTextField2().getText();
            
                      
            String fechaLanzamientoString = this.vista.getjTextField3().getText();
            SimpleDateFormat procesadorDeFechasStringGringo = new SimpleDateFormat ("yyyy-MM-dd");
            Date fechaLanzamientoTipoDate=null; 
            fechaLanzamientoTipoDate = procesadorDeFechasStringGringo.parse(fechaLanzamientoString);
            
            
            
            String metodoCompra = null;
            if (this.vista.getjRadioButton1().isSelected())
            {
                metodoCompra = "O";
            }
            else 
            {
                metodoCompra = "P";
            }
            
            float precio = Float.parseFloat(this.vista.getjTextField4().getText());

            boolean mayoriaEdad=false;
            
            if (this.vista.getjCheckBox1().isSelected())
            {
                mayoriaEdad = true;
            }
            else{
                mayoriaEdad=false;
            }
           
            String categoriaSeleccionada = null;
            int idCategoria = 0;
            String nombreCategoria = null;
            
             if (this.vista.getjComboBox1().getModel().getSize()!=0)
            {
                categoriaSeleccionada = (String)this.vista.getjComboBox1().getSelectedItem();
                String corcheteAbiertoADerecha="[";
                String corcheteAbiertoAIzquierda="]";
                
                int dondeCorcheteAbiertoADerecha = categoriaSeleccionada.indexOf(corcheteAbiertoADerecha);
                int dondeCorcheteAbiertoAIzquierda = categoriaSeleccionada.indexOf(corcheteAbiertoAIzquierda);
                
                String codigoDentroDeLosCorchetes = categoriaSeleccionada.substring(dondeCorcheteAbiertoADerecha+1, dondeCorcheteAbiertoAIzquierda);
                idCategoria = Integer.parseInt(codigoDentroDeLosCorchetes);
                
                nombreCategoria = categoriaSeleccionada.substring(0, dondeCorcheteAbiertoADerecha).trim();     
            
            }
          
            Pelicula p = new Pelicula();
            //p.setId(id);
            p.setNombre(nombre);
            p.setFechaLanzamiento(fechaLanzamientoTipoDate);
            p.setMetodoCompra(metodoCompra);
            p.setPrecio(precio);
            p.setMayoriaEdad(mayoriaEdad);
            p.setId_categoria(idCategoria);
            p.setCategoria(nombreCategoria);
            
            
            
            if (this.vista.getjTextField2().getText().isEmpty())
            {
       
                JOptionPane.showMessageDialog(null,"Debe ingresar el nombre", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
            // 
            else {
                           
                     this.modelo.create(p);
                     JOptionPane.showMessageDialog(null, "Registro agregado exitosamente.");
                     this.vista.setVisible(false); 
                  }
           
            
                             
        }   
        
        catch (com.mysql.jdbc.exceptions.jdbc4.CommunicationsException ex)
        {
            JOptionPane.showMessageDialog(null, "Posible falla del servidor BD, puede que no este dando el servicio o hay un problema con la red. Intente nuevamente o llame a soporte. ");
        }
        
        
       catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this.vista.getjTextField4(), "Ingresar el precio (con caracteres numericos)");
        }

        catch (ParseException ex)
        {
           JOptionPane.showMessageDialog(this.vista.getjTextField3(), "fecha invalida, reingresar por favor");
        }  
           
        catch (Exception ex)
        {
           JOptionPane.showMessageDialog(null, "ingrese los datos pedidos por favor");
        }  
       
        
   }   
    
   
      
}

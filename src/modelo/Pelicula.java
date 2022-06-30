/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.CrudDAOable;
import dao.PeliculaDAOimpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import servicios.FactoriaServiciosImpl;

/**
 *
 * @author Jessica
 */
public class Pelicula {
    private int id;
    private String nombre;
    private Date fechaLanzamiento;
    private String metodoCompra;
    private float precio;
    private boolean mayoriaEdad;
    private int id_categoria;
    
    //para efectos de display
    private String categoria;

    public Pelicula() {
    }

    public Pelicula(int id, String nombre, Date fechaLanzamiento, String metodoCompra, float precio,boolean mayoriaEdad, int id_categoria ) {
        //this.id = id;
        this.setId(id);
        //this.nombre = nombre;
        this.setNombre(nombre);
        //this.fechaLanzamiento = fechaLanzamiento;
        this.setFechaLanzamiento(fechaLanzamiento);
        //this.metodoCompra = metodoCompra;
        this.setMetodoCompra(metodoCompra);
        //this.precio = precio;
        this.setPrecio(precio);
        //this.id_categoria = id_categoria;
        this.mayoriaEdad = mayoriaEdad;
        this.setMayoriaEdad(mayoriaEdad);
        
        this.setId_categoria(id_categoria);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String isMetodoCompra() {
        return metodoCompra;
    }

    public void setMetodoCompra(String metodoCompra) {
        this.metodoCompra = metodoCompra;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    public boolean getMayoriaEdad() {
        return mayoriaEdad;
    }

    public void setMayoriaEdad(boolean mayoriaEdad) {
        this.mayoriaEdad = mayoriaEdad;
    }
    
    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
        
    }

    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.fechaLanzamiento);
        hash = 53 * hash + Objects.hashCode(this.metodoCompra);
        hash = 53 * hash + (this.mayoriaEdad ? 1 : 0);
        hash = 53 * hash + Float.floatToIntBits(this.precio);
        hash = 53 * hash + this.id_categoria;  
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pelicula other = (Pelicula) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.mayoriaEdad != other.mayoriaEdad) {
            return false;
        }
        if (Float.floatToIntBits(this.precio) != Float.floatToIntBits(other.precio)) {
            return false;
        }
        if (this.id_categoria != other.id_categoria) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.metodoCompra, other.metodoCompra)) {
            return false;
        }
        if (!Objects.equals(this.fechaLanzamiento, other.fechaLanzamiento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "id=" + id + ", nombre=" + nombre + ", fechaLanzamiento=" + fechaLanzamiento + ", mayoriaEdad=" + mayoriaEdad + ", precio=" + precio + ", metodoCompra=" + metodoCompra + ", id_categoria=" + id_categoria + ", categoria=" + categoria + '}';
    }

    
    public void create(Pelicula p) throws InstantiationException, IllegalAccessException, Exception
    {
        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
            System.out.println(this.getClass().getCanonicalName() + " Entrando a create");
        }

        CrudDAOable<Pelicula> cDAO = new PeliculaDAOimpl();
        cDAO.create(p);           
    }
    
    public void update(Pelicula p) throws InstantiationException, IllegalAccessException, Exception
    {
        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
            System.out.println(this.getClass().getCanonicalName() + " Entrando a update");
        }

        CrudDAOable<Pelicula> cDAO = new PeliculaDAOimpl();
        cDAO.update(p);           
    }    
    
    public void delete(Pelicula p) throws InstantiationException, IllegalAccessException, Exception
    {
        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
            System.out.println(this.getClass().getCanonicalName() + " Entrando a delete");
        }

        CrudDAOable<Pelicula> cDAO = new PeliculaDAOimpl();
        cDAO.delete(p);           
    }
    
    public ArrayList<Pelicula> read() throws InstantiationException, IllegalAccessException, Exception
    {
        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
            System.out.println(this.getClass().getCanonicalName() + " Entrando a read");
        }
        
        CrudDAOable<Pelicula> cDAO = new PeliculaDAOimpl();
        return cDAO.read();   
    }
    
    public ArrayList<Pelicula> readConWhere(String whereSQL) throws InstantiationException, IllegalAccessException, Exception
    {
        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
            System.out.println(this.getClass().getCanonicalName() + " Entrando a read");
        }
        
        CrudDAOable<Pelicula> cDAO = new PeliculaDAOimpl();
        return cDAO.readWhere(whereSQL);   
    }
    
    public int getCategoriaByNombre(int id) throws IllegalAccessException, Exception
    {
        PeliculaDAOimpl cDAO = new PeliculaDAOimpl();
        return cDAO.getCategoriaByNombre(id);
    }    
    
    public Pelicula getPelicula(Pelicula pli) throws InstantiationException, IllegalAccessException, Exception
    {
        PeliculaDAOimpl cDAO = new PeliculaDAOimpl();
        return cDAO.read(" where peli.id='" + pli.getId()+ "'");
    }
    
    
} 

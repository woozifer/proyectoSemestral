/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import modelo.Pelicula;
import servicios.FactoriaServiciosImpl;

/**
 *
 * @author sebas
 */
public class PeliculaDAOimpl implements PeliculaDAOable {

    @Override
    public void create(Pelicula t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {

        String sql = "insert into pelicula (nombre, fechaLanzamiento,metodoCompra, precio, mayoriaEdad, id_categoria) values ( ?, ?, ?, ?, ?, ?);";

        PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
        //ps.setInt(1, t.getId());
        ps.setString(1, t.getNombre());
        ps.setDate(2, new java.sql.Date(t.getFechaLanzamiento().getTime()));
        ps.setString(3, t.isMetodoCompra());    
        ps.setFloat(4, t.getPrecio());
        ps.setBoolean(5, t.getMayoriaEdad());
        ps.setInt(6, t.getId_categoria());

        ps.executeUpdate();
        
        read();
        

    }

    @Override
    public boolean read(Pelicula t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pelicula> read() throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {

        if (FactoriaServiciosImpl.getFactoria().isDEBUG()) {
            System.out.println(this.getClass().getCanonicalName() + " Entrando a read()");
        }

        ArrayList<Pelicula> al = new ArrayList();
        String sql = "select peli.*, cat.nombre as categoria "
                + " from pelicula peli"
                + " inner join categoria cat on peli.id_categoria = cat.id order by id;";
  
        PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            Date fechaLanzamiento = rs.getDate("fechaLanzamiento"); 
            String metodoCompra = rs.getString("metodoCompra");
            float precio = rs.getFloat("precio");
            boolean mayoriaEdad = rs.getBoolean("mayoriaEdad");
            int idCategoria = rs.getInt("id_categoria");
            String categoria = rs.getNString("categoria");
           

            Pelicula pelicula = new Pelicula();

            pelicula.setId(id);
            pelicula.setNombre(nombre);
            pelicula.setFechaLanzamiento(fechaLanzamiento);
            pelicula.setMetodoCompra(metodoCompra);  
            pelicula.setPrecio(precio);
            pelicula.setMayoriaEdad(mayoriaEdad);
            pelicula.setId_categoria(idCategoria);
            pelicula.setCategoria(categoria);

            al.add(pelicula);
        }
        return al;

    }

    @Override
    public ArrayList<Pelicula> readWhere(String whereSQL) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        ArrayList<Pelicula> al = new ArrayList();
        String sql = "select peli.*, cat.nombre as categoria "
                + " from pelicula peli"
                + " inner join categoria cat on peli.id_categoria = cat.id" + whereSQL + ";";
        if (FactoriaServiciosImpl.getFactoria().isDEBUG()) {
            System.out.println(this.getClass().getCanonicalName() + " Entrando a readWhere()");
            System.out.println(sql);
        }

        PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            Date fechaLanzamiento = rs.getDate("fechaLanzamiento");
            String metodoCompra = rs.getString("metodoCompra");
            float precio = rs.getFloat("precio");
            boolean mayoriaEdad = rs.getBoolean("mayoriaEdad");
            int idcategoria = rs.getInt("id_categoria");
            String categoria = rs.getNString("categoria");
    

            Pelicula pelicula = new Pelicula();
            pelicula.setId(id);
            pelicula.setNombre(nombre);
            pelicula.setFechaLanzamiento(fechaLanzamiento);
            pelicula.setMetodoCompra(metodoCompra);
            pelicula.setPrecio(precio);
            pelicula.setMayoriaEdad(mayoriaEdad);
            pelicula.setId_categoria(idcategoria);
            pelicula.setCategoria(categoria);
            
            al.add(pelicula);
        }
        return al;
    }
    
    public Pelicula read (String whereSQL) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception
    {
        Pelicula pelicula=null;
        String sql = "select peli.*, cat.nombre as categoria "
                + " from pelicula peli"
                + " inner join categoria cat on peli.id_categoria = cat.id" + whereSQL + ";";
        if (FactoriaServiciosImpl.getFactoria().isDEBUG()) {
            System.out.println(this.getClass().getCanonicalName() + " Entrando a readWhere(String whereSQL)");
            System.out.println(sql);
        }

        PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            Date fechaLanzamiento = rs.getDate("fechaLanzamiento");
            String metodoCompra = rs.getString("metodoCompra");
            float precio = rs.getFloat("precio");
            boolean mayoriaEdad = rs.getBoolean("mayoriaEdad");
            int idcategoria = rs.getInt("id_categoria");
            String categoria = rs.getNString("categoria");
    

            pelicula = new Pelicula();
            
            pelicula.setId(id);
            pelicula.setNombre(nombre);
            pelicula.setFechaLanzamiento(fechaLanzamiento);
            pelicula.setMetodoCompra(metodoCompra);
            pelicula.setPrecio(precio);
            pelicula.setMayoriaEdad(mayoriaEdad);
            pelicula.setId_categoria(idcategoria);
            pelicula.setCategoria(categoria);
            
        }
        return pelicula;   
    
    }
    
    
    @Override
    public void update(Pelicula t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String sql = "update pelicula set nombre=?, fechaLanzamiento=?,metodoCompra=? , precio=?, mayoriaEdad=?, id_Categoria=? where id=?;"; 
         
        PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
          
        ps.setString(1, t.getNombre());
        ps.setDate(2, new java.sql.Date(t.getFechaLanzamiento().getTime()));
        ps.setString(3, t.isMetodoCompra());
        ps.setFloat(4, t.getPrecio());
        ps.setBoolean(5, t.getMayoriaEdad());
        ps.setInt(6, t.getId_categoria());
        ps.setInt(7, t.getId());
        ps.executeUpdate();      
    }

    @Override
    public void delete(Pelicula t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        String sql = "delete from pelicula where id=?;";    
        PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
        ps.setInt(1, t.getId());
        ps.executeUpdate();          
    }
    
    public int getCategoriaByNombre(int id) throws IllegalAccessException, Exception
    {
        Pelicula pelicula = this.read(" where peli.id ='" +id+ "'");
        if (pelicula==null)
        {
            return 0;
        }
        else
        {
            return pelicula.getId_categoria();
        }
     
}
    
}

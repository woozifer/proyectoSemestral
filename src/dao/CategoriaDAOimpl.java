/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Categoria;
import servicios.FactoriaServiciosImpl;

/**
 *
 * @author sebas
 */
public class CategoriaDAOimpl implements CategoriaDAOable {

    @Override
    public void create(Categoria t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ArrayList<Categoria> read() throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<Categoria> al = new ArrayList();
        String sql = "select * from categoria;";
        PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next())
        {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            
            Categoria categoria = new Categoria(id, nombre);
            al.add(categoria);
        }        
        return al;
    }
   
    @Override
    public boolean read(Categoria t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public ArrayList<Categoria> readWhere(String whereSQL) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Categoria t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Categoria t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

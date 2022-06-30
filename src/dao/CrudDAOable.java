/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import modelo.Pelicula;

/**
 *
 * @author camila
 */
public interface CrudDAOable<T> {
    public void create(T t)throws java.lang.ClassNotFoundException, java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.Exception;
    public boolean read(T t)throws java.lang.ClassNotFoundException, java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.Exception;
    public ArrayList<T> read() throws java.lang.ClassNotFoundException, java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.Exception;
    public ArrayList<T> readWhere(String whereSQL) throws java.lang.ClassNotFoundException, java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.Exception;
    public void update(T t)throws java.lang.ClassNotFoundException, java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.Exception;
    public void delete(T t)throws java.lang.ClassNotFoundException, java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.Exception;

}

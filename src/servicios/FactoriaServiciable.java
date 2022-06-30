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
public interface FactoriaServiciable {
    public ConexionGenericaDB getConexionDB() throws java.lang.ClassNotFoundException, java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.Exception;
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.almacen.dao;

import com.almacen.modelo.Producto;
import java.util.ArrayList;

/**
 *
 * @author Cristhian
 */
public interface ProductoDAO {
  
  public void insert(Producto producto) throws Exception;
  public void update(Producto producto) throws Exception;
  public void delete(int id) throws Exception;
  public Producto getById(int id) throws Exception;
  public ArrayList<Producto> getAll() throws Exception;
}

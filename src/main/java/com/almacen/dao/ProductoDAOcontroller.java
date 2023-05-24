/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.almacen.dao;

import com.almacen.modelo.Producto;
import com.almacen.util.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Cristhian
 */
public class ProductoDAOcontroller extends ConnectionBD implements ProductoDAO {

  @Override
  public void insert(Producto producto) throws Exception {
    try {

      this.conectar();
      String sql = "INSERT INTO productos (descripcion, cantidad, precio, categoria) values (?, ?, ?, ?)";
      PreparedStatement prepare = this.conn.prepareStatement(sql);
      prepare.setString(1, producto.getDescripcion());
      prepare.setInt(2, producto.getCantidad());
      prepare.setFloat(3, producto.getPrecio());
      prepare.setString(4, producto.getCategoria());

      prepare.executeUpdate();

    } catch (SQLException e) {
      throw e;
    } finally {
      this.desconectar();
    }
  }

  @Override
  public void update(Producto producto) throws Exception {
    try {
      this.conectar();
      String sql = "UPDATE productos SET descripcion = ?, cantidad = ?, precio = ?, categoria = ? WHERE id = ?";
      PreparedStatement prepare = this.conn.prepareStatement(sql);
      prepare.setString(1, producto.getDescripcion());
      prepare.setInt(2, producto.getCantidad());
      prepare.setFloat(3, producto.getPrecio());
      prepare.setString(4, producto.getCategoria());
      prepare.setInt(5, producto.getId());

      prepare.executeUpdate();
    } catch (SQLException e) {
      throw e;
    } finally {
      this.desconectar();
    }
  }

  @Override
  public void delete(int id) throws Exception {
    try {
      this.conectar();
      String sql = "DELETE FROM productos WHERE id = ?";
      PreparedStatement prepare = this.conn.prepareStatement(sql);
      prepare.setInt(1, id);

      prepare.executeUpdate();
    } catch (SQLException e) {
      throw e;
    } finally {
      this.desconectar();
    }
  }

  @Override
  public Producto getById(int id) throws Exception {
    Producto producto = null;
    try {
      this.conectar();
      String sql = "SELECT * FROM productos WHERE id = ? LIMIT 1";
      PreparedStatement prepare = this.conn.prepareStatement(sql);
      prepare.setInt(1, id);
      ResultSet result = prepare.executeQuery();

      if (result.next()) {
        producto = new Producto();

        producto.setId(result.getInt("id"));
        producto.setDescripcion(result.getString("descripcion"));
        producto.setCantidad(result.getInt("cantidad"));
        producto.setPrecio(result.getFloat("precio"));
        producto.setCategoria(result.getString("categoria"));
      }

    } catch (SQLException e) {
      throw e;
    } finally {
      this.desconectar();
    }
    return producto;
  }

  @Override
  public ArrayList<Producto> getAll() throws Exception {
    ArrayList<Producto> productos = new ArrayList<Producto>();
    try {
      this.conectar();
      String sql = "SELECT * FROM productos";
      PreparedStatement prepare = this.conn.prepareStatement(sql);
      ResultSet result = prepare.executeQuery();

      while (result.next()) {
        Producto producto = new Producto();

        producto.setId(result.getInt("id"));
        producto.setDescripcion(result.getString("descripcion"));
        producto.setCantidad(result.getInt("cantidad"));
        producto.setPrecio(result.getFloat("precio"));
        producto.setCategoria(result.getString("categoria"));

        productos.add(producto);
      }

    } catch (SQLException e) {
      throw e;
    } finally {
      this.desconectar();
    }
    return productos;
  }

}

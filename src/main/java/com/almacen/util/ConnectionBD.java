/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.almacen.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristhian
 */
public class ConnectionBD {

  static public String url = "jdbc:mysql://localhost:3306/bd_almacen";
  static public String user = "root";
  static public String password = "";

  protected Connection conn = null;

  public ConnectionBD() {
    try {
      Class.forName("com.mysql.jdbc.Driver");

      conn = DriverManager.getConnection(url, user, password);

      if (conn != null) {
        System.out.println("Conexion exitosa a <db_almacen>");
      }
    } catch (ClassNotFoundException ex) {
      System.err.println("Error en el driver" + ex.getMessage());
    } catch (SQLException ex) {
      System.err.println("Error con la conexion" + ex.getMessage());
    }
  }

  public Connection conectar() {
    return this.conn;
  }
  
  public void desconectar() {
    try {
      System.out.println("Cerrando conexion con la base de datos");
      this.conn.close();
    } catch (SQLException ex) {
      Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

}

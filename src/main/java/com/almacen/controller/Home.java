/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.almacen.controller;

import com.almacen.dao.ProductoDAO;
import com.almacen.dao.ProductoDAOcontroller;
import com.almacen.modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.taglibs.standard.tag.el.core.OutTag;

/**
 *
 * @author Cristhian
 */
@WebServlet(name = "Home", urlPatterns = {"/"})
public class Home extends HttpServlet {

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      ProductoDAO productoDao = new ProductoDAOcontroller();
      String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
      int id; // acceso a todo el switch
      switch (action) {
        case "add":
          request.getRequestDispatcher("formProducto.jsp").forward(request, response);
          break;
        case "edit":
          id = Integer.parseInt(request.getParameter("id"));
          Producto productoEdit = productoDao.getById(id);
          request.setAttribute("producto", productoEdit);
          request.getRequestDispatcher("formProducto.jsp").forward(request, response);
          break;
        case "delete":
          id = Integer.parseInt(request.getParameter("id"));
          productoDao.delete(id);
          response.sendRedirect(request.getContextPath() + "/");
          break;
        case "view":
          ArrayList<Producto> productos = productoDao.getAll();
          request.setAttribute("productos", productos);
          request.getRequestDispatcher("index.jsp").forward(request, response);
          break;
      }

    } catch (Exception e) {
      System.err.println("Ocurrio un error: " + e.getMessage());
    }
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      ProductoDAO productoDao = new ProductoDAOcontroller();
      Producto producto = new Producto();
      producto.setDescripcion(request.getParameter("descripcion"));
      producto.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
      producto.setPrecio(Float.parseFloat(request.getParameter("precio")));
      producto.setCategoria(request.getParameter("categoria"));

      if (request.getParameter("id").isEmpty()) {
        producto.setId(0);
        productoDao.insert(producto);
      } else {
        producto.setId(Integer.parseInt(request.getParameter("id")));
        productoDao.update(producto);
      }
      response.sendRedirect("/almacen");
    } catch (Exception e) {
      System.err.println("Ocurrio un error al crear o actualizar producto: " + e.getMessage());
    }
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}

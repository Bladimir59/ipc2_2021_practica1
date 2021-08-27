/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.ModificacionPieza;

/**
 *
 * @author bladimir
 */
@WebServlet(name = "ServerPieza", urlPatterns = {"/ServerPieza"})
public class ServerPieza extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServerPieza</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>envio la informacion a la base de datos " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //variables para capturar las de entrada de la nueva informacion
    private String nombre;
    private Double precio;
    private int cantidad;
    private String caso;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            logica.ModificacionPieza datos = new ModificacionPieza();
            caso = request.getParameter("caso");
            if (caso.equals("modificar")) {
                datos.setNombre(request.getParameter("nombre"));
                datos.setPrecio(Double.parseDouble(request.getParameter("precio")));
                datos.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
                datos.setCodigo(Integer.parseInt(request.getParameter("codigo")));
                datos.define(request.getParameter("caso"));
            } else if (caso.equals("crear")) {
                datos.setNombre(request.getParameter("nombre"));
                datos.setPrecio(Double.parseDouble(request.getParameter("precio")));
                datos.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
                datos.define(request.getParameter("caso"));

            } else if (caso.equals("eliminar")) {
                datos.setCodigo(Integer.parseInt(request.getParameter("codigo")));
                datos.define(request.getParameter("caso"));

            }

            request.getRequestDispatcher("Aceptado.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("ErrorDatos.jsp").forward(request, response);
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

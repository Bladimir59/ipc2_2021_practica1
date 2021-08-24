/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import Clases.Usuario;
import DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bladimir
 */
@WebServlet(name = "LoginControl", urlPatterns = {"/LoginControl"})
public class LoginControl extends HttpServlet {

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
            out.println("<title>Servlet LoginControl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginControl at " + request.getContextPath() + "</h1>");
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
        String id=request.getParameter("id");
        System.out.println(id);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //variables solo para recivir los datos de main
    private String nombre="";
    private String password="";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("pasa");
        nombre=request.getParameter("nombre");
        password=request.getParameter("password");
        
        revisarCodigo(request, response);
    }
    
    //funcionalidad para ver si existe en la base de datos el usuario y ver que tipo es
    public void revisarCodigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        UsuarioDAO revisar=new UsuarioDAO();
        
        Usuario entrada=new Usuario(password, nombre);
        Usuario salida;
        salida=revisar.tipoUsuario(entrada);
        
        if(salida.getDivicion()==1){
            request.getRequestDispatcher("Fabrica.jsp").forward(request, response);
        }else if(salida.getDivicion()==2){
            request.getRequestDispatcher("Venta.jsp").forward(request, response);
        }else if(salida.getDivicion()==3){
            request.getRequestDispatcher("Financiero.jsp").forward(request, response);
        }else{
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

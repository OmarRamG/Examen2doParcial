/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alumno
 */
public class ServletSession extends HttpServlet {
    String nombre;
    String ap;
    double suma;
            
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            nombre = request.getParameter("Nombre");
            ap = request.getParameter("Apellido");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Validando</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Validando datos</h2>");
            if(nombre.equals("Omar") && ap.equals("Ramirez")){
                out.println("<h3><a href=\"sumadora.html\">Continuar</a></h3>");
            }
            else{
                out.println("<h3><a href=\"error.html\">Continuar</a></h3>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession();
        
        double num1 = Double.parseDouble(request.getParameter("num1"));
        double num2 = Double.parseDouble(request.getParameter("num2"));
        suma = num1 + num2;
        sesion.setAttribute("clave", nombre + ap +suma);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Guardado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Guardado con éxito</h1></br></br>");
            out.println("<h3>Resultado:"+suma+"</h3");
            out.println("</body>");
            out.println("</html>");
    }

    } 


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.EnsambleMueble;
import DAO.EnsambleMuebleDAO;

/**
 *
 * @author bladimir
 */
public class FabricaTienda {

    public String getEnsambles() {
        EnsambleMuebleDAO lista = new EnsambleMuebleDAO();
        String htmlcodigo = "";
        for (EnsambleMueble datos : lista.verEstado()) {
            htmlcodigo += "<form action=\"pasaAtributos\" method=\"post\">"
                    + "<div class=\"col-sm-4\">\n"
                    + "<br>"
                    + "     <div class=\"product-image-wrapper\">\n"
                    + "         <div class=\"single-products\">\n"
                    + "             <div class=\"productinfo text-center\">\n"
                    + "			<img src= alt=\"\" />\n"
                    + "			<h2>Mueble </h2>\n"
                    + "                 <input type\"text\" size=\"30\" name=\"nombre\" value="+datos.getNombreMueble()+"/>"
                    + "			<button type=\"submit\" name=\"accion\" value=\"pasaAtributos\">agregar a tienda</button>"
                    + "             </div>\n"
                    + "		</div>\n"
                    + "     </div>\n"
                    + "	</div>"
                    + "</form>";
        }
        return htmlcodigo;
    }
}

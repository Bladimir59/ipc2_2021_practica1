/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Mueble;
import Clases.ProductoTienda;
import DAO.MuebleDAO;
import DAO.MuebleTiendaDAO;

/**
 *
 * @author bladimir
 */
public class ControladorMueble {
    public String getMueble(){
        MuebleTiendaDAO lista = new MuebleTiendaDAO();
        String htmlcodigo="";
        for (ProductoTienda datos:lista.muebles()) {
            htmlcodigo +="<div class=\"col-sm-4\">\n" +
"							<div class=\"product-image-wrapper\">\n" +
"								<div class=\"single-products\">\n" +
"									<div class=\"productinfo text-center\">\n" +
"										<img src= alt=\"\" />\n" +
"										<h2>Q"+datos.getPrecio()+"</h2>\n" +
"										<p>"+datos.getNombre()+"</p>\n" +
"										<a href=\"product-details.jsp?id="+datos.getId()+"\" class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>Ver Detalles</a>\n" +
"									</div>\n" +
"									<div class=\"product-overlay\">\n" +
"										<div class=\"overlay-content\">\n" +
"											<h2>Q"+datos.getPrecio()+"</h2>\n" +
"											<p>"+datos.getNombre()+"</p>\n" +
"											<a href=\"VentaJSP/Plantilla/product-details.jsp?id="+datos.getId()+"\" class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>Ver Detalles</a>\n" +
"										</div>\n" +
"									</div>\n" +
"								</div>\n" +
"								<div class=\"choose\">\n" +
"									<ul class=\"nav nav-pills nav-justified\">\n" +
"										<li><a href=\"\"><i class=\"fa fa-plus-square\"></i>Add to wishlist</a></li>\n" +
"										<li><a href=\"\"><i class=\"fa fa-plus-square\"></i>Add to compare</a></li>\n" +
"									</ul>\n" +
"								</div>\n" +
"							</div>\n" +
"						</div>";
        }
        return htmlcodigo;
    }
    
    public ProductoTienda obtenerProducto(int id){
        return new MuebleTiendaDAO().obtenerProducto(id);
    }
}

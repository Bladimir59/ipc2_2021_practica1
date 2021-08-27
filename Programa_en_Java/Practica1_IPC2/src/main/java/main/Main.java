/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Clases.Pieza;
import DAO.PiezaDAO;
import java.util.List;

/**
 *
 * @author bladimir
 */
public class Main {
    public static void main(String[] args) {
        //para las pruebas con las busquedas
        String texto="USUARIO(\"blast\",\"ABC\",1)";

        texto = texto.replace("USUARIO","").replace("(", "").replace(")", "");
        System.out.println(""+texto);
        
        String[] dividir = texto.split(",");
        System.out.println("dato sin comillas y bien generado: "+dividir[0].replace("\"", ""));
    }
    
}

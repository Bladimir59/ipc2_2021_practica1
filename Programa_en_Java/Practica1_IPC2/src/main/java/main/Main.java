/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Clases.EnsambleMueble;
import Clases.Mueble;
import Clases.Pieza;
import Clases.Usuario;
import DAO.EnsambleMuebleDAO;
import DAO.MuebleDAO;
import DAO.PiezaDAO;
import DAO.UsuarioDAO;
import java.sql.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author bladimir
 */
public class Main {
    public static void main(String[] args) {
        //para las lineas de el analsis
        String linea = "PIEZA(\"Pata cuadrada\",15.50)";
        String linea2 = "USUARIO(\"blast\",\"ABC\",1)";
        String linea3 = "MUEBLE(\"Mesa rustica\", 150.00)";
        String linea4 = "ENSAMBLE_PIEZAS(\"Mesa rustica\",\"Pata cuadrada\",4)";
        String linea5 = "ENSAMBLAR_MUEBLE(\"Mesa rustica\", blast,\"21/04/2018\")";
        String linea6 = "CLIENTE(\"Jose Gra\", \"578964k\", \"Ciudad\")";
        String linea7 = "CLIENTE(\"Jose Granados\", \"578964k\", \"5av 7-25 zona 1\", \"Quetzaltenango\", \"Quetzaltenango\")";
        
        String patternPieza = "(PIEZA)\\s*\\(\\s*\"\\s*([a-zA-Z ]+)\\s*\"\\s*,\\s*(\\d+(\\.\\d+)?)\\s*\\)";
        String patternUsuario ="(USUARIO)\\s*\\(\\s*\"\\s*([a-zA-Z]+)\\s*\"\\s*,\\s*\"([a-zA-Z]+)\\s*\"\\s*,(1|2|3)\\s*\\)";
        String patternMueble = "(MUEBLE)\\s*\\(\\s*\"\\s*([a-zA-Z ]+)\\s*\"\\s*,\\s*(\\d+(.\\d+)?)\\s*\\)";
        String patternEnsamblePieza = "(ENSAMBLE_PIEZAS)\\s*\\(\\s*\"\\s*([a-zA-Z ]+)\\s*\"\\s*,\\s*\"([a-zA-Z ]+)\\s*\"\\s*,\\s*(\\d)\\s*\\)";
        String patternEnsambleMueble = "(ENSAMBLAR_MUEBLE)\\s*\\(\\s*\"\\s*([a-zA-Z ]+)\\s*\"\\s*,\\s*([a-zA-Z]+)\\s*,\\s*\"\\s*([\\d\\/]+)\\s*\"\\s*\\)";
        String patternClienteP = "(CLIENTE)\\s*\\(\\s*\"\\s*([a-zA-Z ]+)\\s*\"\\s*,\\s*\"([\\da-zA-Z]+)\\s*\"\\s*,\\s*\"\\s*([\\da-zA-Z\\-* ]+)\\s*\"\\s*\\)";
        String patternClienteL = "(CLIENTE)\\s*\\(\\s*\"\\s*([a-zA-Z ]+)\\s*\"\\s*,\\s*\"([\\da-zA-Z]+)\\s*\"\\s*,\\s*\"\\s*([\\da-zA-Z\\-* ]+)\\s*\"\\s*,\\s*\"\\s*([a-zA-Z]+)\\s*\"\\s*,\\s*\"\\s*([a-zA-Z]+)\\s*\"\\s*\\)";
//nuevo objeto pattern
        Pattern r = Pattern.compile(patternMueble);
        
//now creat matches objeto
        Matcher m = r.matcher(linea3);
        
        if (m.find( )) {
           // long fecha=Date.parse(m.group(4));
            //System.out.println(m.group(4)+" o este "+fecha);
            //Clases.EnsambleMueble nuevo=new EnsambleMueble(m.group(2), m.group(3), fecha);
            //DAO.EnsambleMuebleDAO llenar = new EnsambleMuebleDAO();
            //llenar.nuevoEnsambleMueble(nuevo);
            Mueble nuevo=new Mueble(m.group(2), Double.parseDouble(m.group(3)));
            DAO.MuebleDAO llenar=new MuebleDAO();
            llenar.crearMueble(nuevo);
      } else {
         System.out.println("NO MATCH");
      }
    }
}

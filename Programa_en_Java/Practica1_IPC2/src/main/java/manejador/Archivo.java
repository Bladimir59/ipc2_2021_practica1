/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import Clases.Mueble;
import Clases.Pieza;
import Clases.Usuario;
import DAO.MuebleDAO;
import DAO.PiezaDAO;
import DAO.UsuarioDAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.Part;

/**
 *
 * @author bladimir
 */
public class Archivo {

    private Part direccion;
    private List<Pieza> listaPieza;

    public Archivo(Part direccion) {
        this.direccion = direccion;
    }

    public void manejador() {
        //clases para llenar

        BufferedReader br = null;
        
        //los pattenrs para la configuracion de los datos en la cual se divide los datos en sus diferentes estructuras
        try {
            br = new BufferedReader(new InputStreamReader(direccion.getInputStream()));
            String linea = br.readLine();
            while (linea != null) {
                linea = br.readLine();
                //para quitar los espacios por delante y atras de la linea a leer
                String in = linea.trim();
                String patternPieza = "(PIEZA)\\s*\\(\\s*\"\\s*([a-zA-Z ]+)\\s*\"\\s*,\\s*(\\d+(\\.\\d+)?)\\s*\\)";
                String patternUsuario = "(USUARIO)\\s*\\(\\s*\"\\s*([a-zA-Z]+)\\s*\"\\s*,\\s*\"([a-zA-Z\\_]+)\\s*\"\\s*,(1|2|3)\\s*\\)";
                String patternMueble = "(MUEBLE)\\s*\\(\\s*\"\\s*([a-zA-Z ]+)\\s*\"\\s*,\\s*(\\d+(.\\d+)?)\\s*\\)";
                String patternEnsamblePieza = "(ENSAMBLE_PIEZAS)\\s*\\(\\s*\"\\s*([a-zA-Z ]+)\\s*\"\\s*,\\s*\"([a-zA-Z ]+)\\s*\"\\s*,\\s*(\\d)\\s*\\)";
                String patternEnsambleMueble = "(ENSAMBLAR_MUEBLE)\\s*\\(\\s*\"\\s*([a-zA-Z ]+)\\s*\"\\s*,\\s*([a-zA-Z]+)\\s*,\\s*\"\\s*([\\d\\/]+)\\s*\"\\s*\\)";
                String patternClienteC = "(CLIENTE)\\s*\\(\\s*\"\\s*([a-zA-Z ]+)\\s*\"\\s*,\\s*\"([\\da-zA-Z]+)\\s*\"\\s*,\\s*\"\\s*([\\da-zA-Z\\-* ]+)\\s*\"\\s*\\)";
                String patternClienteL = "(CLIENTE)\\s*\\(\\s*\"\\s*([a-zA-Z ]+)\\s*\"\\s*,\\s*\"([\\da-zA-Z]+)\\s*\"\\s*,\\s*\"\\s*([\\da-zA-Z\\-* ]+)\\s*\"\\s*,\\s*\"\\s*([a-zA-Z]+)\\s*\"\\s*,\\s*\"\\s*([a-zA-Z]+)\\s*\"\\s*\\)";

                Pattern analizaPieza = Pattern.compile(patternPieza);
                Pattern analizaUsuario = Pattern.compile(patternUsuario);
                Pattern analizaMueble = Pattern.compile(patternMueble);
                Pattern analizaEnsamblePieza = Pattern.compile(patternEnsamblePieza);
                Pattern analizaEnsambleMueble = Pattern.compile(patternEnsambleMueble);
                Pattern analizaClientecorto = Pattern.compile(patternClienteC);
                Pattern analizaClientelargo = Pattern.compile(patternClienteL);

                Matcher pieza = analizaPieza.matcher(in);
                Matcher usuario = analizaUsuario.matcher(in);
                Matcher mueble = analizaMueble.matcher(in);
                Matcher ensambleP = analizaEnsamblePieza.matcher(in);
                Matcher ensambleM = analizaEnsambleMueble.matcher(in);
                Matcher clienteC = analizaClientecorto.matcher(in);
                Matcher clienteL = analizaClientelargo.matcher(in);
                if (pieza.find()) {
                    DAO.PiezaDAO revisar = null;
                    Pieza datos=new Pieza();
                    datos=revisar.consultaExiste(pieza.group(2), Double.parseDouble(pieza.group(3)));
                    if(datos==null){ 
                        Pieza nuevaPieza = new Pieza(pieza.group(2), Double.parseDouble(pieza.group(3)), 1);
                        revisar.crearPieza(nuevaPieza);
                    }else{
                        Pieza nuevosDatos = new Pieza(datos.getNombre(), datos.getPrecio(), datos.getCantidad()+1, datos.getId());
                        revisar.modificarPieza(nuevosDatos);
                    }
                } else if (usuario.find()) {
                    Usuario nuevoUsuario = new Usuario(usuario.group(3), Integer.parseInt(usuario.group(4)), usuario.group(2));
                    DAO.UsuarioDAO llenarUsuario = new UsuarioDAO();
                    llenarUsuario.crearUsuario(nuevoUsuario);

                } else if (mueble.find()) {
                    Mueble nuevoMueble = new Mueble(mueble.group(2), Double.parseDouble(mueble.group(3)));
                    DAO.MuebleDAO llenarMueble=new MuebleDAO();
                    llenarMueble.crearMueble(nuevoMueble);

                } else if (ensambleP.find()) {

                } else if (ensambleM.find()) {

                } else if (clienteC.find()) {

                } else if (clienteL.find()) {

                }

            }

        } catch (Exception e) {
        }

    }

    //llenando piesas
    private void llenarPieza(String datos) {
        Double precio;
        String nombre;
        int cantidad = 0;
        datos = datos.replace("PIEZA", "");
        String[] descripcion = datos.replace("(", "").replace(")", "").split(",");

        nombre = descripcion[0].replace("\"", "");
        System.out.println("" + nombre);
        precio = Double.parseDouble(descripcion[1]);

        listaPieza = new ArrayList<>();
        for (int i = 0; i < listaPieza.size(); i++) {
            if ((nombre.equals(listaPieza.get(i).getNombre())) && (precio == listaPieza.get(i).getPrecio())) {
                cantidad = listaPieza.get(i).getCantidad();
                cantidad = cantidad + 1;
                listaPieza.get(i).setCantidad(cantidad);
            } else {
                Pieza agregar = new Pieza(nombre, precio, cantidad);
                listaPieza.add(agregar);
            }
        }
    }

    public void llenarBD() {
        DAO.PiezaDAO llenar = new PiezaDAO();
        Pieza agregar;
        for (int i = 0; i < listaPieza.size(); i++) {
            agregar = new Pieza(listaPieza.get(i).getNombre(), listaPieza.get(i).getPrecio(), listaPieza.get(i).getCantidad());
            llenar.crearPieza(agregar);
        }
    }
}

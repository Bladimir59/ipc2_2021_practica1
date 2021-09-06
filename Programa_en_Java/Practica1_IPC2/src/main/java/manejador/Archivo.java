/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import Clases.Cliente;
import Clases.Costo;
import Clases.EnsambleMueble;
import Clases.EnsamblePieza;
import Clases.Mueble;
import Clases.Pieza;
import Clases.Usuario;
import DAO.ClienteDAO;
import DAO.EnsambleMuebleDAO;
import DAO.EnsamblePiezasDAO;
import DAO.MuebleDAO;
import DAO.PiezaDAO;
import DAO.UsuarioDAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
                
                //para quitar los espacios por delante y atras de la linea a leer
                String in = linea.trim();
                String patternPieza = "(PIEZA)\\s*\\(\\s*\"\\s*([a-zA-Z ]+)\\s*\"\\s*,\\s*(\\d+(\\.\\d+)?)\\s*\\)";
                String patternUsuario = "(USUARIO)\\s*\\(\\s*\"\\s*([a-zA-Z]+)\\s*\"\\s*,\\s*\"([\\w\\_\\.\\-0-9]+)\\s*\"\\s*,(1|2|3)\\s*\\)";
                String patternMueble = "(MUEBLE)\\s*\\(\\s*\"\\s*([a-zA-Z ]+)\\s*\"\\s*,\\s*(\\d+(.\\d+)?)\\s*\\)";
                String patternEnsamblePieza = "(ENSAMBLE_PIEZAS)\\s*\\(\\s*\"\\s*([a-zA-Z ]+)\\s*\"\\s*,\\s*\"([a-zA-Z ]+)\\s*\"\\s*,\\s*(\\d)\\s*\\)";
                String patternEnsambleMueble = "(ENSAMBLAR_MUEBLE)\\s*\\(\\s*\"\\s*([\\w ]+)\\s*\"\\s*,\\s*([\\w]+)\\s*,\\s*\"\\s*([\\d\\/]+)\\s*\"\\s*\\)";
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
                    DAO.PiezaDAO revisar = new PiezaDAO();                  
                    Pieza datosPieza = new Pieza();                    
                    System.out.println("" + pieza.group(2));
                    //consulta si existe la Pieza
                    datosPieza=revisar.consultaExistePieza(pieza.group(2));
                    if (datosPieza == null) {
                        Pieza nuevosDatos = new Pieza(pieza.group(2));
                        revisar.crearPieza(nuevosDatos);
                        Costo nuevoCosto = new Costo(pieza.group(2), Double.parseDouble(pieza.group(3)), 1);
                        revisar.crearCosto(nuevoCosto);
                        
                    } else {
                        Costo datos = new Costo();
                        datos=revisar.consultaExisteCosto(pieza.group(2), Double.parseDouble(pieza.group(3)));
                        if(datos==null){
                            Costo nuevoCosto = new Costo(pieza.group(2), Double.parseDouble(pieza.group(3)), 1);
                            revisar.crearCosto(nuevoCosto);
                        }else{
                            int cantidad=datos.getCantidad()+1;
                            Costo update = new Costo(datos.getId(), pieza.group(2), Double.parseDouble(pieza.group(3)), cantidad);
                            revisar.modificarPieza(update);
                            //agregar el update
                            
                        }
                    }
                } else if (usuario.find()) {
                    Usuario nuevoUsuario = new Usuario(usuario.group(3).trim(), Integer.parseInt(usuario.group(4)), usuario.group(2).trim());
                    DAO.UsuarioDAO llenarUsuario = new UsuarioDAO();
                    llenarUsuario.crearUsuario(nuevoUsuario);

                } else if (mueble.find()) {
                    Mueble nuevoMueble = new Mueble(mueble.group(2).trim(), Double.parseDouble(mueble.group(3)));
                    DAO.MuebleDAO llenarMueble = new MuebleDAO();
                    llenarMueble.crearMueble(nuevoMueble);

                } else if (ensambleP.find()) {
                    Clases.EnsamblePieza nuevoEnsamblePiesas = new EnsamblePieza(ensambleP.group(3), ensambleP.group(2) , Integer.parseInt(ensambleP.group(4)));
                    DAO.EnsamblePiezasDAO llenarEnsamblePiezas = new EnsamblePiezasDAO();
                    llenarEnsamblePiezas.nuevoEnsamblePieza(nuevoEnsamblePiesas);

                } else if (ensambleM.find()) {
                    Clases.EnsambleMueble nuevoEnsambleMueble = new EnsambleMueble(ensambleM.group(3).trim(), ensambleM.group(2).trim(), getDate(ensambleM.group(4)));
                    DAO.EnsambleMuebleDAO llenarEnsambleMueble = new EnsambleMuebleDAO();
                    llenarEnsambleMueble.nuevoEnsambleMueble(nuevoEnsambleMueble);

                } else if (clienteC.find()) {
                    Clases.Cliente nuevoClienteC = new Cliente(clienteC.group(3), clienteC.group(4), clienteC.group(2));
                    DAO.ClienteDAO llenarClienteC = new ClienteDAO();
                    llenarClienteC.crearCliente(nuevoClienteC);

                } else if (clienteL.find()) {
                    Clases.Cliente nuevoClienteL = new Cliente(clienteL.group(3), clienteL.group(4), clienteL.group(5), clienteL.group(6), clienteL.group(2));
                    DAO.ClienteDAO llenarClienteL = new ClienteDAO();
                    llenarClienteL.crearCliente(nuevoClienteL);
                }else{
                    System.out.println(""+linea);
                }
                linea = br.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }
    
    public static java.sql.Date getDate(String fechainicial){
        java.sql.Date dato=null;
        try {
            SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date fecha=formato.parse(fechainicial);
            dato=new java.sql.Date(fecha.getTime());
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return dato;
    }
}

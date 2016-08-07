/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

//import Edicion.Modifica_;
import Archivo.Nuevo;

//import Archivo.Add;
//import Archivo.List;
/**
 *
 * @author XIZUTH
 */
public class Variables {

    // se crea un objeto static por comodidad, ya que se utiliza muchas veces y es usado por el mismo programa y nadie mas
    //ademas con esto una vez abierta la base de datos, no se tenga que abrir cantidad de veces, lo que causa que se cree un error
    //al intentar abrir algo que ya esta abierto
    public final static BaseDeDatos BD = new BaseDeDatos();

    public static Nuevo nuevo = new Nuevo(null, true);

    public static String archivo = "Sin archivo";       //almacenara el path del archivo pdf

    public static String codigo ;       //codigo del dispositivo

    private static String titulo = "STORE COMPONENTS";

    public static String getTitulo() {
        return titulo;
    }

    public static void setTitulo(String titulo) {
        Variables.titulo = titulo;
    }
    
}

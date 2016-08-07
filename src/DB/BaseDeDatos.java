/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;//********************************

import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author XIZUTH
 */
public class BaseDeDatos {//constructor*******************************

    // Controlador JDBC y Ruta de la Base de Datos
    final String DRIVER = "org.sqlite.JDBC";
    final String Database = "DB.db";
    final String DATABASE_URL = "jdbc:sqlite:" + Database;
    Connection connection = null; // manages connection
    Statement statement = null; // query statement
    ResultSet resultSet = null; // manages results

    public BaseDeDatos() {//constructor
        // Conexión con la Base de Datos "DB.db" y se realiza una Consulta
        try {
            // Se carga la clase del controlador
            Class.forName(DRIVER);

            // Se establece la conexión con la base de datos
            connection
                    = DriverManager.getConnection(DATABASE_URL);

            // Se crea un objeto statement para consultar la base de datos
            statement = connection.createStatement();
        } // end try
        catch (SQLException sqlException) {
        } // end catch                                                     
        catch (ClassNotFoundException classNotFound) {
        } // end catch           
    }

    public Vector getDatos() {//metodo para utilizar la tabla

        Vector resultado = new Vector();//vector es un tipo de arrayList 

        try {
            // datos obtenidos de la BD tabla -> Empleado

            resultSet = statement.executeQuery("SELECT * FROM DataS");

            while (resultSet.next()) {
                Vector vTemp = new Vector();

                vTemp.add(resultSet.getInt(1));     //ID
                vTemp.add(resultSet.getString(2)); //NOMBRE
                vTemp.add(resultSet.getString(3)); //TIPO
                vTemp.add(resultSet.getString(4)); //CODIGO
//                vTemp.add(resultSet.getString(5)); //DESCRIPCION
                vTemp.add(resultSet.getString(6)); //ENCAPSULADO
//                vTemp.add(resultSet.getString(7));    //DIR PDF
                vTemp.add(resultSet.getString(8));    //UBICACION
                vTemp.add(resultSet.getString(9));    //ESTADO 
                vTemp.add(resultSet.getString(10));    //CANTIDAD
                resultado.add(vTemp);
            }//fin del if

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }

    public Vector getDatosT() {//metodo para utilizar la tabla

        Vector resultado = new Vector();//vector es un tipo de arrayList 

        try {
            // datos obtenidos de la BD tabla 

            resultSet = statement.executeQuery("SELECT * FROM DataS");

            while (resultSet.next()) {
                Vector vTemp = new Vector();
                vTemp.add(resultSet.getInt(1));     //ID
                vTemp.add(resultSet.getString(2)); //NOMBRE
                vTemp.add(resultSet.getString(3)); //TIPO
                vTemp.add(resultSet.getString(4)); //CODIGO
                vTemp.add(resultSet.getString(5)); //DESCRIPCION
                vTemp.add(resultSet.getString(6)); //ENCAPSULADO
                vTemp.add(resultSet.getString(7)); //DIRECCION PDF
                vTemp.add(resultSet.getString(8)); //UBICACION
                vTemp.add(resultSet.getString(9)); //ESTADO
                vTemp.add(resultSet.getString(10)); //CANTIDAD

                resultado.add(vTemp);
            }//fin del if

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }

    public boolean insertarDato(Vector registro) {//agrega un empleado
        try {
            // datos obtenidos de la BD tabla -> usuario
            boolean devolver;
            devolver = statement.execute("INSERT INTO DataS ("
                    + " nombre, tipo, codigo, descripcion, encapsulado, dirPDF, ubicacion, estado, cantidad )" + "VALUES ("
                    //                    + "'" + registro.get(0) + "'," //ID
                    + "'" + registro.get(1) + "'," //NOMBRE
                    + "'" + registro.get(2) + "'," //TIPO
                    + "'" + registro.get(3) + "'," //CODIGO
                    + "'" + registro.get(4) + "'," //DESCRIPCION
                    + "'" + registro.get(5) + "'," //ENCAPSULADO
                    + "'" + registro.get(6) + "'," //DIRPDF
                    + "'" + registro.get(7) + "'," //UBICACION
                    + "'" + registro.get(8) + "'," //ESTADO
                    + "" + registro.get(9) + ")" //CANTIDAD
            );

            return true; //ya que siempre devuelve false por lo tanto si hay algun error se atrapa en la excepcion

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }// fin del metodo insertar dispositivo

    public boolean insertaEnumeracion(int no) {//agrega un empleado
        String sql = "UPDATE DataS SET (";
        try {
            // datos obtenidos de la BD tabla -> usuario
            boolean devolver;

            for (int x = 0; x < (no + 1); x++) {
                sql += "No)" + "VALUES (" + x + ")";
            }
            devolver = statement.execute(sql);

            return true; //ya que siempre devuelve false por lo tanto si hay algun error se atrapa en la excepcion

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }// fin del metodo inse

    public boolean actualizarDatos(Vector registro) {//ACTUALIZAR DATOS

        String updt = "UPDATE DataS SET  ID = " + registro.get(0) //ID
                + ", nombre = '" + registro.get(1) + "'" //NOMBRE
                + ", tipo = '" + registro.get(2) + "'" //TIPO
                + ", codigo = '" + registro.get(3) + "'" //CODIGO
                + ", descripcion = '" + registro.get(4) + "'" //DESCRIPCION
                + ", encapsulado = '" + registro.get(5) + "'" //ENCAPSULADO
                + ", dirPDF = '" + registro.get(6) + "'" //
                + ", ubicacion = '" + registro.get(7) + "'" //UBICACION
                + ", estado = '" + registro.get(8) + "'"//ESTADO
                + ", cantidad = " + registro.get(9) //CANTIDAD
                + "  WHERE ID ='" + registro.get(0) + "'";

        try {
            // datos obtenidos de la BD tabla -> usuario
            int devolver;
            devolver = statement.executeUpdate(updt);
            if (devolver > 0) {
                return true; //ya que siempre devuelve false por lo tanto si hay algun error se atrapa en la excepcion
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

            //JOptionPane.showMessageDialog(null, ex);
            return false;
        }
        return false;

    }// fin del metodo actualizar Empleado

    public void cerrarBD() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Fallo al cerrar");

        }
    }//fin metodo cerrar!!!!!!!

    public boolean eliminarDato(Vector<Integer> ids) {//eliminar dato
        try {
            String sql = "DELETE FROM DataS WHERE ";
            for (Integer id : ids) {
                sql += "ID = " + id + " OR ";// la coma es por si se eliminan varios registros
            }
            sql = sql.substring(0, sql.length() - 4); //con esta instruccion elimina la coma que tiene la instruccion anterior
            // datos obtenidos de la BD
            int devolver = statement.executeUpdate(sql);
            if (devolver > 0) {
                return true; //ya que siempre devuelve false por lo tanto si hay algun error se atrapa en la excepcion
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;

    }// fin del metodo eliminar dato

    public Vector buscarDatoT(String buscar) {//metodo para utilizar la tabla

        Vector resultado = new Vector();//vector es un tipo de arrayList 
//       Vector vTemp = new Vector();
        try {
            // datos obtenidos de la BD tabla -> Empleado
            resultSet = statement.executeQuery("SELECT * FROM DataS WHERE nombre LIKE '%" + buscar + "%' OR "
                    + "tipo LIKE '%" + buscar + "%' OR codigo LIKE '%" + buscar + "%' OR "
                    + " encapsulado LIKE '%" + buscar + "%' OR ubicacion LIKE '%" + buscar + "%' OR"
                    + " estado LIKE '%" + buscar + "%' OR cantidad LIKE '%" + buscar + "%'");

            while (resultSet.next()) {
                Vector vTemp = new Vector();
                vTemp.add(resultSet.getInt(1)); //ID
                vTemp.add(resultSet.getString(2)); //NOMBRE
                vTemp.add(resultSet.getString(3)); //TIPO
                vTemp.add(resultSet.getString(4)); //CODIGO
                vTemp.add(resultSet.getString(6)); //ENCAPSULADO
                vTemp.add(resultSet.getString(8)); //UBICACION
                vTemp.add(resultSet.getString(9)); //ESTADO
                vTemp.add(resultSet.getString(10));//CANTIDAD
                resultado.add(vTemp);

            }//fin del if

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
//         return vTemp;
        return resultado;

    }

    public Vector buscarDatoF(String buscar) {//metodo para utilizar la tabla

        Vector resultado = new Vector();//vector es un tipo de arrayList 

        try {
            // datos obtenidos de la BD tabla
            resultSet = statement.executeQuery("SELECT * FROM DataS WHERE nombre LIKE '%" + buscar + "%'");

            while (resultSet.next()) {

                resultado.add(resultSet.getInt(1)); //ID
                resultado.add(resultSet.getString(2)); //NOMBRE
                resultado.add(resultSet.getString(3)); //TIPO
                resultado.add(resultSet.getString(4)); //CODIGO
                resultado.add(resultSet.getString(5)); //DESCRIPCION
                resultado.add(resultSet.getString(6)); //ENCAPSULADO
                resultado.add(resultSet.getString(7));//PATH PDF
                resultado.add(resultSet.getString(8)); //UBICACION
                resultado.add(resultSet.getString(9)); //ESTADO
                resultado.add(resultSet.getInt(10)); //CANTIDAD

            }//fin del if

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }

    public boolean eliminarDatoP(String id) {//eliminar dato

        try {
            String sql = "DELETE FROM DataS WHERE ";

            sql += "ID = " + id;// la coma es por si se eliminan varios registros

//          sql = sql.substring(0, sql.length()-1); //con esta instruccion elimina la coma que tiene la instruccion anterior
            // datos obtenidos de la BD tabla -> usuario
            int devolver = statement.executeUpdate(sql);

            if (devolver > 0) {
                return true; //ya que siempre devuelve false por lo tanto si hay algun error se atrapa en la excepcion
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return false;

    }// fin del metodo eliminar dato

    public int sizeVector(Vector v) {//metodo para utilizar la tabla

        return v.size();

    }
}//fin de la clase

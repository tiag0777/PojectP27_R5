package modelo.dao;

import java.util.ArrayList;

import javax.swing.JOptionPane;



import util.JDBCUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.vo.Lider;



public class Lider_Dao {

    public ArrayList<Lider> consultartodos() throws SQLException { 

        ArrayList<Lider> respuesta = new ArrayList<Lider>();
        Connection conn =  JDBCUtilities.getConnection();
        boolean existe=false;
        try {
            conn = JDBCUtilities.getConnection();
            // estrucura de las tuplas de la entidad
            String consulta = "SELECT * FROM Lider;";
                                                
            PreparedStatement statement = conn.prepareStatement(consulta);                
            ResultSet resultSet = statement.executeQuery(); 

            while(resultSet.next()){
                existe=true;
                Lider lideres = new Lider();
                lideres.setId_lider(resultSet.getInt(1));
                lideres.setNombre(resultSet.getString(2));
                lideres.setPrimer_Apellido(resultSet.getString(3));
                lideres.setSegundo_Nombre(resultSet.getString(4));
                lideres.setSalario(resultSet.getInt(5));
                lideres.setCiudad_Recidencia(resultSet.getString(6));
                lideres.setCargo(resultSet.getString(7));
                lideres.setClasificacion(resultSet.getInt(8));
                lideres.setDocumento_idendotad(resultSet.getString(9));
                lideres.setFecha_Nacimiento(resultSet.getInt(10));
                respuesta.add(lideres); 
            }
            resultSet.close();
            statement.close();        
            

        } catch (SQLException e){
            // JOptionPane.showMessageDialog(null, "error no se conecto");
            // System.out.println(e);
            System.err.println("error consultando los Materiales"+ e);
        }finally {
            if(conn != null){
                conn.close();
            }
        }
        return respuesta;
    }

    public Lider adicionarMaterial(Lider nuevolider) throws SQLException { 

        Lider materialAdicionados = null;
        Connection conn = null;
        ////hhhhhhh
        
        try {
            conn = JDBCUtilities.getConnection();
            String consulta =  "INSERT INTO Lider (Nombre, Primer_Apellido, Segundo_Apellido, Salario, Ciudad_Residencia, Cargo, Clasificacion, Documento_Identidad, Fecha_Nacimiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            //"SELECT * FROM MaterialConstruccion;";
            //"INSERT INTO MaterialConstruccion VALUES (?, ?, ?, ?)"   
            PreparedStatement statement = conn.prepareStatement(consulta);     
            statement.setString(1, nuevolider.getNombre()); 
            statement.setString(2, nuevolider.getPrimer_Apellido()); 
            statement.setString(3, nuevolider.getSegundo_Nombre()); 
            statement.setInt(4, nuevolider.getSalario());
            statement.setString(5, nuevolider.getCiudad_Recidencia());
            statement.setString(6, nuevolider.getCargo());
            statement.setString(7, nuevolider.getDocumento_idendotad());
            statement.setInt(8, nuevolider.getFecha_Nacimiento());
            //statement.setInt(4, nuevoMaterial.getIdMaterialConstruccion());     
            //actualizacion
            statement.executeUpdate(); 
            statement.close();        
            //si el proceso fue exitoso
            materialAdicionados = nuevolider;

        } catch (SQLException e){
            // JOptionPane.showMessageDialog(null, "error no se conecto");
            // System.out.println(e);
            System.err.println("error agregando  Materiales"+ e);
        }finally {
            if(conn != null){
                conn.close();
            }
        }
        // retornar la intancia del material nulo adocional
        return materialAdicionados;
    }
}


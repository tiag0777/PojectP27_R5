package modelo.dao;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import util.JDBCUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import modelo.vo.Requerimiento_1Vo;


public class Requerimiento_1Dao {
    public ArrayList<Requerimiento_1Vo> requerimiento1() throws SQLException { 

        ArrayList<Requerimiento_1Vo> respuesta = new ArrayList<>();
        Connection conn =  JDBCUtilities.getConnection();
        boolean existe=false;
        try {
            
            String consulta = "SELECT ID_lider,  Salario , Ciudad_Residencia "+ 
                              "FROM Lider l "+
                              "WHERE Salario>(select min(Salario) from Lider) AND Ciudad_Residencia = 'Barranquilla' "+ 
                            "ORDER BY Salario ASC ";
                                                
            PreparedStatement statement = conn.prepareStatement(consulta);                
            ResultSet resultSet = statement.executeQuery(); 

            while(resultSet.next()){
                existe=true;
                
                Requerimiento_1Vo requerimiento_1Vo = new Requerimiento_1Vo();
                requerimiento_1Vo.setId_lider(resultSet.getInt("id_lider"));
                requerimiento_1Vo.setSalario(resultSet.getInt("Salario"));
                requerimiento_1Vo.setCiudad_Residencia (resultSet.getString("Ciudad_Residencia"));
                respuesta.add(requerimiento_1Vo);
            }

            resultSet.close();
            statement.close();        
            

        } catch (SQLException e){
            // JOptionPane.showMessageDialog(null, "error no se conecto");
            // System.out.println(e);
            System.err.println("error consultando lideres y ciudades!! "+ e);
        }finally {
            if(conn != null){
                conn.close();
            }
        }
        return respuesta;
    }
}


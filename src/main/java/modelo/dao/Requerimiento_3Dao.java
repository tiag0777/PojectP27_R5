package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.vo.Requerimiento_3Vo;
import util.JDBCUtilities;

public class Requerimiento_3Dao {
    public ArrayList<Requerimiento_3Vo> requerimiento3() throws SQLException {
        
        ArrayList<Requerimiento_3Vo> respuesta = new ArrayList<Requerimiento_3Vo>();

        Connection conn =  JDBCUtilities.getConnection();

        try {
            String consulta = "SELECT p.ID_Proyecto, c.Proveedor "+
                              "FROM   Proyecto p JOIN Compra c ON(p.ID_Proyecto=c.ID_Proyecto ) WHERE p.ID_Proyecto BETWEEN 120 AND 124 "+
                              "ORDER BY  p.ID_Proyecto ASC ";

            PreparedStatement statement = conn.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Requerimiento_3Vo requerimiento_3vo = new Requerimiento_3Vo();
                requerimiento_3vo.setId_proyecto(resultSet.getInt("Id_Proyecto"));
                requerimiento_3vo.setProvedor(resultSet.getString("Proveedor"));
                respuesta.add(requerimiento_3vo);
            }
            resultSet.close();
            statement.close();
            

        } catch (Exception e) {
            System.err.println("error consulatando "+ e);
        }finally{
            if(conn !=null){
                conn.close();
            }
        }

        return respuesta;
    }
}
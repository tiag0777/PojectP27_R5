package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.vo.Requerimiento_2Vo;
import util.JDBCUtilities;

public class Requerimiento_2Dao {
    public ArrayList<Requerimiento_2Vo> requerimiento2() throws SQLException {
        
        ArrayList<Requerimiento_2Vo> respuesta = new ArrayList<Requerimiento_2Vo>();
        Connection conn =  JDBCUtilities.getConnection();

        try {
            String consulta = "SELECT ID_Proyecto, Nombre_Material, Importado "+
                              "FROM Compra c, MaterialConstruccion mc "+
                              "WHERE c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion "+
                              "AND ID_Proyecto in (1, 184, 400) "+
                              "ORDER BY ID_Proyecto ASC";

            PreparedStatement statement = conn.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Requerimiento_2Vo requerimiento_2Vo = new Requerimiento_2Vo();
                requerimiento_2Vo.setId_proyecto(resultSet.getInt("ID_Proyecto"));
                requerimiento_2Vo.setNombre_Material(resultSet.getString("Nombre_Material"));
                requerimiento_2Vo.setImportado(resultSet.getString("Importado"));
                respuesta.add(requerimiento_2Vo);

            }
            resultSet.close();
            statement.close(); 


        } catch (Exception e) {
            System.err.println("error consultando lideres y ciudades!! "+ e);
        }finally {
            if(conn != null){
                conn.close();
            }
        }
        return respuesta;
    }
}
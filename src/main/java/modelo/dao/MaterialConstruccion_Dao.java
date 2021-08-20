package modelo.dao;

import java.util.ArrayList;

import javax.swing.JOptionPane;



import util.JDBCUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import modelo.vo.MaterialConstruccion;


public class MaterialConstruccion_Dao {

    public ArrayList<MaterialConstruccion> consultartodos() throws SQLException { 

        ArrayList<MaterialConstruccion> respuesta = new ArrayList<MaterialConstruccion>();
        Connection conn =  JDBCUtilities.getConnection();
        boolean existe=false;
        try {
            conn = JDBCUtilities.getConnection();
            // estrucura de las tuplas de la entidad
            String consulta = "SELECT * FROM MaterialConstruccion;";
                                                
            PreparedStatement statement = conn.prepareStatement(consulta);                
            ResultSet resultSet = statement.executeQuery(); 

            while(resultSet.next()){
                existe=true;
                MaterialConstruccion material = new MaterialConstruccion();
                material.setIdMaterialConstruccion(resultSet.getInt(1));
                material.setNombreMaterial(resultSet.getString(2));
                material.setImportado(resultSet.getString(3));
                material.setPrecioUnidad(resultSet.getInt(4));
                respuesta.add(material); 
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

    public MaterialConstruccion adicionarMaterial(MaterialConstruccion nuevoMaterial) throws SQLException { 

        MaterialConstruccion materialAdicionado = null;
        Connection conn = null;
        ////hhhhhhh
        
        try {
            conn = JDBCUtilities.getConnection();
            String consulta =  "INSERT INTO MaterialConstruccion (Nombre_Material, Importado, Precio_Unidad) VALUES (? , ?, ?)";
            //"SELECT * FROM MaterialConstruccion;";
            //"INSERT INTO MaterialConstruccion VALUES (?, ?, ?, ?)"   
            PreparedStatement statement = conn.prepareStatement(consulta);     
            statement.setString(1, nuevoMaterial.getNombreMaterial()); 
            statement.setString(2, nuevoMaterial.getImportado()); 
            statement.setInt(3, nuevoMaterial.getPrecioUnidad()); 
            //statement.setInt(4, nuevoMaterial.getIdMaterialConstruccion());     
            //actualizacion
            statement.executeUpdate(); 
            statement.close();        
            //si el proceso fue exitoso
            materialAdicionado = nuevoMaterial;

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
        return materialAdicionado;
    }



    public MaterialConstruccion actualizarmateriales(MaterialConstruccion actualizarMaterial) throws SQLException { 

        MaterialConstruccion materialActilizado = null;
        Connection conn = null;
        ////hhhhhhh
    
        try {
            conn = JDBCUtilities.getConnection();
            String consulta =  "UPDATE  MaterialConstruccion SET  Nombre_Material = ?, Importado = ?, Precio_Unidad = ?; ";
            //"SELECT * FROM MaterialConstruccion;";
            //"INSERT INTO MaterialConstruccion VALUES (?, ?, ?, ?)"   
            PreparedStatement statement = conn.prepareStatement(consulta);     
            
            statement.setString(1, actualizarMaterial.getNombreMaterial()); 
            statement.setString(2, actualizarMaterial.getImportado()); 
            statement.setInt(3, actualizarMaterial.getPrecioUnidad()); 
            //statement.setInt(4, actualizarMaterial.getIdMaterialConstruccion());  
            
            //actualizacion
            statement.executeUpdate(); 
            statement.close();        
            //si el proceso fue exitoso
            materialActilizado = actualizarMaterial;
        } catch (SQLException e){
            // JOptionPane.showMessageDialog(null, "error no se conecto");
            // System.out.println(e);
            System.err.println("error Actualizando  Materiales"+ e);
        }finally {
            if(conn != null){
                conn.close();
            }
        }
        // retornar la intancia del material nulo adocional
        return materialActilizado;
    }
}
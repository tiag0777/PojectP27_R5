package controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modelo.dao.Requerimiento_1Dao;
import modelo.dao.Requerimiento_2Dao;
import modelo.dao.Requerimiento_3Dao;
import modelo.vo.Requerimiento_1Vo;
import modelo.vo.Requerimiento_2Vo;
import modelo.vo.Requerimiento_3Vo;
import modelo.vo.Lider;
import modelo.vo.MaterialConstruccion;
import modelo.dao.MaterialConstruccion_Dao;
import modelo.vo.Lider;
import modelo.dao.Lider_Dao;

import vista.MenuPrincipalGUI;
import vista.Requerimirnto1_GUI;
import vista.Requerimirnto2_GUI;
import vista.cRUD_lideres_GUI;
import vista.CRUD_materiales_GUI;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControladorRequerimientos implements ActionListener{
    private final Requerimiento_1Dao Requerimiento_1Dao;
    private final Requerimiento_2Dao Requerimiento_2Dao;
    private final Requerimiento_3Dao Requerimiento_3Dao;
    private final MaterialConstruccion_Dao materialConstruccion_Dao;
    private final Lider_Dao lider_Dao;

  
    
    private final MenuPrincipalGUI MenuPrincipalGUI;
    private Requerimirnto1_GUI requerimirnto1_GUI;
    private Requerimirnto2_GUI requerimirnto2_GUI;
    private CRUD_materiales_GUI crud_materiales_GUI;
    private cRUD_lideres_GUI cRUD_lideres_GUI;
    
    
    public ControladorRequerimientos(){
        this.Requerimiento_1Dao= new Requerimiento_1Dao();
        this.Requerimiento_2Dao = new Requerimiento_2Dao();
        this.Requerimiento_3Dao = new Requerimiento_3Dao();
        this.materialConstruccion_Dao = new MaterialConstruccion_Dao();
        this.MenuPrincipalGUI = new MenuPrincipalGUI();
        this.lider_Dao = new Lider_Dao();
    
    
    
    }
    public ArrayList<Requerimiento_1Vo> consultarRequerimiento1() throws SQLException {
        return this.Requerimiento_1Dao.requerimiento1();
        
    }

    public ArrayList<Requerimiento_2Vo> consultarRequerimiento2() throws SQLException {
        return this.Requerimiento_2Dao.requerimiento2();
    }

    public ArrayList<Requerimiento_3Vo> consultarRequerimiento3() throws SQLException {
        return this.Requerimiento_3Dao.requerimiento3();
    }
    // public ArrayList<Lider> consultar() throws SQLException{
    //     return this.lider_Dao.consultartodos();
    // }

    public void iniciarAplicacion(){
        this.MenuPrincipalGUI.iniciarGUI(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
            //obtener el evento boton
            String actioncomand = ((JButton)e.getSource()).getActionCommand();
            switch(actioncomand){

                case "listadolideres":
                    System.out.println("Interfaz listado lideres!");
                    try {
                        
                    ArrayList<Requerimiento_1Vo> proyectos = new ArrayList<Requerimiento_1Vo>();
                    proyectos = this.Requerimiento_1Dao.requerimiento1();
            
                    this.requerimirnto1_GUI = new Requerimirnto1_GUI(proyectos);
                } catch (SQLException eproyectoslideres) {
                    System.err.println("error cargando rlq "+eproyectoslideres);
                }
                break;

                case "listaMateriales":
                    System.out.println("Interfaz Materiales de Construccion!");

                    try {
                    ArrayList<Requerimiento_2Vo> materiales = new ArrayList<Requerimiento_2Vo>();
                    materiales = this.Requerimiento_2Dao.requerimiento2();
                    this.requerimirnto2_GUI = new Requerimirnto2_GUI(materiales);
                    } catch (SQLException emateriales) {
                        System.err.println("error cargando rlq2 " +emateriales);
                    }
                break;
                case "crudMateriales":
                    try {
                        ArrayList<MaterialConstruccion> materiales = new ArrayList<MaterialConstruccion>();
                        materiales = this.materialConstruccion_Dao.consultartodos();
                        this.crud_materiales_GUI = new CRUD_materiales_GUI(materiales, this);
                    } catch (SQLException ematerialesCRUD) {
                            System.err.println("error cargando materiales de construccion!!!" +ematerialesCRUD);
                    }                   
                break;
                case "adicionarMaterial":
                            //recorrer la imformacion del formulario o de la GUI
                        MaterialConstruccion nuevomaterial = new MaterialConstruccion();
                        nuevomaterial.setIdMaterialConstruccion(Integer.valueOf(crud_materiales_GUI.getTxtid_proyecto().getText()));
                        nuevomaterial.setNombreMaterial(crud_materiales_GUI.getTxtNombre_Material().getText());
                        nuevomaterial.setImportado(crud_materiales_GUI.getTxtImportado().getText());
                        int preciounidad=0;
                        try {
                            preciounidad = Integer.valueOf(crud_materiales_GUI.getTxtpreciounidad().getText());
                            
                        } catch(NumberFormatException eformacion) {
                            preciounidad = Integer.valueOf(JOptionPane.showInputDialog(
                                crud_materiales_GUI,
                                "ingrese un precio valido (numerico):", 
                                "error de formato",
                                JOptionPane.ERROR_MESSAGE));
                        }
                        nuevomaterial.setPrecioUnidad(preciounidad);
                        
                        MaterialConstruccion materialRegistrado = null;
                        try{
                            materialRegistrado = materialConstruccion_Dao.adicionarMaterial(nuevomaterial);
                        }catch(SQLException enuevomaterial) {
                            JOptionPane.showMessageDialog(
                                crud_materiales_GUI,
                                "Error insertando nuevo material ",
                                "Error db",
                                JOptionPane.ERROR_MESSAGE
                                );
                        }   
                        if(materialRegistrado != null){
                            JOptionPane.showInputDialog(
                                crud_materiales_GUI,
                                "Registro exitoso!!", 
                                "Transacion completa db",
                                JOptionPane.INFORMATION_MESSAGE
                                );
                            crud_materiales_GUI.getTxtid_proyecto().setText("");
                            crud_materiales_GUI.getTxtNombre_Material().setText("");
                            crud_materiales_GUI.getTxtImportado().setText("");
                            crud_materiales_GUI.getTxtpreciounidad().setText("");

                        }   
                        crud_materiales_GUI.dispose();

                        try {
                            crud_materiales_GUI = new CRUD_materiales_GUI(materialConstruccion_Dao.consultartodos(), this);
                        } catch (SQLException ereconsiliando) {
                            JOptionPane.showMessageDialog(
                                crud_materiales_GUI,
                                "Error consultando los materiales", 
                                "Error db", 
                                JOptionPane.ERROR_MESSAGE
                                );
                        }        
                    
                break;

                case "crudlideres":
                    try {
                        ArrayList<Lider> salarios = new ArrayList<Lider>();
                        salarios = this.lider_Dao.consultartodos();
                        this.cRUD_lideres_GUI = new cRUD_lideres_GUI(salarios,this); 
                    } catch (SQLException esalarios) {
                        System.err.println("error cargando tabla lideres"+esalarios);
                    }
                break;
                case "adicionarMateriales":
                                //recorrer la imformacion del formulario o de la GUI
                    Lider nuevoLider = new Lider();
                            // nuevomaterial.setIdMaterialConstruccion(Integer.valueOf(crud_materiales_GUI.getTxtid_proyecto().getText()));
                    nuevoLider.setNombre(cRUD_lideres_GUI.getTxtNombre().getText());
                    nuevoLider.setPrimer_Apellido(cRUD_lideres_GUI.getTxtPrimer_Apellido().getText());
                    nuevoLider.setSegundo_Nombre(cRUD_lideres_GUI.getTxtSegundo_Nombre().getText());
                    nuevoLider.setSalario(Integer.valueOf(cRUD_lideres_GUI.getTxtSalario().getText()));
                    nuevoLider.setCiudad_Recidencia(cRUD_lideres_GUI.getTxtCiudad_Recidencia().getText());
                    nuevoLider.setCargo(cRUD_lideres_GUI.getTxtcargo().getText());
                    nuevoLider.setClasificacion(Integer.valueOf(cRUD_lideres_GUI.getTxtClasificacion().getText()));
                    nuevoLider.setDocumento_idendotad(cRUD_lideres_GUI.getTxtDocumento_identidad().getText());
                    ///nuevoLider.setFecha_Nacimiento(Integer.valueOf(cRUD_lideres_GUI.getTxtFecha_Nacimiento().getText()));
                    int fecha_Nacimiento=0;
                    
                    try {
                        fecha_Nacimiento = Integer.valueOf(cRUD_lideres_GUI.getTxtFecha_Nacimiento().getText());

                    } catch(NumberFormatException eformaciones) {
                            fecha_Nacimiento = Integer.valueOf(JOptionPane.showInputDialog(
                                cRUD_lideres_GUI,
                                "ingrese un precio valido (numerico):", 
                                "error de formato",
                                JOptionPane.ERROR_MESSAGE));
                        }
                        nuevoLider.setFecha_Nacimiento(fecha_Nacimiento);
                            
                        Lider liderregistrado = null;
                        try{
                            liderregistrado = lider_Dao.adicionarMaterial(nuevoLider);
                        }catch(SQLException enuevomaterial) {
                            JOptionPane.showMessageDialog(
                                cRUD_lideres_GUI,
                                "Error insertando nuevo lider ",
                                "Error db",
                                JOptionPane.ERROR_MESSAGE
                                );
                        }   
                        if(liderregistrado != null){
                            JOptionPane.showInputDialog(
                                cRUD_lideres_GUI,
                                "Registro exitoso!!", 
                                "Transacion completa db",
                                JOptionPane.INFORMATION_MESSAGE
                                );
                                cRUD_lideres_GUI.getTxtNombre().setText("");
                                cRUD_lideres_GUI.getTxtPrimer_Apellido().setText("");
                                cRUD_lideres_GUI.getTxtSegundo_Nombre().setText("");
                                cRUD_lideres_GUI.getTxtSalario().setText("");
                                cRUD_lideres_GUI.getTxtCiudad_Recidencia().setText("");
                                cRUD_lideres_GUI.getTxtcargo().setText("");
                                cRUD_lideres_GUI.getTxtClasificacion().setText("");
                                cRUD_lideres_GUI.getTxtDocumento_identidad().setText("");
                                cRUD_lideres_GUI.getTxtFecha_Nacimiento().setText("");
                            }   
                           // cRUD_lideres_GUI.dispose();

                            // try {
                            //     cRUD_lideres_GUI = CRUD_materiales_GUI(lider_Dao.consultartodos(), this);
                            //     //(materialConstruccion_Dao.consultartodos(), this);
                            // } catch (SQLException ereconsiliandos) {
                            //     JOptionPane.showMessageDialog(
                            //         cRUD_lideres_GUI,
                            //         "Error consultando lideres", 
                            //         "Error db", 
                            //         JOptionPane.ERROR_MESSAGE
                            //         );
                                
                            //     }        
                
                break;
            }  

    }
    
    
    
    
}


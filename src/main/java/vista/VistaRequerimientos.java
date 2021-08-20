package vista;

import java.util.ArrayList;

import controlador.ControladorRequerimientos;
import modelo.vo.Requerimiento_1Vo;
import modelo.vo.Requerimiento_2Vo;
import modelo.vo.Requerimiento_3Vo;

public class VistaRequerimientos {

    public static final ControladorRequerimientos Controlador = new ControladorRequerimientos();

    public static void requerimiento1() {
        try {
            ArrayList<Requerimiento_1Vo> listarequerimiento_1vo;

            listarequerimiento_1vo = Controlador.consultarRequerimiento1();

            for(Requerimiento_1Vo requerimiento_1Vo : listarequerimiento_1vo){
                System.out.printf("%s %s %s %n",
                    requerimiento_1Vo.getId_lider(),
                    requerimiento_1Vo.getSalario(),
                    requerimiento_1Vo.getCiudad_Residencia()
                    );
            }
        } catch (Exception e) {
            System.out.println("Se ha producido el siguiente error:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void requerimiento2() {
        try {
            ArrayList<Requerimiento_2Vo> listarequerimientos_2vo;

            listarequerimientos_2vo = Controlador.consultarRequerimiento2();

            for(Requerimiento_2Vo requerimiento_2Vo : listarequerimientos_2vo){
                System.out.printf("%s %s %s %n",
                    requerimiento_2Vo.getId_proyecto() ,
                    requerimiento_2Vo.getNombre_Material() ,
                    requerimiento_2Vo.getImportado()
                    );
            }
        } catch (Exception e) {
            System.out.println("Se ha producido el siguiente error:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void requerimiento3() {
        try {
            ArrayList<Requerimiento_3Vo> listarequerimiento_3vo;
            listarequerimiento_3vo = Controlador.consultarRequerimiento3();

            for(Requerimiento_3Vo requerimiento_3Vo : listarequerimiento_3vo){
                System.out.printf("%s %s %n",
                  requerimiento_3Vo.getId_proyecto() ,
                  requerimiento_3Vo.getProvedor()
                );
            }
            
        } catch (Exception e) {
            System.out.println("Se ha producido el siguiente error:" + e.getMessage());
            e.printStackTrace();
        }
    }

}

package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Image;
import controlador.ControladorRequerimientos;
import modelo.vo.Requerimiento_2Vo;
import java.util.ArrayList;

public class Requerimirnto2_GUI extends JFrame{

    /// Atributos -> Componentes intermedios y componentes
    
    // private JButton btnRequerimiento1;
    // private JButton btnRequerimiento2;
    // // private JButton btnRequerimiento3;
    private JTable jtmateriales;
    ///constructor realizar la compocion de la ventana
    public Requerimirnto2_GUI(ArrayList<Requerimiento_2Vo> materiales){

      setTitle("Materiales Utilizados");
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);

      String[] encabezado = {"id_Proyecto", "Nombre_Material", "Importado"};
      this.jtmateriales = new JTable(this.formatoregistro(materiales, encabezado.length), encabezado);
      JScrollPane sp = new JScrollPane(this.jtmateriales);
        // //tabla que presentara los proyectos
      JPanel panel = new JPanel(new GridLayout());
      panel.setBorder(new TitledBorder("listado de los Materiles Usados"));
      panel.add(sp);

      getContentPane().add(panel);
       
        /// MOSTRAR VENTANA
      setSize(400,300);
      setLocationRelativeTo(null);
      setVisible(true);
    }
    private ImageIcon redimensionaricono(ImageIcon icono, int pixeles){
        Image Image = icono.getImage();
        Image newming = Image.getScaledInstance(pixeles, pixeles, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newming);
    
    }
    private String[][] formatoregistro(ArrayList<Requerimiento_2Vo> materiales, int numeroEncabezados){
      //contenedor retorno
      String[][] registro = new String[materiales.size()][numeroEncabezados];
      for(int o = 0; o < materiales.size(); o++){
        registro[o][0] = String.valueOf(materiales.get(o).getId_proyecto());
        registro[o][1] = String.valueOf
        (materiales.get(o).getNombre_Material());
        registro[o][2] = materiales.get(o).getImportado();
    }
      


      return registro;
    }

    
    
    
}

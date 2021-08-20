package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Image;
import controlador.ControladorRequerimientos;
import modelo.vo.Requerimiento_1Vo;
import java.util.ArrayList;


public class Requerimirnto1_GUI extends JFrame {

    /// Atributos -> Componentes intermedios y componentes
    
    // private JButton btnRequerimiento1;
    // private JButton btnRequerimiento2;
    // // private JButton btnRequerimiento3;
    private JTable jtproyectos;
    ///constructor realizar la compocion de la ventana
    public Requerimirnto1_GUI(ArrayList<Requerimiento_1Vo> proyectos){

        setTitle("Listado De Los Lideres");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        String[] encabezado = {"ID_lider", "Salario", "Ciudad_Residencia"}; 
        this.jtproyectos = new JTable(this.formatoregistro(proyectos, encabezado.length), encabezado);
        JScrollPane sp = new JScrollPane(this.jtproyectos);
        // //tabla que presentara los proyectos
        JPanel panel = new JPanel(new GridLayout());
        panel.setBorder(new TitledBorder("listado de los lideres y salarios"));
        // panel.setBorder(new EmptyBorder(10,5,10,5));
        // setContentPane(panel);
        
        
        panel.add(sp);

        getContentPane().add(panel);
       
        /// MOSTRAR VENTANA
        setSize(400,200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private ImageIcon redimensionaricono(ImageIcon icono, int pixeles){
        Image Image = icono.getImage();
        Image newming = Image.getScaledInstance(pixeles, pixeles, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newming);
    
    }
    private String[][] formatoregistro(ArrayList<Requerimiento_1Vo> proyectos, int numeroEncabezados){
      //contenedor retorno
      String[][] registro = new String[proyectos.size()][numeroEncabezados];
      for(int i = 0; i < proyectos.size(); i++){
        registro[i][0] = String.valueOf(proyectos.get(i).getId_lider());
        registro[i][1] = String.valueOf(proyectos.get(i).getSalario());
        registro[i][2] = proyectos.get(i).getCiudad_Residencia();
    }
    
      return registro;
    }
}

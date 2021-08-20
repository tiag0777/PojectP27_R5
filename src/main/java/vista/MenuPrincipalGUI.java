package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Image;
import controlador.ControladorRequerimientos;

public class MenuPrincipalGUI extends JFrame {

    /// Atributos -> Componentes intermedios y componentes
   
    private JButton btnRequerimiento1;
    private JButton btnRequerimiento2;
    private JButton btnCRUD_Materialez;
    private JButton btncrudlideres;
    // private JButton btnRequerimiento3;

    ///constructor realizar la compocion de la ventana
    public MenuPrincipalGUI(){

    }
    private ImageIcon redimensionaricono(ImageIcon icono, int pixeles){
        Image Image = icono.getImage();
        Image newming = Image.getScaledInstance(pixeles, pixeles, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newming);
    
    }
    public void iniciarGUI(ControladorRequerimientos controlador){
        ///propiedades de la ventana
     
        
        setTitle("Menu Principal Reto 5 / CRUD");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        /// AGREGAR botones
        
        btnRequerimiento1 = new JButton(redimensionaricono(new ImageIcon("imagnes/salario.png"), 120));
        btnRequerimiento1.setText("lideres");
        //quien me va escuchar
        btnRequerimiento1.addActionListener(controlador);
        btnRequerimiento1.setActionCommand("listadolideres");

        btnRequerimiento2 = new JButton(redimensionaricono(new ImageIcon("imagnes/cemento.png"), 120));
        btnRequerimiento2.setText("Materiales");
        btnRequerimiento2.addActionListener(controlador);
        btnRequerimiento2.setActionCommand("listaMateriales");

        btnCRUD_Materialez = new JButton(redimensionaricono(new ImageIcon("imagnes/mesa.png"), 120));
        btnCRUD_Materialez.setText("Materiales Usados");
        btnCRUD_Materialez.addActionListener(controlador);
        btnCRUD_Materialez.setActionCommand("crudMateriales");

        btncrudlideres = new JButton(redimensionaricono(new ImageIcon("imagnes/lideres.png"), 120));
        btncrudlideres.setText("consultar tabla");
        btncrudlideres.addActionListener(controlador);
        btncrudlideres.setActionCommand("crudlideres");
        // btnRequerimiento3 = new JButton(redimensionaricono(new ImageIcon("imagnes/entrega.png"), 64));
        // btnRequerimiento3.setText("Provedores");
        // btnRequerimiento3.addActionListener(controlador);
        // btnRequerimiento3.setActionCommand("NombresProvedores");
        ///asociar los botones al botones intermedio o al contenedor
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(btnRequerimiento1);
        panel.add(btnRequerimiento2);
        panel.add(btncrudlideres);
        panel.add(btnCRUD_Materialez);
        // panel.add(btnRequerimiento3);

        getContentPane().add(panel);
       
        /// MOSTRAR VENTANA
        setSize(600,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    
    
}

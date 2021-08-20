package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Image;
import controlador.ControladorRequerimientos;
import modelo.vo.MaterialConstruccion;
import java.util.ArrayList;

public class CRUD_materiales_GUI extends JFrame {

    /// Atributos -> Componentes intermedios y componentes
    private JTable jtmateriales;
    private DefaultTableModel modeloTablaMateriales;
    private JButton btnAdicionar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JTextField txtpreciounidad;
    private JTextField txtid_proyecto;
    private JTextField txtNombre_Material;
    private JTextField txtImportado;
    private JLabel lblpreciounidad;
    private JLabel lblid_proyecto;
    private JLabel lblNombre_Material;
    private JLabel lblImportado;
    // private JButton btnRequerimiento3;
    ///constructor realizar la compocion de la ventana
    public CRUD_materiales_GUI(ArrayList<MaterialConstruccion> materiales, ControladorRequerimientos controlador){

        setTitle("Gestion De Materiales");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout());

        String[] encabezado = {"ID Material", "Nombre ", "Importado", "Precio Unitario"}; 
        //forma de construccion de la tabla
        ///this.jtmateriales = new JTable(this.formatoregistro(materiales, encabezado.length), encabezado);
        //contruir quien es editable
        modeloTablaMateriales = new DefaultTableModel(this.formatoregistro(materiales, encabezado.length), encabezado){

          @Override
          public boolean isCellEditable(int row, int column) {
           
            return column !=0;
          }
          //personaizar quien es editable
          
        };
        this.jtmateriales = new JTable(modeloTablaMateriales);
        //colocar interni tabla en caso de sobrepasrce
        JScrollPane sp = new JScrollPane(this.jtmateriales);
        // //tabla que presentara los proyectos
        JPanel panel = new JPanel(new GridLayout());
        panel.setBorder(new TitledBorder("Materiales del sistema"));
        panel.add(sp);

        JPanel panelsectorderecho = new JPanel(new GridLayout(2,1));
        panelsectorderecho.setBorder(new TitledBorder("Registro de Materiales del sistema"));
        //componente intermedio para formulario de adicion al material
        JPanel panelFormularioAdicion = new JPanel(new GridLayout(5,2,0,25));
        //JPanel panelFormularioAdicion = new JPanel(new GridLayout(4,2,0,35));
        // panelFormularioAdicion.setBorder(new TitledBorder("Registro de Materiales del sistema"));

        this.lblid_proyecto = new JLabel("ID Materiales: ",SwingConstants.RIGHT);
        this.lblNombre_Material = new JLabel("Nombre Material: ",SwingConstants.RIGHT);
        this.lblImportado = new JLabel("Importado: ",SwingConstants.RIGHT);
        this.lblpreciounidad = new JLabel("Precio Unidad: ",SwingConstants.RIGHT);

        this.txtid_proyecto = new JTextField();
        this.txtNombre_Material = new JTextField();
        this.txtImportado = new JTextField();
        this.txtpreciounidad = new JTextField();
        
        panelFormularioAdicion.add(this.lblid_proyecto);
        panelFormularioAdicion.add(this.txtid_proyecto);
        panelFormularioAdicion.add(this.lblNombre_Material);
        panelFormularioAdicion.add(this.txtNombre_Material);
        panelFormularioAdicion.add(this.lblImportado);
        panelFormularioAdicion.add(this.txtImportado);
        panelFormularioAdicion.add(this.lblpreciounidad);
        panelFormularioAdicion.add(this.txtpreciounidad);
       

        JPanel panelbotones = new JPanel(new GridLayout(1,3));
        panelbotones.setBorder(new TitledBorder("Acciones"));
        
        btnAdicionar = new JButton(redimensionaricono(new ImageIcon("imagnes/agregar.png"), 28));
        btnAdicionar.setText("Agregar");
        btnAdicionar.addActionListener(controlador);
        btnAdicionar.setActionCommand("adicionarMaterial");

        btnActualizar = new JButton(redimensionaricono(new ImageIcon("imagnes/actualizar.png"), 28));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(controlador);
        btnActualizar.setActionCommand("actualizarMaterial");

        btnEliminar = new JButton(redimensionaricono(new ImageIcon("imagnes/eliminar.png"), 28));
        btnEliminar.setText("Borrar");
        btnEliminar.addActionListener(controlador);
        btnEliminar.setActionCommand("borrarMaterial");

        panelbotones.add(btnAdicionar);
        panelbotones.add(btnActualizar);
        panelbotones.add(btnEliminar);

        panelsectorderecho.add(panelFormularioAdicion);
        panelsectorderecho.add(panelbotones);

        //panelFormularioAdicion.add(panelbotones);

        getContentPane().add(panel);
        getContentPane().add(panelsectorderecho);
        //getContentPane().add(panelFormularioAdicion);
        /// MOSTRAR VENTANA
        setSize(800,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private ImageIcon redimensionaricono(ImageIcon icono, int pixeles){
        Image Image = icono.getImage();
        Image newming = Image.getScaledInstance(pixeles, pixeles, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newming);
    
    }
    private String[][] formatoregistro(ArrayList<MaterialConstruccion> materiales, int numeroEncabezados){
      //contenedor retorno
      String[][] registro = new String[materiales.size()][numeroEncabezados];

      for(int i = 0; i < materiales.size(); i++){
        registro[i][0] = String.valueOf(materiales.get(i).getIdMaterialConstruccion());
        registro[i][1] = materiales.get(i).getNombreMaterial();
        registro[i][2] = materiales.get(i).getImportado();
        registro[i][3] = String.valueOf(materiales.get(i).getPrecioUnidad());
    }
    
      return registro;
    }
    public JTable getJtmateriales() {
      return jtmateriales;
    }
    public void setJtmateriales(JTable jtmateriales) {
      this.jtmateriales = jtmateriales;
    }
    public JTextField getTxtpreciounidad() {
      return txtpreciounidad;
    }
    public void setTxtpreciounidad(JTextField txtpreciounidad) {
      this.txtpreciounidad = txtpreciounidad;
    }
    public JTextField getTxtid_proyecto() {
      return txtid_proyecto;
    }
    public void setTxtid_proyecto(JTextField txtid_proyecto) {
      this.txtid_proyecto = txtid_proyecto;
    }
    public JTextField getTxtNombre_Material() {
      return txtNombre_Material;
    }
    public void setTxtNombre_Material(JTextField txtNombre_Material) {
      this.txtNombre_Material = txtNombre_Material;
    }
    public JTextField getTxtImportado() {
      return txtImportado;
    }
    public void setTxtImportado(JTextField txtImportado) {
      this.txtImportado = txtImportado;
    }
    public DefaultTableModel getModeloTablaMateriales() {
      return modeloTablaMateriales;
    }
    public void setModeloTablaMateriales(DefaultTableModel modeloTablaMateriales) {
      this.modeloTablaMateriales = modeloTablaMateriales;
    }
    

    
}

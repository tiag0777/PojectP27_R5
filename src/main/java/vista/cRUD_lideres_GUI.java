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
import modelo.vo.Lider;
import modelo.vo.MaterialConstruccion;
import java.util.ArrayList;

public class cRUD_lideres_GUI extends JFrame {

    /// Atributos -> Componentes intermedios y componentes
    private JTable jtlideres;
    private DefaultTableModel modeloTablalideres;
    private JButton btnAdicionar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JTextField txtNombre;
    private JTextField txtPrimer_Apellido;
    private JTextField txtSegundo_Nombre;
    private JTextField txtSalario;
    private JTextField txtCiudad_Recidencia;
    private JTextField txtcargo;
    private JTextField txtClasificacion;
    private JTextField txtDocumento_identidad;
    private JTextField txtFecha_Nacimiento;
    private JLabel lblFecha_Nacimiento;
    private JLabel lblDocuemto_idendidad;
    private JLabel lblClasificacion;
    private JLabel lblcargo;
    private JLabel lblCiudad_Recidencia;
    private JLabel lblSalario;
    private JLabel lblPrimer_Apellido;
    private JLabel lblSegundo_Nombre;
    private JLabel lblNombre;
    // private JButton btnRequerimiento3;
    ///constructor realizar la compocion de la ventana
    public cRUD_lideres_GUI(ArrayList<Lider> lideres, ControladorRequerimientos controlador){

        setTitle("Gestion lideres y salarios");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout());

        String[] encabezado = {"ID_lider", "Nombre ", "Primer_Apeellido", "Seguno_Apellido", "Salario", "Ciudad_Recidencia", "Cargo", "Clasificacion", "Documento_Idendidad", "Fecha_Nacimiento"}; 
        //forma de construccion de la tabla
        ///this.jtmateriales = new JTable(this.formatoregistro(materiales, encabezado.length), encabezado);
        //contruir quien es editable
        modeloTablalideres = new DefaultTableModel(this.formatoregistro(lideres, encabezado.length), encabezado){

          @Override
          public boolean isCellEditable(int row, int column) {
           
            return column !=0;
          }
          //personaizar quien es editable
          
        };
        this.jtlideres = new JTable(modeloTablalideres);
        //colocar interni tabla en caso de sobrepasrce
        JScrollPane sp = new JScrollPane(this.jtlideres);
        // //tabla que presentara los proyectos
        JPanel panel = new JPanel(new GridLayout());
        panel.setBorder(new TitledBorder("Tabla lider"));
        panel.add(sp);

        JPanel panelsectorderecho = new JPanel(new GridLayout(2,1));
        panelsectorderecho.setBorder(new TitledBorder("Registro lideres y Salarios"));
        //componente intermedio para formulario de adicion al material
        JPanel panelFormularioAdicion2 = new JPanel(new GridLayout(10,2,0,18));
        //JPanel panelFormularioAdicion = new JPanel(new GridLayout(4,2,0,35));
        // panelFormularioAdicion.setBorder(new TitledBorder("Registro de Materiales del sistema"));

        this.lblNombre = new JLabel("Nombre: ",SwingConstants.RIGHT);
        this.lblPrimer_Apellido = new JLabel("Primer Apellido: ",SwingConstants.RIGHT );
        this.lblSegundo_Nombre = new JLabel("Segundo Apellido: ",SwingConstants.RIGHT);
        this.lblSalario = new JLabel("Salario: ",SwingConstants.RIGHT);
        this.lblCiudad_Recidencia = new JLabel("Cuidad Recidencia: ",SwingConstants.RIGHT);
        this.lblcargo = new JLabel("Cargo: ",SwingConstants.RIGHT);
        this.lblClasificacion = new JLabel("Clasificacio: ",SwingConstants.RIGHT);
        this.lblDocuemto_idendidad = new JLabel("Documento Idenditad: ",SwingConstants.RIGHT);
        this.lblFecha_Nacimiento = new JLabel("Fecha Naciento: ",SwingConstants.RIGHT);



        this.txtNombre = new JTextField();
        this.txtPrimer_Apellido= new JTextField();
        this.txtSegundo_Nombre = new JTextField();
        this.txtSalario = new JTextField();
        this.txtCiudad_Recidencia = new JTextField();
        this.txtcargo = new JTextField();
        this.txtClasificacion = new JTextField();
        this.txtDocumento_identidad= new JTextField();
        this.txtFecha_Nacimiento = new JTextField();
        
        panelFormularioAdicion2.add(this.lblNombre);
        panelFormularioAdicion2.add(this.txtNombre);
        panelFormularioAdicion2.add(this.lblPrimer_Apellido);
        panelFormularioAdicion2.add(this.txtPrimer_Apellido);
        panelFormularioAdicion2.add(this.lblSegundo_Nombre);
        panelFormularioAdicion2.add(this.txtSegundo_Nombre);
        panelFormularioAdicion2.add(this.lblSalario);
        panelFormularioAdicion2.add(this.txtSalario);
        panelFormularioAdicion2.add(this.lblCiudad_Recidencia);
        panelFormularioAdicion2.add(this.txtCiudad_Recidencia);
        panelFormularioAdicion2.add(this.lblcargo);
        panelFormularioAdicion2.add(this.txtcargo);
        panelFormularioAdicion2.add(this.lblClasificacion);
        panelFormularioAdicion2.add(this.txtClasificacion);
        panelFormularioAdicion2.add(this.lblDocuemto_idendidad);
        panelFormularioAdicion2.add(this.txtDocumento_identidad);
        panelFormularioAdicion2.add(this.lblFecha_Nacimiento);
        panelFormularioAdicion2.add(this.txtFecha_Nacimiento);
       

        JPanel panelbotones = new JPanel(new GridLayout(1,3));
        panelbotones.setBorder(new TitledBorder("Acciones"));
        
        btnAdicionar = new JButton(redimensionaricono(new ImageIcon("imagnes/agregar.png"), 25));
        btnAdicionar.setText("Agregar");
        btnAdicionar.addActionListener(controlador);
        btnAdicionar.setActionCommand("adicionarMateriales");

        btnActualizar = new JButton(redimensionaricono(new ImageIcon("imagnes/actualizar.png"), 25));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(controlador);
        btnActualizar.setActionCommand("actualizarMaterial");

        btnEliminar = new JButton(redimensionaricono(new ImageIcon("imagnes/eliminar.png"), 25));
        btnEliminar.setText("Borrar");
        btnEliminar.addActionListener(controlador);
        btnEliminar.setActionCommand("borrarMaterial");

        panelbotones.add(btnAdicionar);
        panelbotones.add(btnActualizar);
        panelbotones.add(btnEliminar);

        panelsectorderecho.add(panelFormularioAdicion2);
        panelsectorderecho.add(panelbotones);

        ///panelFormularioAdicion2.add(panelbotones);

        getContentPane().add(panel);
        getContentPane().add(panelsectorderecho);
        //getContentPane().add(panelFormularioAdicion2);
        /// MOSTRAR VENTANA
        setSize(1200,800);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private ImageIcon redimensionaricono(ImageIcon icono, int pixeles){
        Image Image = icono.getImage();
        Image newming = Image.getScaledInstance(pixeles, pixeles, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newming);
    
    }
    private String[][] formatoregistro(ArrayList<Lider> lideres, int numeroEncabezados){
      //contenedor retorno
      String[][] registro = new String[lideres.size()][numeroEncabezados];

      for(int i = 0; i < lideres.size(); i++){
        registro[i][0] = String.valueOf(lideres.get(i).getId_lider());
        registro[i][1] = lideres.get(i).getNombre();
        registro[i][2] = lideres.get(i).getPrimer_Apellido();
        registro[i][3] = lideres.get(i).getSegundo_Nombre();
        registro[i][4] = String.valueOf(lideres.get(i).getSalario());
        registro[i][5] = lideres.get(i).getCiudad_Recidencia();
        registro[i][6] = lideres.get(i).getCargo();
        registro[i][7] = String.valueOf(lideres.get(i).getClasificacion());
        registro[i][8] = lideres.get(i).getDocumento_idendotad();
        registro[i][9] = String.valueOf(lideres.get(i).getFecha_Nacimiento());
    }
    
      return registro;
    }
    public JTable getJtlideres() {
      return jtlideres;
    }
    public void setJtlideres(JTable jtlideres) {
      this.jtlideres = jtlideres;
    }
    public DefaultTableModel getModeloTablalideres() {
      return modeloTablalideres;
    }
    public void setModeloTablalideres(DefaultTableModel modeloTablalideres) {
      this.modeloTablalideres = modeloTablalideres;
    }
    public JTextField getTxtNombre() {
      return txtNombre;
    }
    public void setTxtNombre(JTextField txtNombre) {
      this.txtNombre = txtNombre;
    }
    public JTextField getTxtPrimer_Apellido() {
      return txtPrimer_Apellido;
    }
    public void setTxtPrimer_Apellido(JTextField txtPrimer_Apellido) {
      this.txtPrimer_Apellido = txtPrimer_Apellido;
    }
    public JTextField getTxtSegundo_Nombre() {
      return txtSegundo_Nombre;
    }
    public void setTxtSegundo_Nombre(JTextField txtSegundo_Nombre) {
      this.txtSegundo_Nombre = txtSegundo_Nombre;
    }
    public JTextField getTxtSalario() {
      return txtSalario;
    }
    public void setTxtSalario(JTextField txtSalario) {
      this.txtSalario = txtSalario;
    }
    public JTextField getTxtCiudad_Recidencia() {
      return txtCiudad_Recidencia;
    }
    public void setTxtCiudad_Recidencia(JTextField txtCiudad_Recidencia) {
      this.txtCiudad_Recidencia = txtCiudad_Recidencia;
    }
    public JTextField getTxtcargo() {
      return txtcargo;
    }
    public void setTxtcargo(JTextField txtcargo) {
      this.txtcargo = txtcargo;
    }
    public JTextField getTxtClasificacion() {
      return txtClasificacion;
    }
    public void setTxtClasificacion(JTextField txtClasificacion) {
      this.txtClasificacion = txtClasificacion;
    }
    public JTextField getTxtFecha_Nacimiento() {
      return txtFecha_Nacimiento;
    }
    public void setTxtFecha_Nacimiento(JTextField txtFecha_Nacimiento) {
      this.txtFecha_Nacimiento = txtFecha_Nacimiento;
    }
    public JTextField getTxtDocumento_identidad() {
      return txtDocumento_identidad;
    }
    public void setTxtDocumento_identidad(JTextField txtDocumento_identidad) {
      this.txtDocumento_identidad = txtDocumento_identidad;
    }
    
    

    
}

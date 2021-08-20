package modelo.vo;

public class Lider {
    private Integer id_lider;
    private String nombre;
    private String primer_Apellido;
    private String segundo_Nombre;
    private Integer salario;
    private String ciudad_Recidencia;
    private String cargo;
    private Integer clasificacion;
    private String documento_idendotad;
    private Integer fecha_Nacimiento;
    
    public Lider() {
    }

    public Lider(Integer id_lider, String nombre, String primer_Apellido, String segundo_Nombre, Integer salario,
            String ciudad_Recidencia, String cargo, Integer clasificacion, String documento_idendotad,
            Integer fecha_Nacimiento) {
        this.id_lider = id_lider;
        this.nombre = nombre;
        this.primer_Apellido = primer_Apellido;
        this.segundo_Nombre = segundo_Nombre;
        this.salario = salario;
        this.ciudad_Recidencia = ciudad_Recidencia;
        this.cargo = cargo;
        this.clasificacion = clasificacion;
        this.documento_idendotad = documento_idendotad;
        this.fecha_Nacimiento = fecha_Nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimer_Apellido() {
        return primer_Apellido;
    }

    public void setPrimer_Apellido(String primer_Apellido) {
        this.primer_Apellido = primer_Apellido;
    }

    public String getSegundo_Nombre() {
        return segundo_Nombre;
    }

    public void setSegundo_Nombre(String segundo_Nombre) {
        this.segundo_Nombre = segundo_Nombre;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public String getCiudad_Recidencia() {
        return ciudad_Recidencia;
    }

    public void setCiudad_Recidencia(String ciudad_Recidencia) {
        this.ciudad_Recidencia = ciudad_Recidencia;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Integer clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDocumento_idendotad() {
        return documento_idendotad;
    }

    public void setDocumento_idendotad(String documento_idendotad) {
        this.documento_idendotad = documento_idendotad;
    }

    public Integer getFecha_Nacimiento() {
        return fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(Integer fecha_Nacimiento) {
        this.fecha_Nacimiento = fecha_Nacimiento;
    }

    public Integer getId_lider() {
        return id_lider;
    }

    public void setId_lider(Integer id_lider) {
        this.id_lider = id_lider;
    }

    
    
}

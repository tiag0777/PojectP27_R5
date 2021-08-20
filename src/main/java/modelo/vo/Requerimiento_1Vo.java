package modelo.vo;

public class Requerimiento_1Vo {
    private Integer id_lider;
    private Integer Salario;
    private String Ciudad_Residencia;
    public Requerimiento_1Vo() {
    }
    public Requerimiento_1Vo(Integer id_lider, Integer salario, String ciudad_Residencia) {
        this.id_lider = id_lider;
        this.Salario = salario;
        this.Ciudad_Residencia = ciudad_Residencia;
    }
    public Integer getId_lider() {
        return id_lider;
    }
    public void setId_lider(Integer id_lider) {
        this.id_lider = id_lider;
    }
    public Integer getSalario() {
        return Salario;
    }
    public void setSalario(Integer salario) {
        this.Salario = salario;
    }
    public String getCiudad_Residencia() {
        return Ciudad_Residencia;
    }
    public void setCiudad_Residencia(String ciudad_Residencia) {
        this.Ciudad_Residencia = ciudad_Residencia;
    }    
} 
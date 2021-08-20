package modelo.vo;

public class Requerimiento_3Vo {
    private Integer id_proyecto;
    private String provedor;

    public Requerimiento_3Vo() {

    }
    

    public Requerimiento_3Vo(Integer id_proyecto, String provedor) {
        this.id_proyecto = id_proyecto;
        this.provedor = provedor;
    }


    public Integer getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(Integer id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public String getProvedor() {
        return provedor;
    }

    public void setProvedor(String provedor) {
        this.provedor = provedor;
    }

    
}   

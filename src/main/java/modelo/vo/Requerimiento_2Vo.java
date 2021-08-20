package modelo.vo;

public class Requerimiento_2Vo {
   private Integer id_proyecto;
   private String Nombre_Material;
   private String Importado;

   public Requerimiento_2Vo() {

   }

    public Requerimiento_2Vo(Integer id_proyecto, String nombre_Material, String importado) {
        this.id_proyecto = id_proyecto;
        this.Nombre_Material = nombre_Material;
        this.Importado = importado;
        
    }

    public Integer getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(Integer id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public String getNombre_Material() {
        return Nombre_Material;
    }

    public void setNombre_Material(String nombre_Material) {
        this.Nombre_Material = nombre_Material;
    }

    public String getImportado() {
        return Importado;
    }

    public void setImportado(String importado) {
        this.Importado = importado;
    }  
}

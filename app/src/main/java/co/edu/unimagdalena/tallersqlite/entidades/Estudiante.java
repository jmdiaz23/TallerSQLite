package co.edu.unimagdalena.tallersqlite.entidades;

public class Estudiante {
    private Integer codigo;
    private String nombre;
    private String programa;

    public Estudiante() {
        this.codigo = codigo;
        this.nombre = nombre;
        this.programa = programa;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }
}

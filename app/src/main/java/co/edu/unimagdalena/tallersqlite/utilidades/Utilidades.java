package co.edu.unimagdalena.tallersqlite.utilidades;

public class Utilidades {

    public static final String TABLA_USUARIO="estudiante";
    public static final String CAMPO_CODIGO="codigo";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_PROGRAMA="programa";


    public static final String CREAR_TABLA_USUARIO="CREATE TABLE " +
            ""+TABLA_USUARIO+" ("+CAMPO_CODIGO+" " +
            "INTEGER, "+CAMPO_NOMBRE+" TEXT,"+CAMPO_PROGRAMA+" TEXT)";
}

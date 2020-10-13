package co.edu.unimagdalena.tallersqlite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import co.edu.unimagdalena.tallersqlite.entidades.Estudiante;
import co.edu.unimagdalena.tallersqlite.utilidades.Utilidades;

public class ConsultarListaListViewActivity extends AppCompatActivity {
    ListView listViewEstudiantes;
    ArrayList<String> listaInformacion;
    ArrayList<Estudiante> listaAlumnos;

    ConexionSQLiteHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_lista_list_view);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_estudiantes",null,1);

        listViewEstudiantes= (ListView) findViewById(R.id.listViewEstudiantes);
        consultarListaEstudiante();

        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        listViewEstudiantes.setAdapter(adaptador);

        listViewEstudiantes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                String informacion="Codigo: "+listaAlumnos.get(pos).getCodigo()+"\n";
                informacion+="Nombre: "+listaAlumnos.get(pos).getNombre()+"\n";
                informacion+="Programa: "+listaAlumnos.get(pos).getPrograma()+"\n";

                Toast.makeText(getApplicationContext(),informacion,Toast.LENGTH_LONG).show();


            }
        });


    }

    private void consultarListaEstudiante() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Estudiante alumno=null;
        listaAlumnos=new ArrayList<Estudiante>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_USUARIO,null);

        while (cursor.moveToNext()){
            alumno=new Estudiante();
            alumno.setCodigo(cursor.getInt(0));
            alumno.setNombre(cursor.getString(1));
            alumno.setPrograma(cursor.getString(2));

            listaAlumnos.add(alumno);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion=new ArrayList<String>();

        for (int i=0; i<listaAlumnos.size();i++){
            listaInformacion.add(listaAlumnos.get(i).getCodigo()+" - "
                    +listaAlumnos.get(i).getNombre());
        }
    }
}


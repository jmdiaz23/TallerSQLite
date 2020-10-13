package co.edu.unimagdalena.tallersqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import co.edu.unimagdalena.tallersqlite.utilidades.Utilidades;

public class RegistroUsuariosActivity extends AppCompatActivity {
    EditText campoCodigo, campoNombre, campoPrograma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        campoCodigo= (EditText) findViewById(R.id.campoCodigo);
        campoNombre= (EditText) findViewById(R.id.campoNombre);
        campoPrograma= (EditText) findViewById(R.id.campoPrograma);

    }

    public void onClick(View view) {
        registrarUsuarios();

    }

    private void registrarUsuarios() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_estudiantes",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_CODIGO,campoCodigo.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_PROGRAMA,campoPrograma.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_CODIGO,values);

        Toast.makeText(getApplicationContext(),"Codigo Registro: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
    }

}

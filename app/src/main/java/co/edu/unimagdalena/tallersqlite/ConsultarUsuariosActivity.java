package co.edu.unimagdalena.tallersqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import co.edu.unimagdalena.tallersqlite.utilidades.Utilidades;

public class ConsultarUsuariosActivity extends AppCompatActivity {

    EditText campoCodigo,campoNombre,campoPrograma;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_usuarios);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_estudiantes",null,1);

        campoCodigo= (EditText) findViewById(R.id.codigoId);
        campoNombre= (EditText) findViewById(R.id.campoNombreConsulta);
        campoPrograma= (EditText) findViewById(R.id.campoProgramaConsulta);


    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnConsultar:
                 consultar();

                break;
            case R.id.btnActualizar: actualizarEstudiante();
                break;
            case R.id.btnEliminar: eliminarEstudiante();
                break;
        }

    }

    private void eliminarEstudiante() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoCodigo.getText().toString()};

        db.delete(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_CODIGO+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se Eliminó el estudiante",Toast.LENGTH_LONG).show();
        campoCodigo.setText("");
        limpiar();
        db.close();
    }

    private void actualizarEstudiante() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoCodigo.getText().toString()};
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_PROGRAMA,campoPrograma.getText().toString());

        db.update(Utilidades.TABLA_USUARIO,values,Utilidades.CAMPO_CODIGO+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se actualizó el estudiante",Toast.LENGTH_LONG).show();
        db.close();

    }

    private void consultar() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={campoCodigo.getText().toString()};
        String[] campos={Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_PROGRAMA};

        try {
            Cursor cursor =db.query(Utilidades.TABLA_USUARIO,campos,Utilidades.CAMPO_CODIGO+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            campoNombre.setText(cursor.getString(0));
            campoPrograma.setText(cursor.getString(1));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El codigo no existe",Toast.LENGTH_LONG).show();
            limpiar();
        }




    }
    private void limpiar() {
        campoNombre.setText("");
        campoPrograma.setText("");
    }

}


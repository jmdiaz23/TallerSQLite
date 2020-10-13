package co.edu.unimagdalena.tallersqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_estudiantes", null, 1);


    }

    public void onClick(View view) {
        Intent i = null;
        switch (view.getId()){
            case R.id.btnOpcionRegistro:
                 i=new Intent(MainActivity.this,RegistroUsuariosActivity.class);

                break;

            case R.id.btnConsultaIndividual:
                i=new Intent(MainActivity.this,ConsultarUsuariosActivity.class);

                break;

            case R.id.btnConsultaLista:
                i=new Intent(MainActivity.this,ConsultarListaListViewActivity.class);

                break;



        }
        if (i!=null){
            startActivity(i);
        }



    }


}
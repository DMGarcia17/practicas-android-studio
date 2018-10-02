package sv.edu.itca.santaana.dm_cuadrosdialogo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void inf(View v){
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setMessage("Esto es un mensaje de alerta")
                .setTitle("Información")
                .setPositiveButton("Ok", null);
        b.setCancelable(false);
        b.create();
        b.show();
    }

    public void reqInf(View v) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(false);
        b.setMessage("¿Que desea ver?")
                .setTitle("ELija")
                .setPositiveButton("Saludo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Mensaje", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Despedida", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Adios", Toast.LENGTH_SHORT).show();
                    }
                });
        b.create();
        b.show();
    }

    public void multi(View v){
        final String[] lang = {"Español", "English", "French"};
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("Selección");
        b.setItems(lang, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(getApplicationContext(), "Idioma Seleccionado: "+lang[i], Toast.LENGTH_SHORT).show();
            }
        });
        b.create();
        b.show();
    }

    public void pinf(View v){
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        LayoutInflater inf = this.getLayoutInflater();
        b.setView(inf.inflate(R.layout.dialogo_preso, null))
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        b.create();
        b.show();
    }


}

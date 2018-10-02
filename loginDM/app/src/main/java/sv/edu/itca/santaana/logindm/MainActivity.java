package sv.edu.itca.santaana.logindm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtUser;
    EditText txtPass;
    Spinner spnTUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnTUser = findViewById(R.id.spnTUser);
        txtUser = findViewById(R.id.txtUser);
        txtPass = findViewById(R.id.txtPass);
    }

    public void iniciar(View v) {
        String type = spnTUser.getSelectedItem().toString();
        String pass = txtPass.getText().toString();

        switch (type){
            case "Administrator":
                if(pass.equals("a")){
                    Toast err = Toast.makeText(getApplicationContext(), "Llego aqui", Toast.LENGTH_SHORT);
                    err.show();
                    Intent trypass = new Intent(MainActivity.this, Adminitration.class);
                    trypass.putExtra("user", txtUser.getText().toString());
                    startActivity(trypass);
                } else {
                    Toast err = Toast.makeText(getApplicationContext(), "Usuario Incorrecto", Toast.LENGTH_SHORT);
                    err.show();
                }
                break;
            case "Customer":
                if(pass.equals("c")){
                    Intent trypasscus = new Intent(this, customer.class);
                    trypasscus.putExtra("user", txtUser.getText().toString());
                    startActivity(trypasscus);
                } else {
                    Toast err = Toast.makeText(getApplicationContext(), "Usuario Incorrecto", Toast.LENGTH_SHORT);
                    err.show();
                }
                break;
            case "Support":
                if(pass.equals("s")){
                    Intent trypasssu = new Intent(this, support.class);
                    trypasssu.putExtra("user", txtUser.getText().toString());
                    startActivity(trypasssu);
                } else {
                    Toast err = Toast.makeText(getApplicationContext(), "Usuario Incorrecto", Toast.LENGTH_SHORT);
                    err.show();
                }
                break;
        }
    }
}

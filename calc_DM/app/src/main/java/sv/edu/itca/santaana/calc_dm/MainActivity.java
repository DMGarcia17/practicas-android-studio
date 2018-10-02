package sv.edu.itca.santaana.calc_dm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtC1;
    EditText txtC2;
    RadioButton rbAdd;
    RadioButton rbLess;
    RadioButton rbMultiplication;
    RadioButton rbDivision;
    Button btnDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtC1 = findViewById(R.id.txtC1);
        txtC1.setFocusable(true);
        txtC2 = findViewById(R.id.txtC2);
        rbAdd = findViewById(R.id.rbAdd);
        rbLess = findViewById(R.id.rbLess);
        rbMultiplication = findViewById(R.id.rbMultication);
        rbDivision = findViewById(R.id.rbDivition);
        btnDo = findViewById(R.id.btnDo);

        txtC1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (txtC1.getText().toString().length() <= 0 || txtC2.getText().toString().length() <= 0) {
                    btnDo.setEnabled(false);
                } else {
                    btnDo.setEnabled(true);
                }
            }
        });

        txtC2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (txtC1.getText().toString().length() <= 0 || txtC2.getText().toString().length() <= 0) {
                    btnDo.setEnabled(false);
                } else {
                    btnDo.setEnabled(true);
                }
            }
        });
    }

    public void allertMaj(View v){
        Toast.makeText(this,
                "Recuerde que para realizar una división el primer número debe ser mayor que el segundo",
                Toast.LENGTH_SHORT).show();
    }


    public void ver(View v) {
        String res = "";
        if (rbAdd.isChecked()) {
            res = String.valueOf(Integer.parseInt(txtC1.getText().toString()) + Integer.parseInt(txtC2.getText().toString()));
        } else if (rbLess.isChecked()) {
            res = String.valueOf(Integer.parseInt(txtC1.getText().toString()) - Integer.parseInt(txtC2.getText().toString()));
        } else if (rbMultiplication.isChecked()) {
            res = String.valueOf(Integer.parseInt(txtC1.getText().toString()) * Integer.parseInt(txtC2.getText().toString()));
        } else if (rbDivision.isChecked()) {
            if (Integer.parseInt(txtC1.getText().toString()) >= Integer.parseInt(txtC2.getText().toString())) {
                res = String.valueOf(Integer.parseInt(txtC1.getText().toString()) / Integer.parseInt(txtC2.getText().toString()));
            } else {
                Toast.makeText(this, "El segundo numero es menor que el primero", Toast.LENGTH_SHORT).show();
            }
        }
        if (res.equals("")) {
            Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
        } else {
            dialogo d = new dialogo();
            d.setRes(res);
            d.show(getSupportFragmentManager(), "dialog");
        }

    }
}

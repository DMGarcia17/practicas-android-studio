package sv.edu.itca.santaana.dm_comunicacionactivities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtName;
    TextView tvResult;
    Button btnV;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 1234 && resultCode == RESULT_OK){
            String res = data.getExtras().getString("res");
            tvResult.setText(res+" fue interesante para ti el ejemplo");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = findViewById(R.id.txtName);
        tvResult = findViewById(R.id.tvResult);
        btnV = findViewById(R.id.btnV);
        txtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(txtName.length() <= 0){
                    btnV.setEnabled(false);
                }else{
                    btnV.setEnabled(true);
                }
            }
        });

    }

    public void about(View v){
        Intent i = new Intent(this, abo.class);
        startActivity(i);
    }

    public void out(View v){
        finish();
    }

    public void veri(View v){
        Intent i = new Intent(this, opt.class);
        i.putExtra("user", txtName.getText().toString());
        startActivityForResult(i, 1234);
    }
}

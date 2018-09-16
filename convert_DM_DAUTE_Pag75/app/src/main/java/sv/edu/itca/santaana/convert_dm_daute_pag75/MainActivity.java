package sv.edu.itca.santaana.convert_dm_daute_pag75;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnCon;
    private Button btnCL;
    private Button btnCT;
    private EditText txtLong;
    private EditText txtVal;
    private EditText txtTemp;
    private TextView tvMm;
    private TextView tvCm;
    private TextView tvM;
    private TextView tvKm;
    private TextView tvL;
    private TextView tvG;
    private TextView tvT;
    private TextView tvK;
    private TextView tvCel;
    private TextView tvKel;
    private TextView tvFar;
    private Spinner spnLong;
    private Spinner spnUni;
    private Spinner spnTemp;
    private double val;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TabHost tbAll = findViewById(R.id.tbAll);

        tbAll.setup();

        TabHost.TabSpec sp;
        sp = tbAll.newTabSpec("Peso");
        sp.setContent(R.id.tab1);
        sp.setIndicator("", getResources().getDrawable(R.drawable.ic_menu_peso));
        tbAll.addTab(sp);

        sp = tbAll.newTabSpec("Long");
        sp.setContent(R.id.tab2);
        sp.setIndicator("", getResources().getDrawable(R.drawable.ic_menu_longitud));
        tbAll.addTab(sp);

        sp = tbAll.newTabSpec("Temp");
        sp.setContent(R.id.tab3);
        sp.setIndicator("", getResources().getDrawable(R.drawable.ic_menu_temperatura));
        tbAll.addTab(sp);

        tvG = findViewById(R.id.tvG);
        tvL = findViewById(R.id.tvL);
        tvK = findViewById(R.id.tvK);
        tvT = findViewById(R.id.tvT);

        btnCon = findViewById(R.id.btnCon);

        txtVal = findViewById(R.id.txtVal);

        spnUni = findViewById(R.id.spnUni);

        tvMm = findViewById(R.id.tvMm);
        tvCm = findViewById(R.id.tvCm);
        tvM = findViewById(R.id.tvM);
        tvKm = findViewById(R.id.tvKm);

        txtLong = findViewById(R.id.txtLong);

        spnLong = findViewById(R.id.spnLong);

        btnCL = findViewById(R.id.btnCL);

        tvCel = findViewById(R.id.tvCel);
        tvFar = findViewById(R.id.tvFar);
        tvKel = findViewById(R.id.tvKel);

        txtTemp = findViewById(R.id.txtTemp);

        spnTemp = findViewById(R.id.spnTemp);

        btnCT = findViewById(R.id.btnCT);


        txtVal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                if(txtVal.getText().toString().isEmpty() || txtVal.getText().toString().equals(".")){
                    btnCon.setEnabled(false);
                }else{
                    btnCon.setEnabled(true);
                }
            }
        });

        txtLong.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(txtLong.getText().toString().isEmpty() || txtLong.getText().toString().equals(".")){
                    btnCL.setEnabled(false);
                }else{
                    btnCL.setEnabled(true);
                }
            }
        });

        txtTemp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(txtTemp.getText().toString().isEmpty() || txtTemp.getText().toString().equals(".")){
                    btnCT.setEnabled(false);
                }else{
                    btnCT.setEnabled(true);
                }
            }
        });

    }

    public void converL(View v){
        val = Double.parseDouble(txtLong.getText().toString());
        switch (spnLong.getSelectedItemPosition()){
            case 0:
                tvMm.setText(String.valueOf(val));
                tvCm.setText(proc1(val, 10));
                tvM.setText(proc1(val, 1000));
                tvKm.setText(proc1(val, 1000000));
                break;
            case 1:
                tvCm.setText(String.valueOf(val));
                tvMm.setText(proc2(val, 10));
                tvM.setText(proc1(val, 100));
                tvKm.setText(proc1(val, 100000));
                break;
            case 2:
                tvM.setText(String.valueOf(val));
                tvMm.setText(proc2(val, 1000));
                tvCm.setText(proc2(val, 100));
                tvKm.setText(proc1(val, 1000));
                break;
            case 3:
                tvKm.setText(String.valueOf(val));
                tvMm.setText(proc2(val, 1000000));
                tvCm.setText(proc2(val, 100000));
                tvM.setText(proc2(val, 1000));
                break;
        }
    }

    public void converP(View v){
        final int gr = 0, lb = 1, kg = 2, Tn = 3;
        final double quinientos = 500, mil = 1000, dmil = 2000, millon = 1000000;
        val = Double.parseDouble(txtVal.getText().toString());
        switch (spnUni.getSelectedItemPosition()){
            case gr:
                tvG.setText(String.valueOf(val));
                tvL.setText(proc1(val, quinientos));
                tvK.setText(proc1(val, mil));
                tvT.setText(proc1(val, millon));
                break;
            case lb:
                tvL.setText(String.valueOf(val));
                tvG.setText(proc2(val, quinientos));
                tvK.setText(proc1(val, 2.20462));
                tvT.setText(proc1(val, dmil));
                break;
            case kg:
                tvK.setText(String.valueOf(val));
                tvG.setText(proc2(val, millon));
                tvL.setText(proc2(val, 2));
                tvT.setText(proc2(val, mil));
                break;
            case Tn:
                tvT.setText(String.valueOf(val));
                tvG.setText(proc2(val, millon));
                tvL.setText(proc2(val, dmil));
                tvK.setText(proc2(val, mil));
                break;
        }
    }

    public void converT(View v){
        val = Double.parseDouble(txtTemp.getText().toString());
        switch (spnTemp.getSelectedItemPosition()){
            case 0:
                tvCel.setText(String.valueOf(val));
                tvKel.setText(proc3(val, 273.15));
                tvFar.setText(proc3(Double.parseDouble(proc2((9/5), val)), 32));
                break;
            case 1:
                tvKel.setText(String.valueOf(val));
                tvCel.setText(proc4(val, 273.15));
                tvFar.setText(proc3(Double.parseDouble(proc2((9/5), Double.parseDouble(tvCel.getText().toString()))), 32));
                break;
            case 2:

                tvFar.setText(String.valueOf(val));
                tvCel.setText(String.valueOf(proc2(Double.parseDouble(proc4(val, 32)), Double.parseDouble(proc1(5, 9)))));
                tvKel.setText(proc3(Double.parseDouble(tvCel.getText().toString()), 273.15));
                break;
        }
    }

    private String proc1(double val, double equi){
        return String.valueOf(val/equi);
    }

    private String proc2(double val, double equi){
        return String.valueOf(val*equi);
    }

    private String proc3(double val, double equi){
        return String.valueOf(val+equi);
    }

    private String proc4(double val, double equi){
        return String.valueOf(val-equi);
    }


}

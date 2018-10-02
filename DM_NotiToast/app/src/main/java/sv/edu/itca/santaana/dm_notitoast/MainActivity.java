package sv.edu.itca.santaana.dm_notitoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnD = findViewById(R.id.btnD);
        Button btnG = findViewById(R.id.btnG);

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.def, Toast.LENGTH_LONG).show();
            }
        });

        btnG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast tG = Toast.makeText(getApplicationContext(), R.string.gra, Toast.LENGTH_LONG);
                tG.setGravity(Gravity.CENTER|Gravity.LEFT, 0, 0);
                tG.show();
            }
        });
    }

    public void d(View v){
        Toast tP = new Toast(getApplicationContext());
        LayoutInflater i = getLayoutInflater();
        View lyt = i.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.lytT));

        TextView tvM = lyt.findViewById(R.id.tvM);

        tvM.setText(R.string.toast);
        tP.setDuration(Toast.LENGTH_SHORT);
        tP.setView(lyt);
        tP.show();
    }
}

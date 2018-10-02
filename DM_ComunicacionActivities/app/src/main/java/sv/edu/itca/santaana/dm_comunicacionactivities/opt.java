package sv.edu.itca.santaana.dm_comunicacionactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class opt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opt);
        TextView tvData = findViewById(R.id.tvData);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle b = getIntent().getExtras();
        tvData.setText("Hola "+(b.getString("user"))+": ¿Encuentras interesante el ejemplo?");
    }

    public void yes(View v){
        Intent i = new Intent();
        i.putExtra("res", "Si");
        setResult(RESULT_OK, i);
        finish();
    }

    public void no(View v){
        Intent i = new Intent();
        i.putExtra("res", "No");
        setResult(RESULT_OK, i);
        finish();
    }

}

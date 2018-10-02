package sv.edu.itca.santaana.logindm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Adminitration extends AppCompatActivity {

    TextView tvWel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminitration);

        Bundle extras = getIntent().getExtras();
        String user = extras.getString("user");

        tvWel = findViewById(R.id.tvWelsu);

        tvWel.setText(user);
    }
}

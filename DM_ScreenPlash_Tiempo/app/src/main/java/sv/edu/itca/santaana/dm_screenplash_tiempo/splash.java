package sv.edu.itca.santaana.dm_screenplash_tiempo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splash extends AppCompatActivity {
    private boolean b = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler m = new Handler();
        m.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                if(!b){
                    Intent i = new Intent(getApplicationContext(), Principal.class);
                    startActivity(i);
                }
            }
        }, 2000);
    }

    @Override
    public void onBackPressed() {
        b = true;
        super.onBackPressed();
    }
}


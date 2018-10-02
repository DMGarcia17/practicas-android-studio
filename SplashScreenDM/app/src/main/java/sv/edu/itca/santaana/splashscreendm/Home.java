package sv.edu.itca.santaana.splashscreendm;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class Home extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);
    }

    public void entrar(View v) {
        Intent intencion = new Intent(Home.this, Principal.class);
        startActivity(intencion);
    }
}

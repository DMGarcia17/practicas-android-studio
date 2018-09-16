package sv.edu.itca.santaana.menuactionbar_dm;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtInfo_ini;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.itN1:
                txtInfo_ini.setText(R.string.n1);
                return true;
            case R.id.itN2:
                txtInfo_ini.setText(R.string.n2);
                return true;
            case R.id.itN3:
                txtInfo_ini.setText(R.string.n3);
                return true;
            case R.id.itN4:
                txtInfo_ini.setText(R.string.n4);
                return true;
            case R.id.itN5:
                txtInfo_ini.setText(R.string.n5);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pmenu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInfo_ini = findViewById(R.id.txtInfo_ini);



    }
}

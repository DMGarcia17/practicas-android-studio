package sv.edu.itca.santaana.menucontext_dm;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvInit;
    ListView ltbTest;

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo i = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.opc1:
                tvInit.setText(R.string.re1);
                tvInit.setTextColor(Color.parseColor("#424EFF"));
                return true;
            case R.id.opc2:
                tvInit.setText(R.string.re2);
                return true;
            case R.id.ltbopc2:
                tvInit.setText("List element #"+(i.position)+": Opción 2 pulsada");
                return true;
            case R.id.ltbopc1:
                tvInit.setText("List element #"+(i.position)+": Opción 1 pulsada");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater princ = getMenuInflater();
        if(v.getId() == R.id.ltbTest){
            AdapterView.AdapterContextMenuInfo i = (AdapterView.AdapterContextMenuInfo) menuInfo;
            menu.setHeaderTitle(ltbTest.getAdapter().getItem(i.position).toString());
            princ.inflate(R.menu.ltbmenu, menu);
        }else if(v.getId() == R.id.tvInit){
            princ.inflate(R.menu.prin, menu);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInit = findViewById(R.id.tvInit);

        registerForContextMenu(tvInit);

        ltbTest = findViewById(R.id.ltbTest);

        String[] d = new String[]{"Elem1", "Elem2", "Elem3", "Elem4", "Elem5"};
        ArrayAdapter<String> a = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, d);
        ltbTest.setAdapter(a);

        registerForContextMenu(ltbTest);

    }
}

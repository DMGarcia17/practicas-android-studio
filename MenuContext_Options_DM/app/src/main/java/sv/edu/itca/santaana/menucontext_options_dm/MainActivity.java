package sv.edu.itca.santaana.menucontext_options_dm;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtOut;
    TextView tvInit;
    ListView ltbData;
    String val;

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo a = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.opcltbET:
                tvInit.setText(val);
                return true;
            case R.id.opcltbEE:
                txtOut.setText(val);
                return true;
            case R.id.opctxtB:
                txtOut.setText("");
                return true;
            case R.id.opctxtET:
                tvInit.setText(txtOut.getText());
                return true;
            case R.id.opctvCC:
                if(tvInit.getCurrentTextColor() == Color.BLACK){
                    tvInit.setTextColor(Color.BLUE);
                }else if(tvInit.getCurrentTextColor() == Color.BLUE){
                    tvInit.setTextColor(Color.GREEN);
                }else if(tvInit.getCurrentTextColor() == Color.GREEN){
                    tvInit.setTextColor(Color.MAGENTA);
                }else{
                    tvInit.setTextColor(Color.BLACK);
                }
                return true;
            case R.id.opctvCT:
                switch (tvInit.getText().toString()){
                    case "Hello World!":
                        tvInit.setText("Come on");
                        break;
                    case "Come on":
                        tvInit.setText("You can do it");
                        break;
                    case "You can do it":
                        tvInit.setText("Just do it");
                        break;
                    case "Just do it":
                        tvInit.setText("it's easy right?");
                        break;
                    default:
                        tvInit.setText("Hello World!");
                }
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater i = getMenuInflater();

        switch (v.getId()){
            case R.id.txtOut:
                i.inflate(R.menu.menu_txt, menu);
                break;
            case R.id.tvInit:
                i.inflate(R.menu.menu_tv, menu);
                break;
            case R.id.ltbData:
                AdapterView.AdapterContextMenuInfo a = (AdapterView.AdapterContextMenuInfo) menuInfo;
                menu.setHeaderTitle(ltbData.getAdapter().getItem(a.position).toString());
                i.inflate(R.menu.menu_ltb, menu);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtOut = findViewById(R.id.txtOut);
        tvInit = findViewById(R.id.tvInit);
        ltbData = findViewById(R.id.ltbData);

        registerForContextMenu(txtOut);
        registerForContextMenu(tvInit);
        registerForContextMenu(ltbData);

        String[] d = new String[]{"Elem1", "Elem2", "Elem3", "Elem4", "Elem5"};
        ArrayAdapter<String> a = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, d);
        ltbData.setAdapter(a);

        ltbData.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                val = ltbData.getItemAtPosition(i).toString();
                return false;
            }
        });


    }
}

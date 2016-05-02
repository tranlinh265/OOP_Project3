package oopprojet.tranlinh.com.oop_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class KichCo extends AppCompatActivity {
    private ListView listViewKichCo;
    final String arr[]={"Teo","Ty","Bin","Bo"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kich_co);
        listViewKichCo = (ListView)findViewById(R.id.listViewKichCo);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, arr);
        listViewKichCo.setAdapter(adapter);
        listViewKichCo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("noiDung",arr[position]);
                setResult(1,intent);
                KichCo.this.finish();
//                danhMuc.button.setText(arr[position]);
            }
        });
    }
}

package oopprojet.tranlinh.com.oop_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NhanHieu extends AppCompatActivity {
    private ListView listViewNhanHieu;
    final String arr[]={"Teo","Ty","Bin","Bo"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_hieu);
        listViewNhanHieu = (ListView)findViewById(R.id.listViewNhanHieu);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, arr);
        listViewNhanHieu.setAdapter(adapter);
        listViewNhanHieu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("noiDung",arr[position]);
                setResult(1,intent);
                NhanHieu.this.finish();
//                danhMuc.button.setText(arr[position]);
            }
        });
    }
}

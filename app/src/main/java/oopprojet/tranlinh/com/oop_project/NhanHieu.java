package oopprojet.tranlinh.com.oop_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class NhanHieu extends AppCompatActivity {
    private ListView listViewNhanHieu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_hieu);
        listViewNhanHieu = (ListView)findViewById(R.id.listViewNhanHieu);
        listViewNhanHieu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}

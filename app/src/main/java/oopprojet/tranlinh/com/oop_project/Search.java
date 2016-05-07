package oopprojet.tranlinh.com.oop_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Search extends AppCompatActivity {
    private MainActivity main = new MainActivity();
    private Database db = new Database(this);
    private XuLy xuLyGia = new XuLy();
    private ListView listView;
    private String tuKhoa,danhMuc,nhanHieu,kichCo,trangThai;
    int[] gia = new int[2];
    private ArrayList<SanPham> sanPhams = new ArrayList<SanPham>();
    private MyArrayAdapter listViewAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        listView = (ListView)findViewById(R.id.listViewSearch);
        tuKhoa = new String(main.keyWordText.getText()+"");
        danhMuc = String.valueOf(main.button.getText()+"");
        nhanHieu = String.valueOf(main.button2.getText()+"");
        kichCo = String.valueOf(main.button3.getText()+"");
        trangThai = String.valueOf(main.statusBtn.getText() + "");
        gia = xuLyGia.CatXau(main.PriceText.getText() + "");

        ArrayList<SanPham> list = db.getAllItem1(tuKhoa,danhMuc,nhanHieu,kichCo,gia[0],gia[1],trangThai);
        if(list.isEmpty()){
            Toast.makeText(Search.this,"Không có sản phẩm phù hợp",Toast.LENGTH_LONG).show();
        }
        this.sanPhams.addAll(list);

        this.listViewAdapter = new MyArrayAdapter(this,R.layout.row_item, this.sanPhams);

        this.listView.setAdapter(this.listViewAdapter);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SanPham sp = sanPhams.get(position);
                String str = sp.getMoTa();
                //String str = "abc";
                Toast.makeText(Search.this,str,Toast.LENGTH_LONG).show();
            }
        });
    }
}

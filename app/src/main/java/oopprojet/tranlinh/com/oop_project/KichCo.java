package oopprojet.tranlinh.com.oop_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class KichCo extends AppCompatActivity {
    private ListView listViewDanhMuc;
    private int[] gia = new int[2];
    private MainActivity main = new MainActivity();
    private XuLy xuLyGia = new XuLy();
    private ArrayList<String> arrayList = new ArrayList<String>();
    private Intent intent = new Intent();
    private Database db = new Database(this);

    private String tuKhoa,danhMuc,nhanHieu,trangThai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kich_co);
        this.findByID();
        arrayList = db.getKC(tuKhoa,nhanHieu,danhMuc,gia[0],gia[1],trangThai);
        if(arrayList.isEmpty()){
            Toast.makeText(KichCo.this, "Không có kích cỡ phù hợp", Toast.LENGTH_LONG).show();
        }
        listViewDanhMuc = (ListView)findViewById(R.id.listViewKichCo);
        ArrayAdapter<String>adapter=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1,arrayList);
        listViewDanhMuc.setAdapter(adapter);
        listViewDanhMuc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent.putExtra("noiDung", (Serializable) arrayList.get(position));
                setResult(3,intent);
                KichCo.this.finish();
            }
        });
    }
    private void findByID(){
        tuKhoa = new String(main.keyWordText.getText()+"");
        danhMuc = String.valueOf(main.button.getText()+"");
        nhanHieu = String.valueOf(main.button2.getText() + "");
        trangThai = String.valueOf(main.statusBtn.getText()+"");
        gia = xuLyGia.CatXau(main.PriceText.getText()+"");

    }
}

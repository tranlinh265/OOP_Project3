package oopprojet.tranlinh.com.oop_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class DanhMuc extends AppCompatActivity {
    private ListView listViewDanhMuc;
    private int[] gia = new int[2];
    private MainActivity main = new MainActivity();
    private XuLy xuLyGia = new XuLy();
    private ArrayList<String> arrayList = new ArrayList<String>();
    private Intent intent = new Intent();
    private Database db = new Database(this);

    private String tuKhoa,nhanHieu,kichCo,trangThai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_muc);
        this.findByID();

        // kiem tra gia
        if(gia[0]>gia[1]){
            Toast.makeText(DanhMuc.this,"Giá nhập vào khoog hợp lệ",Toast.LENGTH_SHORT).show();
            main.PriceText.setText("");
            DanhMuc.this.finish();
        }

        // lay ra day cac danh muc phu hop
        arrayList = db.getDM(tuKhoa,nhanHieu,kichCo,gia[0],gia[1],trangThai);

        // thong bao khi khong co danh muc nao phu hop
        if(arrayList.isEmpty()){
            Toast.makeText(DanhMuc.this, "Không có danh mục phù hợp", Toast.LENGTH_LONG).show();
        }

        // hien thi danh muc
        listViewDanhMuc = (ListView)findViewById(R.id.listViewDanhMuc);
        ArrayAdapter<String>adapter=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1,arrayList);
        listViewDanhMuc.setAdapter(adapter);
        listViewDanhMuc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // tra gia tri danh muc duoc chon de hien thi ra main activity
                intent.putExtra("noiDung", (Serializable) arrayList.get(position));
                setResult(1,intent);

                // ket thuc
                DanhMuc.this.finish();
            }
        });
    }
    private void findByID(){
        tuKhoa = new String(main.keyWordText.getText()+"");
        nhanHieu = String.valueOf(main.button2.getText()+"");
        kichCo = String.valueOf(main.button3.getText()+"");
        trangThai = String.valueOf(main.statusBtn.getText()+"");
        gia = xuLyGia.CatXau(main.PriceText.getText()+"");
    }
}

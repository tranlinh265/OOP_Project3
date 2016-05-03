package oopprojet.tranlinh.com.oop_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DanhMuc extends AppCompatActivity {
    private ListView listViewDanhMuc;
    private int[] gia = new int[2];
    private MainActivity main = new MainActivity();
    private XuLy xuLyGia = new XuLy();
    private ArrayList<SanPham> arrayList = new ArrayList<SanPham>();
//    final String arr[]={"Teo","Ty","Bin","Bo"};
//    private ArrayList<String> test = new ArrayList<String>();
    private Bundle bundle = new Bundle();
    private Intent intent = new Intent();
    private Database db = null;
    private String tuKhoa,danhMuc,nhanHieu,kichCo,trangThai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_muc);
        tuKhoa = String.valueOf(main.keyWordText.getText());
        danhMuc = String.valueOf(main.button.getText());
        nhanHieu = String.valueOf(main.button2.getText());
        kichCo = String.valueOf(main.button3.getText());
        trangThai = String.valueOf(main.statusBtn.getText());
        gia = xuLyGia.CatXau(main.PriceText.getText()+"");
//        arrayList = db.getAllItem(tuKhoa,danhMuc,nhanHieu,kichCo,gia[0],gia[1],trangThai);
//        test.add("nam");
//        gia = xuLyGia.CatXau("100-200k");
//        danhMuc.button2.setText(gia[0]+"");
//        test.add(danhMuc.button.getText().toString());
//        arrayListNoiDung.add(new SanPham(danhMuc.keyWordText.getText()+"",danhMuc.button.getText()+"",danhMuc.button2.getText()+"",
//                danhMuc.button3.getText()+"",danhMuc.statusBtn.getText()+""));
//        intent = getIntent();
//        noiDung = intent.getStringArrayListExtra("info");
////        noiDung = bundle.getStringArrayList("danhmuc");
        listViewDanhMuc = (ListView)findViewById(R.id.listViewDanhMuc);
        ArrayAdapter<SanPham>adapter=new ArrayAdapter<SanPham>
                (this, android.R.layout.simple_list_item_1,arrayList);
        listViewDanhMuc.setAdapter(adapter);
        listViewDanhMuc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent.putExtra("noiDung", (Serializable) arrayList.get(position));
                setResult(1,intent);
                DanhMuc.this.finish();
//                danhMuc.button.setText(arr[position]);
            }
        });
    }
}

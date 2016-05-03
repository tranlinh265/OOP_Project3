package oopprojet.tranlinh.com.oop_project;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

public class Search extends AppCompatActivity {
    private MainActivity main = new MainActivity();
    private Database db = new Database(this);
    private XuLy xuLyGia = new XuLy();
    private Cursor cursor;
    private TextView textViewSearch;
    private String tuKhoa,danhMuc,nhanHieu,kichCo,trangThai;
    int[] gia = new int[2];
    private String noiDung = new String();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        textViewSearch = (TextView) findViewById(R.id.textViewSearch);
        tuKhoa = String.valueOf(main.keyWordText.getText()+"");
        danhMuc = String.valueOf(main.button.getText()+"");
        nhanHieu = String.valueOf(main.button2.getText()+"");
        kichCo = String.valueOf(main.button3.getText()+"");
        trangThai = String.valueOf(main.statusBtn.getText()+"");
        gia = xuLyGia.CatXau(main.PriceText.getText()+"");
        cursor = db.getAllItem(tuKhoa,danhMuc,nhanHieu,kichCo,gia[0],gia[1],trangThai);
        cursor.moveToFirst();
        noiDung = "";
        while (cursor.isAfterLast()==false){
            noiDung+="Ten:";
            noiDung+=cursor.getString(1)+"\nDanh muc :"+cursor.getString(5)+"\nNhan hieu:"+cursor.getString(3)+
                    "\nGia:"+cursor.getInt(9)+"\nTrang thai:"+cursor.getString(6)+"\n-------------------------------------------------------------";
            cursor.moveToNext();
        }
        textViewSearch.setText(noiDung);
    }
}

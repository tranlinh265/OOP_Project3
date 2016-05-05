package oopprojet.tranlinh.com.oop_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class Search extends AppCompatActivity {
    private MainActivity main = new MainActivity();
    private Database db = new Database(this);
    private XuLy xuLyGia = new XuLy();
    private TextView textViewSearch;
    private String tuKhoa,danhMuc,nhanHieu,kichCo,trangThai;
    int[] gia = new int[2];
    private String noiDung = new String();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        this.fingByID();

        noiDung = db.getAllItem(tuKhoa,danhMuc,nhanHieu,kichCo,gia[0],gia[1],trangThai);
        if(noiDung.equals("")){
            Toast.makeText(Search.this, "Không có sản phẩm phù hợp", Toast.LENGTH_LONG).show();
        }

        textViewSearch.setText(noiDung);
    }
    private void fingByID(){
        textViewSearch = (TextView) findViewById(R.id.textViewSearch);
        tuKhoa = new String(main.keyWordText.getText()+"");
        danhMuc = String.valueOf(main.button.getText()+"");
        nhanHieu = String.valueOf(main.button2.getText()+"");
        kichCo = String.valueOf(main.button3.getText()+"");
        trangThai = String.valueOf(main.statusBtn.getText()+"");
        gia = xuLyGia.CatXau(main.PriceText.getText()+"");
    }
}

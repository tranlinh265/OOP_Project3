package oopprojet.tranlinh.com.oop_project;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String status;
    private Bundle bundle;
//    private ArrayList<SanPham> noiDung = new ArrayList<SanPham>();
    private Intent tempIntent = new Intent();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private ImageButton eraseImageButton;
    public static EditText keyWordText,PriceText;
    public static Button button,button2,button3,statusBtn,searchBtn;
    public static EditText editTextGia;
    private Database database = new Database(this);
    private SQLiteDatabase Database = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText) findViewById(R.id.editText);
        final EditText editText1 = (EditText) findViewById(R.id.keyWordText);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        eraseImageButton = (ImageButton) findViewById(R.id.eraseImageButton);
//        eraseImageButton.setOnClickListener(MainActivity.this);

        keyWordText = (EditText) findViewById(R.id.keyWordText);
        PriceText = (EditText) findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("T","adfdsfa");
                DanhMuc();
            }
        });
        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NhanHieu();
            }
        });
        button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KichCo();
            }
        });
        statusBtn = (Button)findViewById(R.id.statusBtn);
        searchBtn = (Button)findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });

    }
    // kiem tra su ton tai cua database
//    public boolean isTableExists(SQLiteDatabase database, String tableName) {
//        Cursor cursor = database.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '"+tableName+"'", null);
//        if(cursor!=null) {
//            if(cursor.getCount()>0) {
//                cursor.close();
//                return true;
//            }
//            cursor.close();
//        }
//        return false;
//    }
    public void DanhMuc(){
        Intent viewDanhMuc = new Intent(this,DanhMuc.class);
        startActivityForResult(viewDanhMuc,1);
    }
    public  void NhanHieu(){
        Intent viewNhanHieu = new Intent(this,NhanHieu.class);
        startActivityForResult(viewNhanHieu,1);
    }
    public void KichCo(){
        Intent viewKichCo = new Intent(this,KichCo.class);
        startActivityForResult(viewKichCo,1);
    }
    public void search(){
        Intent viewSearch = new Intent(this,Search.class);
        startActivity(viewSearch);
    }
    // ham xu ly ket qua tra ve
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode==1){
            //noiDung la noi dung tuong ung cua listView duoc tra ve
            String noidung = data.getStringExtra("noiDung");
            button.setText(noidung);
        }
    }
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.guideBtn: {
                final Dialog guideDialog = new Dialog(this);
                guideDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                guideDialog.setContentView(R.layout.guide);
                guideDialog.setCanceledOnTouchOutside(false);
                Window window = guideDialog.getWindow();
                WindowManager.LayoutParams wlp = window.getAttributes();

                wlp.gravity = Gravity.CENTER;

                guideDialog.show();
                Button backBtn = (Button) guideDialog.findViewById(R.id.backBtn);
                backBtn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        guideDialog.dismiss();
                    }
                });
                break;
            }
            case R.id.eraseImageButton: {
                final Dialog eraseConfirmDialog = new Dialog(this);
                eraseConfirmDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                eraseConfirmDialog.setContentView(R.layout.confirm_erase);
                eraseConfirmDialog.setCanceledOnTouchOutside(false);


                eraseConfirmDialog.show();

                Button backBtn = (Button) eraseConfirmDialog.findViewById(R.id.backBtn);
                backBtn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        eraseConfirmDialog.dismiss();
                    }
                });
                Button eraseBtn = (Button) eraseConfirmDialog.findViewById(R.id.eraseBtn);
                eraseBtn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        keyWordText.setText("");
                        PriceText.setText("");
                        button.setText("Tất cả");
                        button2.setText("Tất cả");
                        button3.setText("Tất cả");
                        statusBtn.setText("");
                        eraseConfirmDialog.dismiss();
                    }
                });
                break;
            }
            case R.id.statusBtn: {
                status = "Mới";
                final Dialog statusDialog = new Dialog(this);
                statusDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                statusDialog.setContentView(R.layout.status);
                statusDialog.setCanceledOnTouchOutside(false);

                statusDialog.show();
                final Button tmpBtn = (Button) findViewById(R.id.statusBtn);
                Button okBtn = (Button) statusDialog.findViewById(R.id.okBtn);

                final RadioGroup radioGroup = (RadioGroup) statusDialog.findViewById(R.id.radioGroup);

                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    public void onCheckedChanged(RadioGroup group, int checkedId) {

                        int checkedRadioId = group.getCheckedRadioButtonId();
                        RadioButton radioButton = (RadioButton) statusDialog.findViewById(checkedRadioId);
                        status = (String) radioButton.getText();
                    }
                });


                okBtn.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        tmpBtn.setText(status);
                        statusDialog.dismiss();
                    }

                });
                break;

            }

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://oopprojet.tranlinh.com.oop_project/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://oopprojet.tranlinh.com.oop_project/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
class MyEvent implements View.OnClickListener{
    public void onClick(View v){
//        if(v.getId()== R.id.button){
//            new DanhMuc();
//        }
        if(v.getId() == R.id.button2){
            new NhanHieu();
        }
        if(v.getId() == R.id.button3){
            new KichCo();
        }
        if(v.getId() == R.id.searchBtn){
            new Search();
        }
    }
}
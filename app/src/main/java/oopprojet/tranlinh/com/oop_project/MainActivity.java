package oopprojet.tranlinh.com.oop_project;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String status;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public static AutoCompleteTextView keyWordText;
    public static Button PriceText;
    public static Button button,button2,button3,statusBtn,searchBtn;
    public static Database database;
    private String array[]= new String[20];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //load database
        database  = new Database(this);
        database.createDefaultIfNeed();

        // load button, textView ...
        this.findViewByID();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        // khoi tao array
        createArray();

    }

    private void findViewByID(){
        keyWordText = (AutoCompleteTextView) findViewById(R.id.keyWordText);
        this.xuLyNutKeyWord();
        PriceText = (Button) findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
    private void xuLyNutKeyWord(){

        // xu ly hien thi goi y
        ArrayList<String> arrayList = database.getSP();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        keyWordText.setThreshold(1);
        keyWordText.setAdapter(adapter);

        // xu ly thiet lap lai mac dinh khi thay doi tu khoa
        keyWordText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                button.setText("Tất cả");
                button2.setText("Tất cả");
                button3.setText("Tất cả");
                statusBtn.setText("Tất cả");
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }
    public void DanhMuc(){
        Intent viewDanhMuc = new Intent(this,DanhMuc.class);
        startActivityForResult(viewDanhMuc,1);
    }
    public  void NhanHieu(){
        Intent viewNhanHieu = new Intent(this,NhanHieu.class);
        startActivityForResult(viewNhanHieu,2);
    }
    public void KichCo(){
        Intent viewKichCo = new Intent(this,KichCo.class);
        startActivityForResult(viewKichCo,3);
    }
    public void search(){
        Intent viewSearch = new Intent(this,Search.class);
        startActivity(viewSearch);
    }

    // ham xu ly ket qua tra ve
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        String noiDung;
        if(resultCode==1){
            //noiDung la noi dung tuong ung cua listView duoc tra ve
            noiDung = data.getStringExtra("noiDung");
            button.setText(noiDung);
        }
        if(resultCode==2){
            noiDung = data.getStringExtra("noiDung");
            button2.setText(noiDung);
        }
        if(resultCode==3){
            noiDung = data.getStringExtra("noiDung");
            button3.setText(noiDung);
        }
    }
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.guideBtn: {
                // su kien khi click vao button huong dan

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

                // su kien khi click vao button xoa
                final AlertDialog.Builder eraseConfirmDialog = new AlertDialog.Builder(MainActivity.this);

                eraseConfirmDialog.setMessage("Dữ liệu nhập vào form sẽ bị xóa hết");
                eraseConfirmDialog.setNegativeButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        keyWordText.setText("");
                        PriceText.setText("");
                        button.setText("Tất cả");
                        button2.setText("Tất cả");
                        button3.setText("Tất cả");
                        statusBtn.setText("Tất cả");
                    }
                });
                eraseConfirmDialog.setPositiveButton("Quay lại", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                eraseConfirmDialog.create().show();
                break;
            }
            case R.id.statusBtn: {

                // su kien khi click vao button trang thai
                status = "Mới";
                final Dialog statusDialog = new Dialog(this);
                statusDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                statusDialog.setContentView(R.layout.status);


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
            case R.id.editText:{
                // su kien khi click vao button gia

                final Dialog priceDialog = new Dialog(this);
                priceDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                priceDialog.setContentView(R.layout.activity_price);

                Window window = priceDialog.getWindow();
                WindowManager.LayoutParams wlp = window.getAttributes();

                wlp.gravity = Gravity.BOTTOM;

                priceDialog.show();

                final NumberPicker giaDau = (NumberPicker)priceDialog.findViewById(R.id.numberPicker);
                final NumberPicker giaCuoi = (NumberPicker)priceDialog.findViewById(R.id.numberPicker2);


                giaDau.setMinValue(0);
                giaDau.setMaxValue(array.length - 1);
                giaDau.setDisplayedValues(array);               // hien thi gia theo dung gia tri cua mang
                giaDau.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
                giaDau.setWrapSelectorWheel(false);
                giaDau.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                    @Override
                    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                        // khi thay doi giaDau, neu lam cho giaDau lon hon giaCuoi thi tu dong tang gia tri cua giaCuoi len
                        if(Integer.parseInt(array[newVal]) >= Integer.parseInt(array[giaCuoi.getValue()])) {
                            giaCuoi.setValue(newVal + 1);
                        }

                        // dua thong tin gia ve cho PriceText
                        PriceText.setText(array[newVal] + "-" + array[giaCuoi.getValue()]);
                    }
                });


                giaCuoi.setMinValue(0);
                giaCuoi.setMaxValue(array.length - 1);
                giaCuoi.setDisplayedValues(array);
                giaCuoi.setWrapSelectorWheel(false);
                giaCuoi.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
                giaCuoi.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                    @Override
                    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                        // khi thay doi giaCuoi, neu lam cho giaCuoi nho hon giaDau thi tu dong giam gia tri cua giaDau
                        if(Integer.parseInt(array[newVal]) <= Integer.parseInt(array[giaDau.getValue()])) {
                            giaDau.setValue(newVal - 1);
                        }

                        //dua thong tin ve cho PriceText
                        PriceText.setText(array[giaDau.getValue()]+"-"+array[newVal]);
                    }
                });
            }

        }
    }

    private void createArray(){
        // ham khoi tao gia tri cho array
        int i;
        array[0] = "500000";
        for(i =1; i< 20;i++){
            array[i] = String.valueOf((i+2)*500000);
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

package oopprojet.tranlinh.com.oop_project;

import android.app.Dialog;
import android.content.Intent;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private String status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText)findViewById(R.id.editText);
        final EditText editText1 = (EditText)findViewById(R.id.keyWordText);

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

    }
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.guideBtn:{
                final Dialog guideDialog = new Dialog(this);
                guideDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                guideDialog.setContentView(R.layout.guide);
                guideDialog.setCanceledOnTouchOutside(false);
                Window window = guideDialog.getWindow();
                WindowManager.LayoutParams wlp =window.getAttributes();

                wlp.gravity = Gravity.CENTER;

                guideDialog.show();
                Button backBtn = (Button)guideDialog.findViewById(R.id.backBtn);
                backBtn.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        guideDialog.dismiss();
                    }
                });
                break;
            }
            case R.id.eraseImageButton:{
                final Dialog eraseConfirmDialog = new Dialog(this);
                eraseConfirmDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                eraseConfirmDialog.setContentView(R.layout.confirm_erase);
                eraseConfirmDialog.setCanceledOnTouchOutside(false);


                eraseConfirmDialog.show();

                Button backBtn = (Button)eraseConfirmDialog.findViewById(R.id.backBtn);
                backBtn.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        eraseConfirmDialog.dismiss();
                    }
                });
                Button eraseBtn = (Button)eraseConfirmDialog.findViewById(R.id.eraseBtn);
                eraseBtn.setOnClickListener(new View.OnClickListener(){
                    public void  onClick(View v){
                        Intent intent = new Intent(MainActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                });
                break;
            }
            case R.id.statusBtn:{
                status ="Mới";
                final Dialog statusDialog = new Dialog(this);
                statusDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                statusDialog.setContentView(R.layout.status);
                statusDialog.setCanceledOnTouchOutside(false);

                statusDialog.show();
                final Button tmpBtn = (Button)findViewById(R.id.statusBtn);
                Button okBtn = (Button) statusDialog.findViewById(R.id.okBtn);

                final RadioGroup radioGroup = (RadioGroup)statusDialog.findViewById(R.id.radioGroup);

                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
                    public void onCheckedChanged(RadioGroup group, int checkedId){

                        int checkedRadioId = group.getCheckedRadioButtonId();
                        RadioButton radioButton =(RadioButton)statusDialog.findViewById(checkedRadioId);
                        status = (String)radioButton.getText();
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
}

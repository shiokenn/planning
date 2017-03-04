package android.lifeistech.com.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MakeActivity extends AppCompatActivity {

    EditText titleEditText;
    EditText contentEditText;
    CheckBox checkBox;

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        titleEditText = (EditText) findViewById(R.id.title);
        contentEditText = (EditText) findViewById(R.id.content);
        checkBox = (CheckBox) findViewById(R.id.checkbox);

        pref = getSharedPreferences("pref_edit", MODE_PRIVATE);

        titleEditText.setText(pref.getString("key_title", ""));
        contentEditText.setText(pref.getString("key_content", ""));



    }

    public void checkbox(View v){

        boolean checked = checkBox.isChecked();


    }





    public void save(View v){
        String titleText = titleEditText.getText().toString();
        String contentText = contentEditText.getText().toString();

        SharedPreferences.Editor editor = pref.edit();
        editor.putString("key_title",titleText);
        editor.putString("key_content",contentText);
        editor.commit();


        finish();

    }
}

package com.example.cambiodeidioma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textview2;
    private TextView textview3;
    private TextView textview4;
    private TextView textview5;
    private Locale locale;
    private Configuration config = new Configuration();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = ((Button)findViewById(R.id.button));
        textview2 = ((TextView)findViewById(R.id.textView2));
        textview3 = ((TextView)findViewById(R.id.textView3));
        textview4 = ((TextView)findViewById(R.id.textView4));
        textview5 = ((TextView)findViewById(R.id.textView5));

        button.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        showDialog();
                    }});
    }


    private void showDialog(){
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle(getResources().getString(R.string.str_button));
        //obtiene los idiomas del array de string.xml
        String[] types = getResources().getStringArray(R.array.languages);
        b.setItems(types, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
                switch(which){
                    case 0:
                        locale = new Locale("es");
                        config.locale =locale;
                        break;
                    case 1:
                        locale = new Locale("en");
                        config.locale =locale;
                        break;
                    case 2:
                        locale = new Locale("it");
                        config.locale =locale;
                        break;
                }
                getResources().updateConfiguration(config, null);
                Intent refresh = new Intent(MainActivity.this, MainActivity.class);
                startActivity(refresh);
                finish();
            }

        });

        b.show();
    }

}

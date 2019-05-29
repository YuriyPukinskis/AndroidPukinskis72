package ru.netology.androidpukinskis72;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        TextView tw = findViewById(R.id.textView);
        final Spinner sp = findViewById(R.id.spinner);
        tw.setText(getResources().getString(R.string.text));
        btn.setText(getResources().getString(R.string.btn));


        btn.setOnClickListener(new View.OnClickListener() {
            Locale locale;
            @Override
            public void onClick(View v) {
                String s= (String)sp.getSelectedItem();
                switch (s){
                    case "Русский": locale = new Locale("ru");break;
                    case "English": locale = new Locale("en");break;
                }

                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                recreate();
            }
        });
    }
}

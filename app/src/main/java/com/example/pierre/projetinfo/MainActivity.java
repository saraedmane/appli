package com.example.pierre.projetinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "distance";//"com.pierre.myapplication.MESSAGE";
    EditText distance = null;
    CheckBox mega = null;
    Button envoyer = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        envoyer = (Button) findViewById(R.id.calcul);
        mega = (CheckBox) findViewById(R.id.mega);
        distance = (EditText) findViewById(R.id.distance);
        envoyer.setOnClickListener(envoyerListener);
        distance.addTextChangedListener(textWatcher);
    }

    private View.OnClickListener envoyerListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String d = distance.getText().toString();
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            Bundle b = new Bundle();
            b.putString(EXTRA_MESSAGE,d);
            intent.putExtras(b);
            startActivity(intent);
        }

    };

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}

package com.example.christian.fitapp2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class Main extends AppCompatActivity {

    // Init DB
    private SQLiteDatabase db = null;
    // Init components
    private Button btnNewCircuit = null;
    private Button btnSelectCircuit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initComponents();
    }

    private void initComponents() {
        this.btnNewCircuit = (Button) findViewById(R.id.btnNewCircuit);
        this.btnNewCircuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newCircuit(v);
            }
        });
        this.btnSelectCircuit = (Button) findViewById(R.id.btnSelectCircuit);
        this.btnSelectCircuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectCircuit(v);
            }
        });
    }

    public void newCircuit(View view) {
        Intent intent = new Intent(this, NewCircuit.class);
        startActivity(intent);
    }

    public void selectCircuit(View view) {
        Intent intent = new Intent(this, SelectCircuit.class);
        startActivity(intent);
    }

}

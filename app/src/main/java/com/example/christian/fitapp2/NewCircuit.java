package com.example.christian.fitapp2;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewCircuit extends AppCompatActivity {

    // Init components
    private EditText inpName = null;
    private EditText inpDescription = null;
    private Button btnSave = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_circuit);

        initComponents();
    }

    private void initComponents() {
        this.inpName = (EditText) findViewById(R.id.inpName);
        this.inpDescription = (EditText) findViewById(R.id.inpDescription);
        this.btnSave = (Button) findViewById(R.id.btnSave);
        this.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveCircuit();
            }
        });
    }

    public void saveCircuit() {
        Context context = getApplicationContext();
        try {
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            // Create insert entries
            ContentValues values = new ContentValues();
            values.put(DBContract.Circuit.COL_NAME, String.valueOf(inpName.getText()));
            values.put(DBContract.Circuit.COL_DESCRIPTION, String.valueOf(inpDescription.getText()));

            // Insert the new row, returning the primary key value of the new row
            long rowId = db.insert(DBContract.Circuit.TABLE_NAME, null, values);

            // Close db
            db.close();

            Toast toast = Toast.makeText(context, "Salvo com sucesso!", Toast.LENGTH_LONG);
            toast.show();

            // Return to Main
            Intent intent = new Intent(this, Main.class);
            startActivity(intent);
        } catch (Exception e) {
            Toast toast = Toast.makeText(context, "Ops! Ocorreu um erro.", Toast.LENGTH_LONG);
            toast.show();
        }

    }

}

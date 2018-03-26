package com.example.christian.fitapp2;

import android.app.ListActivity;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SimpleCursorAdapter;

//public class SelectCircuit extends ListActivity implements LoaderManager.LoaderCallbacks<Cursor> {
public class SelectCircuit extends ListActivity {

    private DBHelper dbHelper;
    private Context context;
    private SQLiteDatabase db;
    private ListView listView;
    private SimpleCursorAdapter adapter;

    final String[] from = new String[]{DBContract.Circuit.COL_ID, DBContract.Circuit.COL_NAME, DBContract.Circuit.COL_DESCRIPTION};
    final int[] to = new int[]{R.id.circuit_id, R.id.circuit_name, R.id.circuit_description};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_circuit);

        // Tutorial muito bom pra CRUD:
        // https://www.journaldev.com/9438/android-sqlite-database-example-tutorial

        context = getApplicationContext();
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();

        Cursor cursor = fetch();

        listView = (ListView) findViewById(android.R.id.list);
        listView.setEmptyView(findViewById(R.id.empty_list));

        adapter = new SimpleCursorAdapter(this, R.layout.view_record, cursor, from, to, 0);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);
    }

    public Cursor fetch() {
        Cursor cursor = db.query(DBContract.Circuit.TABLE_NAME, from, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

}

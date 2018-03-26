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

    // This is the Adapter being used to display the list's data
//    SimpleCursorAdapter mAdapter;
//
//    // These are the Contacts rows that we will retrieve
//    static final String[] PROJECTION = new String[]{DBContract.Circuit.COL_ID, DBContract.Circuit.COL_NAME};
//
//    // This is the select criteria
//    static final String SELECTION = "((" +
//            DBContract.Circuit.COL_NAME + " NOTNULL) AND (" +
//            DBContract.Circuit.COL_NAME + " != '' ))";
    private DBContract dbContract;

    DBHelper dbHelper;
    Context context;
    SQLiteDatabase db;

    private ListView listView;

    private SimpleCursorAdapter adapter;

    final String[] from = new String[] { DBContract.Circuit.COL_ID, DBContract.Circuit.COL_NAME, DBContract.Circuit.COL_DESCRIPTION};

    final int[] to = new int[] { R.id.circuit_id, R.id.circuit_name, R.id.circuit_description };


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

//        listView = (ListView) findViewById(R.id.list_view);
//        listView.setEmptyView(findViewById(R.id.empty_list));

//        adapter = new SimpleCursorAdapter(this, R.layout.view_record, cursor, from, to, 0);
//        adapter.notifyDataSetChanged();
//
//        listView.setAdapter(adapter);





//        // OnCLickListiner For List Items
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
//                TextView idTextView = (TextView) view.findViewById(R.id.id);
//                TextView titleTextView = (TextView) view.findViewById(R.id.title);
//                TextView descTextView = (TextView) view.findViewById(R.id.desc);
//
//                String id = idTextView.getText().toString();
//                String title = titleTextView.getText().toString();
//                String desc = descTextView.getText().toString();
//
//                Intent modify_intent = new Intent(getApplicationContext(), ModifyCountryActivity.class);
//                modify_intent.putExtra("title", title);
//                modify_intent.putExtra("desc", desc);
//                modify_intent.putExtra("id", id);
//
//                startActivity(modify_intent);
//            }
//        });



//        https://www.journaldev.com/9438/android-sqlite-database-example-tutorial



//        // Create a progress bar to display while the list loads
//        ProgressBar progressBar = new ProgressBar(this);
//        progressBar.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
//        progressBar.setIndeterminate(true);
//        getListView().setEmptyView(progressBar);
//
//        // Must add the progress bar to the root of the layout
//        ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
//        root.addView(progressBar);
//
//        String[] fromColumns = {DBContract.Circuit.COL_NAME};
//        int[] toViews = {android.R.id.text1};
//
//        mAdapter = new SimpleCursorAdapter(this,
//                android.R.layout.simple_list_item_1, null,
//                fromColumns, toViews, 0);
//        setListAdapter(mAdapter);
//
//        // Prepare the loader.  Either re-connect with an existing one,
//        // or start a new one.
//        getLoaderManager().initLoader(0, null, this);
    }
    public Cursor fetch() {
        String[] columns = new String[] { DBContract.Circuit.COL_ID, DBContract.Circuit.COL_NAME, DBContract.Circuit.COL_DESCRIPTION };
        Cursor cursor = db.query(DBContract.Circuit.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

//    @Override
//    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
//        return new CursorLoader(this, DBContract.CONTENT_URI,
//                PROJECTION, SELECTION, null, null);
//    }
//
//    @Override
//    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
//        mAdapter.swapCursor(cursor);
//    }
//
//    @Override
//    public void onLoaderReset(Loader<Cursor> loader) {
//        mAdapter.swapCursor(null);
//    }
}

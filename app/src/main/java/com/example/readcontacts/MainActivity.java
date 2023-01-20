package com.example.readcontacts;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    listView = findViewById(R.id.listview);


    }
    public void get(View v)
    {
        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,null,null,null);
        startManagingCursor(cursor);

        String[] from = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER
        ,ContactsContract.CommonDataKinds.Phone._ID};


        int[] to  = {R.id.text1,R.id.text2};

        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,cursor,from,to);
        listView.setAdapter(simpleCursorAdapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }
}
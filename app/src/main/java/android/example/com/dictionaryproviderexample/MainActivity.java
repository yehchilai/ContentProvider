/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package android.example.com.dictionaryproviderexample;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.provider.UserDictionary.Words;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

/**
 * This is the central activity for the Provider Dictionary Example App. The purpose of this app is
 * to show an example of accessing the {@link Words} list via its' Content Provider.
 */
public class MainActivity extends ActionBarActivity {

    private static final String[] COLUMN_TO_BE_BOUND = new String[]{
        Words.WORD,
        Words.FREQUENCY
    };

    private static final int[] LAYOUT_ITEM_TO_FILL = new int[]{
        android.R.id.text1,
        android.R.id.text2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the TextView which will be populated with the Dictionary ContentProvider data.
        ListView dictListView = (ListView) findViewById(R.id.dictionary_list_view);

        // Get the ContentResolver which will send a message to the ContentProvider
        ContentResolver resolver = getContentResolver();

        // Get a Cursor containing all of the rows in the Words table
        Cursor cursor = resolver.query(UserDictionary.Words.CONTENT_URI, null, null, null, null);

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item,
                cursor,
                COLUMN_TO_BE_BOUND,
                LAYOUT_ITEM_TO_FILL,
                0);

        dictListView.setAdapter(adapter);
        /*************
         * Use TextView
         * **************/
//        dictTextView.setText("This is the Udacity project for training how to use ContentProvider\n"
//                + "The words count in Dictionary is : "
//                + cursor.getCount()
//                + "\n");
//
//        int idColumn = cursor.getColumnIndex(Words._ID);
//        int wordColumn = cursor.getColumnIndex(Words.WORD);
//        int frequencyColumn = cursor.getColumnIndex(Words.FREQUENCY);
//
//        try{
//            if(cursor.moveToFirst()){
//
//                dictTextView.append(cursor.getInt(idColumn) + " , "
//                        + cursor.getString(wordColumn) + " , "
//                        + cursor.getInt(frequencyColumn) + " \n");
//
//            }else{
//                Log.e("### ", "There is no data in the table");
//                return;
//            }
//
//            while(cursor.moveToNext()){
//                dictTextView.append(cursor.getInt(idColumn) + " , "
//                        + cursor.getString(wordColumn) + " , "
//                        + cursor.getInt(frequencyColumn) + " \n");
//            }
//        }finally {
//            cursor.close();
//        }

    }
}

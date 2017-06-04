/*
 * Copyright (C) 2016 The Android Open Source Project
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
package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.android.miwok.R.id.numbers;
import static com.example.android.miwok.R.id.phrases;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create an ArrayList of AndroidFlavor objects
        final ArrayList<Word> words = new ArrayList<Word>();
//        Word w = new Word("one","lutti");
//        words.add(w);
        Word.hasAnImage=true;
        //more elegant way
        words.add(new Word("one","lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two","otiiko", R.drawable.number_two, R.raw.number_two ));
        words.add(new Word("three","tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four","oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five","massokka", R.drawable.number_five,R.raw.number_five));
        words.add(new Word("six","temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven","kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight","kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine","wo’e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten","na’aacha", R.drawable.number_ten, R.raw.number_ten));


        // Create an {@link AndroidFlavorAdapter}, whose data source is a list of
        // {@link AndroidFlavor}s. The adapter knows how to create list item views for each item
        // in the list.
        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_numbers);

        // Get a reference to the ListView, and attach the adapter to the listView.
        //Layout for the main screen -->
        ListView listView = (ListView) findViewById(R.id.listview_word);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View selectedView, int position, long id) {

//                Log.d("ON ITEM CLICK...", " ON ITEM CLICK... "+ position + words.get(position).getMusicId());
                Log.v("NumbersActivity", "Current word: " + words);
                // here we are referencing a certain Word Object inside a ListView. We are referencing a method which returns songId
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, words.get(position).getMusicId());

                //start the audio file
                mediaPlayer.start();


            }
        });
    }
}


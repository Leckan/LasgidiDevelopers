package com.leckan.lasgididevelopers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

// TODO:
// 	• Creat List view containing
//      ○ Image
//      Username
//  • OnClick event should open Activity
//        ○ Username
//        ○ Profile Photo
 //       ○ Github url
 //       § On click open
//        ○ Share button
 //       § “Check out this awesome developer @<github username>, <github profile url>.”


public class MainActivity extends AppCompatActivity {
    private JSONParser jsonParser;
    private static String gitURL = "https://api.github.com/search/users?q=location:lagos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     ArrayList<LasgidiUser> listData = getListData();

        final ListView listView = (ListView) findViewById(R.id.userListView);
        listView.setAdapter(new UserListAdapter(this, listData));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                LasgidiUser newsData = (LasgidiUser) listView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Selected :" + " " + newsData, Toast.LENGTH_LONG).show();
            }
        });
    }

    private ArrayList<LasgidiUser> getListData() {
        ArrayList<LasgidiUser> listMockData = new ArrayList<LasgidiUser>();
        String[] images = getResources().getStringArray(R.array.images_array);
        String[] headlines = getResources().getStringArray(R.array.headline_array);

        for (int i = 0; i < images.length; i++) {
            LasgidiUser newsData = new LasgidiUser();
            newsData.setUrl(images[i]);
            newsData.setHeadline(headlines[i]);
            newsData.setReporterName("Pankaj Gupta");
            newsData.setDate("May 26, 2013, 13:35");
            listMockData.add(newsData);
        }
        return listMockData;
    }
}

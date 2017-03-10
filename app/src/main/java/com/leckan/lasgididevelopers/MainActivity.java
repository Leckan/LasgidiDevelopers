package com.leckan.lasgididevelopers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

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


    String[] usernames ={"ahmed","mustapha"};
    int[] images = new int[]{R.mipmap.userpic, R.mipmap.userpic};
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv= (ListView) findViewById(R.id.userListView);
        UserAdapter adapter = new UserAdapter(MainActivity.this, usernames, images);
        lv.setAdapter(adapter);
    }
}

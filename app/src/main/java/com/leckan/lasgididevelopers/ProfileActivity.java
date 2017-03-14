package com.leckan.lasgididevelopers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        LasgidiUser theUser = (LasgidiUser) getIntent().getSerializableExtra("theLasgidiUser");

        TextView usernameView = (TextView) findViewById(R.id.profile_username);
        ImageView imageView = (ImageView) findViewById(R.id.userpic);
        usernameView.setText(theUser.getLogin());
        new DownloadImageTask(imageView).execute(theUser.getAvatar_url());
    }
}

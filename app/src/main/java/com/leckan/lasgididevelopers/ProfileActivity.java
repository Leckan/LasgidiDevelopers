package com.leckan.lasgididevelopers;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    private WebView mWebview ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final LasgidiUser theUser = (LasgidiUser) getIntent().getSerializableExtra("theLasgidiUser");


        ImageView imageView = (ImageView) findViewById(R.id.profile_pic);
        new DownloadImageTask(imageView).execute(theUser.getAvatar_url());

        TextView usernameView = (TextView) findViewById(R.id.profile_username);
        TextView urlView = (TextView) findViewById(R.id.profile_url);
        ImageButton sharingButton = (ImageButton) findViewById(R.id.profile_share);

       // sharingButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
       sharingButton.setImageResource(R.mipmap.share_icon);

        urlView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(theUser.getHtml_url()); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        sharingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Check out this awesome developer @" + theUser.getLogin() + ", "+ theUser.getHtml_url() ;
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);

                startActivity(Intent.createChooser(sharingIntent, "Share via"));
               }
        });

        urlView.setText(theUser.getHtml_url());
        usernameView.setText(theUser.getLogin());



    }
}

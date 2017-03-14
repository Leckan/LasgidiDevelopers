package com.leckan.lasgididevelopers;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

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

    private String TAG = MainActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private static String gitURL = "https://api.github.com/search/users?q=location:lagos";
    ArrayList<LasgidiUser> gitUsers;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView= (ListView) findViewById(R.id.userListView);
        new GetUsers().execute();

    }

    private ArrayList<LasgidiUser> getListData() {
        ArrayList<LasgidiUser> listMockData = new ArrayList<LasgidiUser>();
        String[] images = getResources().getStringArray(R.array.images_array);
        String[] headlines = getResources().getStringArray(R.array.headline_array);

        return listMockData;
    }


    private class GetUsers extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(gitURL);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray myUsers = jsonObj.getJSONArray("items");
                    gitUsers = new ArrayList<LasgidiUser>();
                    // looping through All Contacts
                    for (int i = 0; i < myUsers.length(); i++) {
                        JSONObject c = myUsers.getJSONObject(i);
                        LasgidiUser aUser = new LasgidiUser();
                        aUser.setId(c.getString("id"));
                        aUser.setLogin(c.getString("login"));
                        aUser.setAvatar_url(c.getString("avatar_url"));
                        aUser.setGravatar_id(c.getString("gravatar_id"));
                        aUser.setUserUrl(c.getString("url"));
                        aUser.setHtml_url(c.getString("html_url"));
                        aUser.setFollowers_url(c.getString("followers_url"));
                        aUser.setFollowing_url(c.getString("following_url"));
                        aUser.setGists_url(c.getString("gists_url"));
                        aUser.setStarred_url(c.getString("starred_url"));
                        aUser.setSubscriptions_url(c.getString("subscriptions_url"));
                        aUser.setOrganizations_url(c.getString("organizations_url"));
                        aUser.setRepos_url(c.getString("repos_url"));
                        aUser.setEvents_url(c.getString("events_url"));
                        aUser.setReceived_events_url(c.getString("received_events_url"));
                        aUser.setType(c.getString("type"));
                        aUser.setSite_admin(c.getString("site_admin"));
                        aUser.setScore(c.getString("score"));

                        // adding contact to contact list
                        gitUsers.add(aUser);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */

            listView.setAdapter(new UserListAdapter(MainActivity.this, gitUsers));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                    LasgidiUser aUser = (LasgidiUser) listView.getItemAtPosition(position);
                    Toast.makeText(MainActivity.this, "Selected :" + " " + aUser.getLogin(), Toast.LENGTH_LONG).show();
                }
            });

        }

    }


}

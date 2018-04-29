package com.wenhutech.uav_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class HomeActivity extends Activity {
    private ImageButton uav_help;
    private ImageButton uav_conf;
    private ImageButton uav_play;
    private ImageButton uav_demo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        initHomeView();
        uav_help.setOnClickListener(helpOnClickListener);
        uav_conf.setOnClickListener(confOnClickListener);
        uav_play.setOnClickListener(playOnClickListener);
    }

    private void initHomeView() {
        uav_help = findViewById(R.id.uav_help);
        uav_conf = findViewById(R.id.uav_config);
        uav_play = findViewById(R.id.uav_play);
        uav_demo = findViewById(R.id.uav_demo);
    }

    View.OnClickListener helpOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent helpIntent = new Intent(HomeActivity.this, HelpActivity.class);
            startActivity(helpIntent);
        }
    };

    View.OnClickListener confOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent configIntent = new Intent(HomeActivity.this, ConfActivity.class);
            startActivity(configIntent);

        }
    };

    View.OnClickListener playOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent mainIntent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(mainIntent);
        }
    };

}

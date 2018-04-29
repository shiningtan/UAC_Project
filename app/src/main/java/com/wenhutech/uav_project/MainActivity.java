package com.wenhutech.uav_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by miracle on 2018/4/21.
 */

public class MainActivity extends Activity {

    private ImageButton main_top_back;
    private ImageButton main_top_photo;
    private ImageButton main_top_video;
    private ImageButton main_top_file;
    private ImageButton main_top_percent;
    private ImageButton main_top_gravity;
    private ImageButton main_top_gyro;
    private ImageButton main_top_controller;
    private ImageButton main_top_more;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initAction();
    }

    private void initView() {
        main_top_back = findViewById(R.id.main_top_back);
        main_top_photo = findViewById(R.id.main_top_photo);
        main_top_video = findViewById(R.id.main_top_video);
        main_top_file = findViewById(R.id.main_top_file);
        main_top_percent = findViewById(R.id.main_top_percent);
        main_top_gravity = findViewById(R.id.main_top_gravity);
        main_top_gyro = findViewById(R.id.main_top_gyro);
        main_top_controller = findViewById(R.id.main_top_controller);
        main_top_more = findViewById(R.id.main_top_more);
    }

    private void initAction() {
        main_top_back.setOnClickListener(backOnClickListener);
        main_top_file.setOnClickListener(fileOnClickListener);
    }

    View.OnClickListener backOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

    View.OnClickListener photoOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    View.OnClickListener videoOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    View.OnClickListener fileOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent fileIntent = new Intent(MainActivity.this, FileActivity.class);
            startActivity(fileIntent);
        }
    };

    View.OnClickListener percentOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    View.OnClickListener gravityOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    View.OnClickListener gyroOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    View.OnClickListener controllerOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    View.OnClickListener moreOptionsOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
}

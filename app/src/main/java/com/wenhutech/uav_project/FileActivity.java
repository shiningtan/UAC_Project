package com.wenhutech.uav_project;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by miracle on 2018/4/21.
 */

public class FileActivity extends Activity {
    private ListView fileListView;
    private int[] imagesId = {R.mipmap.file_list_photo, R.mipmap.file_list_video};
    private String[] names = {"手机图片", "手机视频"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        fileListView = findViewById(R.id.fileListView);
        FileAdapter fileAdapter = new FileAdapter(this);
        fileListView.setAdapter(fileAdapter);

    }

    private class FileAdapter extends BaseAdapter {
        private Context mContext;

        public FileAdapter(Context context) {
            this.mContext = context;
        }

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return names[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View layout = View.inflate(mContext, R.layout.file_item_list, null);
            ImageView icon = layout.findViewById(R.id.file_item_iv);
            TextView name = layout.findViewById(R.id.file_item_tv);
            ImageView arrow = layout.findViewById(R.id.file_item_arrow);

            icon.setImageResource(imagesId[position]);
            name.setText(names[position]);
            return layout;
        }
    }
}



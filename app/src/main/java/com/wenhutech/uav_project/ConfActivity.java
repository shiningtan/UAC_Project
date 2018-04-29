package com.wenhutech.uav_project;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by miracle on 2018/4/15.
 */

public class ConfActivity extends Activity {
    private final int TYPE_SWITCH = 0;
    private final int TYPE_BUTTON = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getActionBar();
//
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.conf_actionbar_view);
        setContentView(R.layout.activity_conf);

        actionBar.getCustomView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.conf_back_btn:
                        finish();
                        break;
                    default:
                        break;
                }
            }
        });
        ArrayList<String> list = new ArrayList();
        list.add("自动保存参数");
        list.add("微调参数");
        list.add("右手模式");
        ListView confListView = findViewById(R.id.conf_listView);
        ConfListAdapter adapter = new ConfListAdapter(this, list);
        confListView.setAdapter(adapter);
    }


    private class ConfListAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private Context mContext;
        private List mList;

        public ConfListAdapter(@NonNull Context context, List list) {
            this.mContext = context;
            this.mList = list;
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getItemViewType(int position) {
            if (position == 1) {
                return TYPE_BUTTON;
            } else {
                return TYPE_SWITCH;
            }
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            ViewHolder1 viewHolder1 = null;
            ViewHolder2 viewHolder2 = null;
            int type = getItemViewType(position);
            if (convertView == null) {
                switch (type) {
                    case TYPE_SWITCH:
                        convertView = mInflater.inflate(R.layout.conf_list_switch, parent, false);
                        viewHolder1 = new ViewHolder1();
                        viewHolder1.tv1 = convertView.findViewById(R.id.conf_list_switch_tv);
                        viewHolder1.mSwitch = convertView.findViewById(R.id.conf_list_switch_switch);
                        convertView.setTag(viewHolder1);
                        break;
                    case TYPE_BUTTON:
                        convertView = mInflater.inflate(R.layout.conf_list_button, parent, false);
                        viewHolder2 = new ViewHolder2();
                        viewHolder2.tv2 = convertView.findViewById(R.id.conf_list_button_tv);
                        viewHolder2.mButton = convertView.findViewById(R.id.conf_list_button_button);
                        convertView.setTag(viewHolder2);
                        break;
                }
            } else {
                switch (type) {
                    case TYPE_SWITCH:
                        viewHolder1 = (ViewHolder1) convertView.getTag();
                        break;
                    case TYPE_BUTTON:
                        viewHolder2 = (ViewHolder2) convertView.getTag();
                        break;
                }
            }
            switch (type) {
                case TYPE_SWITCH:
                    viewHolder1.tv1.setText(mList.get(position).toString());
                    break;
                case TYPE_BUTTON:
                    viewHolder2.tv2.setText(mList.get(position).toString());
                    viewHolder2.mButton.setText("重置");
                    break;
            }
            return convertView;
        }
    }

    class ViewHolder1 {
        TextView tv1;
        Switch mSwitch;
    }

    class ViewHolder2 {
        TextView tv2;
        Button mButton;
    }

}

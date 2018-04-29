package com.wenhutech.uav_project;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * Created by miracle on 2018/4/14.
 */

public class HelpActivity extends Activity {
    int current_image = 0;
    private int[] ids = {R.mipmap.help01,
            R.mipmap.help02, R.mipmap.help03,
            R.mipmap.help04, R.mipmap.help05
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_help);
        final ViewPager helpViewPager = findViewById(R.id.help_viewPager);
        ImageButton help_back_btn = findViewById(R.id.help_back_btn);
        final ImageButton help_switch_prev_btn = findViewById(R.id.help_switch_prev_btn);
        final ImageButton help_switch_next_btn = findViewById(R.id.help_switch_next_btn);
        help_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        help_switch_prev_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helpViewPager.setCurrentItem(current_image);
                if (current_image == 0) {
                    help_switch_next_btn.setVisibility(View.VISIBLE);
                    help_switch_prev_btn.setVisibility(View.GONE);
                    current_image++;
                } else {
                    current_image--;
                }
            }
        });

        help_switch_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                helpViewPager.setCurrentItem(current_image);
                if (current_image == ids.length - 1) {
                    help_switch_next_btn.setVisibility(View.GONE);
                    help_switch_prev_btn.setVisibility(View.VISIBLE);
                    current_image--;
                } else {
                    current_image++;
                }
            }


        });
        ArrayList<Integer> imageList = new ArrayList<>();
        for (
                int i = 0;
                i < ids.length; i++)

        {
            imageList.add(ids[i]);
        }

        HelpPageAdapter helpPageAdapter = new HelpPageAdapter(this, imageList);
        helpViewPager.setAdapter(helpPageAdapter);

    }

    private class HelpPageAdapter extends PagerAdapter {
        private ArrayList<Integer> mList;
        private Context mContext;

        public HelpPageAdapter(Context context, ArrayList<Integer> list) {
            this.mList = list;
            this.mContext = context;
        }

        @Override
        public int getCount() {
            return mList.size();
        }


        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView helpImage = new ImageView(mContext);
            RelativeLayout.LayoutParams lp =
                    new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                            RelativeLayout.LayoutParams.MATCH_PARENT);
            helpImage.setLayoutParams(lp);
            helpImage.setImageResource(mList.get(position));
            container.addView(helpImage);
            return helpImage;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }


}

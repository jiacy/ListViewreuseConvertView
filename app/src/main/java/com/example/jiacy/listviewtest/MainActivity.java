package com.example.jiacy.listviewtest;

import android.app.ListActivity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.view.View;
import android.util.Log;


public class MainActivity extends ListActivity {
    private int tagId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter mAdapter = new ArrayAdapter(this, 0) {
            private TextView text1;
            private TextView text2;

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_2, null);
                    //convertView.setMinimumHeight(400);

                    Log.d("位置" + position, "创建新convertView,设置tagId:" + tagId);
                    convertView.setTag(tagId++);
                } else {
                    Log.d("位置" + position, convertView.getTag() + " 复用convertView");
                }

                text1 = convertView.findViewById(android.R.id.text1);
                text1.setTextColor(getResources().getColor(android.R.color.holo_blue_bright));
                text1.setText(getItem(position));

                text2 = convertView.findViewById(android.R.id.text2);
                text2.setTextColor(getResources().getColor(android.R.color.holo_red_light));
                text2.setText("convertView tagId:" + String.valueOf(convertView.getTag()));

                return convertView;
            }

            @Nullable
            @Override
            public String getItem(int position) {
                return "位置position:" + position;
            }

            @Override
            public int getCount() {
                return 99999;
            }
        };

        setListAdapter(mAdapter);
    }
}
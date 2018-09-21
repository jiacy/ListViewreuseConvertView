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

import org.w3c.dom.Text;

class ViewHolder {
    TextView text1;
    TextView text2;
    int tagId;
}


public class MainActivity extends ListActivity {
    private int tagId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter mAdapter = new ArrayAdapter(this, 0) {

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                ViewHolder viewHolder;
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_2, null);
                    //convertView.setMinimumHeight(400);
                    viewHolder = new ViewHolder();
                    viewHolder.text1 = (TextView) convertView.findViewById(android.R.id.text1);
                    viewHolder.text2 = (TextView) convertView.findViewById(android.R.id.text2);
                    viewHolder.text1.setText("newing1+" + tagId);
                    viewHolder.text2.setText("newing2+" + tagId);
                    viewHolder.tagId = tagId;
                    tagId++;
                    Log.d("位置" + position, "创建新convertView,设置tagId:" + tagId);
                    convertView.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) convertView.getTag();
                    Log.d("位置" + position, viewHolder.tagId + " 复用convertView");
                    viewHolder.text1.setText("reusing1+" + viewHolder.tagId);
                    viewHolder.text2.setText("reusing2+" + viewHolder.tagId);
                }

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
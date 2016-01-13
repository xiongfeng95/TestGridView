package com.testgridview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class TestGridViewActivity extends Activity {
    static class ViewHolder {
        ImageView mImg;
        TextView mTxt;
    }

    private GridView mGridView;
    private HorizontalScrollView mScrollView;
    private String TAG = "TestGridView";
    /**
     * 列宽
     */
    private int cWidth = 120;
    /**
     * 水平间距
     */
    private int hSpacing = 10;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findView();
        setValue();
        setListener();
    }

    private void findView() {
        mGridView = (GridView) findViewById(R.id.mGridView);
        mScrollView = (HorizontalScrollView) findViewById(R.id.mScrollView);
        mScrollView.setHorizontalScrollBarEnabled(false);// 隐藏滚动条
    }

    private void setValue() {
        MAdapter mAdapter = new MAdapter(TestGridViewActivity.this);
        mGridView.setAdapter(mAdapter);
        LayoutParams params = new LayoutParams(mAdapter.getCount() * (48 + 10),
                LayoutParams.WRAP_CONTENT);
        mGridView.setLayoutParams(params);
        mGridView.setColumnWidth(cWidth);
        mGridView.setHorizontalSpacing(hSpacing);
        mGridView.setStretchMode(GridView.NO_STRETCH);
        mGridView.setNumColumns(mAdapter.getCount());
    }

    private void setListener() {
        mGridView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                // TODO Auto-generated method stub
                Log.e(TAG, "position = " + position);
            }
        });
    }

    class MAdapter extends BaseAdapter {
        Context mContext;
        LayoutInflater mInflater;

        public MAdapter(Context c) {
            mContext = c;
            mInflater = LayoutInflater.from(mContext);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return 60;
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
        }

        @Override
        public View getView(int arg0, View contentView, ViewGroup arg2) {
            // TODO Auto-generated method stub
            // View v = new View(mContext);
            ViewHolder holder;
            if (contentView == null) {
                holder = new ViewHolder();
                contentView = mInflater.inflate(R.layout.gridview_item, null);
                holder.mImg = (ImageView) contentView.findViewById(R.id.mImage);
                holder.mTxt = (TextView) contentView.findViewById(R.id.mText);
            } else {
                holder = (ViewHolder) contentView.getTag();
            }

            contentView.setTag(holder);
            return contentView;
        }

    }
}

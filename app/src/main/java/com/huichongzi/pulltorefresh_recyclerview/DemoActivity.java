package com.huichongzi.pulltorefresh_recyclerview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.huichongzhi.pulltorefresh_recyclerview.library.PullToRefreshRecyclerView;
import com.huichongzhi.pulltorefresh_recyclerview.library.WrapRecyclerView;

public class DemoActivity extends AppCompatActivity {

    private PullToRefreshRecyclerView pullToRefreshRecyclerView;

    private WrapRecyclerView recyclerView;

    private View header1;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            pullToRefreshRecyclerView.onRefreshComplete();
            Toast.makeText(DemoActivity.this, "refresh complete!", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        initView();
    }


    private void initView(){
        pullToRefreshRecyclerView = (PullToRefreshRecyclerView)findViewById(R.id.pulltorefresh_recyclerview);
        pullToRefreshRecyclerView.setMode(PullToRefreshBase.Mode.BOTH);
        pullToRefreshRecyclerView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<WrapRecyclerView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<WrapRecyclerView> refreshView) {
                mHandler.sendEmptyMessageDelayed(0, 500);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<WrapRecyclerView> refreshView) {
                mHandler.sendEmptyMessageDelayed(0, 500);
            }
        });
        recyclerView = pullToRefreshRecyclerView.getRefreshableView();
        MyAdapter adapter = new MyAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
                Paint p = new Paint();
                p.setColor(0xffcccccc);
                int size = parent.getChildCount();
                for(int i = 0; i < size; i++){
                    int top = parent.getChildAt(i).getBottom();
                    int right = parent.getChildAt(i).getRight();
                    c.drawRect(0, top, right, top + 4, p);
                }
            }
        });
        recyclerView.setAdapter(adapter);

        header1 = LayoutInflater.from(this).inflate(R.layout.wrap_recycleview_header, null);
        recyclerView.addHeaderView(header1);
    }


    class MyAdapter extends RecyclerView.Adapter<MyHolder>{

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(DemoActivity.this).inflate(R.layout.wrap_recycleview_item, null);
            MyHolder holder = new MyHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            holder.tv.setText("item:" + position);
        }

        @Override
        public int getItemCount() {
            return 10;
        }
    }

    class MyHolder extends RecyclerView.ViewHolder{

        TextView tv;
        public MyHolder(View itemView) {
            super(itemView);
            tv = (TextView)itemView.findViewById(R.id.item_text);
        }
    }
}

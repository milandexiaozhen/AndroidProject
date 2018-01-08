package test.com.adnroidproject;

import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.RangeGridLayoutHelper;
import com.alibaba.android.vlayout.layout.RangeGridLayoutHelper.GridRangeStyle;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;

import java.util.LinkedList;
import java.util.List;

import Adapter.HotAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewActivity extends AppCompatActivity {
    @BindView(R.id.swipe_container)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.goods_list)
    RecyclerView goodRecyclerView;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        ButterKnife.bind(this);
        initView();
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(RecyclerViewActivity.this,"sss",Toast.LENGTH_SHORT).show();
                refreshLayout.setRefreshing(false);
            }
        });


    }

    private  void initView(){

        final VirtualLayoutManager layoutManager=new VirtualLayoutManager(this);
        layoutManager.setRecycleOffset(300);
        goodRecyclerView.setLayoutManager(layoutManager);
        RecyclerView.ItemDecoration itemDecoration = new RecyclerView.ItemDecoration() {
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int position = ((VirtualLayoutManager.LayoutParams) view.getLayoutParams()).getViewPosition();
                outRect.set(4, 4, 4, 4);
            }
        };


        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();

        goodRecyclerView.setRecycledViewPool(viewPool);

        // recyclerView.addItemDecoration(itemDecoration);

        viewPool.setMaxRecycledViews(0, 20);

        final DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);

        goodRecyclerView.setAdapter(delegateAdapter);

        final List<DelegateAdapter.Adapter> adapters = new LinkedList<>();
        //品牌分类
        SingleLayoutHelper classificationTitle = new SingleLayoutHelper();
        classificationTitle.setBgColor(Color.rgb(135, 225, 90));
        classificationTitle.setAspectRatio(5);
        classificationTitle.setMargin(10, 20, 10, 20);
        classificationTitle.setPadding(10, 10, 10, 10);
        adapters.add(new HotAdapter(this, classificationTitle, 1, new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200)));

        //每周特卖
        SingleLayoutHelper weeklyTitle = new SingleLayoutHelper();
        weeklyTitle.setBgColor(Color.rgb(135, 225, 90));
        weeklyTitle.setAspectRatio(5);
        weeklyTitle.setMargin(10, 20, 10, 20);
        weeklyTitle.setPadding(10, 10, 10, 10);
        adapters.add(new HotAdapter(this, weeklyTitle, 1, new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200)));

        LinearLayoutHelper weeklySale = new LinearLayoutHelper();
        weeklySale.setBgColor(Color.RED);
        weeklySale.setAspectRatio(2.0f);
        weeklySale.setMargin(10, 10, 10, 10);
        weeklySale.setDividerHeight(10);

        adapters.add(new HotAdapter(this, weeklySale, 2) {
            @Override
            public void onBindViewHolder(MainViewHolder holder, int position) {
                    VirtualLayoutManager.LayoutParams layoutParams = new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300);
                    layoutParams.mAspectRatio = 5;
                    holder.itemView.setLayoutParams(layoutParams);
            }
        });
        //热门品牌
        SingleLayoutHelper hotTitle = new SingleLayoutHelper();
        hotTitle.setBgColor(Color.rgb(135, 225, 90));
        hotTitle.setAspectRatio(7);
        hotTitle.setMargin(10, 20, 10, 20);
        hotTitle.setPadding(10, 10, 10, 10);
        adapters.add(new HotAdapter(this, hotTitle, 1, new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150)));

        RangeGridLayoutHelper popularBrandHelper = new RangeGridLayoutHelper(1);
        popularBrandHelper.setBgColor(Color.WHITE);
        GridRangeStyle popularStyle = new GridRangeStyle();
        popularStyle.setBgColor(Color.RED);
        popularStyle.setSpanCount(3);
        popularStyle.setMargin(10, 10, 10, 10);
        popularStyle.setHGap(5);
        popularStyle.setVGap(5);

        popularStyle.setAspectRatio(7f);//设置缩放
        VirtualLayoutManager.LayoutParams layoutParams = new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300);
        popularBrandHelper.addRangeStyle(0, 7, popularStyle);
        adapters.add(new HotAdapter(this, popularBrandHelper,6,layoutParams));

        //适用人群
        SingleLayoutHelper applyTitle = new SingleLayoutHelper();
        applyTitle.setBgColor(Color.rgb(135, 225, 90));
        applyTitle.setAspectRatio(7);
        applyTitle.setMargin(10, 20, 10, 20);
        adapters.add(new HotAdapter(this, hotTitle, 1, new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100)));

        RangeGridLayoutHelper applyLayoutHelper = new RangeGridLayoutHelper(1);
        applyLayoutHelper.setBgColor(Color.WHITE);
        GridRangeStyle applyStyle = new GridRangeStyle();
        applyStyle.setBgColor(Color.RED);
        applyStyle.setSpanCount(3);
        applyStyle.setMargin(10, 10, 10, 10);
        applyStyle.setHGap(5);
        applyStyle.setVGap(5);
//        applyStyle.setAspectRatio(7f);//设置缩放
        VirtualLayoutManager.LayoutParams applyParams = new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300);
        applyLayoutHelper.addRangeStyle(0, 7, applyStyle);
        adapters.add(new HotAdapter(this, applyLayoutHelper,6,applyParams));

        //新品上市
        SingleLayoutHelper newTitle = new SingleLayoutHelper();
        newTitle.setBgColor(Color.rgb(135, 225, 90));
        newTitle.setAspectRatio(7);
        newTitle.setMargin(10, 20, 10, 20);
        adapters.add(new HotAdapter(this, newTitle, 1, new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100)));

        RangeGridLayoutHelper newGoodsHelper = new RangeGridLayoutHelper(1);
        newGoodsHelper.setBgColor(Color.WHITE);
        GridRangeStyle newGoodsStyle = new GridRangeStyle();
        newGoodsStyle.setBgColor(Color.RED);
        newGoodsStyle.setSpanCount(2);
        newGoodsStyle.setMargin(10, 10, 10, 10);
        newGoodsStyle.setHGap(5);
        newGoodsStyle.setVGap(5);
        newGoodsStyle.setAspectRatio(1.5f);//设置缩放
        VirtualLayoutManager.LayoutParams newParams = new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500);
        newGoodsHelper.addRangeStyle(0, 5, newGoodsStyle);
        adapters.add(new HotAdapter(this, newGoodsHelper,4,newParams));

        //小编推荐
        SingleLayoutHelper recommendTitle = new SingleLayoutHelper();
        recommendTitle.setBgColor(Color.rgb(135, 225, 90));
        recommendTitle.setAspectRatio(7);
        recommendTitle.setMargin(10, 20, 10, 20);
        adapters.add(new HotAdapter(this, recommendTitle, 1, new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100)));

        RangeGridLayoutHelper recommendHelper = new RangeGridLayoutHelper(1);
        recommendHelper.setBgColor(Color.WHITE);
        recommendHelper.setMargin(10, 10, 10, 10);
        GridRangeStyle recommendStyle = new GridRangeStyle();
        recommendStyle.setBgColor(Color.RED);
        recommendStyle.setSpanCount(2);
        recommendStyle.setHGap(5);
        recommendStyle.setVGap(5);
        recommendStyle.setAspectRatio(1.5f);//设置缩放
        VirtualLayoutManager.LayoutParams recommendParams = new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500);
        recommendHelper.addRangeStyle(0, 9, recommendStyle);
        adapters.add(new HotAdapter(this, recommendHelper,8,recommendParams));
        delegateAdapter.setAdapters(adapters);
    }


}

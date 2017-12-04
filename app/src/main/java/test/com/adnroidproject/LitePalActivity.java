package test.com.adnroidproject;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import org.litepal.crud.DataSupport;

import java.util.List;

import Adapter.LitePalDataAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import litepal.Dest;

public class LitePalActivity extends BaseActivity {

    @BindView(R.id.btn_Add)
    Button btnAdd;
    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.btn_delete)
    Button btnDelete;
    @BindView(R.id.btn_change)
    Button btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lite_pal);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_Add, R.id.btn_search, R.id.btn_delete, R.id.btn_change})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_Add:
                for (int i = 0; i < 4; i++) {
                    Dest dest = new Dest();
                    dest.setId(i);
                    dest.setName("name" + i);
                    dest.setPhone("phone" + i);
                    dest.save();
                }
                break;
            case R.id.btn_search:
//                查询DEST表中id为1的这条记录，使用LitePal就可以这样写：
//                DEST mDest = DataSupport.find(DEST.class, 1);
//                想要获取DEST表中的第一条数据，只需要这样写：
//                DEST firstDest = DataSupport.findFirst(DEST.class);
//                想要获取News表中的最后一条数据，只需要这样写：
//                DEST lastDest = DataSupport.findLast(DEST.class);
//                想把DEST表中id为1、3、5、7的数据都查出来，只需要这样写：
//                List<DEST> mDestList = DataSupport.findAll(DEST.class, 1, 3, 5, 7);
//                查询所有数据，只需要这样写：
//                List<DEST> mDestList = DataSupport.findAll(DEST.class);
//                想查询DEST表中所有父类id为"1"的数据，就可以这样写：
//                List<DEST> mDestList = DataSupport.where("parentId = ?", "1").find(DEST.class);
//                不需要那么多的数据，而是只要name,phone;
//                List< DEST> mDestList = DataSupport.select("name", "Phone").where("parentId = ?", "1").find(DEST.class);
//                也许你还要数据按照添加的时间倒序排列，那么可以这样：
//                List<DEST> mDestList = DataSupport.select("cnName", "enName").where("parentId = ?", "1").order("updateTime desc").find(DEST.class);
//                数据太多了，其实你只要前10行就行了，那么可以这样：
//                List<DEST> mDestList = DataSupport.select("cnName", "enName").where("parentId = ?", "1").order("updateTime desc").limit(10).find(DEST.class);
//                果我们想进行分页展示，那么翻页了，怎么办？可以添加一个偏移量就好了，这样：
//                List<DEST> mDestList = DataSupport.select("cnName", "enName").where("parentId = ?", "1").order("updateTime desc").limit(10).offset(10).find(DEST.class);
                upData();
                break;
            case R.id.btn_delete:
//                比如说我们想删除DEST表中id为2的记录，就可以这样写：
//                DataSupport.delete(News.class, 2);
//                想把DEST表中destId为“1”的所有数据删除，就可以这样写：
//                DataSupport.deleteAll(DEST.class, "destId = ? ", "1");
//                如果我们想把DEST表中所有的数据全部删除掉，就可以这样写：
                DataSupport.deleteAll(Dest.class);
                break;
            case R.id.btn_change:
//                如果想把DEST表中id为4的destId改为 "1"，可以这样写：
//                ContentValues values = new ContentValues();
//                values.put("destId", "1");
//                DataSupport.update(DEST.class, values, 4);
////或者用下面这种方法
//                DEST updateNews = new DEST();
//                updateNews.setDestId("1");
//                updateNews.update(4);
//                如果想把DEST表中所有destId为"1"的改为"2"可以这样写：
//                ContentValues values = new ContentValues();
//                values.put("destId", "2");
//                DataSupport.updateAll(DEST.class, values, "destId = ?", "1");
////或者用下面这种方法
//                DEST updateNews = new DEST();
//                updateNews.setdestId("2");
//                updateNews.updateAll("destId = ?", "1");
                Dest updateNews = new Dest();
                updateNews.setName("aaaaaaaaaaaaaaaaaa");
                updateNews.updateAll("phone = ?", "phone1");
                break;
        }
    }

    public void upData(){

        List<Dest> list = DataSupport.findAll(Dest.class);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LitePalDataAdapter(this, list));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}

package Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import litepal.Dest;
import test.com.adnroidproject.R;

/**
 * Created by vtg on 2017/6/2.
 */
public class LitePalDataAdapter extends RecyclerView.Adapter<LitePalDataAdapter.LitePalViewHolder> {

    private Context mContext;
    public List<Dest> mList = new ArrayList<Dest>();
    private final LayoutInflater mLayoutInflater;

    public LitePalDataAdapter(Context context, List<Dest> mList) {
        this.mContext = context;
        this.mList = mList;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public LitePalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LitePalViewHolder(mLayoutInflater.inflate(R.layout.item_litepal, parent, false));
    }

    public void onBindViewHolder(LitePalViewHolder holder, int position) {
        holder.textView.setText(mList.get(position).getName());
       holder.getList(mList);
        holder.getAdapter(this);
    }

    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public static class LitePalViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_view)
        TextView textView;
        public List<Dest> mList = new ArrayList<Dest>();
        private LitePalDataAdapter mAdapter;
        LitePalViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
        public void  getList(List<Dest> mList){
            this.mList=mList;
        }
        public  void getAdapter (LitePalDataAdapter adapter){
            this.mAdapter=adapter;
        }
        @OnClick(R.id.cv_item)
        void onItemClick() {
            Log.d("NormalTextViewHolder", "onClick--> position = " + getAdapterPosition());
        }
        @OnClick(R.id.text_view)
        void tvClick(){
            Log.e("sss", "s" + mList.get(getAdapterPosition()).getName());

        }
        @OnClick(R.id.btn_delete)
        void  delete(){
            DataSupport.deleteAll(Dest.class);
            mList.clear();
            mAdapter.notifyDataSetChanged();
        }
    }
}

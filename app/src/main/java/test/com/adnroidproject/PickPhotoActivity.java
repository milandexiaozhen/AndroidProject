package test.com.adnroidproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.CheckBox;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PickPhotoActivity extends AppCompatActivity {
    @BindView(R.id.photoList)
    RecyclerView rcPhotoView;
    @BindView(R.id.select_checked)
    CheckBox selcetCheckBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_photo);
        ButterKnife.bind(this);
    }
}

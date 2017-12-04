package test.com.adnroidproject;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class VitamioActivity extends Activity implements MediaPlayer.OnPreparedListener {

    @BindView(R.id.vitamio)
    VideoView vitamio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitamio);
        ButterKnife.bind(this);
        Vitamio.initialize(this);
        vitamio.setVideoURI(Uri.parse("http://devimages.apple.com/iphone/samples/bipbop/bipbopall.m3u8"));
        vitamio.setMediaController(new MediaController(this));
        vitamio.setOnPreparedListener(this);

    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        vitamio.start();
    }
}

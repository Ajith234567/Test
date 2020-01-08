package com.exoplayer.recyclerviewvideoplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.VideoView;

import com.danikula.videocache.CacheListener;
import com.danikula.videocache.HttpProxyCacheServer;

import java.io.File;

public class Main2Activity extends AppCompatActivity {

    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        videoView=findViewById(R.id.vid);
        final HttpProxyCacheServer proxy = getProxy();
        String proxyUrl = proxy.getProxyUrl("https://cdn.trell.co/h_640,w_640/user-videos/videos/orig/8ijoZpmyyWR6Kt1pOESjSZSJ4vES0s73.mp4");
        videoView.setVideoPath(proxyUrl);
        /*videoView.setMediaController(new UniversalMediaController(this));
        videoView.setFullscreen(true);
        videoView.setFitXY(true);*/
        videoView.start();
        videoView.requestFocus();
        CacheListener cacheListener=new CacheListener() {
            @Override
            public void onCacheAvailable(File cacheFile, String url, int percentsAvailable) {
                Log.d("Main2Activity", "onCacheAvailable: "+cacheFile.getAbsolutePath()
                +" "+percentsAvailable);

            }
        };
        proxy.registerCacheListener(cacheListener,"https://cdn.trell.co/h_640,w_640/user-videos/videos/orig/P7sls2VpRAJW8Vbz6rnUlU6WvLTZwEhp.mp4"
                );

    }

private static HttpProxyCacheServer httpProxyCacheServer;
    private HttpProxyCacheServer getProxy() {
        if(httpProxyCacheServer==null){
            httpProxyCacheServer=new HttpProxyCacheServer(this);
        }
        return  httpProxyCacheServer;
        // should return single instance of HttpProxyCacheServer shared for whole app.
    }
    private HttpProxyCacheServer newProxy() {
        return new HttpProxyCacheServer.Builder(this)
                .maxCacheSize(1024 * 1024 * 1024)       // 1 Gb for cache
                .build();
    }
}

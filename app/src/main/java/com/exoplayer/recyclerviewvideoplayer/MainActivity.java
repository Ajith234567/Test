package com.exoplayer.recyclerviewvideoplayer;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearSnapHelper;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.exoplayer.recyclerviewvideoplayer.ViewModel.ExoplayerViewmodel;
import com.exoplayer.recyclerviewvideoplayer.models.MediaObject;
import com.exoplayer.recyclerviewvideoplayer.util.Resources;
import com.exoplayer.recyclerviewvideoplayer.util.VerticalSpacingItemDecorator;
import com.danikula.videocache.HttpProxyCacheServer;


import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private VideoPlayerRecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view);

        initRecyclerView();


      /*  ExoplayerViewmodel viewmodel;
        viewmodel.mediaUrl.observe(this, new Observer<MediaObject>() {
            @Override
            public void onChanged(@Nullable MediaObject mediaObject) {
                MediaObject newMediaUrl = mediaObject;
            }
        });*/
    }



    private void initRecyclerView(){
        /*LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);*/
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        mRecyclerView.addItemDecoration(itemDecorator);
        mRecyclerView.setLayoutManager(new SpeedyLinearLayoutManager(this, SpeedyLinearLayoutManager.VERTICAL, false));

        ArrayList<MediaObject> mediaObjects = new ArrayList<MediaObject>(Arrays.asList(Resources.MEDIA_OBJECTS));
        mRecyclerView.setMediaObjects(mediaObjects);
        LinearSnapHelper linearSnapHelper=new SnapHelperOneByOne();
        linearSnapHelper.attachToRecyclerView(mRecyclerView);

        VideoPlayerRecyclerAdapter adapter = new VideoPlayerRecyclerAdapter(mediaObjects, initGlide());
        mRecyclerView.setAdapter(adapter);

    }


    private RequestManager initGlide(){
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.white_background)
                .error(R.drawable.white_background);

        return Glide.with(this)
                .setDefaultRequestOptions(options);
    }


    @Override
    protected void onDestroy() {
        if(mRecyclerView!=null)
            mRecyclerView.releasePlayer();
        super.onDestroy();
    }
    private HttpProxyCacheServer proxy;

}


















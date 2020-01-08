package com.exoplayer.recyclerviewvideoplayer.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.exoplayer.recyclerviewvideoplayer.models.MediaObject;

public class ExoplayerViewmodel extends ViewModel {

    private MutableLiveData<MediaObject> _mediaurl;
    public LiveData<MediaObject> mediaUrl = _mediaurl;


    public void setMediaUrl (MediaObject mediaUrl) {
        _mediaurl.setValue(mediaUrl);
    }
}

package com.exoplayer.recyclerviewvideoplayer;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SnapHelperOneByOne extends LinearSnapHelper {
    @Override
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutmanager, int velocityx, int velocityy) {
        if (!(layoutmanager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
            return RecyclerView.NO_POSITION;
        }
        final View currentview = findSnapView(layoutmanager);
        if (currentview == null) {
            return RecyclerView.NO_POSITION;
        }
        LinearLayoutManager mylayoutmanager = (LinearLayoutManager) layoutmanager;
        int position1 = mylayoutmanager.findFirstVisibleItemPosition();
        int position2 = mylayoutmanager.findLastVisibleItemPosition();
        int currentposition = layoutmanager.getPosition(currentview);
        if (velocityy > 400) {
            currentposition = position2;
        } else if (velocityy < 400) {
            currentposition = position1;
        }
        if(currentposition==RecyclerView.NO_POSITION){
            return RecyclerView.NO_POSITION;
        }
        return currentposition;
    }
}

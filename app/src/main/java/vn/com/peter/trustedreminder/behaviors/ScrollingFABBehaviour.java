package vn.com.peter.trustedreminder.behaviors;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

import vn.com.peter.trustedreminder.utils.Utils;


/**
 * Created by Peter on 10/6/2015.
 */
public class ScrollingFABBehaviour extends CoordinatorLayout.Behavior<FloatingActionButton>{
    private int toolbarHeight;

    public  ScrollingFABBehaviour(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        this.toolbarHeight = Utils.getToolbarHeight(context);
    }


    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        return (dependency instanceof Snackbar.SnackbarLayout) || (dependency instanceof Toolbar);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, final FloatingActionButton child, View dependency) {
        if(dependency instanceof Snackbar.SnackbarLayout){
            float finalVal = (float)parent.getHeight() - dependency.getY();
            child.setTranslationY(-finalVal);
        }

        if(dependency instanceof Toolbar){
            CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams)child.getLayoutParams();
            int fabBottomMargin = lp.bottomMargin;
            int distanceToScroll = child.getHeight() + fabBottomMargin;
            float finalVal = dependency.getY()/(float)toolbarHeight;
            float distFinal = -distanceToScroll * finalVal;
            child.setTranslationY(distFinal);
        }

        return true;
    }
}
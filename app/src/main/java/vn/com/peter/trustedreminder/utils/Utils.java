package vn.com.peter.trustedreminder.utils;

import android.content.Context;
import android.content.res.TypedArray;

import vn.com.peter.trustedreminder.R;

/**
 * Created by Peter on 10/6/2015.
 */
public class Utils {
    public static int getToolbarHeight(Context context) {
        final TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(
                new int[]{R.attr.actionBarSize});
        int toolbarHeight = (int) styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();

        return toolbarHeight;
    }
}

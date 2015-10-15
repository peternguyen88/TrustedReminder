package vn.com.peter.trustedreminder.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import vn.com.peter.trustedreminder.BR;

/**
 * Created by evan on 6/14/15.
 */
public class MainTodoItemViewModel extends BaseObservable {
    public final boolean checkable;
    @Bindable
    private int index;
    @Bindable
    private boolean checked;

    public MainTodoItemViewModel(int index, boolean checkable) {
        this.index = index;
        this.checkable = checkable;
    }

    public int getIndex() {
        return index;
    }

    public boolean checked() {
        return checked;
    }
    
    public boolean onToggleChecked(View v) {
        if (!checkable) {
            return false;
        }
        checked = !checked;
        notifyPropertyChanged(BR.checked);
        return true;
    }
}

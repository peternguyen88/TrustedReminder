package vn.com.peter.trustedreminder.viewmodels;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

/**
 * Created by Peter on 10/6/2015.
 */
public class MainViewModel {
    public final ObservableList<MainTodoItemViewModel> items = new ObservableArrayList<>();
}

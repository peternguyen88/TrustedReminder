package vn.com.peter.trustedreminder.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

import vn.com.peter.trustedreminder.R;
import vn.com.peter.trustedreminder.databinding.ActivityMainBinding;
import vn.com.peter.trustedreminder.viewmodels.MainViewModel;

/**
 * Created by Peter on 10/6/2015.
 */
@EActivity
public class MainActivity extends BaseActivity{
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMainVM(new MainViewModel());
    }

    @Click(R.id.add_todo_item_fab)
    public void addTodoItem(){
        NewTaskActivity_.intent(this).start();
    }
}

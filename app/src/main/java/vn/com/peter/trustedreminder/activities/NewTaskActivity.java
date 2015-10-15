package vn.com.peter.trustedreminder.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import org.androidannotations.annotations.EActivity;

import vn.com.peter.trustedreminder.R;
import vn.com.peter.trustedreminder.databinding.ActivityNewTaskBinding;
import vn.com.peter.trustedreminder.handlers.NewTaskHandler;
import vn.com.peter.trustedreminder.viewmodels.NewTaskViewModel;

@EActivity
public class NewTaskActivity extends BaseActivity {
    private ActivityNewTaskBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_new_task);
        binding.setNewTaskVM(new NewTaskViewModel());
        binding.setNewTaskHandler(new NewTaskHandler(this, binding.getNewTaskVM()));
    }
}

package vn.com.peter.trustedreminder.handlers;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;

import com.rey.material.app.DatePickerDialog;
import com.rey.material.app.DialogFragment;
import com.rey.material.app.TimePickerDialog;

import java.util.Calendar;
import java.util.Date;

import vn.com.peter.trustedreminder.R;
import vn.com.peter.trustedreminder.viewmodels.NewTaskViewModel;

/**
 * Created by Peter on 10/9/2015.
 */
public class NewTaskHandler {
    private AppCompatActivity mActivity;
    private NewTaskViewModel mModel;

    public NewTaskHandler(AppCompatActivity activity, NewTaskViewModel model) {
        this.mActivity = activity;
        this.mModel = model;
    }

    public void onClickChooseDate(View view) {
        DatePickerDialog.Builder builder = new DatePickerDialog.Builder(R.style.Material_App_Dialog_DatePicker_Light) {
            @Override
            public void onPositiveActionClicked(DialogFragment fragment) {
                DatePickerDialog dialog = (DatePickerDialog) fragment.getDialog();
                fragment.dismiss();
            }

            @Override
            public void onNegativeActionClicked(DialogFragment fragment) {
                fragment.dismiss();
            }
        };
        builder.date(new Date().getTime()).positiveAction("OK").negativeAction("CANCEL");
        DialogFragment fragment = DialogFragment.newInstance(builder);
        fragment.show(mActivity.getSupportFragmentManager(), "datePicker");

    }

    public void onClickChooseTime(View view) {
        Calendar reminderCalendar = Calendar.getInstance();
        reminderCalendar.setTime(new Date());
        TimePickerDialog.Builder builder = new TimePickerDialog.Builder(R.style.Material_App_Dialog_TimePicker_Light, 6, 0) {
            @Override
            public void onPositiveActionClicked(DialogFragment fragment) {
                fragment.dismiss();
            }

            @Override
            public void onNegativeActionClicked(DialogFragment fragment) {
                fragment.dismiss();
            }
        };

        builder.hour(reminderCalendar.get(Calendar.HOUR_OF_DAY)).minute(reminderCalendar.get(Calendar.MINUTE))
                .positiveAction("OK").negativeAction("CANCEL");
        DialogFragment fragment = DialogFragment.newInstance(builder);
        fragment.show(mActivity.getSupportFragmentManager(), "timePicker");
    }

    public CompoundButton.OnCheckedChangeListener reminderEnableListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            mModel.reminderEnable.set(isChecked);
        }
    };
}

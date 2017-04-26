package be.bardack.workout.activities.listeners;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import be.bardack.workout.activities.ExecuteWorkoutActivity;
import be.bardack.workout.model.Workout;

/**
 * Created by kokotchy on 4/26/17.
 */

public class StartWorkoutClickListener implements View.OnClickListener {

    private Context mContext;
    private Workout workout;

    public StartWorkoutClickListener(Context mContext, Workout workout) {
        this.mContext = mContext;
        this.workout = workout;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(mContext, ExecuteWorkoutActivity.class);
        intent.putExtra("workout", workout);
        mContext.startActivity(intent);
    }
}

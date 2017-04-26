package be.bardack.workout.activities;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import be.bardack.workout.R;
import be.bardack.workout.model.ExerciseStep;
import be.bardack.workout.model.Workout;
import be.bardack.workout.model.WorkoutExercise;

/**
 * Created by kokotchy on 4/26/17.
 */

public class ExecuteWorkoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_execute_workout);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.debug_layout);
        Workout workout = getIntent().getParcelableExtra("workout");
        addTextView(linearLayout, workout.getTitle());
        for (WorkoutExercise exercise : workout.getExercises()) {
            addTextView(linearLayout, "Exercise: " + exercise.getTitle());
            for (ExerciseStep step : exercise.getSteps()) {
                addTextView(linearLayout, "Step: " + step.getName());
            }
        }
    }

    private void addTextView(LinearLayout layout, String text) {
        TextView textView = new TextView(this);
        textView.setText(text);
        layout.addView(textView);
    }
}

package be.bardack.workout.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kokotchy on 4/26/17.
 */

public class WorkoutExercise {
    private String title;
    private Workout workout;
    private List<ExerciseStep> steps;

    public WorkoutExercise(String title, Workout workout) {
        this.title = title;
        this.workout = workout;
        this.steps = new ArrayList<>();
    }

    public void addStep(ExerciseStep step) {
        steps.add(step);
    }
}

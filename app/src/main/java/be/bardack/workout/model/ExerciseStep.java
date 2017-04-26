package be.bardack.workout.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.concurrent.ExecutionException;

/**
 * Created by kokotchy on 4/26/17.
 */

public class ExerciseStep {
    private String name;
    private WorkoutExercise exercise;

    public ExerciseStep(String name, WorkoutExercise exercise) {
        this.name = name;
        this.exercise = exercise;
    }

    public String getName() {
        return name;
    }

    public WorkoutExercise getExercise() {
        return exercise;
    }
}

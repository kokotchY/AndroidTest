package be.bardack.workout.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kokotchy on 4/26/17.
 */

public class Workout {
    private String title;
    private List<WorkoutExercise> exercises;


    public Workout(String title) {
        this.title = title;
        this.exercises = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void addExercise(WorkoutExercise exercise) {
        this.exercises.add(exercise);
    }

    public List<WorkoutExercise> getExercises() {
        return exercises;
    }
}

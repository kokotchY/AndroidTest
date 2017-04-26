package be.bardack.workout.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.concurrent.ExecutionException;

/**
 * Created by kokotchy on 4/26/17.
 */

public class ExerciseStep implements Parcelable {
    private String name;
    private WorkoutExercise workoutExercise;
    private State state;

    public ExerciseStep(String name, WorkoutExercise exercise) {
        this.name = name;
        this.workoutExercise = exercise;
        state = State.WAITING;
    }

    public ExerciseStep(Parcel in) {
        name = in.readString();
        state = State.valueOf(in.readString());
    }

    public ExerciseStep(String name, WorkoutExercise exercise, State state) {
        this(name, exercise);
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }

    public WorkoutExercise getWorkoutExercise() {
        return workoutExercise;
    }

    public void setWorkoutExercise(WorkoutExercise workoutExercise) {
        this.workoutExercise = workoutExercise;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(state.name());
    }

    public static final Creator<ExerciseStep> CREATOR = new Creator<ExerciseStep>() {
        @Override
        public ExerciseStep createFromParcel(Parcel parcel) {
            return new ExerciseStep(parcel);
        }

        @Override
        public ExerciseStep[] newArray(int size) {
            return new ExerciseStep[size];
        }
    };
}

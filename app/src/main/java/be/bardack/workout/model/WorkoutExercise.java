package be.bardack.workout.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kokotchy on 4/26/17.
 */

public class WorkoutExercise implements Parcelable {
    private String title;
    private Workout workout;
    private List<ExerciseStep> steps;

    public WorkoutExercise(String title, Workout workout) {
        this.title = title;
        this.workout = workout;
        this.steps = new ArrayList<>();
    }

    public WorkoutExercise(Parcel in) {
        title = in.readString();
        steps = new ArrayList<>();
        int nbSteps = in.readInt();
        for (int i = 0; i < nbSteps; i++) {
            ExerciseStep step = in.readParcelable(ExerciseStep.class.getClassLoader());
            step.setWorkoutExercise(this);
            steps.add(step);
        }
    }

    public void addStep(ExerciseStep step) {
        steps.add(step);
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public String getTitle() {
        return title;
    }

    public List<ExerciseStep> getSteps() {
        return steps;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(title);
        parcel.writeInt(steps.size());
        for (ExerciseStep step : steps) {
            parcel.writeParcelable(step, flags);
        }
    }

    public static final Creator<WorkoutExercise> CREATOR = new Creator<WorkoutExercise>() {
        @Override
        public WorkoutExercise createFromParcel(Parcel parcel) {
            return new WorkoutExercise(parcel);
        }

        @Override
        public WorkoutExercise[] newArray(int size) {
            return new WorkoutExercise[size];
        }
    };
}

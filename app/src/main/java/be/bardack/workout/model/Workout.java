package be.bardack.workout.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kokotchy on 4/26/17.
 */

public class Workout implements Parcelable {
    private String title;
    private List<WorkoutExercise> exercises;

    public Workout(String title) {
        this.title = title;
        this.exercises = new ArrayList<>();
    }

    public Workout(Parcel in) {
        title = in.readString();
        int nbExercices = in.readInt();
        exercises = new ArrayList<>();
        for (int i = 0; i < nbExercices; i++) {
            WorkoutExercise ex = in.readParcelable(WorkoutExercise.class.getClassLoader());
            ex.setWorkout(this);
            exercises.add(ex);
        }
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(title);
        parcel.writeInt(exercises.size());
        for (WorkoutExercise exercise : exercises) {
            parcel.writeParcelable(exercise, flags);
        }
    }

    public static final Parcelable.Creator<Workout> CREATOR = new Creator<Workout>() {
        @Override
        public Workout createFromParcel(Parcel parcel) {
            return new Workout(parcel);
        }

        @Override
        public Workout[] newArray(int size) {
            return new Workout[size];
        }
    };
}

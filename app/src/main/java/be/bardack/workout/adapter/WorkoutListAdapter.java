package be.bardack.workout.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import be.bardack.workout.R;
import be.bardack.workout.activities.listeners.StartWorkoutClickListener;
import be.bardack.workout.model.Workout;

/**
 * Created by kokotchy on 4/26/17.
 */

public class WorkoutListAdapter implements ListAdapter {

    private List<DataSetObserver> observers = new ArrayList<>();
    private Context mContext;
    private List<Workout> items = new ArrayList<>();

    public WorkoutListAdapter(Context context, List<Workout> items) {
        this.mContext = context;
        this.items = items;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int i) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.observers.add(dataSetObserver);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.observers.remove(dataSetObserver);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.workout_item, null);
        }
        TextView widgetWorkoutName = (TextView) view.findViewById(R.id.workout_name);
        final Workout workout = (Workout) getItem(i);
        widgetWorkoutName.setText(String.format("%s (# exercices = %d)", workout.getTitle(), workout.getExercises().size()));
        ImageButton playButton = (ImageButton) view.findViewById(R.id.play_workout);
        playButton.setOnClickListener(new StartWorkoutClickListener(mContext, workout));
        view.findViewById(R.id.edit_workout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Edit "+ workout.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public int getItemViewType(int i) {
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return items.size() == 0;
    }

    public void addElement(Workout workout) {
        items.add(workout);
        for (DataSetObserver observer : observers) {
            observer.onChanged();
        }
    }
}

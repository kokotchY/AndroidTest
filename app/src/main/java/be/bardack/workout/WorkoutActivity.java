package be.bardack.workout;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import be.bardack.workout.activities.ExampleTabbed;
import be.bardack.workout.activities.ExampleTabbed2;
import be.bardack.workout.adapter.WorkoutListAdapter;
import be.bardack.workout.model.ExerciseStep;
import be.bardack.workout.model.State;
import be.bardack.workout.model.Workout;
import be.bardack.workout.model.WorkoutExercise;

public class WorkoutActivity extends AppCompatActivity {

    private WorkoutListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                mAdapter.addElement(new Workout("Empty workout"));
            }
        });

        ListView workoutList = (ListView) findViewById(R.id.workoutList);

        workoutList.setClickable(true);
        List<Workout> workouts = getFakeList();
        mAdapter = new WorkoutListAdapter(this, workouts);
        workoutList.setAdapter(mAdapter);
    }

    private List<Workout> getFakeList() {
        List<Workout> workouts = new ArrayList<>();

        Workout workout1 = new Workout("Workout 1");
        WorkoutExercise ex1 = new WorkoutExercise("Ex 1", workout1);
        ex1.addStep(new ExerciseStep("Step 1", ex1, State.FINISHED));
        ex1.addStep(new ExerciseStep("Step 2", ex1));
        workout1.addExercise(ex1);
        workouts.add(workout1);

        Workout workout2 = new Workout("Workout 2");
        ex1 = new WorkoutExercise("Ex 1", workout1);
        ex1.addStep(new ExerciseStep("Step 1", ex1));
        ex1.addStep(new ExerciseStep("Step 2", ex1));
        ex1.addStep(new ExerciseStep("Step 3", ex1));
        workout2.addExercise(ex1);
        WorkoutExercise ex2 = new WorkoutExercise("Ex 2", workout2);
        ex2.addStep(new ExerciseStep("Step 1", ex2));
        ex2.addStep(new ExerciseStep("Step 2", ex2));
        workout2.addExercise(ex2);
        workouts.add(workout2);

        return workouts;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_workout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_step) {
            Intent intent = new Intent();
            intent.setClass(this, ExampleTabbed.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_tabbed) {
            Intent intent = new Intent();
            intent.setClass(this, ExampleTabbed2.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}

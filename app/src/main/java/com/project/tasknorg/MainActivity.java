package com.project.tasknorg;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.project.tasknorg.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

// Imports for the task list
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    // NEW: Task list to store tasks
    private List<Task> tasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });
        // NEW: Example usage of add, edit, and delete task functions
        addTask("New Task", "This is a new task description.");
        editTask(1L, "Updated Task", "Updated description.");
        deleteTask(1L);
    }

    // NEW: Function to add a new task
    private void addTask(String title, String description) {
        Long id = (long) (tasks.size() + 1);  // Simple ID generation
        Task newTask = new Task(id, title, description);
        tasks.add(newTask);
        System.out.println("Task added: " + newTask.getTitle());
    }

    // NEW: Function to edit an existing task by ID
    private void editTask(Long id, String newTitle, String newDescription) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setTitle(newTitle);
                task.setDescription(newDescription);
                System.out.println("Task edited: " + task.getTitle());
                return;
            }
        }
        System.out.println("Task not found");
    }

    // NEW: Function to delete a task by ID
    private void deleteTask(Long id) {
        tasks.removeIf(task -> task.getId().equals(id));
        System.out.println("Task with id " + id + " deleted");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
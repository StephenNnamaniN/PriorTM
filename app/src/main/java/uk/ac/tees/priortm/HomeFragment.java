package uk.ac.tees.priortm;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import uk.ac.tees.priortm.Adapter.ToDoAdapter;
import uk.ac.tees.priortm.Model.ToDoModel;

public class HomeFragment extends Fragment{
    private RecyclerView taskRecyclerView;
    private ToDoAdapter taskAdapter;
    private List<ToDoModel> taskList;


    public HomeFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);

//        taskRecyclerView = view.findViewById(R.id.tasksRecyclerView);
//        taskRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        taskRecyclerView.setHasFixedSize(true);
//        taskAdapter = new ToDoAdapter(HomeFragment.this);
//        taskRecyclerView.setAdapter(taskAdapter);
//
//        taskList = new ArrayList<>();
//
//        ToDoModel task = new ToDoModel();
//        task.setTask("This is a test Task");
//        task.setStatus(0);
//        task.setId(1);
//
//        taskList.add(task);
//        taskList.add(task);
//        taskList.add(task);
//        taskList.add(task);
//        taskList.add(task);
//
//        taskAdapter.setTasks(taskList);
//
//        return view;


    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        dataInitialize();
//
//        taskRecyclerView = view.findViewById(R.id.tasksRecyclerView);
//        taskRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        taskRecyclerView.setHasFixedSize(true);
//        taskAdapter = new ToDoAdapter(HomeFragment.this);
//        taskRecyclerView.setAdapter(taskAdapter);
//    }
//
//    private void dataInitialize() {
//        taskList = new ArrayList<>();
//
//        ToDoModel task = new ToDoModel();
//        task.setTask("This is a test Task");
//        task.setStatus(0);
//        task.setId(1);
//
//        taskList.add(task);
//        taskList.add(task);
//        taskList.add(task);
//        taskList.add(task);
//        taskList.add(task);
//
//        taskAdapter.setTasks(taskList);
//    }
}
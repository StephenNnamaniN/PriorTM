package uk.ac.tees.priortm;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import uk.ac.tees.priortm.Adapter.ToDoAdapter;
import uk.ac.tees.priortm.Model.ToDoModel;
import uk.ac.tees.priortm.utils.DataBasehandler;

public class HomeFragment extends Fragment implements DialogCloseListener{
    private RecyclerView taskRecyclerView;
    private ToDoAdapter taskAdapter;
    private List<ToDoModel> taskList;
    private DataBasehandler db;
    private FloatingActionButton fab;


    public HomeFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        db = new DataBasehandler(getContext());
        db.openDatabase();

        taskList = new ArrayList<>();

        taskRecyclerView = view.findViewById(R.id.tasksRecyclerView);
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        taskRecyclerView.setHasFixedSize(true);
        taskAdapter = new ToDoAdapter(db,HomeFragment.this);
        taskRecyclerView.setAdapter(taskAdapter);

        fab = view.findViewById(R.id.fab);

        ItemTouchHelper itemTouchHelper = new
                ItemTouchHelper(new RecyclerItemTouchHelper(taskAdapter));
        itemTouchHelper.attachToRecyclerView(taskRecyclerView);

        taskList = db.getAllTasks();
        Collections.reverse(taskList);

        taskAdapter.setTasks(taskList);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddNewTask.newInstance().show(getActivity().getSupportFragmentManager(), AddNewTask.TAG);
            }
        });

        return view;
    }

//    @Override
//    public void handleDialogCLose(DialogInterface dialog){
//        taskList = db.getAllTasks();
//        Collections.reverse(taskList);
//        taskAdapter.setTasks(taskList);
//        taskAdapter.notifyDataSetChanged();
//    }

    @Override
    public void handleDialogClose(DialogInterface dialog) {
        taskList = db.getAllTasks();
        Collections.reverse(taskList);
        taskAdapter.setTasks(taskList);
        taskAdapter.notifyDataSetChanged();
    }
}
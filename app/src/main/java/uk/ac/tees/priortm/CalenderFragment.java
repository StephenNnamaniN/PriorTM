package uk.ac.tees.priortm;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import uk.ac.tees.priortm.Model.ToDoModel;


public class CalenderFragment extends Fragment implements AddNewTask.NewTaskListener {
    private FloatingActionButton fab;



    public CalenderFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calender, container, false);

        CalendarView cv = view.findViewById(R.id.calendarView);
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                AddNewTask ant = AddNewTask.newInstance();
                ant.setNewTaskListener(CalenderFragment.this);
                ant.show(getActivity().getSupportFragmentManager(), AddNewTask.TAG);
            }
        });

        fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddNewTask ant = AddNewTask.newInstance();
                ant.setNewTaskListener(CalenderFragment.this);
                ant.show(getActivity().getSupportFragmentManager(), AddNewTask.TAG);

            }
        });
        return view;
    }

    @Override
    public void onNewTask(ToDoModel todoModel) {

    }
}
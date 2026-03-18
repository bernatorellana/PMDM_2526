package com.example.a20260318_room_testing.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.a20260318_room_testing.db.AppDatabase;
import com.example.a20260318_room_testing.db.EmployeeRepository;
import com.example.a20260318_room_testing.db.model.Employee;

import java.util.List;

public class EmployeeViewModel extends AndroidViewModel {

    private final EmployeeRepository repository;
    private final LiveData<List<Employee>> employees;

    private final MutableLiveData<UiState<Void>> insertState = new MutableLiveData<>();

    public EmployeeViewModel(Application application) {
        super(application);

        AppDatabase db = AppDatabase.getInstance(application);
        repository = new EmployeeRepository(db.employeeDao());

        employees = repository.getAllEmployees(); // LiveData from Room
    }

    public LiveData<List<Employee>> getEmployees() {
        return employees;
    }

    public LiveData<UiState<Void>> getInsertState() {
        return insertState;
    }

    public void insert(Employee employee) {

        // repository posts updates directly to insertState
        repository.insert(employee, insertState);
    }
}

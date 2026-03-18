package com.example.a20260318_room_testing.db;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.a20260318_room_testing.db.model.Employee;
import com.example.a20260318_room_testing.viewmodel.UiState;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmployeeRepository {

    private final EmployeeDao dao;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public EmployeeRepository(EmployeeDao dao) {

        this.dao = dao;
    }

    public void insert(Employee employee, MutableLiveData<UiState<Void>> insertState) {
        insertState.postValue(UiState.loading());

        executor.execute(() -> {
            try {
                dao.insert(employee);
                insertState.postValue(UiState.success(null));
            } catch (Exception e) {
                insertState.postValue(UiState.error(e));
            }
        });
    }

    public LiveData<List<Employee>> getAllEmployees() {

        return dao.getAllEmployees();

    }

    public void removeEmployee(int id, MutableLiveData<UiState<Void>> insertState) {insertState.postValue(UiState.loading());

        executor.execute(() -> {
            try {
                dao.removeEmployee(id);
                insertState.postValue(UiState.success(null));
            } catch (Exception e) {
                insertState.postValue(UiState.error(e));
            }
        });
    }
}
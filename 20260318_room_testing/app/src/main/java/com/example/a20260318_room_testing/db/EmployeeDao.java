package com.example.a20260318_room_testing.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.a20260318_room_testing.db.model.Employee;

import java.util.List;

@Dao
public interface EmployeeDao {

    @Insert
    void insert(Employee employee);

    @Update
    void update(Employee employee);

    @Query("SELECT * FROM employees ORDER BY name ASC")
    LiveData<List<Employee>> getAllEmployees();
}
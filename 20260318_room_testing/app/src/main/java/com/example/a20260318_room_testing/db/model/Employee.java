package com.example.a20260318_room_testing.db.model;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "employees", indices = {@Index(value = {"name"}, unique = true)})
public class Employee {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }
}
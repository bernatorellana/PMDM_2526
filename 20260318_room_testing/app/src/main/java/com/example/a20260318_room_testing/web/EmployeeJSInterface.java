package com.example.a20260318_room_testing.web;

import android.webkit.JavascriptInterface;

import com.example.a20260318_room_testing.viewmodel.EmployeeViewModel;

public class EmployeeJSInterface {
    private final EmployeeViewModel viewModel;

    public EmployeeJSInterface(EmployeeViewModel viewModel) {
        this.viewModel = viewModel;
    }


    @JavascriptInterface
    public void removeEmployee(int id){
        viewModel.removeEmployee(id);
    }

}

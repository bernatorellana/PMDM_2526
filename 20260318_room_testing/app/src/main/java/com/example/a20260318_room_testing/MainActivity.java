package com.example.a20260318_room_testing;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.a20260318_room_testing.databinding.ActivityMainBinding;
import com.example.a20260318_room_testing.db.model.Employee;
import com.example.a20260318_room_testing.viewmodel.EmployeeViewModel;
import com.example.a20260318_room_testing.viewmodel.UiState;
import com.example.a20260318_room_testing.web.EmployeeJSInterface;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get the ActivityMainBinding instance
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // get employee view model
        EmployeeViewModel viewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);


        // observe insert state
        viewModel.getInsertState().observe(this, state -> {
            showStatus(state);
        });

        // observe employees
        viewModel.getEmployees().observe(this, employees -> {
            showEmployeeList(employees, viewModel, binding);
        });

        // add button click listener
        binding.btnAdd.setOnClickListener(v -> {
            saveEmployee(binding, viewModel);
        });

        hideLoading();
    }

    private void showStatus(UiState<Void> state) {
        if (state == null) return;

        switch (state.status) {
            case LOADING:
                showLoading();
                break;
            case SUCCESS:
                hideLoading();
                break;
            case ERROR:
                showError(state.error);
                break;
        }
    }

    private void showError(Throwable error) {
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();
        hideLoading();
    }

    private void hideLoading() {
        binding.loadingView.setVisibility(View.GONE);
    }

    private void showLoading() {
        binding.loadingView.setVisibility(View.VISIBLE);
    }

    private void saveEmployee(ActivityMainBinding binding, EmployeeViewModel viewModel) {
        // get the name and position from the edit text
        String name = binding.edtText.getText().toString();
        viewModel.insert(new Employee(name, "Developer"));
    }

    private static void showEmployeeList(List<Employee> employees, EmployeeViewModel viewModel, ActivityMainBinding binding) {
        //activate the webview javascript
        binding.web.getSettings().setBlockNetworkImage(false);
        binding.web.getSettings().setJavaScriptEnabled(true);
        // register EmployeeJSInterface
        binding.web.addJavascriptInterface(new EmployeeJSInterface(viewModel), "Android");


        // update UI
        // list the employees in the webview as html
        String html = "<html>" +
                "<head>" +
                "<style>" +
                "body {"+
                " background-size:cover;"+
                " background-image:url('https://images.pexels.com/photos/18682254/pexels-photo-18682254/free-photo-of-mountain-landscape-with-forests-and-a-stream.jpeg')"+
                "}"+
                " li {" +
                "   font-size:25px;border-radius:10px;display:flex;justify-content:space-between;padding:10px;background-color:lightgray;margin:10px "+
                " } \n"+
                " li:nth-child(2n) {" +
                "   background-color:rgb(120,100,100); color:white; "+
                " } "+
                " input {" +
                "   font-size:20px; color:black; border-radius:5px;"+
                " } \n"+
                "</style>"+
                "<body><ul>";


        for (Employee employee : employees) {
            // add each employee to the html
            html += "<li ><p>" +
                    employee.id + ": " + employee.name +"</p> " +
                    "<input type='button' value='\uD83D\uDDD1'  onclick='Android.removeEmployee(" + employee.id + ");'> </li>";
        }
        html += "</ul></body></html>";
        binding.web.loadData(html, "text/html", "UTF-8");
    }
}
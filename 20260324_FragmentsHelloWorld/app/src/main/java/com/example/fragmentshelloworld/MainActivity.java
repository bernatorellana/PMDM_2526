package com.example.fragmentshelloworld;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.fragmentshelloworld.view.AlcadaFragment;
import com.example.fragmentshelloworld.view.PesFragment;
import com.example.fragmentshelloworld.view.ResultatFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Posar el fragment HomeFragment en el fragmentContainerView
        /*if(savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView, new AlcadaFragment()).commit();
        }*/

        /*Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener( view ->{
            // Check whether the current fragment is AlcadaFragment
            String className = getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView).getClass().getSimpleName();
            Fragment desti;
            switch(className){
                case "AlcadaFragment":{
                    desti = new PesFragment();
                    break;
                }
                case "PesFragment":{
                    desti = new ResultatFragment();
                    break;
                }
                default: desti = null;
            }
            if(desti!=null) {
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragmentContainerView, desti).
                        addToBackStack("seleccioAlcada").
                        commit();
            }
        });*/
    }
}
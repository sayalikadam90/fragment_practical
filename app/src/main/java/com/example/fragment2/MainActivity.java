package com.example.fragment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText medittext;
    Button mbtnaddfragment,mbtnremovefragment;
    ArrayList<Fragment_Counter> mListcounterfragment;
    Fragment_Counter mfragment_counter1, mfragment_conter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListcounterfragment=new ArrayList<>();
        mbtnaddfragment=findViewById(R.id.btnAdd);
        mbtnremovefragment=findViewById(R.id.btnRemove);
        medittext=findViewById(R.id.edtCounter);

        mfragment_counter1=(Fragment_Counter) getSupportFragmentManager().findFragmentById(R.id.fragmentCounter1);
        mfragment_conter2=(Fragment_Counter) getSupportFragmentManager().findFragmentById(R.id.fragmentCounter2);

        mbtnaddfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment_Counter counterFragment = new Fragment_Counter();
                Bundle bundle = new Bundle();
                bundle.putInt("count", Integer.parseInt(medittext.getText().toString()));
                counterFragment.setArguments(bundle);

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.mainContainer, counterFragment);
                fragmentTransaction.commit();

                mListcounterfragment.add(counterFragment);
            }
        });

        mbtnremovefragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().remove(mListcounterfragment.get(mListcounterfragment.size()-1))
                        .commit();

                mListcounterfragment.remove(mListcounterfragment.size()-1);

            }
        });


    }


}

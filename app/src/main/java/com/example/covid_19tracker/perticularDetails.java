package com.example.covid_19tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class perticularDetails extends AppCompatActivity {

    TextView cases,recovered, critical, active,todayCases,totalDeaths,todayDeaths,affectedCountries;
    private  int countryPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perticular_details);

        Intent intent= getIntent();
        countryPosition= intent.getIntExtra("position",0);

        getSupportActionBar().setTitle("Details of " + countries.countryList.get(countryPosition).getCountries());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        cases= findViewById(R.id.tvCases);
        recovered= findViewById(R.id.tvRecovered);
        critical=findViewById(R.id.tvCritical);
        active=findViewById(R.id.tvActive);
        todayCases=findViewById(R.id.tvTodayCases);
        totalDeaths=findViewById(R.id.tvDeaths);
        todayDeaths=findViewById(R.id.tvTodayDeaths);
        affectedCountries=findViewById(R.id.tvCountry);

        cases.setText(countries.countryList.get(countryPosition).getCases());
        recovered.setText(countries.countryList.get(countryPosition).getRecovered());
        critical.setText(countries.countryList.get(countryPosition).getCritical());
        active.setText(countries.countryList.get(countryPosition).getActive());
        todayCases.setText(countries.countryList.get(countryPosition).getTodayCases());
        totalDeaths.setText(countries.countryList.get(countryPosition).getDeath());
        todayDeaths.setText(countries.countryList.get(countryPosition).getTodayDeath());
        affectedCountries.setText(countries.countryList.get(countryPosition).getCountries());

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home);
        finish();

        return super.onOptionsItemSelected(item);
    }

}
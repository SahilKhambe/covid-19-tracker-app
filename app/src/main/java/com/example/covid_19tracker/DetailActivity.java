package com.example.covid_19tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private int positionCountry;
    TextView tvCountry, tvCases, tvRecovered, tvActive, tvCritical, tvTodayCases, tvDeaths, tvTodayDeaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        positionCountry = intent.getIntExtra("position", 0);

        getSupportActionBar().setTitle("Detail of "+AffectedCountries.modelList.get(positionCountry).getCountry());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tvCountry = findViewById(R.id.tvCountry);
        tvCases = findViewById(R.id.tvCases1);
        tvRecovered = findViewById(R.id.tvRecovered1);
        tvActive = findViewById(R.id.tvActive1);
        tvCritical = findViewById(R.id.tvCritical1);
        tvTodayCases = findViewById(R.id.tvTodayCases1);
        tvDeaths = findViewById(R.id.tvDeaths1);
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths1);

        tvCountry.setText(AffectedCountries.modelList.get(positionCountry).getCountry());
        tvCases.setText(AffectedCountries.modelList.get(positionCountry).getCases());
        tvRecovered.setText(AffectedCountries.modelList.get(positionCountry).getRecovered());
        tvActive.setText(AffectedCountries.modelList.get(positionCountry).getActive());
        tvCritical.setText(AffectedCountries.modelList.get(positionCountry).getCritical());
        tvTodayCases.setText(AffectedCountries.modelList.get(positionCountry).getTodayCases());
        tvDeaths.setText(AffectedCountries.modelList.get(positionCountry).getDeaths());
        tvTodayDeaths.setText(AffectedCountries.modelList.get(positionCountry).getTodayDeaths());


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }

}
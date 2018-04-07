package com.lawteam.lawinfo;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Person selected = (Person) intent.getSerializableExtra("Selected");

        TextView tvName = findViewById(R.id.DescrName);
        TextView tvGroup = findViewById(R.id.DescrGroup);
        TextView tvWorkingOn = findViewById(R.id.DescrWorkingOn);
        TextView tvDescription = findViewById(R.id.DescrDescription);

        tvName.setText(selected.getName());
        tvGroup.setText(selected.getGroup());
        tvWorkingOn.setText(selected.getWorkingOn());
        tvDescription.setText(selected.getDescription());
    }
}

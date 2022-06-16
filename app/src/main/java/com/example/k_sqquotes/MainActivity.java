package com.example.k_sqquotes;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
   private Toolbar toolbar;
   BottomNavigationView bottomNavigationView;
   HomeFragment homeFragment=new HomeFragment();
   FavFragment favFragment=new FavFragment();
   PropFragment propFragment=new PropFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        bottomNavigationView=findViewById(R.id.bnv);
        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,homeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                 switch (item.getItemId()){
                     case R.id.home_menu:
                        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,homeFragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                         return true;
                     case R.id.fav_menu:
                         FragmentTransaction transaction_= getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,favFragment);
                         transaction_.addToBackStack(null);
                         transaction_.commit();
                         return true;
                     case R.id.prop_menu:
                         FragmentTransaction transaction__= getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,propFragment);
                         transaction__.addToBackStack(null);
                         transaction__.commit();
                         return true;

                 }
                 return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem menuItem=menu.findItem(R.id.search_item);
        SearchView searchView=(SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search in App");

        return super.onCreateOptionsMenu(menu);
    }
}

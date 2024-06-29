package com.example.moviemania;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;


import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.moviemania.model.Movie;
//import com.example.moviemania.databinding.ActivityMainBinding;
import com.example.moviemania.view.MovieAdapter;
import com.example.moviemania.viewmodel.MainActivityViewModel;
import com.google.android.material.navigation.NavigationView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Movie> movies;
    private MovieAdapter movieAdapter;
    private RecyclerView recyclerView;

    private SwipeRefreshLayout swipeRefreshLayout;
//    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private Toolbar toolbar;

    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawer_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        toolbar = findViewById(R.id.toolbar);




        // Initialize DrawerLayout and NavigationView
        drawerLayout = findViewById(R.id.drawer_layout);
         navigationView = findViewById(R.id.navigation_view);
        setSupportActionBar(toolbar);
        // Setup ActionBarDrawerToggle
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        loadFragment(new FirstFragment());

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if (id == R.id.nav_setting){
                    Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                    loadFragment(new SettingsFragment());
                }else if (id == R.id.nav_home) {
                    loadFragment(new HomeFragment());

                } else if (id == R.id.nav_profile) {
                    Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                }
                drawerLayout.closeDrawer(GravityCompat.START);


                return true;
            }
        });


//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
//
//        getPopularMovies();
//
//        swipeRefreshLayout = binding.swipeLayout;
//        swipeRefreshLayout.setColorSchemeResources(R.color.black);
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                getPopularMovies();
////                swipeRefreshLayout.setRefreshing(false);
//            }
//        });







    }


    void loadFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragmentContainer , fragment);
        transaction.commit();

    }
//    private void getPopularMovies(){
//        viewModel.getAllMovies().observe(this, new Observer<List<Movie>>() {
//            @Override
//            public void onChanged(List<Movie> moviesFromLiveData){
//                movies = (ArrayList<Movie>) moviesFromLiveData;
//                displayMoviesInRecyclerView();
//
//            }
//        });
//    }

//    private void displayMoviesInRecyclerView() {
//        recyclerView = binding.recyclerView;
//        movieAdapter = new MovieAdapter(this,movies);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(movieAdapter);
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//
////        notify
//        movieAdapter.notifyDataSetChanged();
//
//    }
}
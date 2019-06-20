package com.example.eckovation;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.eckovation.ui.main.AllFeedFragment;
import com.example.eckovation.ui.main.AnswersBookmarkedFragment;
import com.example.eckovation.ui.main.QuestionsFollowed;
import com.example.eckovation.ui.main.SectionsPagerAdapter;
import com.example.eckovation.ui.main.UnansweredQuestionsFragment;

public class MainActivity extends AppCompatActivity implements AllFeedFragment.OnFragmentInteractionListener, UnansweredQuestionsFragment.OnFragmentInteractionListener, QuestionsFollowed.OnFragmentInteractionListener, AnswersBookmarkedFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        return;
    }
}
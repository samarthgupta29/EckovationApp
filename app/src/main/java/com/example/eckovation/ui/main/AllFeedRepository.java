package com.example.eckovation.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class AllFeedRepository {

    private String DB_NAME = "db_allFeed";
    private AllFeedDatabase allFeedDatabase;
    public AllFeedRepository(Context context){
        allFeedDatabase = Room.databaseBuilder(context,AllFeedDatabase.class,DB_NAME).allowMainThreadQueries().build();
    }

    public LiveData<List<AllFeed>> getTasks(){
        return allFeedDatabase.allFeedDAO().fetchAll();
    }

    public void insertTask(final AllFeed allFeed){
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                allFeedDatabase.allFeedDAO().insertTask(allFeed);
                return null;
            }
        }.execute();
    }

    public List<AllFeed> fetchUnansList(){
        return allFeedDatabase.allFeedDAO().fetchUnansweredList(0);
    }

    public void updateFollowing(){
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                allFeedDatabase.allFeedDAO().updateFollowing(1);
                return null;
            }
        }.execute();
    }

    public List<AllFeed> fetchFollowing(){
        return allFeedDatabase.allFeedDAO().fetchFollowing(1);
    }

//    public void updateBookmark(){
//        new AsyncTask<Void,Void,Void>(){
//            @Override
//            protected Void doInBackground(Void... voids) {
//                allFeedDatabase.allFeedDAO().updateBookmark(1);
//                return null;
//            }
//        }.execute();
//    }
//
//    public List<AllFeed> fetchBookmark(){
//        return allFeedDatabase.allFeedDAO().fetchBookmark(1);
//    }


}

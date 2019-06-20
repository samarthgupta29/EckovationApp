package com.example.eckovation.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface AllFeedDAO {

    @Insert
    void insertTask(AllFeed allFeed);

    @Query("SELECT * FROM AllFeed")
    LiveData<List<AllFeed>> fetchAll();

    @Query("SELECT * FROM AllFeed WHERE answers = :num")
    List<AllFeed> fetchUnansweredList(int num);

    @Query("UPDATE AllFeed SET followers = :num")
    void updateFollowing(int num);

    @Query("SELECT * FROM AllFeed WHERE followers = :num")
    List<AllFeed> fetchFollowing(int num);

//    @Query("UPDATE TopAnswer SET bookmark = :num")
//    void updateBookmark(int num);
//
//    @Query("SELECT * FROM TopAnswer WHERE bookmark = :num")
//    List<AllFeed> fetchBookmark(int num);

}

package com.example.eckovation.ui.main;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {AllFeed.class,Answer.class,Question.class,TopAnswer.class},version = 1,exportSchema = false)
public abstract class AllFeedDatabase extends RoomDatabase {
    public abstract AllFeedDAO allFeedDAO();
}

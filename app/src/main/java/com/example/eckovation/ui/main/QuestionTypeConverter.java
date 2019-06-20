package com.example.eckovation.ui.main;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;

class QuestionTypeConverter {

    @TypeConverter
    public static Question fromString(String questionJson){
        if(questionJson == null) return null;
        Gson gson = new Gson();
        Question question = gson.fromJson(questionJson,Question.class);
        return question;
    }

    @TypeConverter
    public static String toString(Question question){
        if(question == null) return null;
        Gson gson=new Gson();
        String questionJson = gson.toJson(question);
        return questionJson;
    }
}

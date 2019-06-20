package com.example.eckovation.ui.main;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;

class TopAnswerTypeConverter {
    @TypeConverter
    public static TopAnswer fromString(String topAnswerJson){
        if(topAnswerJson == null) return null;
        Gson gson = new Gson();
        TopAnswer topAnswer = gson.fromJson(topAnswerJson,TopAnswer.class);
        return topAnswer;
    }

    @TypeConverter
    public static String toString(TopAnswer topAnswer){
        if(topAnswer == null) return null;
        Gson gson=new Gson();
        String topAnswerJson = gson.toJson(topAnswer);
        return topAnswerJson;
    }
}

package com.example.eckovation.ui.main;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;

class AnswerTypeConverter {

    @TypeConverter
    public static Answer fromString(String answerJson){
        if(answerJson == null) return null;
        Gson gson = new Gson();
        Answer answer = gson.fromJson(answerJson,Answer.class);
        return answer;
    }

    @TypeConverter
    public static String toString(Answer answer){
        if(answer == null) return null;
        Gson gson=new Gson();
        String answerJson = gson.toJson(answer);
        return answerJson;
    }
}

package com.example.eckovation.ui.main;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class AllFeed implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    @SerializedName("index")
    @Expose
    @ColumnInfo(name = "index")
    private Integer index;
    @SerializedName("picture")
    @Expose
    @ColumnInfo(name = "picture")
    private String picture;
    @SerializedName("name")
    @Expose
    @ColumnInfo(name = "name")
    private String name;
    @SerializedName("question_posted")
    @Expose
    @ColumnInfo(name = "question_posted")
    private String questionPosted;
    @SerializedName("question")
    @Expose
    @ColumnInfo(name = "question")
    @TypeConverters(QuestionTypeConverter.class)
    private Question question;
    @SerializedName("followers")
    @Expose
    @ColumnInfo(name = "followers")
    private int followers;
    @SerializedName("answers")
    @Expose
    @ColumnInfo(name = "answers")
    private int answers;
    @SerializedName("top_answer")
    @Expose
    @ColumnInfo(name = "top_answer")
    @TypeConverters(TopAnswerTypeConverter.class)
    private TopAnswer topAnswer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuestionPosted() {
        return questionPosted;
    }

    public void setQuestionPosted(String questionPosted) {
        this.questionPosted = questionPosted;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getAnswers() {
        return answers;
    }

    public void setAnswers(int answers) {
        this.answers = answers;
    }

    public TopAnswer getTopAnswer() {
        return topAnswer;
    }

    public void setTopAnswer(TopAnswer topAnswer) {
        this.topAnswer = topAnswer;
    }

}

@Entity
class Answer {

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    @SerializedName("answer_title")
    @Expose
    @ColumnInfo(name = "answer_title")
    private String answerTitle;
    @SerializedName("answer_image")
    @Expose
    @ColumnInfo(name = "answer_image")
    private String answerImage;

    public String getAnswerTitle() {
        return answerTitle;
    }

    public void setAnswerTitle(String answerTitle) {
        this.answerTitle = answerTitle;
    }

    public String getAnswerImage() {
        return answerImage;
    }

    public void setAnswerImage(String answerImage) {
        this.answerImage = answerImage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}


@Entity
class Question {

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    @SerializedName("question_title")
    @Expose
    @ColumnInfo(name = "question_title")
    private String questionTitle;
    @SerializedName("question_image")
    @Expose
    @ColumnInfo(name = "question_image")
    private String questionImage;

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionImage() {
        return questionImage;
    }

    public void setQuestionImage(String questionImage) {
        this.questionImage = questionImage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

@Entity
class TopAnswer {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    @SerializedName("picture")
    @Expose
    @ColumnInfo(name = "picture")
    private String picture;
    @SerializedName("name")
    @Expose
    @ColumnInfo(name = "name")
    private String name;
    @SerializedName("answer_posted")
    @Expose
    @ColumnInfo(name = "answer_posted")
    private String answerPosted;
    @SerializedName("answer")
    @Expose
    @ColumnInfo(name = "answer")
    @TypeConverters(AnswerTypeConverter.class)
    private Answer answer;
    @SerializedName("upvote_count")
    @Expose
    @ColumnInfo(name = "upvote_count")
    private Integer upvoteCount;
    @SerializedName("bookmark")
    @Expose
    @ColumnInfo(name = "bookmark")
    private int bookmark;

    public int getBookmark() {
        return bookmark;
    }

    public void setBookmark(int bookmark) {
        this.bookmark = bookmark;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnswerPosted() {
        return answerPosted;
    }

    public void setAnswerPosted(String answerPosted) {
        this.answerPosted = answerPosted;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Integer getUpvoteCount() {
        return upvoteCount;
    }

    public void setUpvoteCount(Integer upvoteCount) {
        this.upvoteCount = upvoteCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
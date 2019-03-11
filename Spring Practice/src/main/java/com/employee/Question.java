package com.employee;

import java.util.Arrays;
import java.util.List;

public class Question {
    private int id;
    private String name;
    private List<String> answers;
    
    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", answers=" + getString(answers) +
                '}';
    }
    
    private String getString(List<String> answers) {
        String str = "";
        for(String x: answers){
            str = str + "," + x;
        }
        return str;
    }
    
    public Question(int id, String name, List<String> answers) {
        this.id = id;
        this.name = name;
        this.answers = answers;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public List<String> getAnswers() {
        return answers;
    }
    
    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}

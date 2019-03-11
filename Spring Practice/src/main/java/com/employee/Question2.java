package com.employee;

import java.util.List;

public class Question2 {
    private int id;
    private String name;
    private List<Answer> answerList;
    
    @Override
    public String toString() {
        String str = "";
        for(Answer x:answerList){
            str = str+x.toString()+" ";
        }
        String s = "Question2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", answerList=" + str;
        return s;
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
    
    public List<Answer> getAnswerList() {
        return answerList;
    }
    
    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }
    
    public Question2(int id, String name, List<Answer> answerList) {
        this.id = id;
        this.name = name;
        this.answerList = answerList;
    }
}

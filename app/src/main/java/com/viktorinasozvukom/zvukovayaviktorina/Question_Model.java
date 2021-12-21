package com.viktorinasozvukom.zvukovayaviktorina;

public class Question_Model {
    public String optionA, optionB, optionC, music;
    public int checkedId = -1;

    public int correctOption;
    public boolean isAnswered, bool=false;
    public boolean isAnsweredImage = false;
    String src_image;

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public int getCheckedId() {
        return checkedId;
    }

    public void setCheckedId(int checkedId) {
        this.checkedId = checkedId;
    }

    public int getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(int correctOption) {
        this.correctOption = correctOption;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public String getSrc_image() {
        return src_image;
    }

    public void setSrc_image(String src_image) {
        this.src_image = src_image;
    }
}

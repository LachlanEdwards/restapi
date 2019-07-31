package com.metlease.Entity;

import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Date;

public class BuildingReviewPayload {
    private String comment;
    private int score;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getScore() {
        return score;
    }

    public void setScore() {
        this.score = score;
    }
}

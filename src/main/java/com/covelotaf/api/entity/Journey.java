package com.covelotaf.api.entity;

import java.util.List;

import javax.persistence.Id;

public class Journey {

    @Id
    private String id;

    private List<Point> points;

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}

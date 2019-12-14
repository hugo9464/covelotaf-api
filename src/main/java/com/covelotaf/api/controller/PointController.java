package com.covelotaf.api.controller;

import com.covelotaf.api.entity.Point;
import com.covelotaf.api.repository.PointRepository;
import com.covelotaf.api.request.AddPointRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class PointController {

    @Autowired
    private PointRepository pointRepository;

    @PostMapping("/point")
    public Point create(@RequestBody AddPointRequest addPointRequest) throws IOException {
        Point point = new Point(addPointRequest.getLongitude(), addPointRequest.getLatitude());

        pointRepository.insert(point);

        return point;
    }

    @GetMapping("/points")
    public List<Point> getPoints() {
        return pointRepository.findAll();
    }
}
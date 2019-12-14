package com.covelotaf.api.repository;

import com.covelotaf.api.entity.Point;
import com.covelotaf.api.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PointRepository extends MongoRepository<Point, String> {

}

package com.stackroute.Muzix.Repository;

import com.stackroute.Muzix.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface TrackRepository extends MongoRepository<Track,Integer> {

    List<Track> findByTrackName(String trackName);

}

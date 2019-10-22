package com.stackroute.Muzix.SeedData;

import com.stackroute.Muzix.Repository.TrackRepository;
import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerData implements CommandLineRunner {
    @Autowired
    TrackRepository trackRepository;

    public CommandLineRunnerData(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Track track=new Track();
        track.setTrackId(2);
        track.setTrackName("bahubali");
        track.setComments("good");
        trackRepository.save(track);
    }


}



package com.stackroute.Muzix.SeedData;

import com.stackroute.Muzix.Repository.TrackRepository;
import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.service.TrackService;
import com.stackroute.Muzix.exception.TrackAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@PropertySource("application.properties")
public class ApplicationListenerData implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    TrackRepository trackRepository;

    @Value("${track.TrackId}")
    private int TrackId;

    @Value("${track.TrackName}")
    private String TrackName;

    @Value("${track.TrackComments}")
    private String TrackComments;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

            Track track = new Track(TrackId,TrackName,TrackComments);
//            track.setTrackId(1);
//            track.setTrackName("Bahubali");
//            track.setComments("good");

        trackRepository.save(track);
    }
    }


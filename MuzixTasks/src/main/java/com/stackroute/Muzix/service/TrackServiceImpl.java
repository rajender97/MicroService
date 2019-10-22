package com.stackroute.Muzix.service;

import com.stackroute.Muzix.Repository.TrackRepository;
import com.stackroute.Muzix.domain.Track;

import com.stackroute.Muzix.exception.TrackAlreadyExistsException;
import com.stackroute.Muzix.exception.TrackNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Primary
@Service
public class TrackServiceImpl implements TrackService {

    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if(trackRepository.existsById(track.getTrackId())){
            throw new TrackAlreadyExistsException("Track already exists");
        }
        Track track1 = trackRepository.save(track);
        if(track1==null){
            throw new TrackAlreadyExistsException("Track is already exists");
        }

        return track1;
    }

    @Override
    public List<Track> getTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track updateComments(Track track) {

        return trackRepository.save(track);
    }

    @Override
    public boolean deleteTrack(int trackId) {
        trackRepository.deleteById(trackId);
        return true;
    }

    @Override
    public Optional<Track> getTrackById(int id) throws TrackNotFoundException {

        if(!trackRepository.existsById(id))
        {
            throw new TrackNotFoundException("Track not found");
        }
        Track list = trackRepository.findById(id).get();
        if(list==null)
        {
            throw new TrackNotFoundException("Track not found");
        }
        return trackRepository.findById(id);
    }

    @Override
    public List<Track> getTrackByName(String name) throws TrackNotFoundException{
        List<Track> list=trackRepository.findByTrackName(name);
        if(list.isEmpty()){
            throw new TrackNotFoundException("Track not Found");
        }
        return list;
    }
}


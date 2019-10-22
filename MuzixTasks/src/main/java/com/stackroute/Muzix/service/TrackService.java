package com.stackroute.Muzix.service;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.exception.TrackAlreadyExistsException;
import com.stackroute.Muzix.exception.TrackNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TrackService {

    public Track saveTrack(Track track) throws TrackAlreadyExistsException;

    public List<Track> getTracks();

    public Track updateComments(Track track);

    public boolean deleteTrack(int trackId);

    public Optional<Track> getTrackById(int id) throws TrackNotFoundException;

    public List<Track> getTrackByName(String name) throws TrackNotFoundException;

}
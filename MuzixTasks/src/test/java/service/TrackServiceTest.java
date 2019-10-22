package service;

import com.stackroute.Muzix.Repository.TrackRepository;
import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.exception.TrackAlreadyExistsException;
import com.stackroute.Muzix.service.TrackServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TrackServiceTest {

    private Track track;

    //Create a mock for UserRepository
    @Mock
    private TrackRepository trackRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private TrackServiceImpl trackService;
    List<Track> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setComments("awesome");
        track.setTrackId(1);
        track.setTrackName("Dhoni");
        list = new ArrayList<>();
        list.add(track);


    }

    @Test
    public void saveTrackTestSuccess() throws TrackAlreadyExistsException {

        when(trackRepository.save((Track)any())).thenReturn(track);
        Track savedTrack = trackService.saveTrack(track);
        Assert.assertEquals(track,savedTrack);

        //verify here verifies that userRepository save method is only called once
        verify(trackRepository,times(1)).save(track);

    }

    @Test(expected = TrackAlreadyExistsException.class)
    public void saveUserTestFailure() throws TrackAlreadyExistsException {
        when(trackRepository.save((Track)any())).thenReturn(null);
        Track savedTrack = trackService.saveTrack(track);
        System.out.println("savedTrack" + savedTrack);
        Assert.assertEquals(track,savedTrack);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }

    @Test
    public void getAllUser(){

        trackRepository.save(track);
        //stubbing the mock to return specific data
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> tracklist = trackService.getTracks();
        Assert.assertEquals(list,tracklist);
    }





}

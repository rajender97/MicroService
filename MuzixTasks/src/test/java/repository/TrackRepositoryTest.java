package repository;
import com.stackroute.Muzix.Repository.TrackRepository;
import com.stackroute.Muzix.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TrackRepositoryTest {

    @Autowired
    private TrackRepository trackRepository;
    private Track track;

    @Before
    public void setUp()
    {
        track = new Track();
        track.setTrackId(1);
        track.setTrackName("Dhoni");
        track.setComments("Awesome");

    }

    @After
    public void tearDown(){

        trackRepository.deleteAll();
    }


    @Test
    public void testSaveTrack(){
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getTrackId()).get();
        Assert.assertEquals(1,fetchTrack.getTrackId());

    }

    @Test
    public void testSaveTrackFailure(){
        Track testTrack = new Track(2,"Virat","good");
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getTrackId()).get();
        Assert.assertNotSame(testTrack,track);
    }

    @Test
    public void testGetTracks(){
        Track t = new Track(7,"Dhoni","awesome");
        Track t1 = new Track(18,"virat","good");
        trackRepository.save(t);
        trackRepository.save(t1);

        List<Track>list = trackRepository.findAll();
        Assert.assertEquals("awesome",list.get(1).getTrackName());

    }


}

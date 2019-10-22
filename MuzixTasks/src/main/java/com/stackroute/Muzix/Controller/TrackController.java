package com.stackroute.Muzix.Controller;
import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.service.TrackService;
import com.stackroute.Muzix.exception.TrackAlreadyExistsException;
import com.stackroute.Muzix.exception.TrackNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping(value="/api")
   public class TrackController<TrackDao> {

    TrackService trackService;
    @Autowired
    public TrackController(TrackService trackService){

             this.trackService=trackService;
    }

    @PostMapping("track")
           public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException {
                 ResponseEntity responseEntity;
            //try {
                  trackService.saveTrack(track);
                  responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
             //}
             //catch (Exception ex){
             //  responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
            //}
        return responseEntity;
    }

    @GetMapping("track")
        public ResponseEntity<?> getTracks(){
        ResponseEntity responseEntity;
        List<Track> tracks=trackService.getTracks();
        //try{
            responseEntity = new ResponseEntity<>(tracks, HttpStatus.OK);
        //}catch (Exception ex) {
          //  responseEntity = new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
        //}
        return responseEntity;
    }

    @GetMapping("track/{id}")
         public ResponseEntity<?> getTrackById(@PathVariable int id) throws TrackNotFoundException{
        ResponseEntity responseEntity;
        // try{
        responseEntity = new ResponseEntity<Optional<Track>>(trackService.getTrackById(id), HttpStatus.CREATED);
        //}catch (TrackNotFoundException ex) {
          //responseEntity = new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
        //}
        return responseEntity;
    }

    @GetMapping("track/name/{name}")
          public ResponseEntity<?> getTrackByName(@PathVariable(value = "name") String name) throws TrackNotFoundException{
        ResponseEntity responseEntity;
       // try{
            trackService.getTrackByName(name);
            responseEntity = new ResponseEntity<List<Track>>(trackService.getTrackByName(name), HttpStatus.OK);
       // }catch (TrackNotFoundException ex) {
         //   responseEntity = new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
       //}
        return responseEntity;
    }





   // @PutMapping("track/{id}")
   // public  ResponseEntity<?> updateTracks(@PathVariable(value = "id") int id,@Valid @RequestBody Track track) throws TrackNotFoundException, TrackAlreadyExistsException {
     //   ResponseEntity responseEntity;
       // Optional<Track> track1 = trackService.getTrackById(id);
       // try{
            //if(!track1.isPresent()){
              //  throw new Exception("id-"+id);
           // }
         //   track.setTrackId(id);
           // trackService.saveTrack(track);
           // responseEntity = new ResponseEntity(trackService.getTracks(), HttpStatus.CREATED);
        //}catch (Exception ex) {
           // responseEntity = new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
      //  }
      //  return responseEntity;
   // }

    @DeleteMapping("track/track/{id}")
        public ResponseEntity<?> deleteTracks(@PathVariable("id") int id){
        ResponseEntity responseEntity;
        //try{
            trackService.deleteTrack(id);
            responseEntity = new ResponseEntity(trackService.getTracks(), HttpStatus.CREATED);
        //}catch (Exception ex) {
          //  responseEntity = new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
       //}
        return responseEntity;
    }
}

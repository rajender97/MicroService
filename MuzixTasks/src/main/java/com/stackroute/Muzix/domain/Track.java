package com.stackroute.Muzix.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.Entity;
//import javax.persistence.Id;

//@Entity
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Track {
    @Id
    int trackId;
    String trackName;
    String comments;
}



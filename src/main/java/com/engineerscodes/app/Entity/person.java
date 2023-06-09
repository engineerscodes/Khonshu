package com.engineerscodes.app.Entity;


import com.engineerscodes.app.Util.StringPrefixedSequenceIdGenerator;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Generated;



@Entity(name = "emp")
@Data
@Table(name = "person2")
public class person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="player_seq")
    @GenericGenerator(
            name = "player_seq",
            strategy = "com.engineerscodes.app.Util.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "khonshu"),
                    })
    private String ID;

    @Column(name = "user_name")
    private String name;

}

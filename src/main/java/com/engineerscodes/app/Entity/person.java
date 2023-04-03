package com.engineerscodes.app.Entity;


import com.engineerscodes.app.Util.StringPrefixedSequenceIdGenerator;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Generated;



@Entity
@Data
@Table(name = "person2")
public class person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @GenericGenerator(
            name = "book_seq",
            strategy = "com.engineerscodes.app.Util.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "kh"),
                    })
    private String ID;

    private String name;

}

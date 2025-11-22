package DTO;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode //not mandatory from 6+ versions but recommended to provide
public class Profile implements Serializable {
    @EmbeddedId
	CompositeKeysOfProfile ck; // Profile HAS-A CompositeKeysOfProfile
    String name,gender;
    int age;
}

package SpringBoottutorial.demo.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.io.Serializable;
//import javax.persistence.*;

@Entity
// @Table(name = "usr")
public class User implements Serializable {
  @Id
  private String userId;

  private String password;

  private String firstName;

  private String lastName;

  @Enumerated(EnumType.STRING)
  private RoleName roleName;

}

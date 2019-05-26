package sql.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "note")
public class Note {

  @Id
  @Column(name = "idNote",
          unique = true,
          nullable = false)
  @GeneratedValue(
          strategy = GenerationType.AUTO,
          generator = "native"
  )
  @GenericGenerator(
          name = "native",
          strategy = "native"
  )
  Integer idNote;
  String valoareNota;


}

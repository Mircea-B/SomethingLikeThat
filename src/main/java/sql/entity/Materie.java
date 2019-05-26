package sql.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "materie")
public class Materie {

  @Id
  @Column(name = "idMaterie",
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
  Integer idMaterie;

  String numeMaterie;

  @OneToMany(mappedBy = "materie")
  List<Profesori> profesoriList;


  public Materie() {
  }

  public Materie(String numeMaterie) {
    this.numeMaterie = numeMaterie;
  }

  @Override
  public String toString() {
    return "Materie{" +
            "idMaterie=" + idMaterie +
            ", numeMaterie='" + numeMaterie + '\'' +
            '}';
  }
}

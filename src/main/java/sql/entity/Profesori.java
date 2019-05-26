package sql.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "profesori")
public class Profesori {

  @Id
  @Column(name = "idProfesor",
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
  Integer idProfesor;

  String numeProfesor;

  @OneToOne
  @JoinColumn(name = "idMateriePredata")
  Materie materie;

  public Profesori(String numeProfesor, Materie materie) {
    this.numeProfesor = numeProfesor;
    this.materie = materie;
  }

  public Profesori() {
  }

  @Override
  public String toString() {
    return "Profesori{" +
            "idProfesor=" + idProfesor +
            ", numeProfesor='" + numeProfesor + '\'' +
            ", materie=" + materie +
            '}';
  }
}

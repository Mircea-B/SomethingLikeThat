package sql.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "medii")
public class Medii {

  @Id
  @Column(name = "idMedie",unique = true,nullable = false)
  @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
  @GenericGenerator(name = "native",strategy = "native")
  Integer idMedie;

  @Column(name="valoareMedie")
  Integer valoareMedie;

  @OneToOne
  @JoinColumn(name = "idMaterie")
  Materie materie;

  @OneToOne
  @JoinColumn(name = "idElev")
  Elevi elev;

  @Override
  public String toString() {
    return "Medii{" +
            "idMedie=" + idMedie +
            ", valoareMedie=" + valoareMedie +
            ", materie=" + materie +
            ", elev=" + elev +
            '}';
  }
}
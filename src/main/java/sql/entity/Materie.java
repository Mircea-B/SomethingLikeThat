package sql.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="materie")
public class Materie {

    @Id
    @Column(name = "idMaterie",
            unique = true,
            nullable = false)
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
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

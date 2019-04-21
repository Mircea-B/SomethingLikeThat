package sql.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="clasa")
public class Clasa {

    @Id
    @Column(name = "idClasa",
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
    Integer idClasa;

    String numeClasa;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clasa")
    List<Elevi> eleviList;

    @Override
    public String toString() {
        return "Clasa{" +
                "idClasa=" + idClasa +
                ", numeClasa='" + numeClasa + '\'' +
                '}';
    }

    public Clasa(String numeClasa) {
        this.numeClasa = numeClasa;
    }

    public Clasa() {
    }
}

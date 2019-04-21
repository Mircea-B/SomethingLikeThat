package sql.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import sql.entity.Clasa;

@Entity
@Table(name="elevi")
public class Elevi {

    @Id
    @Column(name = "idElev",
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
    Integer idElev;

    String numeElev;

    @ManyToOne
    @JoinColumn(name = "idClasa")
    Clasa clasa;

    public Elevi(String numeElev, Clasa clasa) {
        this.numeElev = numeElev;
        this.clasa = clasa;
    }

    public Elevi() {
    }

    @Override
    public String toString() {

        return "Elevi{" +
                "idElev=" + idElev +
                ", numeElev='" + numeElev + '\'' +
                ", clasa=" + clasa +
                '}';
    }
}

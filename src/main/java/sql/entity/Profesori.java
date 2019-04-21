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

import sql.entity.Materie;

@Entity
@Table(name="profesori")
public class Profesori {

    @Id
    @Column(name = "idProfesor",
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

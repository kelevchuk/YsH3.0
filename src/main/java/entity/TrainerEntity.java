package entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by LevchukK.E. on 04.05.17.
 */
@Entity
@Table(name = "trainer", schema = "public", catalog = "ysh_db")
public class TrainerEntity {
    private long idTrainer;
    private String nameTrainer;
    private Collection<ClubTrainerEntity> clubTrainersByIdTrainer;

    @Id
    @Column(name = "id_trainer", nullable = false)
    public long getIdTrainer() {
        return idTrainer;
    }

    public void setIdTrainer(long idTrainer) {
        this.idTrainer = idTrainer;
    }

    @Basic
    @Column(name = "name_trainer", nullable = true, length = -1)
    public String getNameTrainer() {
        return nameTrainer;
    }

    public void setNameTrainer(String nameTrainer) {
        this.nameTrainer = nameTrainer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainerEntity that = (TrainerEntity) o;

        if (idTrainer != that.idTrainer) return false;
        if (nameTrainer != null ? !nameTrainer.equals(that.nameTrainer) : that.nameTrainer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idTrainer ^ (idTrainer >>> 32));
        result = 31 * result + (nameTrainer != null ? nameTrainer.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "trainerByIdTrainer")
    public Collection<ClubTrainerEntity> getClubTrainersByIdTrainer() {
        return clubTrainersByIdTrainer;
    }

    public void setClubTrainersByIdTrainer(Collection<ClubTrainerEntity> clubTrainersByIdTrainer) {
        this.clubTrainersByIdTrainer = clubTrainersByIdTrainer;
    }
}

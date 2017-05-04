package entity;

import javax.persistence.*;

/**
 * Created by LevchukK.E. on 04.05.17.
 */
@Entity
@Table(name = "club_trainer", schema = "public", catalog = "ysh_db")
public class ClubTrainerEntity {
    private long idClubTrainer;
    private Long idClub;
    private Long idTrainer;
    private ClubEntity clubByIdClub;
    private TrainerEntity trainerByIdTrainer;

    @Id
    @Column(name = "id_club_trainer", nullable = false)
    public long getIdClubTrainer() {
        return idClubTrainer;
    }

    public void setIdClubTrainer(long idClubTrainer) {
        this.idClubTrainer = idClubTrainer;
    }

    @Basic
    @Column(name = "id_club", nullable = true)
    public Long getIdClub() {
        return idClub;
    }

    public void setIdClub(Long idClub) {
        this.idClub = idClub;
    }

    @Basic
    @Column(name = "id_trainer", nullable = true)
    public Long getIdTrainer() {
        return idTrainer;
    }

    public void setIdTrainer(Long idTrainer) {
        this.idTrainer = idTrainer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClubTrainerEntity that = (ClubTrainerEntity) o;

        if (idClubTrainer != that.idClubTrainer) return false;
        if (idClub != null ? !idClub.equals(that.idClub) : that.idClub != null) return false;
        if (idTrainer != null ? !idTrainer.equals(that.idTrainer) : that.idTrainer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idClubTrainer ^ (idClubTrainer >>> 32));
        result = 31 * result + (idClub != null ? idClub.hashCode() : 0);
        result = 31 * result + (idTrainer != null ? idTrainer.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_club", referencedColumnName = "id_club", insertable = false, updatable = false)
    public ClubEntity getClubByIdClub() {
        return clubByIdClub;
    }

    public void setClubByIdClub(ClubEntity clubByIdClub) {
        this.clubByIdClub = clubByIdClub;
    }

    @ManyToOne
    @JoinColumn(name = "id_trainer", referencedColumnName = "id_trainer", insertable = false, updatable = false)
    public TrainerEntity getTrainerByIdTrainer() {
        return trainerByIdTrainer;
    }

    public void setTrainerByIdTrainer(TrainerEntity trainerByIdTrainer) {
        this.trainerByIdTrainer = trainerByIdTrainer;
    }
}

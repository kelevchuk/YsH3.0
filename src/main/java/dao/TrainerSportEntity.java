package dao;

import javax.persistence.*;

/**
 * Created by LevchukK.E. on 08.05.17.
 */
@Entity
@Table(name = "trainer_sport", schema = "public", catalog = "ysh_db")
public class TrainerSportEntity {
    private long idTrainerSport;
    private Long idTrainerFk;
    private Long idSportFk;
    private TrainerEntity trainerByIdTrainerFk;
    private SportTypeEntity sportTypeByIdSportFk;

    @Id
    @Column(name = "id_trainer_sport", nullable = false)
    public long getIdTrainerSport() {
        return idTrainerSport;
    }

    public void setIdTrainerSport(long idTrainerSport) {
        this.idTrainerSport = idTrainerSport;
    }

    @Basic
    @Column(name = "id_trainer_fk", nullable = true)
    public Long getIdTrainerFk() {
        return idTrainerFk;
    }

    public void setIdTrainerFk(Long idTrainerFk) {
        this.idTrainerFk = idTrainerFk;
    }

    @Basic
    @Column(name = "id_sport_fk", nullable = true)
    public Long getIdSportFk() {
        return idSportFk;
    }

    public void setIdSportFk(Long idSportFk) {
        this.idSportFk = idSportFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainerSportEntity that = (TrainerSportEntity) o;

        if (idTrainerSport != that.idTrainerSport) return false;
        if (idTrainerFk != null ? !idTrainerFk.equals(that.idTrainerFk) : that.idTrainerFk != null) return false;
        if (idSportFk != null ? !idSportFk.equals(that.idSportFk) : that.idSportFk != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idTrainerSport ^ (idTrainerSport >>> 32));
        result = 31 * result + (idTrainerFk != null ? idTrainerFk.hashCode() : 0);
        result = 31 * result + (idSportFk != null ? idSportFk.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_trainer_fk", referencedColumnName = "id_trainer", insertable = false, updatable = false)
    public TrainerEntity getTrainerByIdTrainerFk() {
        return trainerByIdTrainerFk;
    }

    public void setTrainerByIdTrainerFk(TrainerEntity trainerByIdTrainerFk) {
        this.trainerByIdTrainerFk = trainerByIdTrainerFk;
    }

    @ManyToOne
    @JoinColumn(name = "id_sport_fk", referencedColumnName = "id_sport", insertable = false, updatable = false)
    public SportTypeEntity getSportTypeByIdSportFk() {
        return sportTypeByIdSportFk;
    }

    public void setSportTypeByIdSportFk(SportTypeEntity sportTypeByIdSportFk) {
        this.sportTypeByIdSportFk = sportTypeByIdSportFk;
    }
}

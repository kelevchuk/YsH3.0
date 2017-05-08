package dao;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by LevchukK.E. on 08.05.17.
 */
@Entity
@Table(name = "trainer", schema = "public", catalog = "ysh_db")
public class TrainerEntity {
    private long idTrainer;
    private String nameTrainer;
    private Long idNumberFk;
    private Collection<ClubTrainerEntity> clubTrainersByIdTrainer;
    private Collection<SectionEntity> sectionsByIdTrainer;
    private NumberEntity numberByIdNumberFk;
    private Collection<TrainerSportEntity> trainerSportsByIdTrainer;

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

    @Basic
    @Column(name = "id_number_fk", nullable = true)
    public Long getIdNumberFk() {
        return idNumberFk;
    }

    public void setIdNumberFk(Long idNumberFk) {
        this.idNumberFk = idNumberFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainerEntity that = (TrainerEntity) o;

        if (idTrainer != that.idTrainer) return false;
        if (nameTrainer != null ? !nameTrainer.equals(that.nameTrainer) : that.nameTrainer != null) return false;
        if (idNumberFk != null ? !idNumberFk.equals(that.idNumberFk) : that.idNumberFk != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idTrainer ^ (idTrainer >>> 32));
        result = 31 * result + (nameTrainer != null ? nameTrainer.hashCode() : 0);
        result = 31 * result + (idNumberFk != null ? idNumberFk.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "trainerByIdTrainer")
    public Collection<ClubTrainerEntity> getClubTrainersByIdTrainer() {
        return clubTrainersByIdTrainer;
    }

    public void setClubTrainersByIdTrainer(Collection<ClubTrainerEntity> clubTrainersByIdTrainer) {
        this.clubTrainersByIdTrainer = clubTrainersByIdTrainer;
    }

    @OneToMany(mappedBy = "trainerByIdTrainerFk")
    public Collection<SectionEntity> getSectionsByIdTrainer() {
        return sectionsByIdTrainer;
    }

    public void setSectionsByIdTrainer(Collection<SectionEntity> sectionsByIdTrainer) {
        this.sectionsByIdTrainer = sectionsByIdTrainer;
    }

    @ManyToOne
    @JoinColumn(name = "id_number_fk", referencedColumnName = "id_number", insertable = false, updatable = false)
    public NumberEntity getNumberByIdNumberFk() {
        return numberByIdNumberFk;
    }

    public void setNumberByIdNumberFk(NumberEntity numberByIdNumberFk) {
        this.numberByIdNumberFk = numberByIdNumberFk;
    }

    @OneToMany(mappedBy = "trainerByIdTrainerFk")
    public Collection<TrainerSportEntity> getTrainerSportsByIdTrainer() {
        return trainerSportsByIdTrainer;
    }

    public void setTrainerSportsByIdTrainer(Collection<TrainerSportEntity> trainerSportsByIdTrainer) {
        this.trainerSportsByIdTrainer = trainerSportsByIdTrainer;
    }
}

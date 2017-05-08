package dao;

import javax.persistence.*;

/**
 * Created by LevchukK.E. on 08.05.17.
 */
@Entity
@Table(name = "section", schema = "public", catalog = "ysh_db")
public class SectionEntity {
    private long idSection;
    private Long sectionFk;
    private Long idAgeFk;
    private String schedule;
    private Long idTrainerFk;
    private ClubSportEntity clubSportBySectionFk;
    private AgeEntity ageByIdAgeFk;
    private TrainerEntity trainerByIdTrainerFk;

    @Id
    @Column(name = "id_section", nullable = false)
    public long getIdSection() {
        return idSection;
    }

    public void setIdSection(long idSection) {
        this.idSection = idSection;
    }

    @Basic
    @Column(name = "section_fk", nullable = true)
    public Long getSectionFk() {
        return sectionFk;
    }

    public void setSectionFk(Long sectionFk) {
        this.sectionFk = sectionFk;
    }

    @Basic
    @Column(name = "id_age_fk", nullable = true)
    public Long getIdAgeFk() {
        return idAgeFk;
    }

    public void setIdAgeFk(Long idAgeFk) {
        this.idAgeFk = idAgeFk;
    }

    @Basic
    @Column(name = "schedule", nullable = true, length = -1)
    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @Basic
    @Column(name = "id_trainer_fk", nullable = true)
    public Long getIdTrainerFk() {
        return idTrainerFk;
    }

    public void setIdTrainerFk(Long idTrainerFk) {
        this.idTrainerFk = idTrainerFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SectionEntity that = (SectionEntity) o;

        if (idSection != that.idSection) return false;
        if (sectionFk != null ? !sectionFk.equals(that.sectionFk) : that.sectionFk != null) return false;
        if (idAgeFk != null ? !idAgeFk.equals(that.idAgeFk) : that.idAgeFk != null) return false;
        if (schedule != null ? !schedule.equals(that.schedule) : that.schedule != null) return false;
        if (idTrainerFk != null ? !idTrainerFk.equals(that.idTrainerFk) : that.idTrainerFk != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idSection ^ (idSection >>> 32));
        result = 31 * result + (sectionFk != null ? sectionFk.hashCode() : 0);
        result = 31 * result + (idAgeFk != null ? idAgeFk.hashCode() : 0);
        result = 31 * result + (schedule != null ? schedule.hashCode() : 0);
        result = 31 * result + (idTrainerFk != null ? idTrainerFk.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "section_fk", referencedColumnName = "id_club_sport", insertable = false, updatable = false)
    public ClubSportEntity getClubSportBySectionFk() {
        return clubSportBySectionFk;
    }

    public void setClubSportBySectionFk(ClubSportEntity clubSportBySectionFk) {
        this.clubSportBySectionFk = clubSportBySectionFk;
    }

    @ManyToOne
    @JoinColumn(name = "id_age_fk", referencedColumnName = "id_age", insertable = false, updatable = false)
    public AgeEntity getAgeByIdAgeFk() {
        return ageByIdAgeFk;
    }

    public void setAgeByIdAgeFk(AgeEntity ageByIdAgeFk) {
        this.ageByIdAgeFk = ageByIdAgeFk;
    }

    @ManyToOne
    @JoinColumn(name = "id_trainer_fk", referencedColumnName = "id_trainer", insertable = false, updatable = false)
    public TrainerEntity getTrainerByIdTrainerFk() {
        return trainerByIdTrainerFk;
    }

    public void setTrainerByIdTrainerFk(TrainerEntity trainerByIdTrainerFk) {
        this.trainerByIdTrainerFk = trainerByIdTrainerFk;
    }
}

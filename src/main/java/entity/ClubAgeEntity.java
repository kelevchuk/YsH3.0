package entity;

import javax.persistence.*;

/**
 * Created by LevchukK.E. on 04.05.17.
 */
@Entity
@Table(name = "club_age", schema = "public", catalog = "ysh_db")
public class ClubAgeEntity {
    private long idClubAge;
    private Long idClub;
    private Long idAge;
    private ClubEntity clubByIdClub;
    private AgeEntity ageByIdAge;

    @Id
    @Column(name = "id_club_age", nullable = false)
    public long getIdClubAge() {
        return idClubAge;
    }

    public void setIdClubAge(long idClubAge) {
        this.idClubAge = idClubAge;
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
    @Column(name = "id_age", nullable = true)
    public Long getIdAge() {
        return idAge;
    }

    public void setIdAge(Long idAge) {
        this.idAge = idAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClubAgeEntity that = (ClubAgeEntity) o;

        if (idClubAge != that.idClubAge) return false;
        if (idClub != null ? !idClub.equals(that.idClub) : that.idClub != null) return false;
        if (idAge != null ? !idAge.equals(that.idAge) : that.idAge != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idClubAge ^ (idClubAge >>> 32));
        result = 31 * result + (idClub != null ? idClub.hashCode() : 0);
        result = 31 * result + (idAge != null ? idAge.hashCode() : 0);
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
    @JoinColumn(name = "id_age", referencedColumnName = "id_age", insertable = false, updatable = false)
    public AgeEntity getAgeByIdAge() {
        return ageByIdAge;
    }

    public void setAgeByIdAge(AgeEntity ageByIdAge) {
        this.ageByIdAge = ageByIdAge;
    }
}

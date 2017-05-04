package entity;

import javax.persistence.*;

/**
 * Created by LevchukK.E. on 04.05.17.
 */
@Entity
@Table(name = "club_number", schema = "public", catalog = "ysh_db")
public class ClubNumberEntity {
    private long idClubNumber;
    private Long idClub;
    private Long idNumber;
    private ClubEntity clubByIdClub;
    private NumberEntity numberByIdClub;

    @Id
    @Column(name = "id_club_number", nullable = false)
    public long getIdClubNumber() {
        return idClubNumber;
    }

    public void setIdClubNumber(long idClubNumber) {
        this.idClubNumber = idClubNumber;
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
    @Column(name = "id_number", nullable = true)
    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClubNumberEntity that = (ClubNumberEntity) o;

        if (idClubNumber != that.idClubNumber) return false;
        if (idClub != null ? !idClub.equals(that.idClub) : that.idClub != null) return false;
        if (idNumber != null ? !idNumber.equals(that.idNumber) : that.idNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idClubNumber ^ (idClubNumber >>> 32));
        result = 31 * result + (idClub != null ? idClub.hashCode() : 0);
        result = 31 * result + (idNumber != null ? idNumber.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_club", referencedColumnName = "id_club",  insertable = false, updatable = false)
    public ClubEntity getClubByIdClub() {
        return clubByIdClub;
    }

    public void setClubByIdClub(ClubEntity clubByIdClub) {
        this.clubByIdClub = clubByIdClub;
    }

    @ManyToOne
    @JoinColumn(name = "id_club", referencedColumnName = "id_number",  insertable = false, updatable = false)
    public NumberEntity getNumberByIdClub() {
        return numberByIdClub;
    }

    public void setNumberByIdClub(NumberEntity numberByIdClub) {
        this.numberByIdClub = numberByIdClub;
    }
}

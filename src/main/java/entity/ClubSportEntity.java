package entity;

import javax.persistence.*;

/**
 * Created by LevchukK.E. on 04.05.17.
 */
@Entity
@Table(name = "club_sport", schema = "public", catalog = "ysh_db")
public class ClubSportEntity {
    private long idClubSport;
    private Long idClub;
    private Long idSport;
    private ClubEntity clubByIdClub;
    private SportTypeEntity sportTypeByIdSport;

    @Id
    @Column(name = "id_club_sport", nullable = false)
    public long getIdClubSport() {
        return idClubSport;
    }

    public void setIdClubSport(long idClubSport) {
        this.idClubSport = idClubSport;
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
    @Column(name = "id_sport", nullable = true)
    public Long getIdSport() {
        return idSport;
    }

    public void setIdSport(Long idSport) {
        this.idSport = idSport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClubSportEntity that = (ClubSportEntity) o;

        if (idClubSport != that.idClubSport) return false;
        if (idClub != null ? !idClub.equals(that.idClub) : that.idClub != null) return false;
        if (idSport != null ? !idSport.equals(that.idSport) : that.idSport != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idClubSport ^ (idClubSport >>> 32));
        result = 31 * result + (idClub != null ? idClub.hashCode() : 0);
        result = 31 * result + (idSport != null ? idSport.hashCode() : 0);
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
    @JoinColumn(name = "id_sport", referencedColumnName = "id_sport", insertable = false, updatable = false)
    public SportTypeEntity getSportTypeByIdSport() {
        return sportTypeByIdSport;
    }

    public void setSportTypeByIdSport(SportTypeEntity sportTypeByIdSport) {
        this.sportTypeByIdSport = sportTypeByIdSport;
    }
}

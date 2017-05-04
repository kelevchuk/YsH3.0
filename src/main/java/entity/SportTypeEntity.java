package entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by LevchukK.E. on 04.05.17.
 */
@Entity
@Table(name = "sport_type", schema = "public", catalog = "ysh_db")
public class SportTypeEntity {
    private long idSport;
    private String nameSport;
    private Collection<ClubSportEntity> clubSportsByIdSport;

    @Id
    @Column(name = "id_sport", nullable = false)
    public long getIdSport() {
        return idSport;
    }

    public void setIdSport(long idSport) {
        this.idSport = idSport;
    }

    @Basic
    @Column(name = "name_sport", nullable = true, length = -1)
    public String getNameSport() {
        return nameSport;
    }

    public void setNameSport(String nameSport) {
        this.nameSport = nameSport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SportTypeEntity that = (SportTypeEntity) o;

        if (idSport != that.idSport) return false;
        if (nameSport != null ? !nameSport.equals(that.nameSport) : that.nameSport != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idSport ^ (idSport >>> 32));
        result = 31 * result + (nameSport != null ? nameSport.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "sportTypeByIdSport")
    public Collection<ClubSportEntity> getClubSportsByIdSport() {
        return clubSportsByIdSport;
    }

    public void setClubSportsByIdSport(Collection<ClubSportEntity> clubSportsByIdSport) {
        this.clubSportsByIdSport = clubSportsByIdSport;
    }
}

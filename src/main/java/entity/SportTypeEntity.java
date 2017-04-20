package entity;

import javax.persistence.*;

/**
 * Created by LevchukK.E. on 19.04.17.
 */
@Entity
@Table(name = "sport_type", schema = "public", catalog = "ysh_db")
public class SportTypeEntity {
    private long id;
    private String sportName;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sport_name")
    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SportTypeEntity that = (SportTypeEntity) o;

        if (id != that.id) return false;
        if (sportName != null ? !sportName.equals(that.sportName) : that.sportName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (sportName != null ? sportName.hashCode() : 0);
        return result;
    }
}

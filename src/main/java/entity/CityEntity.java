package entity;

import javax.persistence.*;

/**
 * Created by LevchukK.E. on 21.04.17.
 */
@Entity
@Table(name = "city", schema = "public", catalog = "ysh_db")
public class CityEntity {
    private long idCity;
    private String nameCity;

    @Id
    @Column(name = "id_city")
    public long getIdCity() {
        return idCity;
    }

    public void setIdCity(long idCity) {
        this.idCity = idCity;
    }

    @Basic
    @Column(name = "name_city")
    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityEntity that = (CityEntity) o;

        if (idCity != that.idCity) return false;
        if (nameCity != null ? !nameCity.equals(that.nameCity) : that.nameCity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idCity ^ (idCity >>> 32));
        result = 31 * result + (nameCity != null ? nameCity.hashCode() : 0);
        return result;
    }
}

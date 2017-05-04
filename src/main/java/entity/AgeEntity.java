package entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by LevchukK.E. on 04.05.17.
 */
@Entity
@Table(name = "age", schema = "public", catalog = "ysh_db")
public class AgeEntity {
    private long idAge;
    private String valueAge;
    private String value;
    private Collection<ClubAgeEntity> clubAgesByIdAge;

    @Id
    @Column(name = "id_age", nullable = false)
    public long getIdAge() {
        return idAge;
    }

    public void setIdAge(long idAge) {
        this.idAge = idAge;
    }

    @Basic
    @Column(name = "value_age", nullable = true, length = -1)
    public String getValueAge() {
        return valueAge;
    }

    public void setValueAge(String valueAge) {
        this.valueAge = valueAge;
    }

    @Basic
    @Column(name = "value", nullable = true, length = 255)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AgeEntity ageEntity = (AgeEntity) o;

        if (idAge != ageEntity.idAge) return false;
        if (valueAge != null ? !valueAge.equals(ageEntity.valueAge) : ageEntity.valueAge != null) return false;
        if (value != null ? !value.equals(ageEntity.value) : ageEntity.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idAge ^ (idAge >>> 32));
        result = 31 * result + (valueAge != null ? valueAge.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "ageByIdAge")
    public Collection<ClubAgeEntity> getClubAgesByIdAge() {
        return clubAgesByIdAge;
    }

    public void setClubAgesByIdAge(Collection<ClubAgeEntity> clubAgesByIdAge) {
        this.clubAgesByIdAge = clubAgesByIdAge;
    }
}

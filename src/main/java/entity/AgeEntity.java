package entity;

import javax.persistence.*;

/**
 * Created by armen on 18.04.2017.
 */
@Entity
@Table(name = "age", schema = "public", catalog = "ysh_db")
public class AgeEntity {
    private long idAge;
    private String value;

    @Id
    @Column(name = "id_age", nullable = false)
    public long getIdAge() {
        return idAge;
    }

    public void setIdAge(long idAge) {
        this.idAge = idAge;
    }

    @Basic
    @Column(name = "value", nullable = true, length = -1)
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
        if (value != null ? !value.equals(ageEntity.value) : ageEntity.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idAge ^ (idAge >>> 32));
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}

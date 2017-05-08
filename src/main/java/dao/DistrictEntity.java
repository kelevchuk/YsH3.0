package dao;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by LevchukK.E. on 08.05.17.
 */
@Entity
@Table(name = "district", schema = "public", catalog = "ysh_db")
public class DistrictEntity {
    private long idDistrict;
    private String nameDistrict;
    private Collection<AddressEntity> addressesByIdDistrict;

    @Id
    @Column(name = "id_district", nullable = false)
    public long getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(long idDistrict) {
        this.idDistrict = idDistrict;
    }

    @Basic
    @Column(name = "name_district", nullable = true, length = -1)
    public String getNameDistrict() {
        return nameDistrict;
    }

    public void setNameDistrict(String nameDistrict) {
        this.nameDistrict = nameDistrict;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DistrictEntity that = (DistrictEntity) o;

        if (idDistrict != that.idDistrict) return false;
        if (nameDistrict != null ? !nameDistrict.equals(that.nameDistrict) : that.nameDistrict != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idDistrict ^ (idDistrict >>> 32));
        result = 31 * result + (nameDistrict != null ? nameDistrict.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "districtByDistrict")
    public Collection<AddressEntity> getAddressesByIdDistrict() {
        return addressesByIdDistrict;
    }

    public void setAddressesByIdDistrict(Collection<AddressEntity> addressesByIdDistrict) {
        this.addressesByIdDistrict = addressesByIdDistrict;
    }
}

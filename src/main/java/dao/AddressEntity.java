package dao;

import javax.persistence.*;

/**
 * Created by LevchukK.E. on 08.05.17.
 */
@Entity
@Table(name = "address", schema = "public", catalog = "ysh_db")
public class AddressEntity {
    private long idAddress;
    private String valueAddress;
    private Long district;
    private Long city;
    private Float coordX;
    private Float coordY;
    private DistrictEntity districtByDistrict;
    private CityEntity cityByCity;
    private ClubEntity clubByIdAddress;

    @Id
    @Column(name = "id_address", nullable = false)
    public long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(long idAddress) {
        this.idAddress = idAddress;
    }

    @Basic
    @Column(name = "value_address", nullable = true, length = -1)
    public String getValueAddress() {
        return valueAddress;
    }

    public void setValueAddress(String valueAddress) {
        this.valueAddress = valueAddress;
    }

    @Basic
    @Column(name = "district", nullable = true)
    public Long getDistrict() {
        return district;
    }

    public void setDistrict(Long district) {
        this.district = district;
    }

    @Basic
    @Column(name = "city", nullable = true)
    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }

    @Basic
    @Column(name = "coord_x", nullable = true, precision = 0)
    public Float getCoordX() {
        return coordX;
    }

    public void setCoordX(Float coordX) {
        this.coordX = coordX;
    }

    @Basic
    @Column(name = "coord_y", nullable = true, precision = 0)
    public Float getCoordY() {
        return coordY;
    }

    public void setCoordY(Float coordY) {
        this.coordY = coordY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressEntity that = (AddressEntity) o;

        if (idAddress != that.idAddress) return false;
        if (valueAddress != null ? !valueAddress.equals(that.valueAddress) : that.valueAddress != null) return false;
        if (district != null ? !district.equals(that.district) : that.district != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (coordX != null ? !coordX.equals(that.coordX) : that.coordX != null) return false;
        if (coordY != null ? !coordY.equals(that.coordY) : that.coordY != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idAddress ^ (idAddress >>> 32));
        result = 31 * result + (valueAddress != null ? valueAddress.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (coordX != null ? coordX.hashCode() : 0);
        result = 31 * result + (coordY != null ? coordY.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "district", referencedColumnName = "id_district", insertable = false, updatable = false)
    public DistrictEntity getDistrictByDistrict() {
        return districtByDistrict;
    }

    public void setDistrictByDistrict(DistrictEntity districtByDistrict) {
        this.districtByDistrict = districtByDistrict;
    }

    @ManyToOne
    @JoinColumn(name = "city", referencedColumnName = "id_city", insertable = false, updatable = false)
    public CityEntity getCityByCity() {
        return cityByCity;
    }

    public void setCityByCity(CityEntity cityByCity) {
        this.cityByCity = cityByCity;
    }

    @OneToOne(mappedBy = "addressByIdClub")
    public ClubEntity getClubByIdAddress() {
        return clubByIdAddress;
    }

    public void setClubByIdAddress(ClubEntity clubByIdAddress) {
        this.clubByIdAddress = clubByIdAddress;
    }
}

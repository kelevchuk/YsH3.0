package dao;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by LevchukK.E. on 08.05.17.
 */
@Entity
@Table(name = "club", schema = "public", catalog = "ysh_db")
public class ClubEntity {
    private long idClub;
    private String nameClub;
    private Long address;
    private AddressEntity addressByIdClub;
    private Collection<ClubAgeEntity> clubAgesByIdClub;
    private Collection<ClubNumberEntity> clubNumbersByIdClub;
    private Collection<ClubSportEntity> clubSportsByIdClub;
    private Collection<ClubTrainerEntity> clubTrainersByIdClub;

    @Id
    @Column(name = "id_club", nullable = false)
    public long getIdClub() {
        return idClub;
    }

    public void setIdClub(long idClub) {
        this.idClub = idClub;
    }

    @Basic
    @Column(name = "name_club", nullable = true, length = -1)
    public String getNameClub() {
        return nameClub;
    }

    public void setNameClub(String nameClub) {
        this.nameClub = nameClub;
    }

    @Basic
    @Column(name = "address", nullable = true)
    public Long getAddress() {
        return address;
    }

    public void setAddress(Long address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClubEntity that = (ClubEntity) o;

        if (idClub != that.idClub) return false;
        if (nameClub != null ? !nameClub.equals(that.nameClub) : that.nameClub != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idClub ^ (idClub >>> 32));
        result = 31 * result + (nameClub != null ? nameClub.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "id_club", referencedColumnName = "id_address", nullable = false, insertable = false, updatable = false)
    public AddressEntity getAddressByIdClub() {
        return addressByIdClub;
    }

    public void setAddressByIdClub(AddressEntity addressByIdClub) {
        this.addressByIdClub = addressByIdClub;
    }

    @OneToMany(mappedBy = "clubByIdClub")
    public Collection<ClubAgeEntity> getClubAgesByIdClub() {
        return clubAgesByIdClub;
    }

    public void setClubAgesByIdClub(Collection<ClubAgeEntity> clubAgesByIdClub) {
        this.clubAgesByIdClub = clubAgesByIdClub;
    }

    @OneToMany(mappedBy = "clubByIdClub")
    public Collection<ClubNumberEntity> getClubNumbersByIdClub() {
        return clubNumbersByIdClub;
    }

    public void setClubNumbersByIdClub(Collection<ClubNumberEntity> clubNumbersByIdClub) {
        this.clubNumbersByIdClub = clubNumbersByIdClub;
    }

    @OneToMany(mappedBy = "clubByIdClub")
    public Collection<ClubSportEntity> getClubSportsByIdClub() {
        return clubSportsByIdClub;
    }

    public void setClubSportsByIdClub(Collection<ClubSportEntity> clubSportsByIdClub) {
        this.clubSportsByIdClub = clubSportsByIdClub;
    }

    @OneToMany(mappedBy = "clubByIdClub")
    public Collection<ClubTrainerEntity> getClubTrainersByIdClub() {
        return clubTrainersByIdClub;
    }

    public void setClubTrainersByIdClub(Collection<ClubTrainerEntity> clubTrainersByIdClub) {
        this.clubTrainersByIdClub = clubTrainersByIdClub;
    }
}

package entity;

import javax.persistence.*;

/**
 * Created by LevchukK.E. on 21.04.17.
 */
@Entity
@Table(name = "full_clubs", schema = "public", catalog = "ysh_db")
public class FullClubsEntity {
    private long clubId;
    private String name;
    private Long sportFk;
    private Long age;
    private Long noteFk;
    private String address;
    private String contactInf;
    private Long cityFk;

    @Id
    @Column(name = "club_id")
    public long getClubId() {
        return clubId;
    }

    public void setClubId(long clubId) {
        this.clubId = clubId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sport_fk")
    public Long getSportFk() {
        return sportFk;
    }

    public void setSportFk(Long sportFk) {
        this.sportFk = sportFk;
    }

    @Basic
    @Column(name = "age")
    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    @Basic
    @Column(name = "note_fk")
    public Long getNoteFk() {
        return noteFk;
    }

    public void setNoteFk(Long noteFk) {
        this.noteFk = noteFk;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "contact_inf")
    public String getContactInf() {
        return contactInf;
    }

    public void setContactInf(String contactInf) {
        this.contactInf = contactInf;
    }

    @Basic
    @Column(name = "city_fk")
    public Long getCityFk() {
        return cityFk;
    }

    public void setCityFk(Long cityFk) {
        this.cityFk = cityFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FullClubsEntity that = (FullClubsEntity) o;

        if (clubId != that.clubId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (sportFk != null ? !sportFk.equals(that.sportFk) : that.sportFk != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (noteFk != null ? !noteFk.equals(that.noteFk) : that.noteFk != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (contactInf != null ? !contactInf.equals(that.contactInf) : that.contactInf != null) return false;
        if (cityFk != null ? !cityFk.equals(that.cityFk) : that.cityFk != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (clubId ^ (clubId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sportFk != null ? sportFk.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (noteFk != null ? noteFk.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (contactInf != null ? contactInf.hashCode() : 0);
        result = 31 * result + (cityFk != null ? cityFk.hashCode() : 0);
        return result;
    }
}

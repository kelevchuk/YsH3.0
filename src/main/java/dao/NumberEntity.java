package dao;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by LevchukK.E. on 08.05.17.
 */
@Entity
@Table(name = "number", schema = "public", catalog = "ysh_db")
public class NumberEntity {
    private long idNumber;
    private String number;
    private Collection<ClubNumberEntity> clubNumbersByIdNumber;
    private Collection<TrainerEntity> trainersByIdNumber;

    @Id
    @Column(name = "id_number", nullable = false)
    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    @Basic
    @Column(name = "number", nullable = true, length = -1)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NumberEntity that = (NumberEntity) o;

        if (idNumber != that.idNumber) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idNumber ^ (idNumber >>> 32));
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "numberByIdNumber")
    public Collection<ClubNumberEntity> getClubNumbersByIdNumber() {
        return clubNumbersByIdNumber;
    }

    public void setClubNumbersByIdNumber(Collection<ClubNumberEntity> clubNumbersByIdNumber) {
        this.clubNumbersByIdNumber = clubNumbersByIdNumber;
    }

    @OneToMany(mappedBy = "numberByIdNumberFk")
    public Collection<TrainerEntity> getTrainersByIdNumber() {
        return trainersByIdNumber;
    }

    public void setTrainersByIdNumber(Collection<TrainerEntity> trainersByIdNumber) {
        this.trainersByIdNumber = trainersByIdNumber;
    }
}

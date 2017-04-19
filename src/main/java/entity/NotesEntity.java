package entity;

import javax.persistence.*;

/**
 * Created by armen on 18.04.2017.
 */
@Entity
@Table(name = "notes", schema = "public", catalog = "ysh_db")
public class NotesEntity {
    private long id;
    private String noteName;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "note_name", nullable = true, length = -1)
    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotesEntity that = (NotesEntity) o;

        if (id != that.id) return false;
        if (noteName != null ? !noteName.equals(that.noteName) : that.noteName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (noteName != null ? noteName.hashCode() : 0);
        return result;
    }
}

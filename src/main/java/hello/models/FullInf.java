package hello.models;

/**
 * Created by LevchukK.E. on 04.05.17.
 */
public class FullInf {
    private final Object nameClub;
    private final Object nameSports;
    private final Object coach;
    private final Object number;

    public FullInf(Object nameClub, Object nameSports, Object coach, Object number) {
        this.nameClub = nameClub;
        this.nameSports = nameSports;
        this.coach = coach;
        this.number = number;
    }

    public Object getNameClub() {
        return nameClub;
    }

    public Object getNameSports() {
        return nameSports;
    }

    public Object getCoach() {
        return coach;
    }

    public Object getNumber() {
        return number;
    }
}

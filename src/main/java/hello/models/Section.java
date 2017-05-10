package hello.models;

/**
 * Created by LevchukK.E. on 08.05.17.
 */
public class Section {
    private final Object section;
    private final Object numberSection;

    public Section(Object section, Object numberSection) {
        this.section = section;
        this.numberSection = numberSection;
    }

    public Object getSection() {
        return section;
    }

    public Object getNumberSection() {
        return numberSection;
    }
}

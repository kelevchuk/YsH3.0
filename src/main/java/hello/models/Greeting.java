package hello.models;

public class Greeting {


    private final Object content;
    private final Object sas;

    public Greeting(Object content, Object sas) {
        this.content = content;
        this.sas = sas;
    }


    public Object getContent() {
        return content;
    }

    public Object getSas() {
        return sas;
    }
}

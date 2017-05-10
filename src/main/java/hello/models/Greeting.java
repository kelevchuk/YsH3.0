package hello.models;

public class Greeting {


    private final Object content;

    public Greeting(Object content) {
        this.content = content;
    }


    public Object getContent() {
        return content;
    }

}

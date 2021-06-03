public class Node {
    public String object ;
    public String value;

    public Node(String object, String value) {
        this.object = object;
        this.value = value;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" +
                "object='" + object + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

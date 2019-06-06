package code.flatura.expendit.model;

public class ConsumableType extends AbstractNamedEntity {
    private String comments;

    public ConsumableType(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "ConsumableType{" +
                "comments='" + comments + '\'' +
                "} " + super.toString();
    }
}

public class HashTag {
    private long id;
    private String text;
    private static long hashtagID=0;
    public HashTag(String text) {
        this.id = hashtagID++;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

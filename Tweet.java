import LinkedList.MyLinkedListImpl;

import java.time.LocalDate;

public class Tweet {
    private long id;
    private User user;
    private LocalDate date;
    private String content;
    private String source;
    private boolean isRetweet;
    private MyLinkedListImpl<HashTag> tweetHashtags;
    private static long tweetID = 0;
    public Tweet(User user, LocalDate date, String content, String source, boolean isRetweet) {
        this.id = tweetID++;
        this.user = user;
        this.date = date;
        this.content = content;
        this.source = source;
        this.isRetweet = isRetweet;
        this.tweetHashtags = new MyLinkedListImpl<>();
    }

    public void addHashtag(HashTag hashTagToAdd) {
        this.tweetHashtags.add(hashTagToAdd);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isRetweet() {
        return isRetweet;
    }

    public void setRetweet(boolean retweet) {
        isRetweet = retweet;
    }

    public MyLinkedListImpl<HashTag> getTweetHashtags() {
        return tweetHashtags;
    }

    public void setTweetHashtags(MyLinkedListImpl<HashTag> tweetHashtags) {
        this.tweetHashtags = tweetHashtags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public static long getTweetID() {
        return tweetID;
    }

    public static void setTweetID(long tweetID) {
        Tweet.tweetID = tweetID;
    }
}

package zack.san.watcho;

import java.util.Date;

import io.realm.RealmObject;

public class Anime extends RealmObject {


    private String title;
    private int Episodes;
    private int progress;
    private int score;
    private Date startDate;
    private Date endDate;
    private String imageUrl;

    public Anime() {
    }

    public Anime(String title) {
        this.title = title;
    }

    public Anime(String title, int episodes, String imageUrl) {
        this.title = title;
        Episodes = episodes;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEpisodes() {
        return Episodes;
    }

    public void setEpisodes(int episodes) {
        Episodes = episodes;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}

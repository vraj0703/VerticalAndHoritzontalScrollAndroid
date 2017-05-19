package raj.io.verticalandhoritzontalscrollandroid.model;

/**
 * Created by vraj0 on 18-May-17.
 */

public class HorizontalScrollItemModel {

    private String title;
    private int color;
    private int rating;
    private boolean isFree;

    public HorizontalScrollItemModel(String title, int color, int rating, boolean isFree) {
        this.title = title;
        this.color = color;
        this.rating = rating;
        this.isFree = isFree;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}

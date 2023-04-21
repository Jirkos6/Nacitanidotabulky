public class Deskovky {
    private String name;
    private Boolean bought;
    private int rating;


    public Deskovky(String name, Boolean bought, int rating) {
        this.name = name;
        this.bought = bought;
        this.rating = rating;
    }

    public String getJmeno() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getBought() {
        return bought;
    }

    public void setBought(Boolean bought) {
        this.bought = bought;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return name;
    }

}

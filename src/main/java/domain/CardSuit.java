package domain;

public enum CardSuit {
    SPADE("♠", "SPADE"),
    HEART("♥", "HEART"),
    DIAMOND("♦", "DIAMOND"),
    CLUB("♣", "CLUB");

    private String picture;
    private String title;

    CardSuit(String picture, String title) {
        this.picture = picture;
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static boolean contains(String title){
        for(CardSuit cardSuit : CardSuit.values()){
            if(cardSuit.name().equalsIgnoreCase(title)){
                return true;
            }
        }
        return false;
    }
}

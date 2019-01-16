package daoexample;

public class Article {

    private int artcleId;
    private String title;
    private int idUser;

    public Article(int artcleId, String title, int idUser) {
        this.artcleId = artcleId;
        this.title = title;
        this.idUser = idUser;
    }

    public void setArtcleId(int artcleId) {
        this.artcleId = artcleId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getArtcleId() {
        return artcleId;
    }

    public String getTitle() {
        return title;
    }

    public int getIdUser() {
        return idUser;
    }
}


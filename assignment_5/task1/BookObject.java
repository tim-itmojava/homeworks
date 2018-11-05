package assignment_5.task1;

public class BookObject {

    private String title;
    private String author;
    private int pageNum;

    public BookObject() {
    }

    public BookObject(String title, String author, int pageNum) {
        this.author = author;
        this. title = title;
        System.out.println("A new book comes to live ... " + this.author + " || " + this.title);

        if (pageNum > 0) this.pageNum = pageNum;
        else { System.out.println("Please provide a correct number of pages in the book " + this.title + " written by " + this.author);
            System.exit(10); }
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPageNum() {
        return pageNum;
    }

    @Override
    public String toString() {
        return "BookObject{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

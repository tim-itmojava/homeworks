package assignment_4;

import java.util.ArrayList;

public class Task_3 {

    public static void main(String[] args) {

        Book book1 = new Book("The war and peace", "Leo Tolstoy", 589);
        Book book2 = new Book("Ulyses", "James Joyce", 896);
        Book book3 = new Book("Lolita", "Nabokov", 452);
        Book book4 = new Book("Brief history of time", "Hawking", 156);

        Library afterJoyce = new Library(5);

        // depositing the books
        afterJoyce.depositBooks(book1, book2, book3, book4);

        // checking if a book is in the Library
        afterJoyce.checkIfBookThere("Brief history of time", "Hooking", 156);

    }
}

class Library {

    private ArrayList<Book> collection;
    private int capacity;

    public Library (int capacity) {
        this.capacity = capacity;
        this.collection = new ArrayList<>(capacity);
        System.out.println("Instantiating a Library with book capacity = " + this.capacity);
    }

    public void depositBooks (Book ... books) {

        int counter = 0;

        for(Book e:books) counter++;

        if (this.collection.size() + counter > this.capacity) { System.out.println("Cannot take any more books in the collection");
            System.exit(10); }

        else {

            for(Book e:books) {
                System.out.println("I am depositing the books being handed over... and it's " + e.toString());
                this.collection.add(e);

            }
        }

        System.out.println("All books handed over have been deposited. Number of books in Library = " + this.collection.size());
        System.out.println("=========================================");

    }

    public void checkIfBookThere (String aTitle, String anAuthor, int aPageNum) {

        Book temp = new Book();
        int event = 0;

        for (int i = 0; i < this.collection.size(); i++) {
            temp = this.collection.get(i);

            if (temp.getAuthor().equals(anAuthor) && temp.getTitle().equals(aTitle) && temp.getPageNum() == aPageNum) {
                System.out.println("There is an item of the requested book in the library "); event++;
            }
            else if (event == 0 && (i == this.collection.size() - 1)) {
                System.out.println("Looking for a book ... but cannot find any. Sorry");
            }
        }
    }
}

class Book {

        private String title;
        private String author;
        private int pageNum;

    public Book() {
    }

    public Book(String title, String author, int pageNum) {
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
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
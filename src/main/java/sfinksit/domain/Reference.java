package sfinksit.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Reference extends AbstractPersistable<Long> {

<<<<<<< HEAD
    // public long id;
    public String author;
    public String title;
    public String journal;
    public int volume;
    public int number;
    public int year;
    public int startPage;
    public int endPage;
    public String publisher;
    public String address;
=======
    private String author;
    private String title;
    private String journal;
    private int volume;
    private int number;
    private int year;
    private int startPage;
    private int endPage;
    private String publisher;
    private String address;
>>>>>>> 17ac1d7680bea28f5584ae9a0e5cb78b7150bc26

   
//getterit
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getJournal() {
        return journal;
    }

    public int getVolume() {
        return volume;
    }

    public int getNumber() {
        return number;
    }

    public int getYear() {
        return year;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAddress() {
        return address;
    }

//setterit
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}

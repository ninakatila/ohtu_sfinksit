package sfinksit.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;

public class Reference extends AbstractPersistable<Long> {

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

}

package sfinksit.domain;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Reference extends AbstractPersistable<Long> {

    @NotBlank
    @Size(min = 4)
    public String author;

    @NotBlank
    @Size(min = 4)
    public String title;

    @NotBlank
    @Size(min = 4)
    public String journal;

    @Min(value = 0)
    public int volume;

    @Min(value = 0)
    public int number;

    @Min(value = 0)
    public int year;

    @Min(value = 0)
    public int startPage;

    @Min(value = 0)
    public int endPage;

    @NotBlank
    @Size(min = 4)
    public String publisher;
    
    public String address;

    // getterit
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

    // setterit
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

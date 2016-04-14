package sfinksit.domain;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Article extends AbstractPersistable<Long> {

    @OneToOne
    public Reference reference;
    
    public String bibtexKey;
    
    @NotNull
    @Size(min = 4)
    public String journal;

    @Min(value = 0)
    public int volume;

    @Min(value = 0)
    public int number;
    
    @Min(value = 0)
    public int startPage;

    @Min(value = 0)
    public int endPage;
    
    public String address;
    
    // getterit
    public Reference getReference() {
        return this.reference;
    }
    
    public String getBibtexKey() {
        return this.bibtexKey;
    }
    
    public String getJournal() {
        return this.journal;
    }
    
    public int getVolume() {
        return this.volume;
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public int getStartPage() {
        return this.startPage;
    }
    
    public int getEndPage() {
        return this.endPage;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    // setterit
    public void setReference(Reference reference) {
        this.reference = reference;
    }
    
    public void setBibtexKey(String bibtexKey) {
        this.bibtexKey = bibtexKey;
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

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
}
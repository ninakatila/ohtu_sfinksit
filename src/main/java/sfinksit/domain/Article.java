package sfinksit.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Article extends AbstractPersistable<Long> {

    @OneToOne(mappedBy="article")
    public Reference reference;
    
    @NotBlank
    @Size(min = 4)
    public String journal;

    @Min(0)
    public Integer volume;

    @Min(0)
    public Integer number;
    
    @Min(0)
    public Integer startPage;

    @Min(0)
    public Integer endPage;
    
    public String address;
    
    // getterit
    public Reference getReference() {
        return this.reference;
    }
    
    public String getJournal() {
        return this.journal;
    }
    
    public Integer getVolume() {
        return this.volume;
    }
    
    public Integer getNumber() {
        return this.number;
    }
    
    public Integer getStartPage() {
        return this.startPage;
    }
    
    public Integer getEndPage() {
        return this.endPage;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    // setterit
    public void setReference(Reference reference) {
        this.reference = reference;
    }
    
    public void setJournal(String journal) {
        this.journal = journal;
    }
    
    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    public void setEndPage(Integer endPage) {
        this.endPage = endPage;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
}

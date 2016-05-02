package sfinksit.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Book extends AbstractPersistable<Long>{
    
    @OneToOne(mappedBy="book")
    public Reference ref;
    
    @Min(value = 0, message = "must be a positive number")
    public Integer volume;
    
    @Size(max = 70, message = "length must be below 70")
    public String series;
    
    @Size(max = 70, message = "length must be below 70")
    public String address;
    
    @Size(max = 70, message = "length must be below 70")
    public String edition;
    
    @Min(value = 1, message="must be between 1 and 12")
    @Max(value = 12, message="must be between 1 and 12")
    public Integer month;
    
    @Size(max = 70, message = "length must be below 70")
    public String note;
    
    public Reference getRef() {
        return ref;
    }
    
    public Reference setRef(Reference ref) {
        return this.ref = ref; 
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

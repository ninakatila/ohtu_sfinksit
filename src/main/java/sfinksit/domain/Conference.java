package sfinksit.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Conference extends AbstractPersistable<Long> {

    @OneToOne(mappedBy="conference")
    public Reference ref;
    
    @Size(max = 70, message = "length must be below 70")
    public String booktitle;
    
    @Size(max = 70, message = "length must be below 70")
    public String editor;
    
    @Min(value = 0, message = "must be a positive number")
    public Integer volume;
    
    @Size(max = 70, message = "length must be below 70")
    public String series;
    
    @Min(value = 0, message = "must be a positive number")
    public Integer startPage;
    
    @Min(value = 0, message = "must be a positive number")
    public Integer endPage;
    
    @Size(max = 70, message = "length must be below 70")
    public String address;
    
    @Min(value = 1, message = "must be between 1 and 12")
    @Max(value = 12, message = "must be between 1 and 12")
    public Integer month;
    
    @Size(max = 70, message = "length must be below 70")
    public String organization;
    
    @Size(max = 70, message = "length must be below 70")
    public String note;
    
    public Reference getRef() {
        return this.ref;
    }
    
    public void setRef(Reference ref) {
        this.ref = ref;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public Integer getStartPage() {
        return startPage;
    }

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    public Integer getEndPage() {
        return endPage;
    }

    public void setEndPage(Integer endPage) {
        this.endPage = endPage;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
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

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

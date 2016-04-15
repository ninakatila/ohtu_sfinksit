package sfinksit.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Conference extends AbstractPersistable<Long> {

    @OneToOne(mappedBy="conference")
    public Reference ref;
    public String booktitle;
    public String pages;
    public String startPage;
    public String endPage;
    
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

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getStartPage() {
        return startPage;
    }

    public void setStartPage(String startPage) {
        this.startPage = startPage;
    }

    public String getEndPage() {
        return endPage;
    }

    public void setEndPage(String endPage) {
        this.endPage = endPage;
    }
}

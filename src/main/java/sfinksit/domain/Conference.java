package sfinksit.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Conference extends AbstractPersistable<Long> {
    public Reference ref;
    public String booktitle;
    public String pages;
    public String startPage;
    public String endPage;
    
    public Reference getRef() {
        return getRef();
    }
    
    public Reference setRef(Reference ref) {
        return this.ref = ref;
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

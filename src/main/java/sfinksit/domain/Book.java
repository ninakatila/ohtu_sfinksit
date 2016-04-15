package sfinksit.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Book extends AbstractPersistable<Long>{
    
    @OneToOne(mappedBy="book")
    public Reference ref;
    public String edition;
    
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
}

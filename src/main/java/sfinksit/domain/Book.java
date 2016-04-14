package sfinksit.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Book extends AbstractPersistable<Long>{
    
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

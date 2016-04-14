package sfinksit.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Book extends AbstractPersistable<Long>{
    
    public Reference ref;
    
    public Reference getRef() {
        return ref;
    }
    
    public Reference setRe(Reference ref) {
        return this.ref = ref; 
    }
}

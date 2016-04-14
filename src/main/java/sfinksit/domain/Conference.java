package sfinksit.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Conference extends AbstractPersistable<Long> {
    public Reference ref;
    
    public Reference getConfId() {
        return ref;
    }
    
    public Reference setConfId(Reference ref) {
        return this.ref = ref;
    }
}

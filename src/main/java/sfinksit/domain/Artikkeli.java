package sfinksit.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Artikkeli extends AbstractPersistable<Long> {
    
    private String kirjoittaja;
    
    public String getKirjoittaja() {
        return this.kirjoittaja;
    }
    
    public void setKirjoittaja(String kirjoittaja) {
        this.kirjoittaja = kirjoittaja;
    }
}
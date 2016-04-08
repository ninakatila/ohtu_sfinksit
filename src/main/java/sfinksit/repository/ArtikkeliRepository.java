package sfinksit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfinksit.domain.Artikkeli;

public interface ArtikkeliRepository extends JpaRepository<Artikkeli, Long> {
    
}
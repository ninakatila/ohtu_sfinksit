package sfinksit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfinksit.domain.Reference;


public interface ReferenceRepository extends JpaRepository<Reference, Long> {
    
 
}
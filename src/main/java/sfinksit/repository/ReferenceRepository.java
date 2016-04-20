package sfinksit.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sfinksit.domain.Reference;


public interface ReferenceRepository extends JpaRepository<Reference, Long> {
    @Query("select u from Reference u where u.bibtexKey like %?1")
    List<Reference> findExistingBibtexKey(String bibtexKey);
 
}
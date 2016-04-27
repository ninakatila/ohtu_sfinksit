package sfinksit.repository;

import java.util.List;
import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sfinksit.domain.Reference;


public interface ReferenceRepository extends JpaRepository<Reference, Long> {    
    @Query("select u from Reference u where u.bibtexKey = ?1")
    List<Reference> findExistingBibtexKey(String bibtexKey);
    
    @Query("SELECT u from Reference u LEFT JOIN u.article a LEFT JOIN u.book b LEFT JOIN u.conference c WHERE u.bibtexKey = ?1 OR u.author = ?1 OR u.publisher = ?1 OR u.title = ?1 OR u.article.journal = ?1 OR u.article.address = ?1 OR u.book.series = ?1 OR u.book.address = ?1 OR u.book.edition = ?1 OR u.book.note = ?1 OR u.conference.booktitle = ?1 OR u.conference.editor = ?1 OR u.conference.series = ?1 OR u.conference.address = ?1 OR u.conference.organization = ?1 OR u.conference.note = ?1")
    List<Reference> findSearchTermFromAll(String searchTerm); 
    
    @Query("SELECT u from Reference u LEFT JOIN u.article a LEFT JOIN u.book b LEFT JOIN u.conference c WHERE u.year = ?1 OR u.article.volume = ?1 OR u.article.number = ?1 OR u.article.startPage = ?1 OR u.article.endPage = ?1 OR u.book.volume = ?1 OR u.book.month = ?1 OR u.conference.volume = ?1 OR u.conference.startPage = ?1 OR u.conference.endPage = ?1 OR u.conference.month = ?1")
    List<Reference> findSearchTermFromAllIntegers(int searchTerm);
    
    @Query("SELECT u from Reference u LEFT JOIN u.article a LEFT JOIN u.book b LEFT JOIN u.conference c WHERE u.bibtexKey = ?1 OR u.author = ?1 OR u.publisher = ?1 OR u.title = ?1 OR u.article.journal = ?1 OR u.article.address = ?1 OR u.book.series = ?1 OR u.book.address = ?1 OR u.book.edition = ?1 OR u.book.month = ?2 OR u.book.note = ?1 OR u.conference.booktitle = ?1 OR u.conference.editor = ?1 OR u.conference.series = ?1 OR u.conference.address = ?1 OR u.conference.organization = ?1 OR u.conference.note = ?1 OR u.year = ?2 OR u.article.volume = ?2 OR u.article.number = ?2 OR u.article.startPage = ?2 OR u.article.endPage = ?2 OR u.book.volume = ?2 OR u.book.month = ?2 OR u.conference.volume = ?2 OR u.conference.startPage = ?2 OR u.conference.endPage = ?2 OR u.conference.month = ?2")
    List<Reference> findSearchTermFromStringsAndIntegers(String searchTerm, int searchInt);
}
package sfinksit.repository;

import java.util.List;
import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sfinksit.domain.Reference;


public interface ReferenceRepository extends JpaRepository<Reference, Long> {
    String hakuehto1 ="select u from Reference u where u.bibtexKey like %?1 OR u.author like %?1";
    //String hakuehto2 = "select u from Reference u where u like%?1";
    String hakuehto3 = "select u from Reference u where u.bibtexKey like %?1";
    //String hakuehto4 = "select u from Reference u where u.author = "katto";
    String hakuehto5 = "select u from Reference u where u.bibtexKey = ?1 OR u.author = ?1 OR u.publisher = ?1 OR u.title = ?1 OR u.article.address = ?1";
    String searchWord = "select u from Reference u where u.bibtexKey = ?1 OR u.author = ?1 OR u.publisher = ?1 OR u.title = ?1 OR u.article.journal = ?1 OR u.article.address = ?1 OR u.book.series = ?1 OR u.book.address = ?1 OR u.book.edition = ?1 OR u.book.month = ?1 OR u.book.note = ?1 OR u.conference.booktitle = ?1 OR u.conference.editor = ?1 OR u.conference.series = ?1 OR u.conference.address = ?1 OR u.conference.organization = ?1 OR u.conference.note = ?1";
    
    @Query("select u from Reference u where u.bibtexKey = ?1")
    List<Reference> findExistingBibtexKey(String bibtexKey);
    
    //@Query("select u from Reference u where u.bibtexKey = :user", nativeQuery = true)
    //Reference findReference(@Param(value = "user");
    //findall palauttaa listan
    //nativeQuery = true
    
    @Query("select u from Reference u where u.bibtexKey = ?1 OR u.author = ?1 OR u.publisher = ?1 OR u.title = ?1 OR u.article.journal = ?1 OR u.article.address = ?1")
    List<Reference> findSearchFromArticle(String searchTerm);
    //select u from Reference u where u.bibtexKey = ?1 OR u.author = ?1 OR u.publisher = ?1 OR u.title = ?1 OR u.article.address = ?1
    //OR u.year = ?1
    
    @Query("select u from Reference u where u.bibtexKey = ?1 OR u.author = ?1 OR u.publisher = ?1 OR u.title = ?1 OR u.book.series = ?1 OR u.book.address = ?1 OR u.book.edition = ?1 OR u.book.month = ?1 OR u.book.note = ?1")
    List<Reference> findSearchFromBook(String searchTerm);
    
    @Query("select u from Reference u where u.bibtexKey = ?1 OR u.author = ?1 OR u.publisher = ?1 OR u.title = ?1 OR u.conference.booktitle = ?1 OR u.conference.editor = ?1 OR u.conference.series = ?1 OR u.conference.address = ?1 OR u.conference.organization = ?1 OR u.conference.note = ?1")
    List<Reference> findSearchFromConference(String searchTerm);
}
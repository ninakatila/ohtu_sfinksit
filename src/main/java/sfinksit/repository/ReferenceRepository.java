package sfinksit.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sfinksit.domain.Reference;


public interface ReferenceRepository extends JpaRepository<Reference, Long> {    
    @Query("select u from Reference u where u.bibtexKey = ?1")
    List<Reference> findExistingBibtexKey(String bibtexKey);
    
    @Query("SELECT u from Reference u LEFT JOIN u.article LEFT JOIN u.book LEFT JOIN u.conference WHERE u.bibtexKey like %?1% OR u.author like %?1% OR u.publisher like %?1% OR u.title like %?1% OR u.article.journal like %?1% OR u.article.address like %?1% OR u.book.series like %?1% OR u.book.address like %?1% OR u.book.edition like %?1% OR u.book.note like %?1% OR u.conference.booktitle like %?1% OR u.conference.editor like %?1% OR u.conference.series like %?1% OR u.conference.address like %?1% OR u.conference.organization like %?1% OR u.conference.note like %?1%")
    List<Reference> findSearchTermFromAll(String searchTerm);
    
    @Query("SELECT u from Reference u LEFT JOIN u.article a LEFT JOIN u.book b LEFT JOIN u.conference c WHERE u.year = ?1 OR u.article.volume = ?1 OR u.article.number = ?1 OR u.article.startPage = ?1 OR u.article.endPage = ?1 OR u.book.volume = ?1 OR u.book.month = ?1 OR u.conference.volume = ?1 OR u.conference.startPage = ?1 OR u.conference.endPage = ?1 OR u.conference.month = ?1")
    List<Reference> findSearchTermFromAllIntegers(int searchTerm);
     
    @Query("SELECT u from Reference u LEFT JOIN u.article LEFT JOIN u.book LEFT JOIN u.conference WHERE u.bibtexKey like %?1% OR u.author like %?1% OR u.publisher like %?1% OR u.title like %?1% OR u.article.journal like %?1% OR u.article.address like %?1% OR u.book.series like %?1% OR u.book.address like %?1% OR u.book.edition like %?1% OR u.book.note like %?1% OR u.conference.booktitle like %?1% OR u.conference.editor like %?1% OR u.conference.series like %?1% OR u.conference.address like %?1% OR u.conference.organization like %?1% OR u.conference.note like %?1% OR u.book.month = ?2 OR u.year = ?2 OR u.article.volume = ?2 OR u.article.number = ?2 OR u.article.startPage = ?2 OR u.article.endPage = ?2 OR u.book.volume = ?2 OR u.book.month = ?2 OR u.conference.volume = ?2 OR u.conference.startPage = ?2 OR u.conference.endPage = ?2 OR u.conference.month = ?2")
    List<Reference> findSearchTermFromStringsAndIntegers(String searchWord, int searchInt);
}
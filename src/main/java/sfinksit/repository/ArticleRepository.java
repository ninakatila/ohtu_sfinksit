package sfinksit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfinksit.domain.Reference;
import sfinksit.domain.Article;


public interface ArticleRepository extends JpaRepository<Article, Long> {
    
 
}
package sfinksit.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;
import sfinksit.repository.ReferenceRepository;
import sfinksit.tools.Generator;

@Entity
public class Reference extends AbstractPersistable<Long> {

    // @Column(unique=true)
    public String bibtexKey;

    @NotBlank
    @Size(min = 4)
    public String author;

    @NotBlank
    @Size(min = 4)
    public String title;

    @Min(value = 0)
    public Integer year;

    @NotBlank
    @Size(min = 3)
    public String publisher;
    
    @OneToOne(cascade={CascadeType.ALL})
    public Article article;
    
    @OneToOne(cascade={CascadeType.ALL})
    public Book book;
    
    @OneToOne(cascade={CascadeType.ALL})
    public Conference conference;
    
    /**
     * Generate an unique BibTeX key for this reference
     * 
     * @param rep ReferenceRepository to check that the key is unique
     */
    public void generateBibtexKey(ReferenceRepository rep) {
        Generator gen = new Generator();
        this.setBibtexKey(gen.generate(rep, this));
    }

    // getterit
    public String getBibtexKey() {
        return this.bibtexKey;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getPublisher() {
        return publisher;
    }
    
    public Article getArticle() {
        return this.article;
    }
    
    public Book getBook() {
        return this.book;
    }
    
    public Conference getConference() {
        return this.conference;
    }

    // setterit
    public void setBibtexKey(String key) {
        this.bibtexKey = key;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public void setArticle(Article article) {
        this.article = article;
    }
    
    public void setBook(Book book) {
        this.book = book;
    }
    
    public void setConference(Conference conference) {
        this.conference = conference;
    }

}

package com.bookstore.service;

import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bookstore.repository.AuthorAnthologyViewRepository;
import com.bookstore.view.AuthorAnthologyView;

@Service
public class BookstoreService {
	
	 private static final Logger logger = Logger.getLogger(BookstoreService.class.getName());

    private final AuthorAnthologyViewRepository authorAnthologyViewRepository;

    public BookstoreService(AuthorAnthologyViewRepository authorAnthologyViewRepository) {
        this.authorAnthologyViewRepository = authorAnthologyViewRepository;
    }

    @Transactional
    public void updateAuthorAgeViaView() {
        AuthorAnthologyView author
                = authorAnthologyViewRepository.findByName("Quartis Young");
        System.out.println(" *********author.getAge**********"+author.getAge());
        author.setAge(author.getAge() + 1);
    }

    public void insertAuthorViaView() {
        AuthorAnthologyView newAuthor = new AuthorAnthologyView();
        newAuthor.setName("Toij Kalu");
        newAuthor.setGenre("Anthology");
        newAuthor.setAge(42);

        authorAnthologyViewRepository.save(newAuthor);
    }
    
    @Transactional
    public void deleteAuthorViaView() {
        AuthorAnthologyView author
                = authorAnthologyViewRepository.findByName("Mark Janel");
        
        authorAnthologyViewRepository.delete(author);
    }    
}

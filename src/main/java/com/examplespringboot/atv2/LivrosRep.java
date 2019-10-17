package com.examplespringboot.atv2;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface LivrosRep extends MongoRepository<Livros, String> {

    static Livros getById(String id) {
        return getById(id);
    }

    List<Livros> findByTitulo(String titulo);
    Livros findLivrosById(String id);

}




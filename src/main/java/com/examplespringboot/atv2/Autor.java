package com.examplespringboot.atv2;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Autor {
    @Id
    String id;
    String nome;
    public  Autor(String nome){
        this.nome =nome;
    }

}

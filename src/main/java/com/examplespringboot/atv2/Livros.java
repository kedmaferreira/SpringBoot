package com.examplespringboot.atv2;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Getter
@Setter
@Document
public class Livros {
    @Id
    private String id;
    private String titulo;
   	private String ano;
    private String genero;
    private int  edicao;


    public Livros(String titulo, String ano, int edicao, String genero){
         this.titulo = titulo;
         this.ano = ano;
         this.edicao = edicao;
         this.genero = genero;
    }


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getAno() {
		return ano;
	}


	public void setAno(String ano) {
		this.ano = ano;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public int getEdicao() {
		return edicao;
	}


	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}






}

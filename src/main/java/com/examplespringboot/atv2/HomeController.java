package com.examplespringboot.atv2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;


@Controller
public class HomeController {

    @Autowired
    LivrosRep rep;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/cadastrar")
    @ResponseBody
    public Livros salvar(@RequestParam String titulo, @RequestParam String ano, @RequestParam int edicao, @RequestParam String genero) {
        Livros Livro = new Livros( titulo, ano, edicao, genero);
        rep.save(Livro);
        return Livro;
    }

    @GetMapping("/deleta")
    @ResponseBody
    public List<Livros> Deleta(@RequestParam String id) {
        rep.deleteById(id);
        return rep.findAll();
    }

    @GetMapping("/listarTodos")
    @ResponseBody
    public List<Livros> listarTodos(){
        return rep.findAll();
    }

    @GetMapping("/listarEspecifico")
    @ResponseBody
    public Optional<Livros> listarEspecifico(@RequestParam String id) {
        return rep.findById(id);
    }


    @GetMapping("/editar")
    @ResponseBody
    public Optional<Livros> editar(@RequestParam String id, String titulo, String ano, int edicao, String genero) {
        Livros livroAtt = new Livros(titulo, ano, edicao, genero);

        return listarEspecifico(id).map(atualizar -> {
            atualizar.setTitulo(livroAtt.getTitulo());
            atualizar.setAno(livroAtt.getAno());
            atualizar.setGenero(livroAtt.getGenero());
            atualizar.setEdicao(livroAtt.getEdicao());

            return rep.save(atualizar);
        });
    }


}

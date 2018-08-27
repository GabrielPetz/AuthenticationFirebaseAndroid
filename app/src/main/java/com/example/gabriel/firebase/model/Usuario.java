package com.example.gabriel.firebase.model;

import com.google.firebase.auth.FirebaseUser;

import java.util.Date;

public class Usuario {
    private String id;
    private String nome;
    private String dtnascimento;
    private String graduacao;
    private String idiomanativo;

    public Usuario(FirebaseUser user) {
        this.id = user.getUid();
    }

    public Usuario(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDtnascimento() {
        return dtnascimento;
    }

    public void setDtnascimento(String dtnascimento) {
        this.dtnascimento = dtnascimento;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public String getIdiomanativo() {
        return idiomanativo;
    }

    public void setIdiomanativo(String idiomanativo) {
        this.idiomanativo = idiomanativo;
    }
}

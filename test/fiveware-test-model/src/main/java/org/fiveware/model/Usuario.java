package org.fiveware.model;

import javax.persistence.*;

/**
 * Created by wallace on 11/01/17.
 */
@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String termo; //Checkbox
    private String curso; //Combobox
    private String sexo; //radio

    public Usuario() {
    }

    public Usuario(String nome, String termo, String curso, String sexo) {
        this.nome = nome;
        this.termo = termo;
        this.curso = curso;
        this.sexo = sexo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTermo() {
        return termo;
    }

    public void setTermo(String termo) {
        this.termo = termo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
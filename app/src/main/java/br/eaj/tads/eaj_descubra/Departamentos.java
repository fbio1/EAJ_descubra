package br.eaj.tads.eaj_descubra;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by fbio_ on 15/10/2017.
 */

public class Departamentos {
    private int imagem;
    private String nome;
    private String descricao;
    private String responsavel;
    private String email;
    private String telefone;
    private String horario_funcionamento;
    private LatLng latitude;

    public Departamentos() {
    }

    public Departamentos(int imagem, String nome, String descricao, String responsavel, String email, String telefone, String horario_funcionamento, LatLng latitude) {
        this.imagem = imagem;
        this.nome = nome;
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.email = email;
        this.telefone = telefone;
        this.horario_funcionamento = horario_funcionamento;
        this.latitude = latitude;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getHorario_funcionamento() {
        return horario_funcionamento;
    }

    public void setHorario_funcionamento(String horario_funcionamento) {
        this.horario_funcionamento = horario_funcionamento;
    }

    public LatLng getLatitude() {
        return latitude;
    }

    public void setLatitude(LatLng latitude) {
        this.latitude = latitude;
    }
}

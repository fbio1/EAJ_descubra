package br.eaj.tads.eaj_descubra;

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
//    private double latitude;
//    private double longitute;

    public Departamentos() {
    }

    public Departamentos(int imagem, String nome, String descricao, String responsavel, String email, String telefone, String horario_funcionamento) {
        this.imagem = imagem;
        this.nome = nome;
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.email = email;
        this.telefone = telefone;
        this.horario_funcionamento = horario_funcionamento;
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

//    public double getLatitude() {
//        return latitude;
//    }
//
//    public void setLatitude(double latitude) {
//        this.latitude = latitude;
//    }
//
//    public double getLongitute() {
//        return longitute;
//    }
//
//    public void setLongitute(double longitute) {
//        this.longitute = longitute;
//    }
}

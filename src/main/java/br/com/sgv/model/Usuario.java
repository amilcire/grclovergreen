package br.com.sgv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Eric Lima <eclimmc@gmail.com> 
 * @date 12/05/2021
 * @brief class Usuario
 */

@Entity

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Size(min = 1, message = "O login precisa ser válido.")
    @Column(unique = true)
    private String login;
    
    private String senha;
    
    private String papel;

    private String nome;
    
    public long getId(){
        return id;
    }
            
    public void setId(long id){
        this.id = id;
    }
    
    public void setSenha(String senha) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.senha = encoder.encode(senha);
    }
    public void setLogin(String login){
        this.login = login;
    }
    public String getLogin() {
        return login; // Retorna o login
    }

    public String getSenha() {
        return senha; // Retorna a senha
    }

    public void setPapel(String papel){
        this.papel = papel;
    }
    public String getPapel() {
        return papel; // Retorna o papel
    }

    public String getNome() {
        return nome; //corrigido 
    }
public void setNome(String nome){
    this.nome = nome;
}
}

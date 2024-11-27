package br.com.sgv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;  // Adicione esta linha

/**
 *
 * @author Pablo Rangel <pablo.rangel@gmail.com>
 * @date 22/04/2021
 * @brief class Produto
 */
@Entity
@Getter
@Setter
public class Produto{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Size(min = 1, message = "O nome do produto precisa ser válido.")
    private String nome;
    private BigDecimal preco;
    private Integer quantidadeEstoque;
     
    
    @Override
    public String toString() {
        return nome;    
    }
 public static void main(String[] args) {
        Produto produto = new Produto();

        // Define o nome do produto
        produto.setNome("Exemplo Produto");

        // Define o preço diretamente como BigDecimal
        produto.setPreco(new BigDecimal("199.99"));

        // Exibe o produto completo
        System.out.println(produto);
    }
    
}


package br.com.sgv.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

/**
 *
 * @author Pablo Rangel <pablo.rangel@gmail.com>
 * @date 22/04/2021
 * @brief class Produto
 */
@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idProduto;
    @Size(min = 1, message = "O nome do produto precisa ser válido.")
    private String nome;
    private float preco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private List<HistoricoPreco> listaHistoricoPreco = new ArrayList();

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public List<HistoricoPreco> getListaHistoricoPreco() {
        return listaHistoricoPreco;
    }

    public void setListaHistoricoPreco(List<HistoricoPreco> listaHistoricoPreco) {
        this.listaHistoricoPreco = listaHistoricoPreco;
    }

    @Override
    public String toString() {
        return nome;
    }
}

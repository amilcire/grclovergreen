package br.com.sgv.controller;

import br.com.sgv.model.Produto;
import br.com.sgv.repository.ProdutoRepository;
import jakarta.validation.Valid;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estoque")  // Define o caminho base para as rotas do estoque
public class EstoqueController {

    @Autowired
    private ProdutoRepository produtoRepository;  // Repositório para acessar os produtos

    // Exibe o estoque de um produto específico
        @GetMapping
    public String gerenciarEstoque(Model model) {
        model.addAttribute("produtos", produtoRepository.findAll());  // Lista de todos os produtos no estoque
        return "gerenciador_estoque";  // Nome da view que exibe o gerenciamento de estoque
    }

    // Atualiza a quantidade de estoque de um produto
    @PostMapping("/atualizar/{id}")
    public String atualizarEstoque(@PathVariable("id") Long id, @RequestParam Integer quantidade, Model model) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Produto inválido"));

        // Atualiza a quantidade de estoque
        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + quantidade);
        produtoRepository.save(produto);

        // Redireciona para a página de ver estoque com as informações atualizadas
        model.addAttribute("produto", produto);
        return "redirect:/estoque/ver/" + id;
    }

@GetMapping("/produtos")
    public String listar(Model model) {
        model.addAttribute("listaProdutos", produtoRepository.findAll());
        return "gerenciar_produtos";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("produto", new Produto());
        return "editar_produto";
    }

    @GetMapping("/produtos/{id}")
    public String editar(@PathVariable("id") long id, Model model) {
        Optional<Produto> produto = produtoRepository.findById(id);
        model.addAttribute("produto", produto.get());
        return "editar_produto";
    }

    @PostMapping("/produtos")
    public String salvar(@Valid Produto produto, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_produto";
        }
        produtoRepository.save(produto);
        return "redirect:/produtos";
    }

    @DeleteMapping("/produtos/{id}")
    public String excluir(@PathVariable("id") long id) {
        produtoRepository.deleteById(id);
        return "redirect:/produtos";
    }
}


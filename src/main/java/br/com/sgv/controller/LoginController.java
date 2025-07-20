package br.com.sgv.controller;

import br.com.sgv.model.Usuario;
import br.com.sgv.repository.UsuarioRepository;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * 
 * @brief  class LoginController
 */
@Controller
public class LoginController {
    
   @Autowired
  private UsuarioRepository usuarioRepository;  
   
@GetMapping("/")
public String index(Model model, Principal principal) {
    if (principal != null) {
        // pega o nome do usuário logado
        String login = principal.getName();
        Usuario usuario = usuarioRepository.findByLogin(login);
        if (usuario != null) {
            model.addAttribute("usuarioNome", usuario.getNome());
        } else {
            model.addAttribute("usuarioNome", login);
        }
    } else {
        model.addAttribute("usuarioNome", "Visitante");
    }
    return "index";
}
            
           
    //@GetMapping("/")
    //public String index(){
      //  return "index";
    //}
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
    @GetMapping("/logout")
    public String logout(){
        return "logout";
    }
 
}

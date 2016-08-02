package br.com.unipe.unipejet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.unipe.unipejet.model.dao.AutorizacaoDAO;
import br.com.unipe.unipejet.model.dao.PassageiroDAO;
import br.com.unipe.unipejet.model.vo.Passageiro;

@Controller
public class UsuarioController {
	
	@Autowired
	private PassageiroDAO usuarioDAO;
	
	@Autowired
	private AutorizacaoDAO autorizacaoDAO;
	
	@RequestMapping("/prepararCadastroUsuario")
	public String prepararCadastro(Model model){
		model.addAttribute("usuario", new Passageiro());
		model.addAttribute("autorizacoes", autorizacaoDAO.listAll());
		return "/cadastroUsuario";
	}
	
	@RequestMapping("/addUsuario")
	public String cadastro(Passageiro usuario){
		usuarioDAO.create(usuario);
		return "redirect:/prepararListarUsuario";
	}
	
	@RequestMapping("/prepararListarUsuario")
	public String prepararListar(Model model){
		model.addAttribute("usuarioList", usuarioDAO.listAll());
		return "/listUsuario";
	}
	
	
	@RequestMapping("/prepararAtualizarUsuario")
	public String prepararUpdate(Long id, Model model){
		model.addAttribute("usuario", usuarioDAO.findById(id));
		model.addAttribute("autorizacoes", autorizacaoDAO.listAll());
		return "/updateUsuario";
	}
	
	@RequestMapping("/updateActionUsuario")
	public String update(Passageiro usuario, Model model){
		usuarioDAO.update(usuario);
		return "redirect:/prepararListarUsuario";
	}
	
	@RequestMapping("/removerUsuario")
	public String remover(Passageiro id){
		usuarioDAO.delete(id);
		return "redirect:/prepararListarUsuario";
	}


}
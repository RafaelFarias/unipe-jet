package br.com.unipe.gerenciamentoAdvogados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.unipe.gerenciamentoAdvogados.model.dao.AutorizacaoDAO;
import br.com.unipe.gerenciamentoAdvogados.model.dao.UsuarioDAO;
import br.com.unipe.gerenciamentoAdvogados.model.vo.Usuario;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private AutorizacaoDAO autorizacaoDAO;
	
	@RequestMapping("/prepararCadastroUsuario")
	public String prepararCadastro(Model model){
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("autorizacoes", autorizacaoDAO.listAll());
		return "/cadastroUsuario";
	}
	
	@RequestMapping("/addUsuario")
	public String cadastro(Usuario usuario){
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
	public String update(Usuario usuario, Model model){
		usuarioDAO.update(usuario);
		return "redirect:/prepararListarUsuario";
	}
	
	@RequestMapping("/removerUsuario")
	public String remover(Usuario id){
		usuarioDAO.delete(id);
		return "redirect:/prepararListarUsuario";
	}


}

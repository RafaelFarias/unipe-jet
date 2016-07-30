package br.com.unipe.gerenciamentoAdvogados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.unipe.gerenciamentoAdvogados.model.dao.AutorizacaoDAO;
import br.com.unipe.gerenciamentoAdvogados.model.vo.Autorizacao;

@Controller
public class AutorizacaoController {
	
	@Autowired
	private AutorizacaoDAO autorizacaoDAO;
	
	@RequestMapping("/prepararCadastroAutorizacao")
	public String prepararCadastro(Model model){
		model.addAttribute("autorizacao", new Autorizacao());
		return "/cadastroAutorizacao";
	}
	
	@RequestMapping("/addAutorizacao")
	public String cadastro(Autorizacao autoricao){
		autorizacaoDAO.create(autoricao);
		return "redirect:/prepararListarAutorizacao";
	}
	
	@RequestMapping("/prepararListarAutorizacao")
	public String prepararListar(Model model){
		model.addAttribute("autorizacaoList", autorizacaoDAO.listAll());
		return "/listAutorizacao";
	}
	
	
	@RequestMapping("/prepararAtualizarAutorizacao")
	public String prepararUpdate(Long id, Model model){
		model.addAttribute("autorizacao", autorizacaoDAO.findById(id));
		return "/updateAutorizacao";
	}
	
	@RequestMapping("/updateActionAutorizacao")
	public String update(Autorizacao auth, Model model){
		autorizacaoDAO.update(auth);
		return "redirect:/prepararListarAutorizacao";
	}
	
	@RequestMapping("/removerAutorizacao")
	public String remover(Autorizacao id){
		autorizacaoDAO.delete(id);
		return "redirect:/prepararListarAutorizacao";
	}


}

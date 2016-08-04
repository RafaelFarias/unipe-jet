package br.com.unipe.unipejet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.unipe.unipejet.model.dao.AutorizacaoDAO;
import br.com.unipe.unipejet.model.dao.VooDAO;
import br.com.unipe.unipejet.model.vo.Voo;

@Controller
public class VooController {
	
	@Autowired
	private VooDAO vooDAO;
	
	@Autowired
	private AutorizacaoDAO autorizacaoDAO;
	
	@RequestMapping("/prepararCadastroVoo")
	public String prepararCadastro(Model model){
		model.addAttribute("voo", new Voo());
		model.addAttribute("autorizacoes", autorizacaoDAO.listAll());
		return "/cadastroVoo";
	}
	
	@RequestMapping("/addVoo")
	public String cadastro(Voo voo){
		vooDAO.create(voo);
		return "redirect:/prepararListarVoo";
	}
	
	@RequestMapping("/prepararListarVoo")
	public String prepararListar(Model model){
		model.addAttribute("vooList", vooDAO.listAll());
		return "/listVoo";
	}
	
	
	@RequestMapping("/prepararAtualizarVoo")
	public String prepararUpdate(Long id, Model model){
		model.addAttribute("voo", vooDAO.findById(id));
		model.addAttribute("autorizacoes", autorizacaoDAO.listAll());
		return "/updateVoo";
	}
	
	@RequestMapping("/updateActionVoo")
	public String update(Voo voo, Model model){
		vooDAO.update(voo);
		return "redirect:/prepararListarVoo";
	}
	
	@RequestMapping("/removerVoo")
	public String remover(Voo id){
		vooDAO.delete(id);
		return "redirect:/prepararListarVoo";
	}


}

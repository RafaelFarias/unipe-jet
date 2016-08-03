package br.com.unipe.unipejet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.unipe.unipejet.model.dao.AutorizacaoDAO;
import br.com.unipe.unipejet.model.dao.PassageiroDAO;
import br.com.unipe.unipejet.model.vo.Passageiro;

@Controller
public class PassageiroController {
	
	@Autowired
	private PassageiroDAO passageiroDAO;
	
	@Autowired
	private AutorizacaoDAO autorizacaoDAO;
	
	@RequestMapping("/prepararCadastroPassageiro")
	public String prepararCadastro(Model model){
		model.addAttribute("passageiro", new Passageiro());
		model.addAttribute("autorizacoes", autorizacaoDAO.listAll());
		return "/cadastroPassageiro";
	}
	
	@RequestMapping("/addPassageiro")
	public String cadastro(Passageiro passageiro){
		passageiroDAO.create(passageiro);
		return "redirect:/prepararListarPassageiro";
	}
	
	@RequestMapping("/prepararListarPassageiro")
	public String prepararListar(Model model){
		model.addAttribute("passageiroList", passageiroDAO.listAll());
		return "/listPassageiro";
	}
	
	
	@RequestMapping("/prepararAtualizarPassageiro")
	public String prepararUpdate(Long id, Model model){
		model.addAttribute("usuario", passageiroDAO.findById(id));
		model.addAttribute("autorizacoes", autorizacaoDAO.listAll());
		return "/updatePassageiro";
	}
	
	@RequestMapping("/updateActionPassageiro")
	public String update(Passageiro passageiro, Model model){
		passageiroDAO.update(passageiro);
		return "redirect:/prepararListarPassageiro";
	}
	
	@RequestMapping("/removerPassageiro")
	public String remover(Passageiro id){
		passageiroDAO.delete(id);
		return "redirect:/prepararListarPassageiro";
	}


}

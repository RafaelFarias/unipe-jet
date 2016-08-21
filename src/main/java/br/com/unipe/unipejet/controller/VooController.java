package br.com.unipe.unipejet.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.unipe.unipejet.model.dao.AutorizacaoDAO;
import br.com.unipe.unipejet.model.dao.UsuarioDAO;
import br.com.unipe.unipejet.model.dao.VooDAO;
import br.com.unipe.unipejet.model.vo.Usuario;
import br.com.unipe.unipejet.model.vo.Voo;

@Controller
public class VooController {
	
	@Autowired
	private VooDAO vooDAO;
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
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
	
	@RequestMapping("/prepararComprarVoo")
	public String prepararComprar(Long id, Model model){
		List<Voo> vooList = new ArrayList();
		vooList.add(vooDAO.findById(id));
		model.addAttribute("vooList", vooList);
		model.addAttribute("autorizacoes", autorizacaoDAO.listAll());
		return "/compraVoo";
	}
	
	@RequestMapping("/finalizarCompra")
	public String finalizarCompra(Long id, Model model, HttpServletRequest request){
				
		HttpSession session = request.getSession(true);
		Long userId = (Long) session.getAttribute("usuarioId");
		
		if(userId == null)
			userId = 1L;
		
		Usuario usuario = usuarioDAO.findById(userId);
		Voo voo = vooDAO.findById(id);	
		
		Integer capacidade = voo.getCapacidade();
		Long milhasVoo = voo.getDistancia();
		Long milhasUsuario = usuario.getQuantidadeMilhas();
		
		voo.setCapacidade(capacidade - 1);
		usuario.setQuantidadeMilhas(milhasUsuario + milhasVoo);
		
		vooDAO.update(voo);
		usuarioDAO.update(usuario);
		
		model.addAttribute("vooList", vooDAO.listAll());
		
		return "/listVoo";
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
	
	@RequestMapping("/prepararBuscarVoo")
	public String prepararBuscar(Model model){
		model.addAttribute("voo", new Voo());
		model.addAttribute("autorizacoes", autorizacaoDAO.listAll());
		return "/searchVoo";
	}
	
	@RequestMapping("/buscarVoo")
	public String searchVoo(Voo voo, Model model){
		model.addAttribute("vooList", vooDAO.searchVoo(voo));
		return "/listVoo";
	}


}

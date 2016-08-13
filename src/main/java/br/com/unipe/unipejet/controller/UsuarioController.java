package br.com.unipe.unipejet.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.unipe.unipejet.model.dao.AutorizacaoDAO;
import br.com.unipe.unipejet.model.dao.UsuarioDAO;
import br.com.unipe.unipejet.model.vo.Usuario;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private AutorizacaoDAO autorizacaoDAO;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
	
	@RequestMapping("/prepararCadastroUsuario")
	public String prepararCadastro(Model model){
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("autorizacoes", autorizacaoDAO.listAll());
		return "/cadastroUsuario";
	}
	
	@RequestMapping("/loginUsuario")
	public String login(String login, String senha, HttpServletRequest request){		
		Usuario usuarioLogado = usuarioDAO.login(login, senha);
		HttpSession session = request.getSession(true);
		if(usuarioLogado == null){			
			return "redirect:/";
		}
		session.setAttribute("usuarioId",usuarioLogado.getId());
		return "redirect:/prepararListarVoo";
	}
	
	@RequestMapping("/addUsuario")
	public String cadastro(Usuario usuario, HttpServletRequest request){
		usuarioDAO.create(usuario);
		HttpSession session = request.getSession(true);
		Long userId = (Long) session.getAttribute("usuarioId");
		if(userId == null){			
			return "redirect:/";
		} 
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

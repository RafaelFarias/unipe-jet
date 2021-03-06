package br.com.unipe.unipejet.model.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.unipe.unipejet.model.dao.AutorizacaoDAO;
import br.com.unipe.unipejet.model.vo.Autorizacao;

@Component
public class SchedulerLog {

	@Autowired
	private AutorizacaoDAO autorizacaoDAO;
	
	@Scheduled(fixedRate=60000)
	public void task(){
		for(Autorizacao a: autorizacaoDAO.listAll()){
			System.out.println(a.getNome());
		}
	}
}

package br.com.unipe.gerenciamentoAdvogados.model.main;

import java.util.Date;
import java.util.List;

import br.com.unipe.gerenciamentoAdvogados.model.dao.AutorizacaoDAOImpl;
import br.com.unipe.gerenciamentoAdvogados.model.vo.Autorizacao;

public class Executar {

	public static void main(String[] args) {
		Autorizacao auth = new Autorizacao();
		auth.setCreatedOn(new Date());
		auth.setNome("ADMIN");

		AutorizacaoDAOImpl dao = new AutorizacaoDAOImpl();
		dao.create(auth);

		Autorizacao auth2 = new Autorizacao();
		auth2.setCreatedOn(new Date());
		auth2.setNome("ADMIN2");
		dao.create(auth2);

		List<Autorizacao> list = dao.listAll();

		for (Autorizacao a : list) {
			System.out.println(a.getNome());
			Autorizacao authBD = dao.findById(a.getId());
			authBD.setNome(a.getNome()+":ADMIN");
			dao.update2(authBD);

		}

	}

}

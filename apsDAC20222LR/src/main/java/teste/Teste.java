package teste;

import dao.JogoDao;
import entidade.Jogo;

public class Teste {

	public static void main(String[] args) {
		
//		Jogo j1 = new Jogo();
//		j1.setV1(3333);
//		j1.setV4(22222);
//		JogoDao.salvar(j1);

		Jogo j2 = JogoDao.acharPorId(4);
//		j2.setV1(4444);
//		JogoDao.editar(j2);
		
		JogoDao.remover(j2);
//		JogoDao.listar();
	}

}

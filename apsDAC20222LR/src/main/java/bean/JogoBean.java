package bean;

import static util.MessageUtil.addErrorMessage;
import static util.MessageUtil.addInfoMessage;

import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.JogoDao;
import entidade.Jogo;

@ManagedBean
public class JogoBean {
	private Jogo jogo = new Jogo();
	private List<Jogo> lista;

	public String salvar() {
		try {
			JogoDao.salvar(jogo);
			addInfoMessage("Sucesso", "Valor salvo com sucesso.");
			jogo = new Jogo();
		} catch (Exception e) {
			addErrorMessage("Erro", "Erro ao salvar o valor.");
		}

		return null;
	}

	public String editar() {
		try {
			JogoDao.editar(jogo);
			addInfoMessage("Sucesso", "Valor alterado com sucesso.");
			jogo = new Jogo();
		} catch (Exception e) {
			addErrorMessage("Erro", "Erro ao salvar o valor.");
		}

		return null;
	}

	public String excluir() {
		try {
			JogoDao.acharPorId(jogo.getId());
			JogoDao.remover(jogo);
			addInfoMessage("Sucesso", "valor Removido com sucesso.");
			jogo = new Jogo();
		} catch (Exception e) {
			addErrorMessage("Erro", "Erro ao apagar a bicicleta.");
		}

		return null;
	}

	public Integer maiorValor() {

		int valores[] = new int[5];
		valores[0] = jogo.getV1();
		valores[1] = jogo.getV2();
		valores[2] = jogo.getV3();
		valores[3] = jogo.getV4();
		valores[4] = jogo.getV5();
		Integer maior = Integer.MIN_VALUE;

		for (int i = 0; i < valores.length; i++) {
			if (valores[i] > maior) {
				maior = valores[i];
			}
		}
		addInfoMessage("Resultado:", "O maior valor inserido foi " + maior);

		return maior;

	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public List<Jogo> getLista() {
		if (lista == null) {
			lista = JogoDao.listar();

		}
		return lista;
	}

	public void setLista(List<Jogo> lista) {
		this.lista = lista;
	}
}

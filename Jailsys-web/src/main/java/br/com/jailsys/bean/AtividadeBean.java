package br.com.jailsys.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.model.DualListModel;

import br.com.jailsys.bean.basic.AbstractBean;
import br.com.jailsys.model.Atividade;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.service.AtividadeService;
import br.com.jailsys.util.Constantes;
import br.com.jailsys.util.FacesUtil;
import br.com.jailsys.view.AtividadeView;

@ManagedBean
@ViewScoped
public class AtividadeBean implements Serializable, AbstractBean<EntidadeComum> {

	private static final long serialVersionUID = 7961530823602276424L;

	@Inject
	private AtividadeService service;

	@Inject
	private AtividadeView atividadeView;

	private List<Atividade> atividadesDesvinculadas;

	private List<Atividade> atividadesVinculadas;

	private DualListModel<Atividade> atividadesDualList;

	public List<Atividade> listarPorAtivo() {
		if (atividadeView.getAtividades().isEmpty()) {
			atualizarView();
		}
		return atividadeView.getAtividades();
	}

	@Override
	public String prepararEdicao() {
		return Constantes.Atividade.TELA_EDICAO;
	}

	@Override
	public String salvar() {
		atividadesDesvinculadas = atividadesDualList.getSource();
		atividadesVinculadas = atividadesDualList.getTarget();
		
		service.salvar(atividadeView.getAtividade());
		atualizarView();
		FacesUtil
				.mostrarMensagemSucesso(Constantes.Atividade.MENSAGEM_CADASTRO);
		return Constantes.Atividade.TELA_CONSULTA;
	}

	@Override
	public void atualizarView() {
		atividadeView.setAtividades(service.listarPorAtivo());
	}

	@Override
	public String editar() {
		service.editar(atividadeView.getAtividade());
		atualizarView();
		FacesUtil.mostrarMensagemSucesso(Constantes.Atividade.MENSAGEM_EDICAO);
		return Constantes.Atividade.TELA_CONSULTA;
	}

	@Override
	public String visualizar() {
		return Constantes.Atividade.TELA_EDICAO;
	}

	@Override
	public String excluir(EntidadeComum entidade) {
		service.excluir(entidade);
		atualizarView();
		FacesUtil
				.mostrarMensagemSucesso(Constantes.Atividade.MENSAGEM_EXCLUSAO);
		return Constantes.Atividade.TELA_CONSULTA;
	}

	public AtividadeView getAtividadeView() {
		return atividadeView;
	}

	public void setAtividadeView(AtividadeView atividadeView) {
		this.atividadeView = atividadeView;
	}

	public List<Atividade> getAtividadesDesvinculadas() {
		return atividadesDesvinculadas;
	}

	public void setAtividadesDesvinculadas(List<Atividade> atividadesDesvinculadas) {
		this.atividadesDesvinculadas = atividadesDesvinculadas;
	}

	public List<Atividade> getAtividadesVinculadas() {
		return atividadesVinculadas;
	}

	public void setAtividadesVinculadas(List<Atividade> atividadesVinculadas) {
		this.atividadesVinculadas = atividadesVinculadas;
	}

	public DualListModel<Atividade> getAtividadesDualList() {
		atividadesDesvinculadas = service.listarPorAtivo();//listarDesvinculadas();
		atividadesVinculadas = service.listarVinculadas(); //new ArrayList<Atividade>();
		
		atividadesDualList = new DualListModel<Atividade>(atividadesDesvinculadas, atividadesVinculadas);
		
		return atividadesDualList;
	}

	public void setAtividadesDualList(DualListModel<Atividade> atividadesDualList) {
		this.atividadesDualList = atividadesDualList;
	}

}

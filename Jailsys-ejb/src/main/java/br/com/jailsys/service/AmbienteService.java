package br.com.jailsys.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.jailsys.DAO.AmbienteDAO;
import br.com.jailsys.model.Ambiente;
import br.com.jailsys.model.EntidadeComum;

public class AmbienteService implements AbstractService<EntidadeComum>,
        Serializable {

    private static final long serialVersionUID = -4724998597875963171L;

    @Inject
    AmbienteDAO ambienteDao;

    public List<Ambiente> listar(){
        return ambienteDao.listar();
    }
    
    @Override
    public void salvar(EntidadeComum entidade) {
        ambienteDao.salvar((Ambiente) entidade);
    }

    @Override
    public EntidadeComum salvarERetornar(EntidadeComum entidade) {
        ambienteDao.salvarERetornar((Ambiente) entidade);
        return (Ambiente) entidade;
    }

    @Override
    public void editar(EntidadeComum entidade) {
        ambienteDao.editar((Ambiente) entidade);

    }

    @Override
    public void excluir(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void excluir(EntidadeComum entidade) {
        // TODO Auto-generated method stub

    }

    @Override
    public EntidadeComum buscar(Long id) {
        return ambienteDao.buscar(id);
    }

}

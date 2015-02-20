package br.com.jailsys.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.jailsys.model.Usuario;
import br.com.jailsys.qualifier.UsuarioBean;

@Named
public class UsuarioView implements Serializable {

	private static final long serialVersionUID = 693074166910643443L;

	@Inject
	@UsuarioBean
	private Usuario usuario;

	private List<Usuario> usuarios = new ArrayList<Usuario>();

	private String confirmacaoSenha;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}
}

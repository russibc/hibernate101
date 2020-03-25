package ifsc;

import java.util.List;

import org.hibernate.Session;

public class EnderecoDAOImpl implements EnderecoDAO {

	@Override
	public void salvar(Endereco endereco) {
		Session session = Hibernate.getInstance().getSession();
		session.beginTransaction();
		session.save(endereco);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void remover(Endereco endereco) {
		Session session = Hibernate.getInstance().getSession();
		session.beginTransaction();
		session.remove(endereco);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void atualizar(Endereco endereco) {
		Session session = Hibernate.getInstance().getSession();
		session.beginTransaction();
		Endereco endToEdit = session.get(Endereco.class, 1);
		endToEdit.setCep(endereco.getCep());
		endToEdit.setCidade(endereco.getCidade());
		endToEdit.setEstado(endereco.getEstado());
		endToEdit.setRua(endereco.getRua());
		session.update(endToEdit);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Endereco> listar() {
		Session session = Hibernate.getInstance().getSession();
		List<Endereco> enderecos = session.createQuery("from Endereco", Endereco.class).list();
		session.close();
		return enderecos;
	}

	@Override
	public Endereco buscarPorId(int id) {
		Session session = Hibernate.getInstance().getSession();
		Endereco endereco = (Endereco) session.get(Endereco.class, id);
		session.close();
		return endereco;
	}

}

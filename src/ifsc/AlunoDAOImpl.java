package ifsc;

import java.util.List;

import org.hibernate.Session;

public class AlunoDAOImpl implements AlunoDAO {

	@Override
	public void salvar(Aluno aluno) {
		Session session = Hibernate.getInstance().getSession();
		session.beginTransaction();
		session.save(aluno);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void remover(Aluno aluno) {
		Session session = Hibernate.getInstance().getSession();
		session.beginTransaction();
		session.remove(aluno);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void atualizar(Aluno aluno) {
		Session session = Hibernate.getInstance().getSession();
		session.beginTransaction();
		Aluno alunoToEdit = session.get(Aluno.class, aluno.getId());
		alunoToEdit.setNome(aluno.getNome());
		alunoToEdit.getEndereco().setCidade(aluno.getEndereco().getCidade());
		alunoToEdit.getEndereco().setEstado(aluno.getEndereco().getEstado());
		alunoToEdit.getEndereco().setCep(aluno.getEndereco().getCep());
		alunoToEdit.getEndereco().setRua(aluno.getEndereco().getRua());
		session.update(alunoToEdit);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Aluno> listar() {
		Session session = Hibernate.getInstance().getSession();
		List<Aluno> alunos = session.createQuery("from Aluno", Aluno.class).list();
		session.close();
		return alunos;
	}

	@Override
	public Aluno buscarPorId(int id) {
		Session session = Hibernate.getInstance().getSession();
		Aluno aluno = (Aluno) session.get(Aluno.class, id);
		session.close();
		return aluno;
	}

}

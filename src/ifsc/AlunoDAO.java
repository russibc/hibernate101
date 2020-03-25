package ifsc;

import java.util.List;

public interface AlunoDAO {

	public void salvar(Aluno aluno);

	public void remover(Aluno aluno);

	public void atualizar(Aluno aluno);

	public List<Aluno> listar();

	public Aluno buscarPorId(int id);

}

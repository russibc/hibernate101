package ifsc;

import java.util.List;

public interface EnderecoDAO {

	public void salvar(Endereco endereco);

	public void remover(Endereco endereco);

	public void atualizar(Endereco endereco);

	public List<Endereco> listar();

	public Endereco buscarPorId(int id);

}

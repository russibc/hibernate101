package ifsc;

public class MainAluno {

	public static void main(String[] args) {

		AlunoDAO dao = new AlunoDAOImpl();

		Endereco endereco1 = new Endereco();
		endereco1.setRua("Rua 1");
		endereco1.setCep("123456");
		endereco1.setCidade("Macei");
		endereco1.setEstado("Alagoas");

		Endereco endereco2 = new Endereco();
		endereco2.setRua("Rua 1");
		endereco2.setCep("654321");
		endereco2.setCidade("Gaspar");
		endereco2.setEstado("Santa Catarina");

		Aluno aluno1 = new Aluno();
		aluno1.setNome("João");
		aluno1.setEndereco(endereco1);

		Aluno aluno2 = new Aluno();
		aluno2.setNome("Maria");
		aluno2.setEndereco(endereco2);

		dao.salvar(aluno1);
		dao.salvar(aluno2);

		MainEndereco.imprimirLista(dao.listar());

		Aluno novoAluno = dao.buscarPorId(1);

		novoAluno.getEndereco().setCidade("Maceio");
		novoAluno.setNome("João José");

		dao.atualizar(novoAluno);

		MainEndereco.imprimirLista(dao.listar());

		dao.remover(novoAluno);

		MainEndereco.imprimirLista(dao.listar());
		
		dao.remover(dao.buscarPorId(2));

	}
}

//Id = 1
//Nome = João
//Cidade = Macei
//Estado = Alagoas
//Cep = 123456
//
//Id = 2
//Nome = Maria
//Cidade = Gaspar
//Estado = Santa Catarina
//Cep = 654321
//
//Id = 1
//Nome = João José
//Cidade = Maceio
//Estado = Alagoas
//Cep = 123456
//
//Id = 2
//Nome = Maria
//Cidade = Gaspar
//Estado = Santa Catarina
//Cep = 654321
//
//Id = 2
//Nome = Maria
//Cidade = Gaspar
//Estado = Santa Catarina
//Cep = 654321

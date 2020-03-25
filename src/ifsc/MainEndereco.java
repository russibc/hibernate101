package ifsc;

import java.util.List;

public class MainEndereco {

	public static void imprimirLista(List<?> list) {
		for (Object object : list) {
			System.out.println(object);
		}
	}

	public static void main(String[] args) {

		EnderecoDAO dao = new EnderecoDAOImpl();

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

		dao.salvar(endereco1);
		dao.salvar(endereco2);

		imprimirLista(dao.listar());

		Endereco novoEndereco = dao.buscarPorId(1);

		novoEndereco.setCidade("Maceió");
		dao.atualizar(novoEndereco);

		imprimirLista(dao.listar());

		dao.remover(novoEndereco);

		imprimirLista(dao.listar());
		
		dao.remover(dao.buscarPorId(2));

	}

}

//Id = 1
//Rua = Rua 1
//Cidade = Macei
//Estado = Alagoas
//Cep = 123456
//
//Id = 2
//Rua = Rua 1
//Cidade = Gaspar
//Estado = Santa Catarina
//Cep = 654321
//
//Id = 1
//Rua = Rua 1
//Cidade = Maceió
//Estado = Alagoas
//Cep = 123456
//
//Id = 2
//Rua = Rua 1
//Cidade = Gaspar
//Estado = Santa Catarina
//Cep = 654321
//
//Id = 2
//Rua = Rua 1
//Cidade = Gaspar
//Estado = Santa Catarina
//Cep = 654321
//

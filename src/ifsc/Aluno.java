package ifsc;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "aluno")
public class Aluno {

	private int id;
	private String nome;
	private Endereco endereco;

	public Aluno() {
	}

	public Aluno(int id, String nome, Endereco endereco) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
	}

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "enderecoId")
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id = "+this.id);
		sb.append("\n");
		sb.append("Nome = "+this.nome);
		sb.append("\n");
		sb.append("Cidade = "+this.endereco.getCidade());
		sb.append("\n");
		sb.append("Estado = "+this.endereco.getEstado());
		sb.append("\n");
		sb.append("Cep = "+this.endereco.getCep());
		sb.append("\n");
		return sb.toString();
	}
}

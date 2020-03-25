package ifsc;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "endereco")
public class Endereco {

	private int id;
	private String rua;
	private String cidade;
	private String estado;
	private String cep;

	public Endereco() {
	}

	public Endereco(int id, String rua, String cidade, String estado, String cep) {
		this.id = id;
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
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

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id = " + this.id);
		sb.append("\n");
		sb.append("Rua = " + this.rua);
		sb.append("\n");
		sb.append("Cidade = " + this.cidade);
		sb.append("\n");
		sb.append("Estado = " + this.estado);
		sb.append("\n");
		sb.append("Cep = " + this.cep);
		sb.append("\n");
		return sb.toString();
	}

}

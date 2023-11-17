package sistema;

public class Especificacao {
	
	private String nome;
	private String marca;
	private String tamanho;
	
	public Especificacao(String nome, String marca, String tamanho) {
		this.nome = nome;
		this.marca = marca;
		this.tamanho = tamanho;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	 public boolean comparar(Especificacao especificacao) {
	        return this.nome.equals(especificacao.nome) &&
	               this.marca.equals(especificacao.marca) &&
	               this.tamanho.equals(especificacao.tamanho);
	    }
}

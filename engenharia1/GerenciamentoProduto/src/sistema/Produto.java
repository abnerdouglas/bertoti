package sistema;

public class Produto {
	
	private String codigo;
	private Especificacao especificacao;
	
	public Produto(String codigo, Especificacao especificacao) {
		this.codigo = codigo;
		this.especificacao = especificacao;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Especificacao getEspecificacao() {
		return especificacao;
	}
	
	public void setEspecificacao(Especificacao especificacao) {
		this.especificacao = especificacao;
	}
	
	
}

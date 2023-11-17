package sistema;

import java.util.List;
import java.util.LinkedList;

public class Estoque {
	
	private List<Produto> produtos = new LinkedList<Produto>();
	
	public void cadastrarProduto(Produto produto) {
		produtos.add(produto);
	}
	
	public List<Produto> buscarProdutoPorEspecificacao(Especificacao espec) {
		List<Produto> produtosEncontrados = new LinkedList<Produto>();
		for (Produto produto : produtos) {
			if(produto.getEspecificacao().comparar(espec)) 
				produtosEncontrados.add(produto);
		}
		return produtosEncontrados;
	}
	
	public Produto buscarProdutoPorCodigo(String codigo) {
		for(Produto produto : produtos) {
			if(produto.getCodigo().equals(codigo))
				return produto;
		}
		return null;
	}
	
	public List<Produto> getProdutos(){
		return produtos;
	}

	
	
	
} 


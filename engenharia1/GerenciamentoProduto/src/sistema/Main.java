package sistema;

import java.util.List;

public class Main {
	
	public static void main(String[] args) {

		Especificacao esp1 = new Especificacao("Regata", "Adidas", "P");
		Especificacao esp2 = new Especificacao("Moletom", "Puma", "G");

		Produto verao = new Produto("001", esp1);
		Produto inverno = new Produto("002", esp2);

		Estoque estoque = new Estoque();
		estoque.cadastrarProduto(verao);
		estoque.cadastrarProduto(inverno);
		
		Produto produtoEncontrado = estoque.buscarProdutoPorCodigo("001");
		
        if (produtoEncontrado != null) {
            System.out.println("Produto encontrado: " + produtoEncontrado.getEspecificacao().getNome());
        } else {
            System.out.println("Produto não encontrado.");
        }

        
        Especificacao especBusca = new Especificacao("Moletom", "Puma", "G");
        
        List<Produto> produtosEncontrados = estoque.buscarProdutoPorEspecificacao(especBusca);
        if (!produtosEncontrados.isEmpty()) {
            System.out.println("Produtos encontrados com a especificação:");
            for (Produto produto : produtosEncontrados) {
                System.out.println("- " + produto.getEspecificacao().getNome() + " (" + produto.getCodigo() + ")");
            }
        } else {
            System.out.println("Nenhum produto encontrado com essa especificação.");
        }
	}

}

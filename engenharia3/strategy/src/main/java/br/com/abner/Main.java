package br.com.abner;

import br.com.abner.strategies.ImpostoICMS;
import br.com.abner.strategies.ImpostoIPI;
import br.com.abner.strategies.ImpostoIPVA;
import br.com.abner.strategies.ImpostoStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static ImpostoStrategy impostoStrategy;
    private static double valor;
    private static int escolha = 1;

    public static void main(String[] args) throws IOException {

        while (escolha != 0) {
            System.out.println(
                    "\n<------------------------------------------------------------------------------->" + "\n" +
                    "Qual imposto você deseja calcular?" + "\n\n" +
                    "1 - ICMS : Imposto sobre Circulação de Mercadorias e Prestação de Serviços" + "\n" +
                    "2 - IPVA : Imposto sobre a Propriedade de Veículos Automotores" + "\n" +
                    "3 - IPI : Imposto sobre Produtos Industrializados " + "\n" +
                    "0 - Fechar o programa" + "\n\n" +
                    "OBS: Utilizar o ponto(.) ao invés da vírgula(,) para representar casas decimais." + "\n" +
                    "<------------------------------------------------------------------------------->"
            );
            escolha = Integer.parseInt(reader.readLine());

            switch (escolha) {
                case 0:
                    System.out.println("Até mais :)");
                    return;
                case 1:
                    System.out.println("Digite o valor da venda/serviço (em R$):");
                    valor = Double.parseDouble(reader.readLine());
                    impostoStrategy = new ImpostoICMS();
                    break;
                case 2:
                    System.out.println("Digite o valor de mercado do veículo (em R$):");
                    valor = Double.parseDouble(reader.readLine());
                    impostoStrategy = new ImpostoIPVA();
                    break;
                case 3:
                    System.out.println("Digite o valor do produto (em R$):");
                    valor = Double.parseDouble(reader.readLine());
                    impostoStrategy = new ImpostoIPI();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente outra opção.");
                    continue;
            }

            impostoStrategy.calcularImposto(valor);
        }
    }
}
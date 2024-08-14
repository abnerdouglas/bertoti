package br.com.abner.strategies;

import br.com.abner.EstadoICMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class ImpostoICMS implements ImpostoStrategy{
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private DecimalFormat formatacao = new DecimalFormat("#,##0.00");
    @Override
    public double calcularImposto(double valor) {
        try {
            System.out.println("Digite a sigla do estado de origem (ex: SP): ");
            String estadoDeOrigem = READER.readLine().toUpperCase();

            System.out.println("Digite a sigla do estado de destino (ex: RJ): ");
            String estadoDeDestino = READER.readLine().toUpperCase();

            // Converter as siglas para o enum correspondente
            EstadoICMS origem = EstadoICMS.valueOf(estadoDeOrigem);
            EstadoICMS destino = EstadoICMS.valueOf(estadoDeDestino);

            // Calcular o ICMS com base nos estados e no valor fornecido
            double valorICMS = calcularICMSInterestadual(valor, origem, destino);

            System.out.println("O valor do ICMS é: R$" + formatacao.format(valorICMS));
            return valorICMS;

        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Sigla de estado inválida. Por favor, verifique as siglas e tente novamente.");
        }
        return 0;
    }

    private static double calcularICMSInterestadual(double valor, EstadoICMS estadoOrigem, EstadoICMS estadoDestino) {
        if (estadoOrigem == estadoDestino) {
            // Operação interna
            return valor * estadoOrigem.getAliquotaInterna();
        }

        // Operação interestadual
        double aliquotaInterestadual = estadoOrigem.getAliquotaInterestadual12();
        if (estadoDestino == EstadoICMS.RR || estadoDestino == EstadoICMS.AM || estadoDestino == EstadoICMS.AP || estadoDestino == EstadoICMS.AC) {
            aliquotaInterestadual = estadoOrigem.getAliquotaInterestadual7();
        }

        double valorICMS = valor * aliquotaInterestadual;
        double difal = valor * (estadoDestino.getAliquotaInterna() - aliquotaInterestadual);
        return valorICMS + difal;
    }
}

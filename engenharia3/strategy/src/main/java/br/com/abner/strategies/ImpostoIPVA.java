package br.com.abner.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ImpostoIPVA implements ImpostoStrategy{

    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public double calcularImposto(double valor) {
        try {
            System.out.println("Digite a alíquota do IPVA (em %)");
            double aliquotaIPVA = Double.parseDouble(READER.readLine());

            double valorIPVA = calcularIPVA(valor, aliquotaIPVA);
            String formatacaoValorIPVA = String.format("O valor do IPVA é R$: %2f", valorIPVA);
            System.out.println(formatacaoValorIPVA);

            return valorIPVA;

        } catch (IOException exception){
            exception.printStackTrace();
        }
        return 0;
    }

    public double calcularIPVA(double valor, double aliquota){
        return valor * (aliquota/100);
    }
}

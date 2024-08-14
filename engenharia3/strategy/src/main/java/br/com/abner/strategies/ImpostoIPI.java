package br.com.abner.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class ImpostoIPI implements ImpostoStrategy{

    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private DecimalFormat formatacao = new DecimalFormat("#,##0.00");
    @Override
    public double calcularImposto(double valor) {
        try {
            System.out.println("Digite a alíquota do IPI para o produto (em %): ");
            double aliquota = Double.parseDouble(READER.readLine());

            double valorICI = calcularIPI(valor, aliquota);

            System.out.println("O valor do IPI é R$" + formatacao.format(valorICI));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    private double calcularIPI(double valor, double aliquota){
        return valor * (aliquota/100);
    }
}

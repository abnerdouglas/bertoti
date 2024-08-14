package br.com.abner;

public enum EstadoICMS {
    // Dados coletados de 13 de agosto de 2024
    AC(0.19, 0.12, 0.07),
    AL(0.19, 0.12, 0.07),
    AM(0.20, 0.12, 0.07),
    AP(0.18, 0.12, 0.07),
    BA(0.205, 0.12, 0.07),
    CE(0.20, 0.12, 0.07),
    DF(0.20, 0.12, 0.07),
    ES(0.17, 0.12, 0.07),
    GO(0.17, 0.12, 0.07),
    MA(0.22, 0.12, 0.07),
    MT(0.17, 0.12, 0.07),
    MS(0.17, 0.12, 0.07),
    MG(0.18, 0.12, 0.07),
    PA(0.19, 0.12, 0.07),
    PB(0.20, 0.12, 0.07),
    PR(0.195, 0.12, 0.07),
    PE(0.205, 0.12, 0.07),
    PI(0.21, 0.12, 0.07),
    RJ(0.20, 0.12, 0.07),
    RN(0.18, 0.12, 0.07),
    RS(0.17, 0.12, 0.07),
    RO(0.195, 0.12, 0.07),
    RR(0.20, 0.12, 0.07),
    SC(0.17, 0.12, 0.07),
    SP(0.18, 0.12, 0.07),
    SE(0.19, 0.12, 0.07),
    TO(0.20, 0.12, 0.07);

    private final double aliquotaInterna;
    private final double aliquotaInterestadual12;
    private final double aliquotaInterestadual7;


    EstadoICMS(double aliquotaInterna, double aliquotaInterestadual12, double aliquotaInterestadual7) {
        this.aliquotaInterna = aliquotaInterna;
        this.aliquotaInterestadual12 = aliquotaInterestadual12;
        this.aliquotaInterestadual7 = aliquotaInterestadual7;
    }
    public double getAliquotaInterna() {
        return aliquotaInterna;
    }

    public double getAliquotaInterestadual7() {
        return aliquotaInterestadual7;
    }

    public double getAliquotaInterestadual12() {
        return aliquotaInterestadual12;
    }
}

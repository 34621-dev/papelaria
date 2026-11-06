package model;

public class ItemPedido {


    public static final double DESCONTO_KIT = 0.15;
    public static final double DESCONTO_ATACADO = 0.08;
    public static final int QTD_MINIMA_ATACADO = 10;


    private String descricao;
    private double valorUnitario;
    private int quantidade;
    private boolean kit;


    public ItemPedido(String descricao, double valorUnitario, int quantidade, boolean kit) {
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.kit = kit;
    }


    public double calcularValorBruto() {
        return valorUnitario * quantidade;
    }

    public double calcularDesconto() {
        double bruto = calcularValorBruto();
        if (isKit()) {
            return bruto * DESCONTO_KIT;
        } else if (quantidade >= QTD_MINIMA_ATACADO) {
            return bruto * DESCONTO_ATACADO;
        } else {
            return 0.0;
        }
    }

    public double calcularValorLiquido() {
        return calcularValorBruto() - calcularDesconto();
    }


    public void exibirLinha() {
        System.out.printf("%-20s %3d un | bruto R$ %7.2f | desc R$ %6.2f | R$ %7.2f%n",
                descricao, quantidade, calcularValorBruto(), calcularDesconto(), calcularValorLiquido());
    }

    
    public String getDescricao() { return descricao; }
    public double getValorUnitario() { return valorUnitario; }
    public int getQuantidade() { return quantidade; }
    public boolean isKit() { return kit; }
}
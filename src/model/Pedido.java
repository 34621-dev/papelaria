package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    public static final double VALOR_MINIMO_FRETE_GRATIS = 150.0;
    public static final double VALOR_FRETE_PADRAO = 12.90;

    private List<ItemPedido> itens;

    public Pedido() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemPedido item) {
        this.itens.add(item);
    }

    public double calcularTotalItens() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.calcularValorLiquido();
        }
        return total;
    }

    public double calcularFrete() {
        double valorItens = calcularTotalItens();
        if (valorItens >= VALOR_MINIMO_FRETE_GRATIS) {
            return 0.0;
        } else {
            return VALOR_FRETE_PADRAO;
        }
    }

    public void exibirResumo() {
        System.out.println("=== PAPELARIA PONTO FINAL ===\n");

        for (ItemPedido item : itens) {
            item.exibirLinha();
        }

        double totalItens = calcularTotalItens();
        double frete = calcularFrete();
        double totalGeral = totalItens + frete;

        System.out.printf("%nItens:  R$ %.2f%n", totalItens);
        System.out.printf("Frete:  R$ %.2f%n", frete);
        System.out.printf("Total do pedido: R$ %.2f%n", totalGeral);
    }

    public List<ItemPedido> getItens() {
        return itens;
    }
}
package app;

import model.ItemPedido;
import model.Pedido;

/*
RESPOSTAS 5)
a)
   O bloco de cálculo de desconto e exibição de linha do item (o cálculo do 
   valor bruto, cálculo da regra de abatimento com if/else se é kit ou atacado, 
   cálculo do líquido e a chamada do System.out.printf) estava repetido 4 vezes.

b)
   - descricao1, descricao2, descricao3, descricao4
   - valor1, valor2, valor3, valor4
   - qtd1, qtd2, qtd3, qtd4
   - kit1, kit2, kit3, kit4
   - bruto1, bruto2, bruto3, bruto4
   - abatimento1, abatimento2, abatimento3, abatimento4
   - liquido1, liquido2, liquido3, liquido4

c)
   - 0.15: Percentual de desconto de 15% para kits escolar.
   - 0.08: Percentual de desconto de 8% para compras no atacado (quantidade >= 10).
   - 10: Quantidade mínima de itens para ter direito ao desconto de atacado.
   - 150.0: Valor mínimo total em compras para obter frete grátis.
   - 12.90: Valor cobrado pela taxa de frete padrão caso não atinja o valor mínimo.
*/

public class Papelaria {

    public static void main(String[] args) {
        
        Pedido pedido = new Pedido();

       
        pedido.adicionarItem(new ItemPedido("Caderno 10 materias", 24.90, 1, false));
        pedido.adicionarItem(new ItemPedido("Lapis grafite", 1.50, 12, false));
        pedido.adicionarItem(new ItemPedido("Kit escolar basico", 84.00, 1, true));
        pedido.adicionarItem(new ItemPedido("Caneta azul", 2.80, 10, false));


        pedido.exibirResumo();
    }
}
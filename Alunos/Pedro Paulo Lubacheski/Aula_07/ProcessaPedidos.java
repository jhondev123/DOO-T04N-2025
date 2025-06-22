
import java.util.ArrayList;
import java.util.Date;

public class ProcessaPedido {

    public Pedido processar(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva,
            Cliente cliente, Vendedor vendedor, Loja loja, ArrayList<Item> itens) {
        if (!confirmarPagamento(dataVencimentoReserva)) {
            System.out.println("Reserva vencida! N�o foi poss�vel confirmar o pagamento.");
            return null;
        }

        return new Pedido(id, dataCriacao, dataPagamento, dataVencimentoReserva, cliente, vendedor, loja, itens);
    }

    private boolean confirmarPagamento(Date dataVencimentoReserva) {
        Date agora = new Date();
        return agora.before(dataVencimentoReserva);
    }
}

import java.util.ArrayList;
import java.util.List;

public class SistemaProdutos {

    private List<Produto> produtos;

    public SistemaProdutos() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) throws Exception {
        if (produtos.contains(produto)) {
            throw new Exception("Produto já cadastrado no sistema.");
        }
        produtos.add(produto);
    }

    public void listarProdutos() {
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }
}

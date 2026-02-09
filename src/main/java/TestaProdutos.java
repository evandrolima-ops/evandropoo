import java.util.Scanner;

public class TestaProdutos {

    public static void main(String[] args) {

        SistemaProdutos sistema = new SistemaProdutos();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite o ID do produto: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Digite o nome do produto: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o preço do produto: ");
            double preco = scanner.nextDouble();

            Produto produto = new Produto(id, nome, preco);

            sistema.adicionarProduto(produto);

            produto.aplicarDesconto(10);

            sistema.listarProdutos();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static sort.Utils.quicksort;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        int op;
        String menuView = """
                \n******** List Sorter ********
                Escolha uma opção:
                1: Criar e ordenar um alista de números.
                0: Sair da aplicação.
                """;

        do {
            System.out.println(menuView);
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    List<Integer> list = getList(scanner);
                    Integer[] sortedArr = quicksort(list.toArray(new Integer[0]), 0, list.size() - 1);
                    System.out.print("Lista ordenada: ");
                    for (int item : sortedArr) {
                        System.out.print(item + " ");
                    }
                    break;
                case 0:
                    loop = false;
                    scanner.close();
                    System.out.println("Encerrando a aplicação.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (loop);
    }

    private static List<Integer> getList(Scanner scanner) {
        List<Integer> list = new ArrayList<>();
        boolean loop = true;
        int op;
        String listView = """
                 \nEscolha uma opção:
                 1: Adicionar um número.
                 2: Ordenar a lista.
                """;

        do {
            System.out.println(listView);
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Adicionar um número na lista:");
                    op = scanner.nextInt();
                    list.add(op);

                    System.out.println("Lista atual: ");
                    for (Integer i : list) {
                        System.out.print(i + " ");
                    }
                    break;
                case 2:
                    loop = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (loop);

        return list;
    }

}

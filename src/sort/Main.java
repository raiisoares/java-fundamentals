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
                Choose an option:
                1: Create and sort a list of numbers.
                0: Exit app.
                """;

        do {
            System.out.println(menuView);
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    List<Integer> list = getList(scanner);
                    Integer[] sortedArr = quicksort(list.toArray(new Integer[0]), 0, list.size() - 1);
                    System.out.print("Sorted List: ");
                    for (int item : sortedArr) {
                        System.out.print(item + " ");
                    }
                    break;
                case 0:
                    loop = false;
                    scanner.close();
                    System.out.println("Thanks for using this app.");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }

        } while (loop);
    }

    private static List<Integer> getList(Scanner scanner) {
        List<Integer> list = new ArrayList<>();
        boolean loop = true;
        int op;
        String listView = """
                 \nChoose an option:
                 1: Add number.
                 2: Sort the list.
                """;

        do {
            System.out.println(listView);
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Add a number on list:");
                    op = scanner.nextInt();
                    list.add(op);

                    System.out.println("Current List: ");
                    for (Integer i : list) {
                        System.out.print(i + " ");
                    }
                    break;
                case 2:
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }

        } while (loop);

        return list;
    }

}

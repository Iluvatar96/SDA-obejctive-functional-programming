package sda.finances;


import sda.finances.model.Expense;
import sda.finances.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application {


    public static void main(String[] args) {

        List<Expense> expenses = init();

        expenses.forEach(expense -> {
            expense.getProducts().stream()
                    .filter(product -> product.getUnitPrice() <= 3)
                    .forEach(System.out::println);


        });


        double banan = expenses.stream()
                .mapToDouble(expense -> expense.getProducts()
                        .stream()
                        .filter(product -> product.getName().equals("banan"))
                        .mapToDouble(product -> product.getUnitPrice() * product.getAmount())
                        .sum()

                )
                .sum();
        System.out.println(banan);


        expenses.stream()

                .filter(expense ->
                        expense.getDate().isBefore(LocalDate.of(2017, 2, 19)))
                .forEach(expense -> expense.getProducts()
                        .forEach(System.out::println));


        expenses.forEach(expense -> expense.getProducts()
                .stream()
                .filter(product -> product.getName().startsWith("t"))
                .forEach(System.out::println));

        System.out.println();


        System.out.println(expenses.stream()
                .mapToDouble(expense -> expense.getProducts().stream()

                        .filter(product -> product.getAmount() % 2 == 0)
                        .mapToDouble(product -> product.getAmount() * product.getUnitPrice())
                        .sum())
                .sum());

        expenses.stream()
                .map(expense -> expense.getProducts()
                        .stream()
                        .max((e1, e2) ->
                                (e1.getUnitPrice() * e1.getAmount()) >
                                (e2.getAmount() * e2.getUnitPrice()) ? 1 : -1)
                        .get())
                .forEach(System.out::println);

        expenses.stream()
                .map(expense -> expense.getProducts()
                        .stream()
                        .max((e1, e2) ->
                                (e1.getUnitPrice() * e1.getAmount()) >
                                (e2.getAmount() * e2.getUnitPrice()) ? 1 : -1)
                        .get())
                .max((e1, e2) ->

                        (e1.getUnitPrice() * e1.getAmount()) >
                                (e2.getAmount() * e2.getUnitPrice()) ? 1 : -1)

                        .get();


    }

    private static List<Expense> init() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("banan", 5, 12));
        products.add(new Product("baklazan", 8, 5));
        products.add(new Product("batat", 4, 20));
        products.add(new Product("twojaStara", 1, 1));
        Expense expense = new Expense("Spozywcze", products);

        List<Product> products2 = new ArrayList<>();
        products.add(new Product("farba", 5, 12));
        products.add(new Product("mlotek", 3, 3));
        products.add(new Product("gwozdzie", 1, 20));
        products.add(new Product("twojStary", 1, 1));
        Expense expense2 = new Expense("budowlane", products2, 2017, 2, 19);

        List<Product> products3 = new ArrayList<>();
        products.add(new Product("accodin", 25, 3));
        products.add(new Product("wellbutrin", 3, 10));
        products.add(new Product("konopie", 100, 10));
        products.add(new Product("machupacabra", 2, 2));
        Expense expense3 = new Expense("lekarstwa", products3, 2017, 2, 18);


        return Arrays.asList(expense, expense2, expense3);

    }
}




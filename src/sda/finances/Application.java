package sda.finances;


import sda.finances.model.Expense;
import sda.finances.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {


    public static void main(String[] args) {

        List<Expense> expenses = init();

        expenses.forEach(expense -> {
            expense.getProducts().stream()
                    .filter(product -> product.getUnitPrice() <= 3)
                    .forEach(e2 -> System.out.println(e2));


        });
    }

        private static List<Expense>init(){
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




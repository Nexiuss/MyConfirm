/**
 * FileName: CompletableFutureTest
 * Author:   Administrator
 * Date:     2019/8/28 17:44
 * Description:
 *//*

package thread;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureTest {
    public static void main(String[] args) {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (1 == 1) {
                throw new RuntimeException("测试一下异常情况");
            }
            return "s1";
        }).whenComplete((s, t) -> {
            System.out.println(s);
            System.out.println(t.getMessage());
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return "hello world";
        }).join();
        System.out.println(result);

    }

    public  void findPrices(String product){
         List<Shop> shops = Arrays.asList(new Shop("shop1"),
                new Shop("shop2"),
                new Shop("shop3"),
                new Shop("shop4"),
                new Shop("shop5"),
                new Shop("shop6"),
                new Shop("shop7"),
                new Shop("shop8")
        );
        long start = System.currentTimeMillis();

        Executor executor = Executors.newCachedThreadPool();
        //Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(),100));
        CompletableFuture<?>[] priceFuture = shops.stream()
                .map(shop -> CompletableFuture
                        .supplyAsync(() -> shop.getPice(product), executor)
                        .thenCombine(CompletableFuture.supplyAsync(()->ExchangeDemo.getRate("USD","CNY"),executor),
                                (quote, rate) -> new Quote(quote.getShop(),quote.getPrice()*rate,quote.getDiscount())))//这返回的是异步处理
                //.map(future->future.thenApply(Quote::parse))//thenApp是前一个对象完成了之后调下个对象的方法（parse）
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> DiscountDemo.applyDiscount(quote), executor)))
                //thenAccept()定义CompletableFuture返回的结果
                .map(future -> future.thenAccept(content -> System.out.println(content + "(done in " + (System.currentTimeMillis() - start) + " msecs")))
                .toArray(size->new  CompletableFuture[size]);
        //allOf接收一个数组，当里面的CompletableFuture都完成的时候，就会执行下一个语句
        CompletableFuture.allOf(priceFuture).thenAccept((obj)->System.out.println(" all done"));
        //allOf接收一个数组，当里面的CompletableFuture有一个完成时，就会执行下一个语句
        CompletableFuture.anyOf(priceFuture).thenAccept((obj) -> System.out.println("fastest anyOf done " + obj));

    }


}

class ExchangeDemo {

    public static void delay() {
        try {
            Thread.sleep(1000l);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static double getRate(String source,String target){
        delay();
        return 10;
    }

}

class DiscountDemo {

    public static void delay() {

        try {
            Thread.sleep(1000L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String applyDiscount(Quote quote){
        return quote.getShop()+" price is " +apply(quote.getPrice(),quote.getDiscount());
    }

    private static String apply(double price,Discount discussion) {
        delay();
        return NumberFormat.getInstance().format(price * (100 - discussion.getPercent())/100);
    }

}
enum Discount {

    NONE(0),SILVER(5),GOLD(10),PLATNUM(15),DIAMOND(20);

    private final int percent;

    Discount(int percent){
        this.percent = percent;
    }

    public int getPercent() {
        return percent;
    }

}

class Quote{

    private String shop;
    private double price;
    private Discount discount;

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Quote(String shop, double price, Discount discount) {
        this.shop = shop;
        this.price = price;
        this.discount = discount;
    }
}


 class Shop {

    Random random = new Random();

    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public double getPice(String product) {
        delay();
        return random.nextDouble() * 100;
    }

    public Future<Double> getPriceAsync(String product) {
        //CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        //new Thread(() -> futurePrice.complete(getPice(product))).start();
        */
/*
         * supplyAsync()该方法对线程异常进行处理，避免出现异常后的堵塞
         * *//*

        return CompletableFuture.supplyAsync(() -> (getPice(product)));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws Exception {
        Shop show = new Shop("bestShow");
        long start = System.currentTimeMillis();
        Future<Double> futurePrice = show.getPriceAsync("some product");
        System.out.println("调用返回，耗时" + (System.currentTimeMillis() - start));
        double price = futurePrice.get();
        System.out.println("价格返回，耗时" + (System.currentTimeMillis() - start));

    }

}*/

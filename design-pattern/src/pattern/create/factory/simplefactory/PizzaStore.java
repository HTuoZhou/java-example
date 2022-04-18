package pattern.create.factory.simplefactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * @author TuoZhou
 * @date 2022/4/18
 * 简单工厂模式
 */
public class PizzaStore {

    public static void main(String[] args) {
        // SimpleFactory simpleFactory = new SimpleFactory();
        // new OrderPizza(simpleFactory);
        new OrderPizza();
    }

}

abstract class AbstractPizza {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void prepare();

    public void bake() {
        System.out.println(name + " baking");
    }

    public void cut() {
        System.out.println(name + " cutting");
    }

    public void box() {
        System.out.println(name + " boxing");
    }

}

class CheesePizza extends AbstractPizza {

    @Override
    public void prepare() {
        System.out.println("cheese" + " preparing");
    }

}

class GreekPizza extends AbstractPizza {

    @Override
    public void prepare() {
        System.out.println("greek" + " preparing");
    }

}

class SimpleFactory {

    // public AbstractPizza pizza(String orderType) {
    //     AbstractPizza pizza = null;
    //     if (Objects.equals(orderType, "cheese")) {
    //         pizza = new CheesePizza();
    //         pizza.setName("cheese");
    //     } else if (Objects.equals(orderType, "greek")) {
    //         pizza = new GreekPizza();
    //         pizza.setName("greek");
    //     }
    //     return pizza;
    // }

    public static AbstractPizza pizza(String orderType) {
        AbstractPizza pizza = null;
        if (Objects.equals(orderType, "cheese")) {
            pizza = new CheesePizza();
            pizza.setName("cheese");
        } else if (Objects.equals(orderType, "greek")) {
            pizza = new GreekPizza();
            pizza.setName("greek");
        }
        return pizza;
    }

}

class OrderPizza {

    public OrderPizza() {
        AbstractPizza pizza = null;
        String orderType;
        do {
            orderType = getOrderType();
            pizza = SimpleFactory.pizza(orderType);
            if (Objects.nonNull(pizza)) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }
        } while (true);
    }

    // public OrderPizza(SimpleFactory simpleFactory) {
    //     AbstractPizza pizza = null;
    //     String orderType;
    //     do {
    //         orderType = getOrderType();
    //         pizza = simpleFactory.pizza(orderType);
    //         if (Objects.nonNull(pizza)) {
    //             pizza.prepare();
    //             pizza.bake();
    //             pizza.cut();
    //             pizza.box();
    //         }
    //     } while (true);
    // }

    private String getOrderType() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("please input orderType");
            return bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}

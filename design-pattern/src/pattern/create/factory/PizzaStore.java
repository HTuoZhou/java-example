package pattern.create.factory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * @author TuoZhou
 */
public class PizzaStore {

    public static void main(String[] args) {
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

class OrderPizza {

    public OrderPizza() {
        AbstractPizza pizza = null;
        String orderType;
        do {
            orderType = getOrderType();
            if (Objects.equals(orderType, "cheese")) {
                pizza = new CheesePizza();
                pizza.setName("cheese");
            } else if (Objects.equals(orderType, "greek")) {
                pizza = new GreekPizza();
                pizza.setName("greek");
            }

            if (Objects.nonNull(pizza)) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }
        } while (true);
    }

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


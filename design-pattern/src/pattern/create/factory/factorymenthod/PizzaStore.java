package pattern.create.factory.factorymenthod;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * @author TuoZhou
 * 工厂方法模式
 */
public class PizzaStore {

    public static void main(String[] args) {
        // new BeiJinOrderPizza();
        new LunDunOrderPizza();
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

class BeiJinCheesePizza extends AbstractPizza {

    @Override
    public void prepare() {
        System.out.println("beiJinCheese" + " preparing");
    }

}

class LunDunCheesePizza extends AbstractPizza {

    @Override
    public void prepare() {
        System.out.println("lunDunCheese" + " preparing");
    }

}

class BeiJinGreekPizza extends AbstractPizza {

    @Override
    public void prepare() {
        System.out.println("beiJinGreek" + " preparing");
    }

}

class LunDunGreekPizza extends AbstractPizza {

    @Override
    public void prepare() {
        System.out.println("lunDunGreek" + " preparing");
    }

}

abstract class AbstractOrderPizza {

    abstract AbstractPizza createPizza(String orderType);

    public AbstractOrderPizza() {
        AbstractPizza pizza = null;
        String orderType;
        do {
            orderType = getOrderType();
            pizza = this.createPizza(orderType);
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

class BeiJinOrderPizza extends AbstractOrderPizza {

    @Override
    AbstractPizza createPizza(String orderType) {
        AbstractPizza pizza = null;
        if (Objects.equals(orderType, "cheese")) {
            pizza = new BeiJinCheesePizza();
            pizza.setName("beiJinCheese");
        } else if (Objects.equals(orderType, "greek")) {
            pizza = new BeiJinGreekPizza();
            pizza.setName("beiJinGreek");
        }
        return pizza;
    }
}

class LunDunOrderPizza extends AbstractOrderPizza {

    @Override
    AbstractPizza createPizza(String orderType) {
        AbstractPizza pizza = null;
        if (Objects.equals(orderType, "cheese")) {
            pizza = new LunDunCheesePizza();
            pizza.setName("lunDunCheese");
        } else if (Objects.equals(orderType, "greek")) {
            pizza = new LunDunGreekPizza();
            pizza.setName("lunDunGreek");
        }
        return pizza;
    }

}
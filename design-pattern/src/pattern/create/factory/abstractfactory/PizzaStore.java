package pattern.create.factory.abstractfactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * @author TuoZhou
 * 抽象工厂模式
 */
public class PizzaStore {

    public static void main(String[] args) {
        // new OrderPizza(new BeiJinFactory());
        new OrderPizza(new LunDunFactory());
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

interface IFactory {
    AbstractPizza createPizza(String orderType);
}

class BeiJinFactory implements IFactory {
    @Override
    public AbstractPizza createPizza(String orderType) {
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

class LunDunFactory implements IFactory {
    @Override
    public AbstractPizza createPizza(String orderType) {
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

class OrderPizza {
    public OrderPizza(IFactory factory) {
        AbstractPizza pizza = null;
        String orderType;
        do {
            orderType = getOrderType();
            pizza = factory.createPizza(orderType);
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


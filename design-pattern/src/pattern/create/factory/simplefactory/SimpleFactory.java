package pattern.create.factory.simplefactory;

/**
 * @author TuoZhou
 * @date 2022/4/16
 * 简单工厂模式
 */
public class SimpleFactory {
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
        System.out.println(name + "baking");
    }

    public void cut() {
        System.out.println(name + "cutting");
    }

    public void box() {
        System.out.println(name + "boxing");
    }

}

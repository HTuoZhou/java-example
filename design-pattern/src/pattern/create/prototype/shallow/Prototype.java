package pattern.create.prototype.shallow;

/**
 * @author TuoZhou
 * 原型模式 浅拷贝
 * 基本数据类型 复制值
 * 引用类型 复制内存地址
 * 实现方法
 * 使用默认的clone()方法来实现，即Sheep sheep = (Sheep) super.clone();
 */
public class Prototype {

    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep sheep = new Sheep(1, "tom", new SheepVariety(1, "广州绵羊"));
        System.out.println("sheep = " + sheep);
        System.out.println("sheep hashcode = " + sheep.hashCode());
        System.out.println("sheep sheepVariety hashcode = " + sheep.getSheepVariety().hashCode());

        System.out.println();

        Sheep sheep1 = (Sheep) sheep.clone();
        System.out.println("sheep1 = " + sheep1);
        System.out.println("sheep1 hashcode = " + sheep1.hashCode());
        System.out.println("sheep1 sheepVariety hashcode = " + sheep1.getSheepVariety().hashCode());
    }

}

class Sheep implements Cloneable {
    private Integer id;
    private String name;
    private SheepVariety sheepVariety;

    public Sheep() {
    }

    public Sheep(Integer id, String name, SheepVariety sheepVariety) {
        this.id = id;
        this.name = name;
        this.sheepVariety = sheepVariety;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SheepVariety getSheepVariety() {
        return sheepVariety;
    }

    public void setSheepVariety(SheepVariety sheepVariety) {
        this.sheepVariety = sheepVariety;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sheepVariety=" + sheepVariety +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Sheep) super.clone();
    }
}

class SheepVariety implements Cloneable {
    private Integer id;
    private String varietyName;

    public SheepVariety() {
    }

    public SheepVariety(Integer id, String varietyName) {
        this.id = id;
        this.varietyName = varietyName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVarietyName() {
        return varietyName;
    }

    public void setVarietyName(String varietyName) {
        this.varietyName = varietyName;
    }

    @Override
    public String toString() {
        return "SheepVariety{" +
                "id=" + id +
                ", varietyName='" + varietyName + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (SheepVariety) super.clone();
    }
}



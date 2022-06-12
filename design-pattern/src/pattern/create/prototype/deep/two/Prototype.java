package pattern.create.prototype.deep.two;

import java.io.*;

/**
 * @author TuoZhou
 * 原型模式 深度拷贝
 * 基本数据类型 复制值
 * 引用类型 复制值
 * 实现方法2
 * 对象序列化 推荐使用
 */
public class Prototype {

    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep sheep = new Sheep(1, "tom", new SheepVariety(1, "广州绵羊"));
        System.out.println("sheep = " + sheep);
        System.out.println("sheep hashcode = " + sheep.hashCode());
        System.out.println("sheep sheepVariety hashcode = " + sheep.getSheepVariety().hashCode());

        System.out.println();

        Sheep sheep1 = (Sheep) sheep.objectSerialized();
        System.out.println("sheep1 = " + sheep1);
        System.out.println("sheep1 hashcode = " + sheep1.hashCode());
        System.out.println("sheep1 sheepVariety hashcode = " + sheep1.getSheepVariety().hashCode());
    }

}

class Sheep implements Serializable {
    private static final long serialVersionUID = -5481200937089348708L;
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

    public Object objectSerialized() {
        Sheep sheep = null;

        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            // 序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            // 反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            sheep = (Sheep) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
                if (oos != null) {
                    oos.close();
                }
                if (bis != null) {
                    bis.close();
                }
                if (ois != null) {
                    ois.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sheep;
    }
}

class SheepVariety implements Serializable {
    private static final long serialVersionUID = 2167145356275537409L;
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
}



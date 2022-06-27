package pattern.struct.bridge;

/**
 * @author TuoZhou
 * 桥接模式
 */
public class Bridge {

    public static void main(String[] args) {
        Phone folderPhone = new FolderPhone(new XiaoMi());
        folderPhone.open();
        folderPhone.close();
        folderPhone.call();

        System.out.println("---------------------------");

        Phone upRightPhone = new UpRightPhone(new XiaoMi());
        upRightPhone.open();
        upRightPhone.close();
        upRightPhone.call();
    }

}

interface Brand {
    void open();

    void close();

    void call();
}

class XiaoMi implements Brand {

    @Override
    public void open() {
        System.out.println("小米手机开机");
    }

    @Override
    public void close() {
        System.out.println("小米手机关机");
    }

    @Override
    public void call() {
        System.out.println("小米手机打电话");
    }
}

class Vivo implements Brand {

    @Override
    public void open() {
        System.out.println("vivo手机开机");
    }

    @Override
    public void close() {
        System.out.println("vivo手机关机");
    }

    @Override
    public void call() {
        System.out.println("vivo手机打电话");
    }
}

abstract class Phone {
    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    protected void open() {
        brand.open();
    }

    protected void close() {
        brand.close();
    }

    protected void call() {
        brand.close();
    }
}

class FolderPhone extends Phone {

    public FolderPhone(Brand brand) {
        super(brand);
    }

    @Override
    protected void open() {
        super.open();
        System.out.println("折叠样式手机");
    }

    @Override
    protected void call() {
        super.call();
        System.out.println("折叠样式手机");
    }

    @Override
    protected void close() {
        super.close();
        System.out.println("折叠样式手机");
    }
}

class UpRightPhone extends Phone {

    public UpRightPhone(Brand brand) {
        super(brand);
    }

    @Override
    protected void open() {
        super.open();
        System.out.println("直立样式手机");
    }

    @Override
    protected void call() {
        super.call();
        System.out.println("直立样式手机");
    }

    @Override
    protected void close() {
        super.close();
        System.out.println("直立样式手机");
    }
}

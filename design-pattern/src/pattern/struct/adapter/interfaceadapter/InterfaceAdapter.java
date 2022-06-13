package pattern.struct.adapter.interfaceadapter;

/**
 * @author TuoZhou
 * 适配器模式
 * 接口适配器模式(缺省适配器模式)
 */
public class InterfaceAdapter {

    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging();
    }

}

interface IVoltage {
    int output220V();

    int output36V();
}

abstract class AbstractVoltageAdapter implements IVoltage {
    public int output220V() {
        return 0;
    }

    public int output36V() {
        return 0;
    }
}

class Phone {
    public void charging() {
        AbstractVoltageAdapter adapter = new AbstractVoltageAdapter() {
            @Override
            public int output220V() {
                int src = 220;
                System.out.println("输出电压：" + src + "V");
                return src;
            }
        };
        adapter.output220V();
    }
}
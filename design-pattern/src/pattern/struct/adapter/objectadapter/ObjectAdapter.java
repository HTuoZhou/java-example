package pattern.struct.adapter.objectadapter;

/**
 * @author TuoZhou
 * 适配器模式
 * 对象适配器模式
 */
public class ObjectAdapter {

    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter(new Voltage220V()));
    }
}

/**
 * 被适配的类
 */
class Voltage220V {
    public int output220V() {
        int src = 220;
        System.out.println("输出电压：" + src + "V");
        return src;
    }
}

/**
 * 适配接口
 */
interface IVoltage5V {
    int output5V();
}

/**
 * 适配器类
 */
class VoltageAdapter implements IVoltage5V {

    private Voltage220V voltage220V;

    public VoltageAdapter() {
    }

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int src = voltage220V.output220V();
        int des = src / 44;
        return des;
    }
}

class Phone {
    public void charging(IVoltage5V voltage5V) {
        if (voltage5V.output5V() == 5) {
            System.out.println("电压5V，可以充电~");
        } else if (voltage5V.output5V() > 5) {
            System.out.println("电压大于5V，不能充电~");
        }
    }
}

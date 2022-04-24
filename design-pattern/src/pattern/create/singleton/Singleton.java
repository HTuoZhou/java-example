package pattern.create.singleton;

/**
 * @author TuoZhou
 * 单例模式
 * 饿汉式(静态常量)
 * 饿汉式(静态代码块)
 * 懒汉式(线程不安全)
 * 懒汉式(线程安全，同步方法)
 * 懒汉式(线程安全，同步代码块)
 * 双重检查
 * 静态内部类
 * 枚举
 */
public class Singleton {

    public static void main(String[] args) {
        // 饿汉式(静态常量)
        Singleton01 singleton011 = Singleton01.getInstance();
        Singleton01 singleton012 = Singleton01.getInstance();
        System.out.println("饿汉式(静态常量)" + (singleton011 == singleton012));

        // 饿汉式(静态代码块)
        Singleton02 singleton021 = Singleton02.getInstance();
        Singleton02 singleton022 = Singleton02.getInstance();
        System.out.println("饿汉式(静态代码块)" + (singleton021 == singleton022));


        // 懒汉式(线程不安全)
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                Singleton03 singleton031 = Singleton03.getInstance();
                Singleton03 singleton032 = Singleton03.getInstance();
                System.out.println("懒汉式(线程不安全)" + (singleton031 == singleton032));
            }).start();
        }

        // 懒汉式(线程安全，同步方法)
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                Singleton04 singleton041 = Singleton04.getInstance();
                Singleton04 singleton042 = Singleton04.getInstance();
                System.out.println("懒汉式(线程安全，同步方法)" + (singleton041 == singleton042));
            }).start();
        }

        // 懒汉式(线程安全，同步代码块)
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                Singleton05 singleton051 = Singleton05.getInstance();
                Singleton05 singleton052 = Singleton05.getInstance();
                System.out.println("懒汉式(线程安全，同步代码块)" + (singleton051 == singleton052));
            }).start();
        }

        // 双重检查
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                Singleton06 singleton061 = Singleton06.getInstance();
                Singleton06 singleton062 = Singleton06.getInstance();
                System.out.println("双重检查" + (singleton061 == singleton062));
            }).start();
        }

        // 静态内部类
        Singleton07 singleton071 = Singleton07.getInstance();
        Singleton07 singleton072 = Singleton07.getInstance();
        System.out.println("静态内部类" + (singleton071 == singleton072));

        // 枚举
        Singleton08 singleton081 = Singleton08.INSTANCE;
        Singleton08 singleton082 = Singleton08.INSTANCE;
        System.out.println("枚举" + (singleton081 == singleton082));
    }

}

/**
 * 饿汉式(静态常量)
 */
class Singleton01 {

    private Singleton01() {

    }

    private static final Singleton01 INSTANCE = new Singleton01();

    public static Singleton01 getInstance() {
        return INSTANCE;
    }

}

/**
 * 饿汉式(静态代码块)
 */
class Singleton02 {

    private Singleton02() {

    }

    private static final Singleton02 INSTANCE;

    static {
        INSTANCE = new Singleton02();
    }

    public static Singleton02 getInstance() {
        return INSTANCE;
    }

}

/**
 * 懒汉式(线程不安全)
 */
class Singleton03 {

    private Singleton03() {

    }

    private static Singleton03 instance;

    public static Singleton03 getInstance() {
        if (instance == null) {
            instance = new Singleton03();
        }
        return instance;
    }

}

/**
 * 懒汉式(线程安全，同步方法)
 */
class Singleton04 {

    private Singleton04() {

    }

    private static Singleton04 instance;

    public static synchronized Singleton04 getInstance() {
        if (instance == null) {
            instance = new Singleton04();
        }
        return instance;
    }

}

/**
 * 懒汉式(线程安全，同步代码块)
 */
class Singleton05 {

    private Singleton05() {

    }

    private static Singleton05 instance;

    public static Singleton05 getInstance() {
        synchronized (Singleton05.class) {
            if (instance == null) {
                instance = new Singleton05();
            }
        }
        return instance;
    }

}

/**
 * 双重检查
 */
class Singleton06 {

    private Singleton06() {

    }

    private static volatile Singleton06 instance;

    public static Singleton06 getInstance() {
        if (instance == null) {
            synchronized (Singleton06.class) {
                if (instance == null) {
                    instance = new Singleton06();
                }
            }
        }
        return instance;
    }

}

/**
 * 静态内部类
 */
class Singleton07 {

    private Singleton07() {

    }

    private static class Singleton07Instance {
        private static final Singleton07 INSTANCE = new Singleton07();
    }

    public static Singleton07 getInstance() {
        return Singleton07Instance.INSTANCE;
    }

}

/**
 * 枚举
 */
enum Singleton08 {

    INSTANCE;

}
package pattern.create.builder;

/**
 * @author TuoZhou
 * 建造者模式
 */
public class Builder {

    public static void main(String[] args) {
        House commonHouse = new HouseBuilder(new CommonHouse()).builder();
        System.out.println(commonHouse);

        System.out.println();

        House highHouse = new HouseBuilder(new HighHouse()).builder();
        System.out.println(highHouse);
    }

}

class House {
    private String basic;
    private String wall;
    private String roof;

    public House() {
    }

    public House(String basic, String wall, String roof) {
        this.basic = basic;
        this.wall = wall;
        this.roof = roof;
    }

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoof() {
        return roof;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    @Override
    public String toString() {
        return "House{" +
                "basic='" + basic + '\'' +
                ", wall='" + wall + '\'' +
                ", roof='" + roof + '\'' +
                '}';
    }
}

abstract class AbstractHouseBuilder {
    protected House house = new House();

    public abstract void buildBasic();

    public abstract void buildWall();

    public abstract void buildRoof();

    public House buildHouse() {
        return house;
    }
}

class CommonHouse extends AbstractHouseBuilder {

    @Override
    public void buildBasic() {
        System.out.println("给普通房子打地基");
    }

    @Override
    public void buildWall() {
        System.out.println("给普通房子砌墙");
    }

    @Override
    public void buildRoof() {
        System.out.println("给普通房子封顶");
    }
}

class HighHouse extends AbstractHouseBuilder {

    @Override
    public void buildBasic() {
        System.out.println("给高楼打地基");
    }

    @Override
    public void buildWall() {
        System.out.println("给高楼砌墙");
    }

    @Override
    public void buildRoof() {
        System.out.println("给高楼封顶");
    }
}

class HouseBuilder {
    AbstractHouseBuilder houseBuilder = null;

    public HouseBuilder() {
    }

    public HouseBuilder(AbstractHouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public void setHouseBuilder(AbstractHouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House builder() {
        houseBuilder.buildBasic();
        houseBuilder.buildWall();
        houseBuilder.buildRoof();
        return houseBuilder.buildHouse();
    }
}
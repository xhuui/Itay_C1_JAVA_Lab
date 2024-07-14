import java.util.*;

public class ParKing {
    private List<ParkingLot> parkingLots;

    // Private static variable of the single instance
    private static ParKing INSTANCE = null;

    // Private constructor to restrict instantiation of the class from other classes
    private ParKing() {
        parkingLots = new ArrayList<>();
    }

    // Public static method that returns the instance of the class
    public static ParKing getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ParKing();
        }
        return INSTANCE;
    }

    // Example method
    public void addLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }
    public Integer getBalance(){
        Integer totalBalance = 0;
        for (ParkingLot parkingLot: parkingLots){
            totalBalance +=parkingLot.getBalance();
        }
        return totalBalance;
    }
    public Integer getRevenue() {
        Integer totalRevenue = 0;
        for (ParkingLot parkingLot: parkingLots){
            totalRevenue +=parkingLot.getExpectedRevenue();
        }
        return totalRevenue;
    }
    public Integer countVehicles() {
        return parkingLots.stream().mapToInt(parkingLot -> parkingLot.getVehicleNumber()).sum();
    }
    public int countSpaceships() {
        return parkingLots.stream().mapToInt(parkingLot -> parkingLot.getSpaceShipNumber()).sum();
    }
    public static void main(String[] args) {
        ParKing park = ParKing.getInstance();

        SpacePort spacePort = new SpacePort(4, 4);
        Car car = new Car(8, "WV", "Orange", 40);
        Motorcycle motor = new Motorcycle(5, "AR", "Black", 10);
        CargoShip cargoShip = new CargoShip(2, "ET", "Purple", 1000, 3, 4);
        DeathStar deathStar = new DeathStar(2, "TE", "Green", 1000);

        ParKing x = ParKing.getInstance();

        System.out.println(spacePort.enter(car, 2));
        System.out.println(spacePort.enter(motor, 2));
        System.out.println(spacePort.enter(cargoShip, 2));
        System.out.println(spacePort.enter(deathStar, 2));

        x.addLot(spacePort);
        System.out.println(park.countVehicles()); //2
        System.out.println(park.countSpaceships()); //2

        System.out.println(x.getBalance()); //0
        System.out.println(x.getRevenue()); // 4*4*2 = 32

        ParkingLot parkingLot = new ParkingLot(3, 5);
        Truck truck = new Truck(20, "BMW", "Gray", 60);

        System.out.println(parkingLot.enter(truck, 1));

        park.addLot(parkingLot);
        System.out.println(park.countSpaceships()); //2
        System.out.println(park.countVehicles()); //3

        spacePort.load(motor,cargoShip);
        // we move vehicle from lot to cargoship this the spaceship and vehicle count should stay the same
        System.out.println(park.countSpaceships()); //2
        System.out.println(park.countVehicles()); //3

        System.out.println(park.getBalance()); // 4
        System.out.println(park.getRevenue()); // 4 + 3*2*4 + 1*5 = 33

        parkingLot.exit(truck);
        System.out.println(park.getBalance()); // 4 + 5*1 = 9
    }
}

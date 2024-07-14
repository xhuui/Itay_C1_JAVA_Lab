import java.util.HashSet;
import java.util.stream.Stream;

public class ParkingLot {

    private SizableVehicleStorage<Vehicle, Integer> vehicles;

    private Integer size, pricePerTime, totalBalance;

    public ParkingLot(Integer size, Integer pricePerTime) {
        this.size = size;
        this.vehicles = new SizableVehicleStorage<Vehicle, Integer>(size);
        this.pricePerTime = pricePerTime;
        this.totalBalance = 0;
    }

    public Boolean enter(Vehicle vehicle, Integer expectedStay) {
        try{
            this.vehicles.put(vehicle, expectedStay);
        }
        catch (StorageError e){
            return false;
        }
        return true;
    }

    public Boolean exit(Vehicle vehicle) {
        if (!this.vehicles.containsKey(vehicle)){
            return false;
        }
        else {
            this.totalBalance += this.vehicles.get(vehicle) * this.pricePerTime;
            this.vehicles.remove(vehicle);
            return true;
        }
    }

    public Boolean exitHalf(Vehicle vehicle) {
        if (!this.vehicles.containsKey(vehicle)){
            return false;
        }
        else {
            this.totalBalance += this.vehicles.get(vehicle) * this.pricePerTime / 2;
            this.vehicles.remove(vehicle);
            return true;
        }
    }

    public Integer getBalance() {
        return this.totalBalance;
    }
    public Integer getExpectedRevenue() {
        int expectedRevenue = this.totalBalance;
        for (Vehicle vehicle : this.vehicles.keySet()) {
            expectedRevenue += this.vehicles.get(vehicle) * this.pricePerTime;
        }
        return expectedRevenue;
    }
    public int countBikes() {
        return (int) this.vehicles.keySet().stream().filter(vehicle -> vehicle instanceof Motorcycle).count();
    }
    public int getCarNumber(){
        return vehicles.size();
    }

    public boolean checkVehicleExists(Vehicle vehicle){
        return this.vehicles.containsKey(vehicle);
    }

    public Integer getVehicleExpectedStay(Vehicle vehicle) {
        return this.vehicles.get(vehicle);
    }
    public Integer getSpaceShipNumber(){
        Integer sum = 0;
        sum += (int)this.vehicles.keySet().stream().filter(vehicle -> vehicle instanceof SpaceShip).count();
        sum += this.vehicles.keySet().stream().filter(vehicle -> vehicle instanceof CargoShip).mapToInt(ship -> ((CargoShip) ship).getSpaceShipNumber()).sum();
        return sum;
    }
    public Integer getVehicleNumber(){
        Integer sum = 0;
        sum += (int)this.vehicles.keySet().stream().filter(vehicle -> !(vehicle instanceof SpaceShip)).count();
        sum += this.vehicles.keySet().stream().filter(vehicle -> vehicle instanceof CargoShip).mapToInt(ship -> ((CargoShip) ship).getVehicleNumber()).sum();
        return sum;
    }

    // implement parking lot size

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(2, 5);
        Car c = new Car(8, "WV", "Orange", 40);
        Motorcycle m = new Motorcycle(5, "AR", "Black", 10);
        Truck t = new Truck(20, "BMW", "Gray", 60);

        System.out.println(parkingLot.enter(c, 1));
        System.out.println(parkingLot.getExpectedRevenue());
        System.out.println(parkingLot.getBalance());

        System.out.println(parkingLot.enter(m, 2));
        System.out.println(parkingLot.enter(t, 3));
        System.out.println(parkingLot.exit(c));
        System.out.println(parkingLot.exit(c));
        System.out.println(parkingLot.getExpectedRevenue());
        System.out.println(parkingLot.getBalance());
        System.out.println(parkingLot.countBikes());
    }

}

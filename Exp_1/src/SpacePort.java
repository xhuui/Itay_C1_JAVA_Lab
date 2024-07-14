public class SpacePort extends ParkingLot{
    public SpacePort(Integer maxCarsAndSpaceShips, Integer pricePerTime){
        super(maxCarsAndSpaceShips,pricePerTime);
    }
    public void load(Vehicle V,CargoShip S){
        boolean foundCar = this.checkVehicleExists(V), foundCargoShip = this.checkVehicleExists(S);
        if (foundCar && foundCargoShip){
            Integer expectedTime = this.getVehicleExpectedStay(V);
            this.exitHalf(V);
            S.enter(V, expectedTime);
        }
    }
    public void unload(Vehicle V,CargoShip S){
        boolean foundSpaceShip = this.checkVehicleExists(S), foundCar = S.checkVehicleExists(V);
        if (foundSpaceShip && foundCar){
            Integer expectedTime = S.getVehicleExpectedStay(V);
            S.exit(V);
            this.enter(V, expectedTime / 2);
        }
    }
    public static void main(String[] args) {
        SpacePort spacePort = new SpacePort(3, 4);
        Car c = new Car(8, "WV", "Orange", 40);
        CargoShip cargoShip = new CargoShip(2, "ET", "Purple", 1000, 4, 3);

        System.out.println(spacePort.enter(c, 2));
        spacePort.load(c, cargoShip);
        System.out.println(spacePort.enter(cargoShip, 10));
        spacePort.load(c, cargoShip);

        System.out.println(spacePort.getExpectedRevenue());
        System.out.println(spacePort.getBalance());

        spacePort.unload(c, cargoShip);
        System.out.println(spacePort.getExpectedRevenue());
        System.out.println(spacePort.getBalance());
    }
}

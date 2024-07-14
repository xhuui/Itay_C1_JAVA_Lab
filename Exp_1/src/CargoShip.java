public class CargoShip extends SpaceShip{
    private Integer cargoSize;
    private ParkingLot parkingLot;
    public CargoShip(Integer GPK, String make, String color, Integer tank_size, Integer cargoSize, Integer pricePerTime){
        super(GPK, make, color, tank_size);
        this.cargoSize = cargoSize;
        parkingLot = new ParkingLot(cargoSize,pricePerTime);
    }
    public String toString(){
        return color + " " + make + " " + parkingLot.getCarNumber() + "/" + cargoSize;
    }
    public boolean enter(Vehicle vehicle,Integer expectedTime){
        return parkingLot.enter(vehicle,expectedTime);
    }
    public boolean exit(Vehicle vehicle){
        boolean success = false;
        success = parkingLot.exit(vehicle);
        if (success == true){
            return true;
        }
        else{
            throw new VehicleNotPresentException();
        }
    }
    public boolean checkVehicleExists(Vehicle vehicle){
        return this.parkingLot.checkVehicleExists(vehicle);
    }

    public Integer getVehicleExpectedStay(Vehicle vehicle) {
        return this.parkingLot.getVehicleExpectedStay(vehicle);
    }
    public Integer getSpaceShipNumber(){
        return parkingLot.getSpaceShipNumber();
    }
    public Integer getVehicleNumber(){
        return parkingLot.getVehicleNumber();
    }

}

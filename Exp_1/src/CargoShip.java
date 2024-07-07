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
    public boolean enter(Vehicle vehicle)// stopped here
}

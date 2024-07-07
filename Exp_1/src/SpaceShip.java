public abstract class SpaceShip extends Vehicle {
    public SpaceShip(Integer GPK, String make, String color, Integer tank_size) {
        super(GPK, make, color, tank_size);
    }

    public String toString() {
        return this.color + " " + this.make;
    }

    public Boolean liftOff(Integer distance) {
        return super.drive(distance);
    }

    public void shoot() {
        System.out.println("Bcuck!");
    }

    public Boolean drive(Integer distance) {
       throw new UnsupportedOperationException();
    }

    public String changeTires() {
        throw new UnsupportedOperationException();
    }
}

public abstract class Vehicle {
    protected Integer GPK, tank_size, gas, num_of_tires;
    protected String make, color;
    public Vehicle(Integer GPK, String make, String color, Integer tank_size) {
        this.GPK = GPK;
        this.tank_size = tank_size;
        this.make = make;
        this.color = color;
        this.gas = tank_size;
    }

    public String toString() {
        return this.color + " " + this.make + " " + this.gas + "/" + this.tank_size;
    }

    public Boolean drive(Integer distance) {
        if (this.gas >= distance * this.GPK) {
            this.gas -= distance * this.GPK;
            return true;
        }
        else {
            return false;
        }
    }

    public float fillGas(float price_per_liter) {
        this.gas = this.tank_size;
        return (float)(this.tank_size - this.gas) * price_per_liter;
    }

    public String changeTires() {
        return num_of_tires.toString();
    }

}

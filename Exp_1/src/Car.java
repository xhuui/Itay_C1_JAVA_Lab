public class Car extends Vehicle {
    public Car(Integer GPK, String make, String color, Integer tank_size) {
        super(GPK, make, color, tank_size);
        num_of_tires = 4;
    }
}

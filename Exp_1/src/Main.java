import java.util.ArrayList;
import java.util.List;

// TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicle_list = new ArrayList<>();
        Car c = new Car(8, "WV", "Orange", 40); // Update constructor call
        Motorcycle m = new Motorcycle(5, "AR", "Black", 10);
        Truck t = new Truck(20, "BMW", "Gray", 60);

        vehicle_list.add(c);
        vehicle_list.add(m);
        vehicle_list.add(t);

        vehicle_list.forEach(
                (vehicle -> {
                    System.out.println(vehicle.toString() + " Number of tires = " + vehicle.changeTires());
                })
        );
    }
}

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SizableVehicleStorage<K,V> extends HashMap<K,V> {
    private final int maxSize;

    public SizableVehicleStorage(int maxSize) {
        super();
        if (maxSize <= 0) {
            throw new StorageError();
        }
        this.maxSize = maxSize;
    }

    /*
    Only the "put" and "putAll" functions are dependent on the HashMap maximum size.
    Therefore, only these functions needed to be overridden.
     */
    @Override
    public V put(K key, V value) {
        if (this.size() >= maxSize && !this.containsKey(key)) {
            throw new StorageError();
        }
        return super.put(key, value);
    }
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        HashSet<K> combinedKeys = new HashSet<K>();
        combinedKeys.addAll(this.keySet());
        combinedKeys.addAll(m.keySet());

        if (combinedKeys.size() > maxSize) {
            throw new StorageError();
        }
        super.putAll(m);
    }
    public V putIfAbsent(K key, V value) {
        if (this.size() >= maxSize && !this.containsKey(key)) {
            throw new StorageError();
        }
        return super.putIfAbsent(key, value);
    }



    public static void main(String[] args) {
        // Example usage
        SizableVehicleStorage vehicleStorage1 = new SizableVehicleStorage(3);
        SizableVehicleStorage vehicleStorage2 = new SizableVehicleStorage(5);

        vehicleStorage1.put(1, new Car(2,"Toyota", "RED",50));
        vehicleStorage1.put(2, new Truck(2,"Tesla", "RED",5000));
        vehicleStorage1.put(3, new Motorcycle(2,"Yamaha", "RED",50));

        vehicleStorage2.put(3, new Car(2,"Toyota", "RED",50));
        vehicleStorage2.put(4, new Truck(2,"Tesla", "RED",5000));
        vehicleStorage2.put(5, new Motorcycle(2,"Yamaha", "RED",50));

        System.out.println(vehicleStorage1);
        System.out.println(vehicleStorage2);
        System.out.println(vehicleStorage1.size());
        System.out.println(vehicleStorage2.size());

        vehicleStorage2.putAll(vehicleStorage1);

        System.out.println(vehicleStorage1);
        System.out.println(vehicleStorage2);
    }
}

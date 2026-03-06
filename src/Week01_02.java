public class Week01_02 {

    static class ParkingSpot {
        String plate;
        boolean occupied;

        ParkingSpot() {
            occupied = false;
        }
    }

    ParkingSpot[] table = new ParkingSpot[500];

    public Week01_02() {
        for (int i = 0; i < table.length; i++)
            table[i] = new ParkingSpot();
    }

    int hash(String plate) {
        return Math.abs(plate.hashCode()) % table.length;
    }

    public int parkVehicle(String plate) {
        int index = hash(plate);

        while (table[index].occupied) {
            index = (index + 1) % table.length;
        }

        table[index].plate = plate;
        table[index].occupied = true;

        return index;
    }

    public void exitVehicle(String plate) {

        for (int i = 0; i < table.length; i++) {
            if (table[i].occupied && table[i].plate.equals(plate)) {
                table[i].occupied = false;
                System.out.println("Vehicle exited spot " + i);
            }
        }
    }

    public static void main(String[] args) {

        Week01_02 parking = new Week01_02();

        System.out.println("Parked at spot " + parking.parkVehicle("ABC123"));
        parking.exitVehicle("ABC123");
    }
}
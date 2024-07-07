public class Car_OLD {
    private Integer GPK,Tank_Size,Gas;
    private String Make, Color;


    public Car_OLD(Integer GPK, String Make, String Color, Integer Tank_Size){
        this.GPK = GPK;
        this.Tank_Size = Tank_Size;
        this.Make=Make;
        this.Color = Color;
        Gas = Tank_Size;
    }

    @Override
    public String toString() {
        return this.Color + " " + this.Make + " " + this.Gas.toString() + "/" + this.Tank_Size.toString();
    }

    public boolean drive(Integer Distance){
        if (Gas >= Distance * GPK){
            Gas -= Distance * GPK;
            return true;
        }
        else{
            return false;
        }
    }
    public float fillGas(float Price_per_liter){
        Integer left_to_fill = Tank_Size - Gas;
        Gas = Tank_Size;
        return (float)left_to_fill * Price_per_liter;
    }
    public void changeTiers(){
        System.out.println("4");
    }
    public static void main(String[] args){
        Car_OLD c = new Car_OLD(8,"WV","Orange", 40);
        System.out.println(c.toString());
        float payed = c.fillGas(5);
        System.out.println("Payed =" + payed);
        Boolean drives = c.drive(2);
        System.out.println("Can we drive? =" + drives);
        System.out.println(c.toString());
    }
}

public class Main {
    public record Rectangle (double length, double width){
    }
    public record Box (Rectangle ReA, Rectangle ReB){

    }
    
    public static void main(String[] args) {
        Rectangle Re1 = new Rectangle(34,23);
        Box B1 = new Box(new Rectangle(1,2), new Rectangle(3,4));

        //java 16
        if (Re1 instanceof Rectangle R){
            System.out.println(R.length());
            System.out.println(R.width());
        }

        //java 21
        if (Re1 instanceof Rectangle(double length, double width)){
            System.out.println(length);
            System.out.println(width);
            System.out.println("Area: "+width*length);
        }

        switch (B1) {
            case Box(Rectangle(double lengthA, double widthA),Rectangle ReB):
                System.out.println(lengthA + widthA);
        }

    }
}

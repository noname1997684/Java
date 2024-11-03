import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    sealed interface GameClassification
            permits IndoorGame, OutdoorGame {}
    public enum IndoorGame implements GameClassification
    { BOARD, BALL, VIDEO, PUZZLE }
    final class OutdoorGame implements GameClassification {}
    public static void main(String[] args) {
       int month = 12;
       String monthName;
       switch (month) {
           case 1:
               monthName = "January";
               break;
           case 2:
               monthName = "February";
               break;
           case 3:
               monthName = "March";
               break;
           case 4:
               monthName = "April";
               break;
           case 5:
               monthName = "May";
               break;
           case 6:
               monthName = "June";
               break;
           case 7:
               monthName = "July";
               break;
           case 8:
               monthName = "August";
               break;
           case 9:
               monthName = "September";
               break;
           case 10:
               monthName = "October";
               break;
           case 11:
               monthName = "November";
               break;
           case 12:
               monthName = "December";
               break;
           default:
               monthName = "Invalid month";
               break;
       }
    //    System.out.println("The month is " + monthName);
        IndoorGame d= IndoorGame.BOARD;
        String o= null;
     
    //    test21Input("YES");
    //     test21Input("NO");
//        if(o instanceof String ){
//            String s= (String)o;
//            System.out.println(s.toUpperCase());
//        }
        //    if(o instanceof String s){
        //        System.out.println(s.toUpperCase());
        //    }

     exhaustiveSwitchWithBetterEnumSupport(IndoorGame.BOARD);
        exhaustiveSwitchWithBetterEnumSupport(IndoorGame.BALL);
        exhaustiveSwitchWithBetterEnumSupport(IndoorGame.VIDEO);
        exhaustiveSwitchWithBetterEnumSupport(IndoorGame.PUZZLE);
    // System.out.println(format21Value(12));
    // System.out.println(format21Value(2.5));
    // System.out.println(format21Value("Hello"));
    // System.out.println(format21Value(new Date()));
    }
    static String formatValue(Object obj) {
        String formatted = "Unknown";
        if (obj instanceof Integer i) {
            formatted = String.format("Integer %d", i);
        } else if (obj instanceof Long l) {
            formatted = String.format("Long %d", l);
        }else if (obj instanceof Double d) {
            formatted = String.format("Double %f", d);
        } else if (obj instanceof String s) {
            formatted = String.format("String %s", s);
        } else{
            formatted= obj.toString();
        }
        return formatted;
    }
    static String format21Value(Object obj) {
        return switch (obj) {
            case Integer i -> String.format("Integer %d", i);
            case Long l    -> String.format("Long %d", l);
            case Double d  -> String.format("Double %f", d);
            case String s  -> String.format("String %s", s);
            default        -> obj.toString();
        };
    }
    static void generateResponse(String s) {
        // if (s == null) {
        //     System.out.println("Nothing to say!");
        //     return;
        // }
        switch (s) {
            case "Hello", "Bye" -> System.out.println("See you!");
            default             -> System.out.println("Same to you!");
        }
    }
    static void generate21Response(String s) {
        switch (s) {
            case null           -> System.out.println("Nothing to say!");
            case "Hello", "Bye" -> System.out.println("See you!");
            default             -> System.out.println("Same to you!");
        }
    }
    static void testInput(String response) {
        switch (response) {
            case null -> System.out.println("Nothing to say!");
            case String s -> {
                if (s.equalsIgnoreCase("YES"))
                    System.out.println("Welcome!");
                else if (s.equalsIgnoreCase("NO"))
                    System.out.println("Good Bye!");
                else
                System.out.println("Retry!");
            }
        }
    }
    static void test21Input(String response) {
        switch (response) {
            case null -> System.out.println("Nothing to say!");
            case String s
                    when s.equalsIgnoreCase("YES") -> {
                System.out.println("Welcome!");
            }
            case String s
                    when s.equalsIgnoreCase("NO") -> {
                System.out.println("Good Bye!");
            }
            case String s -> System.out.println("Retry!");
        }
    }
    static void switchClassicEnums(IndoorGame c) {
        switch (c) {
            case BOARD -> System.out.println("It's BOARD");
            case BALL  -> System.out.println("It's BALL");
            case VIDEO -> System.out.println("It's VIDEO");
            default    -> System.out.println("It's PUZZLE");
        }
    }
    static void exhaustiveSwitchWithoutEnumSupport(GameClassification c) {
        switch (c) {
            case IndoorGame s when
                    s == IndoorGame.BOARD ->
                    System.out.println("It's BOARD");
            case IndoorGame s when
                    s == IndoorGame.BALL  ->
                    System.out.println("It's BALL");
            case IndoorGame s
                    when s == IndoorGame.VIDEO ->
                    System.out.println("It's VIDEO");
            case IndoorGame s  ->
                    System.out.println("It's PUZZLE");
            case OutdoorGame t ->
                    System.out.println("It's a OutdoorGame");
        }
    }
    static void exhaustiveSwitchWithBetterEnumSupport(GameClassification c) {
        switch (c) {
            case IndoorGame.BOARD -> System.out.println("It's BOARD");
            case IndoorGame.BALL  ->
                    System.out.println("It's BALL");
            case IndoorGame.VIDEO ->
                    System.out.println("It's VIDEO");
            case IndoorGame.PUZZLE->
                    System.out.println("It's PUZZLE");
            case OutdoorGame t    ->
                    System.out.println("It's a OutdoorGame");
        }
    }
}

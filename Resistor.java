import java.util.Hashtable;
class Resistor {
    Hashtable<String, String> colorCode = new Hashtable<String, String>();

    private String[] firstDigit;
    private String[] secondDigit;
    private String[] tolerance;

    Resistor() {
        initColorCode();
        initColorArrays();
    }

    private void initColorCode() {
        colorCode.put("black", "0");
        colorCode.put("brown", "1");
        colorCode.put("red", "2");
        colorCode.put("orange", "3");
        colorCode.put("yellow", "4");
        colorCode.put("green", "5");
        colorCode.put("blue", "6");
        colorCode.put("violet", "7");
        colorCode.put("grey", "8");
        colorCode.put("white", "9");
        colorCode.put("gold", "0.1");
        colorCode.put("silver", "0.01");
    }

    private void initColorArrays() {
        firstDigit = new String[] {
                "brown",
                "red",
                "orange",
                "yellow",
                "green",
                "blue",
                "violet",
                "grey",
                "white"
        };

        secondDigit = new String[] {
                "black",
                "brown",
                "red",
                "orange",
                "yellow",
                "green",
                "blue",
                "violet",
                "grey",
                "white"
        };

        tolerance = new String[] {
                "gold", "silver"
        };
    }

    public String[] randomColor() {
        int random1 = (int) (Math.random() * 9);
        int random2 = (int) (Math.random() * 9);
        int random3 = (int) (Math.random() * 9);
        int random4 = (int) (Math.random() * 2);

        String[] color = {
                firstDigit[random1],
                secondDigit[random2],
                secondDigit[random3],
                tolerance[random4]
        };
        return color;
    }

    public double calculateResistance(String[] colors) {
        double resistance = Double.parseDouble(colorCode.get(colors[0]) + colorCode.get(colors[1]));
        resistance *= Math.pow(10, Double.parseDouble(colorCode.get(colors[2])));
        return resistance;
    }

    public String calculateTolerance(String[] colors) {
        return colorCode.get(colors[3]);
    }

    public String formatResistance(double resistance) {
        String formattedResistance = "";
        if (resistance >= 1000000000) {
            formattedResistance = String.format("%.2f", resistance / 1000000000) + "G";
        } else if (resistance >= 1000000) {
            formattedResistance = String.format("%.2f", resistance / 1000000) + "M";
        } else if (resistance >= 1000) {
            formattedResistance = String.format("%.2f", resistance / 1000) + "k";
        } else if (resistance == (int) resistance) {
            formattedResistance = String.valueOf((int) resistance);
        } else {
            formattedResistance = String.format((resistance % 1 == 0) ? "%.0f" : "%.2f", resistance);
        }
        return formattedResistance;
    }

    public String formatTolerance(String tolerance) {
        String formattedTolerance = "";
        if (tolerance.equals("0.1")) {
            formattedTolerance = "5%";
        } else if (tolerance.equals("0.01")) {
            formattedTolerance = "10%";
        }
        return formattedTolerance;
    }
}

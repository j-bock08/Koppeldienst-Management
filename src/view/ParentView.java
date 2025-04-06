package view;

import java.util.Scanner;

public abstract class ParentView {

    private final Scanner scn = new Scanner(System.in);

    public int intInput() {
        boolean wrongInput = true;
        int convertedInput = 0;

        while (wrongInput) {
            String input = scn.next();
            try {
                convertedInput = Integer.parseInt(input);
                wrongInput = false;

            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe!");
            }
        }

        return convertedInput;
    }

    public String stringInput(boolean trimSpacesOf) {
        String input = scn.nextLine();

        if (trimSpacesOf) {
            input.trim();
        }

        if (input.equals("0")){
            return null;
        }

        return input;
    }

    public double doubleInput() {
        boolean wrongInput = true;
        double convertedInput = 0.00;

        while (wrongInput) {
            String input = scn.nextLine();

            input.replace(",", ".");

            try {

                convertedInput = Double.parseDouble(input);
                wrongInput = false;

            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe!");
            }
        }

        return convertedInput;
    }
}
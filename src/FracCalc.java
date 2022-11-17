import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args)
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
        System.out.println("Input your fraction expression:");
        Scanner in = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Input your fraction expression:");
            String input = in.nextLine();
            if (input.equals("quit")) {
                break;
            }
            System.out.println(produceAnswer(input));

        }

    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String expression) {
        // gets operands for Scanner
        Scanner operands = new Scanner(expression);
        // gets firstFrac
        String firstFrac = operands.next();
        // gets operand
        String operand = operands.next();
        // gets secondFrac
        String secondFrac = operands.next();
        // returns secondFrac
        return splitter(secondFrac);


        // splits operands into whole #, numerator, denominator
        // String parsedfirstFrac = FracCalc.splitter(firstFrac);
        // String parsedsecondFrac = FracCalc.splitter(secondFrac);
        // return parsedsecondFrac;


        // TODO: Implement this function to produce the solution to the input
    }
    public static String splitter(String operand) {
        Scanner splitter = new Scanner(operand);
        int wholeNum = 0;
        int numerator = 0;
        int denominator = 1;
        // TODO: checks if its in this format: 6_5/8
        if (operand.contains("_")) {
            splitter.useDelimiter("_");
            wholeNum = splitter.nextInt();
            // takes fraction part and
            String fraction = splitter.next();
            Scanner fractionSplitter = new Scanner(fraction);
            fractionSplitter.useDelimiter("/");
            numerator = fractionSplitter.nextInt();
            denominator = fractionSplitter.nextInt();

        }
        // TODO: checks if its in this format: 20
        else if (splitter.hasNextInt()) {
            wholeNum = splitter.nextInt();
            numerator = 0;
            denominator = 1;
        } else if (splitter.hasNext()) {
            String fraction = splitter.next();
            Scanner fractionSplitter = new Scanner(fraction);
            fractionSplitter.useDelimiter("/");
            numerator = fractionSplitter.nextInt();
            denominator = fractionSplitter.nextInt();
        }

        String final_parsed = "whole:" + wholeNum + " numerator:" + numerator + " denominator:" + denominator;
        return final_parsed;
        // TODO: checks if its in this format: 27/21

        // wholeNum = Math.abs(wholeNum);
        // String fraction = splitter.next();
        // Scanner fractionSplitter = new Scanner(fraction);
        // fractionSplitter.useDelimiter("/");
        // int numerator = fractionSplitter.nextInt();
        // numerator = Math.abs(numerator);
        // int denominator = fractionSplitter.nextInt();
        // denominator = Math.abs(denominator);
        // String final_parsed = "whole:" + wholeNum + " numerator:" + numerator + " denominator:" + denominator;
        // return final_parsed;



    }

    // TODO: Fill in the space below with any helper methods that you think you will need

}
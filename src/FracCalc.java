import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args)
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
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
        // parses firstFrac and secondFrac and returns parsedSecondFrac s
        String parsedSecondFrac = parseFraction(secondFrac);
        String parsedFirstFrac = parseFraction(firstFrac);
        if (operand.equals("+")) {
            return add(parsedFirstFrac, parsedSecondFrac);
        }
        else if (operand.equals("*")) {
            return multiply(parsedFirstFrac, parsedSecondFrac);
        }
        else if (operand.equals("-")) {
            return subtract(parsedFirstFrac, parsedSecondFrac);
        }
        else if (operand.equals("/")) {
            return divide(parsedFirstFrac, parsedSecondFrac);
        } else {
            return divide(parsedFirstFrac, parsedSecondFrac);
        }


        // TODO: Implement this function to produce the solution to the input
    }
    public static String parseFraction(String operand) {
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

        // TODO: checks if its in this format: 27/21
        }
        else if (splitter.hasNext()) {
            String fraction = splitter.next();
            Scanner fractionSplitter = new Scanner(fraction);
            fractionSplitter.useDelimiter("/");
            numerator = fractionSplitter.nextInt();
            denominator = fractionSplitter.nextInt();
        }

        String final_parsed = "whole: " + wholeNum + " numerator: " + numerator + " denominator: " + denominator;
        return final_parsed;



    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static String toImproperFraction(String parsedFraction) {
        // changes the fraction to an improper fraction for ease of use when evaluating
        // seperate numerator, denominator and wholeNum
        String improperFrac = "";
        Scanner seperator = new Scanner(parsedFraction);
        // taking numerator, denominator and wholeNum and making an improperfraction
        seperator.next();
        int wholeNum = seperator.nextInt();
        seperator.next();
        int numerator = seperator.nextInt();
        seperator.next();
        int denominator = seperator.nextInt();
        if (wholeNum < 0) {
            improperFrac = (wholeNum*denominator + numerator*-1) + "/" + denominator;
        }
        else {
            improperFrac = (wholeNum*denominator + numerator) + "/" + denominator;
        }


        return improperFrac;


    }
    public static String add(String parsedFirstFrac, String parsedSecondFrac) {
        // gets improper fractions
        String improperFirstFrac = toImproperFraction(parsedFirstFrac);
        String improperSecondFrac = toImproperFraction(parsedSecondFrac);
        // 4/5 + 2/3
        // seperates first and second fractions into numerator and denominator
        Scanner seperator = new Scanner(improperFirstFrac);
        seperator.useDelimiter("/");
        int firstFracNumerator = seperator.nextInt();
        int firstFracDenominator = seperator.nextInt();
        seperator = new Scanner(improperSecondFrac);
        seperator.useDelimiter("/");
        int secondFracNumerator = seperator.nextInt();
        int secondFracDenominator = seperator.nextInt();
        String fractionSum = (firstFracNumerator*secondFracDenominator + secondFracNumerator*firstFracDenominator) + "/" + (firstFracDenominator*secondFracDenominator);
        return fractionSum;
    }
    public static String subtract(String parsedFirstFrac, String parsedSecondFrac) {
        // gets improper fractions
        String improperFirstFrac = toImproperFraction(parsedFirstFrac);
        String improperSecondFrac = toImproperFraction(parsedSecondFrac);
        // 4/5 + 2/3
        // seperates first and second fractions into numerator and denominator
        Scanner seperator = new Scanner(improperFirstFrac);
        seperator.useDelimiter("/");
        int firstFracNumerator = seperator.nextInt();
        int firstFracDenominator = seperator.nextInt();
        seperator = new Scanner(improperSecondFrac);
        seperator.useDelimiter("/");
        int secondFracNumerator = seperator.nextInt();
        int secondFracDenominator = seperator.nextInt();
        String fractionSum = (firstFracNumerator*secondFracDenominator - secondFracNumerator*firstFracDenominator) + "/" + (firstFracDenominator*secondFracDenominator);
        return fractionSum;
    }
    public static String divide(String parsedFirstFrac, String parsedSecondFrac) {
        // gets improper fractions
        String improperFirstFrac = toImproperFraction(parsedFirstFrac);
        String improperSecondFrac = toImproperFraction(parsedSecondFrac);
        // seperates first and second fractions into numerator and denominator
        Scanner seperator = new Scanner(improperFirstFrac);
        seperator.useDelimiter("/");
        int firstFracNumerator = seperator.nextInt();
        int firstFracDenominator = seperator.nextInt();
        seperator = new Scanner(improperSecondFrac);
        seperator.useDelimiter("/");
        int secondFracNumerator = seperator.nextInt();
        int secondFracDenominator = seperator.nextInt();
        // TODO: performs division
        String fractionDivision = (firstFracNumerator*secondFracDenominator) + "/" + (firstFracDenominator*secondFracNumerator);
        return fractionDivision;

    }
    public static String multiply(String parsedFirstFrac, String parsedSecondFrac) {
        // gets improper fractions
        String improperFirstFrac = toImproperFraction(parsedFirstFrac);
        String improperSecondFrac = toImproperFraction(parsedSecondFrac);
        // seperates first and second fractions into numerator and denominator
        Scanner seperator = new Scanner(improperFirstFrac);
        seperator.useDelimiter("/");
        int firstFracNumerator = seperator.nextInt();
        int firstFracDenominator = seperator.nextInt();
        seperator = new Scanner(improperSecondFrac);
        seperator.useDelimiter("/");
        int secondFracNumerator = seperator.nextInt();
        int secondFracDenominator = seperator.nextInt();
        // TODO: performs multiplication
        String fractionMultiplication  = (firstFracNumerator*secondFracNumerator) + "/" + (firstFracDenominator*secondFracDenominator);
        return fractionMultiplication;
    }

}
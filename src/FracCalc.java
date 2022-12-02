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
        // return parsedFirstFrac;
        if (operand.equals("+")) {
            return FracCalc.simplifyFraction(add(parsedFirstFrac, parsedSecondFrac));
        }
        else if (operand.equals("*")) {
            return FracCalc.simplifyFraction(multiply(parsedFirstFrac, parsedSecondFrac));
        }
        else if (operand.equals("-")) {
            return FracCalc.simplifyFraction(subtract(parsedFirstFrac, parsedSecondFrac));
        }
        else if (operand.equals("/")) {
            return FracCalc.simplifyFraction(divide(parsedFirstFrac, parsedSecondFrac));
        } else {
            return FracCalc.simplifyFraction(divide(parsedFirstFrac, parsedSecondFrac));
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
        String fractionDivision;
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
        if (firstFracNumerator*secondFracDenominator < 0 && firstFracDenominator*secondFracNumerator < 0) {
            fractionDivision = (-1*firstFracNumerator*secondFracDenominator) + "/" + (-1*firstFracDenominator*secondFracNumerator);
        } else {
            fractionDivision = (firstFracNumerator*secondFracDenominator) + "/" + (firstFracDenominator*secondFracNumerator);
        }
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
    public static String simplifyFraction(String fraction)
    {
        // splits fraction into numerator and denominator
        Scanner seperator = new Scanner(fraction);
        seperator.useDelimiter("/");
        int numer = seperator.nextInt();
        int denom = seperator.nextInt();
        int greatestCommonDivisor;
        greatestCommonDivisor = gcd(numer, denom);
        // making gcd positive just in case
        greatestCommonDivisor = Math.abs(greatestCommonDivisor);
        //
        int numerator = numer / greatestCommonDivisor;
        int denominator = denom / greatestCommonDivisor;

        if (denominator < 0) {
            denominator = Math.abs(denominator);
            numerator = (-1 * numerator);
        }

        int wholeNum = 0;
        int leftover = 0;
        String simplifiedFraction;
        // checks to make sure it turns into mixed numbers
        if (numerator > denominator) {
            wholeNum = numerator / denominator;
            leftover = numerator - wholeNum * denominator;
            if (leftover == 0) {
                simplifiedFraction = "" + wholeNum;
            } else {
                simplifiedFraction = wholeNum + "_" + leftover + "/" + denominator;
            }

        } else if (Math.abs(numerator) > denominator) {
            wholeNum = numerator / denominator;
            leftover = (numerator) - wholeNum * denominator;
            leftover = Math.abs(leftover);
            if (leftover == 0) {
                simplifiedFraction = "" + wholeNum;
            } else {
                simplifiedFraction = wholeNum + "_" + leftover + "/" + denominator;
            }
        } else if (numerator == denominator) {
            simplifiedFraction = "" + numerator / denominator;
        } else if (numerator == 0) {
            simplifiedFraction = "" + 0;
        }
        else {
            simplifiedFraction = numerator + "/" + denominator;
        }
        // simplifiedFraction = numerator + "/" + denominator;
        return simplifiedFraction;

    }

    public static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
        // checks for common factors between x and y

    }
}
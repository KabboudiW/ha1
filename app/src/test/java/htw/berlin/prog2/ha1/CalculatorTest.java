package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    //Test 1
    @Test
    @DisplayName("should display result after multiply two positive multi-digit numbers")
    void testMultiply() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();
        String expected = "400";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }
    //Test 2
    @Test
    @DisplayName("should display the precedent result after Pressing an Operation key")
    void testBinaryOperationKey() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(2);
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("+");
        String expected = "7";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    // Fehler 2:Es berechnet nur das Ergebnis zweier gegebener Zahlen und das Zwischenergebnis kann das Programm nicht berechnen.
    //Wenn wir die Equalskey drücken und dann eine Binaryoperationkey drücken, kommt es zu einem Überschreiben und einem falschen Ergebnis.
    //TODO hier weitere Tests erstellen
}


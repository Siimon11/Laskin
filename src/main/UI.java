package main;

import java.awt.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class UI {
    CalculatorPanel calculatorPanel;
    Graphics2D g2;
    public int commandNumber = 0;
    public int numberChooser = 0;
    public int padState = 0;
    public boolean hasChosenFirstNumber = false;
    public boolean hasChosenSecondNumber = false;
    public boolean number1ChoosingEnabled = false;
    public boolean number2ChoosingEnabled = false;

    public float floatFinalAnswer;

    // OPERATIONS
    public int operation;
    public final int plusOperation = 1;
    public final int minusOperation = 2;
    public final int divideOperation = 3;
    public final int multiplicationOperation = 4;
    public final int powerOperation = 5;
    public final int factorialOperation = 6;
    public final int rootOperation = 7;

    public UI(CalculatorPanel calculatorPanel) {this.calculatorPanel = calculatorPanel;}

    public void draw(Graphics2D g2) {
        this.g2 = g2;

        // TITLE
        if (calculatorPanel.calculatorState == calculatorPanel.titleState) {
            drawTitleScreen();
        }
        // MAIN
        if (calculatorPanel.calculatorState == calculatorPanel.mainState) {
            if (padState == 0) {
                drawCalculationScreen();
                drawNumberSelectionScreen();
                drawAlreadySelected();
            }
            if (padState == 1) {
                drawCalculationScreen();
                drawAlreadySelected();
                drawOperationSelectionScreen();
            }
        }
        // ANSWER
        if (calculatorPanel.calculatorState == calculatorPanel.answerState) {
            drawAnswerScreen();
            drawAnswer();
        }
    }
    public void drawTitleScreen() {
        g2.setColor(Color.GRAY);
        g2.fillRect(0, 0, calculatorPanel.screenWidth, calculatorPanel.screenHeight);

        g2.setFont(new Font("Arial", Font.PLAIN, 110));
        String text = "Calculator";
        int x = getXforCenteredText(text);
        int y = 300;

        g2.setColor(Color.BLACK);
        g2.drawString(text, x+1, y+1);
        g2.drawString(text, x+2, y+2);
        g2.drawString(text, x+3, y+3);
        g2.drawString(text, x+4, y+4);
        g2.drawString(text, x+5, y+5);
        g2.drawString(text, x+6, y+6);
        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        g2.setFont(g2.getFont().deriveFont(50f));
        text = "Calculate";
        x = getXforCenteredText(text);
        y += 300;
        g2.drawString(text, x, y);
        if (commandNumber == 0) {
            g2.drawString(">", x-30, y);
        }

        text = "Quit";
        x = getXforCenteredText(text);
        y += 50;
        g2.drawString(text, x, y);
        if (commandNumber == 1) {
            g2.drawString(">", x-30, y);
        }
    }
    public void drawCalculationScreen() {
        g2.setColor(Color.gray);
        g2.fillRect(0, 0, calculatorPanel.screenWidth, calculatorPanel.screenHeight);

        drawSubWindow(40, 20, 900, 100);
        g2.setColor(Color.black);
        g2.setFont(new Font("Arial", Font.PLAIN, 50));
        String text = "Choose two numbers and an operation.";
        g2.drawString(text, 50, 80);

        drawSubWindow(40, 200, 380,60);
        text = "First Number";
        g2.drawString(text, 50, 250);

        drawNumberWindow(40, 270, 380, 60);

        drawSubWindow(40, 400, 380,60);
        text = "Second Number";
        g2.drawString(text, 50, 450);

        drawNumberWindow(40, 470, 380, 60);
    }
    public void drawNumberSelectionScreen() {
        int frameX = 550;
        int frameY = 200;
        int frameWidth = 450;
        int frameHeight = 600;
        drawNumberWindow(frameX, frameY, frameWidth, frameHeight);

        g2.setColor(new Color(0,0,0, 210));

        // UP - DOWN
        g2.fillRect(frameX +147, frameY, 6, 600);
        g2.fillRect(frameX +297, frameY, 6, 600);
        // LEFT - RIGHT
        g2.fillRect(frameX, frameY + 147, frameWidth, 6);
        g2.fillRect(frameX, frameY + 297, frameWidth, 6);
        g2.fillRect(frameX, frameY + 447, frameWidth, 6);
        // NUMBERS
        g2.setColor(new Color(0,0,0, 255));
        g2.setFont(g2.getFont().deriveFont(150f));
        g2.drawString("1", 580, 330);
        g2.drawString("2", 580 + 160, 330);
        g2.drawString("3", 580 + 160 + 150, 330);
        g2.drawString("4", 580, 480);
        g2.drawString("5", 580 + 160, 480);
        g2.drawString("6", 580 + 160 + 150, 480);
        g2.drawString("7", 580, 630);
        g2.drawString("8", 580 + 160, 630);
        g2.drawString("9", 580 + 160 + 150, 630);
        g2.drawString("0", 580 + 160, 780);
        g2.drawString("=", 580 + 160 + 150, 780);
        g2.setFont(g2.getFont().deriveFont(110f));
        g2.drawString("+/-", 560, 760);

    }

    public void drawOperationSelectionScreen() {
        int frameX = 550;
        int frameY = 200;
        int frameWidth = 450;
        int frameHeight = 600;
        drawNumberWindow(frameX, frameY, frameWidth, frameHeight);

        g2.setColor(new Color(0,0,0, 210));

        // UP - DOWN
        g2.fillRect(frameX +147, frameY +150, 6, 450);
        g2.fillRect(frameX +297, frameY +150, 6, 450);
        // LEFT - RIGHT
        g2.fillRect(frameX, frameY + 147, frameWidth, 6);
        g2.fillRect(frameX, frameY + 297, frameWidth, 6);
        g2.fillRect(frameX, frameY + 447, frameWidth, 6);
        // NUMBERS
        g2.setColor(new Color(0,0,0, 255));
        g2.setFont(g2.getFont().deriveFont(150f));

        if (operation != 7) {
            g2.drawString("a", 580, 320);
        }
        if (operation == 7) {
            g2.drawString("a", 630, 320);
        }
        if (operation != 6 && operation != 7) {
            g2.drawString("b", 580 + 160 + 150, 325);
        }
        g2.drawString("+", 580, 480);
        g2.drawString("-", 590 + 160, 470);
        g2.drawString("/", 590 + 160 + 150, 480);
        g2.drawString("*", 595, 655);
        g2.drawString("^", 580 + 160, 650);
        g2.drawString("!", 580 + 160 + 160, 630);
        g2.drawString("=", 580 + 160 + 150, 780);
        g2.setFont(g2.getFont().deriveFont(110f));
        g2.drawString("+/-", 560, 760);
        g2.drawString("√", 580 + 130, 780);
        g2.fillRect(767, 677, 60, 4);


        switch (operation) {
            case 1: g2.drawString("+", 740, 320); break;
            case 2: g2.drawString("-", 755, 310); break;
            case 3: g2.drawString("/", 760, 320); break;
            case 4: g2.drawString("*", 750, 325); break;
            case 5: g2.drawString("^", 750, 320); break;
            case 6: g2.drawString("!", 670, 320); break;
            case 7: g2.drawString("√", 570, 330); g2.setFont(g2.getFont().deriveFont(110f)); g2.fillRect(628, 228, 70, 4); break;
        }
        g2.setColor(new Color(0,0,0, 215));
        g2.setFont(g2.getFont().deriveFont(110f));
    }
    public void restart() {
        floatFinalAnswer = 0;
        padState = 0;
        numberChooser = 0;
        operation = 0;
        commandNumber = 0;
        hasChosenFirstNumber = false;
        hasChosenSecondNumber = false;
        number1ChoosingEnabled = false;
        number2ChoosingEnabled = false;
        calculatorPanel.calculatorState = calculatorPanel.mainState;
        calculatorPanel.timeCounter = 0;
        calculatorPanel.cooldown = 0;

        calculatorPanel.number1.clear();
        calculatorPanel.number2.clear();

        calculatorPanel.number1.add(0);
        calculatorPanel.number2.add(0);
    }
    public void drawAlreadySelected() {
        g2.setFont(g2.getFont().deriveFont(50f));

        if (numberChooser == 0) {
            g2.fillOval(390, 292, 20, 20);
        } else {
            g2.fillOval(390, 492, 20, 20);
        }

        String drawNumber1 = String.valueOf(calculatorPanel.listNum1);
        String drawNumber2 = String.valueOf(calculatorPanel.listNum2);

        g2.drawString(drawNumber1, 60, 318);
        g2.drawString(drawNumber2, 60, 518);
    }
    public void drawAnswerScreen() {
        g2.setColor(Color.lightGray);
        g2.fillRect(0, 0, calculatorPanel.screenWidth, calculatorPanel.screenHeight);
        g2.setFont(new Font("Arial", Font.PLAIN, 200));
        String text = "Answer";
        int x = getXforCenteredText(text);
        int y = 200;
        g2.setColor(new Color(0,0,0, 150));
        g2.drawString(text, x, y);
        g2.fillRect(240, 220, 700, 20);

        drawSubWindow(100, 300, 400, 400);

        g2.setFont(g2.getFont().deriveFont(70f));
        g2.setColor(new Color(0,0,0,200));
        if (operation != 6 && operation != 7) {
            g2.drawString(calculatorPanel.mouseHandler.finalFirstNumber, 130, 400);
        } else if (operation == 6){
            g2.drawString(calculatorPanel.mouseHandler.finalFirstNumber, 130, 500);
        } else {
            g2.drawString(calculatorPanel.mouseHandler.finalFirstNumber, 160, 500);
        }

        switch (operation) {
            case 1: g2.drawString("+", 150, 530); break;
            case 2: g2.drawString("-", 150, 530); break;
            case 3: g2.drawString("/", 150, 530); break;
            case 4: g2.drawString("*", 150, 530); break;
            case 5: g2.drawString("^", 150, 530); break;
            case 6: g2.drawString("!", 440, 500); break;
            case 7: g2.drawString("√", 130, 500); g2.fillRect(166, 436, 70, 3); break;
        }
        if (operation != 6 && operation != 7) {
            g2.drawString(calculatorPanel.mouseHandler.finalSecondNumber, 130, 650);
        }
        g2.drawString("=", 570, 500);
    }
    public void drawAnswer() {
        drawSubWindow(650, 425, 500, 100);

        if (operation == 1) {
            floatFinalAnswer = calculatorPanel.listNum1 + calculatorPanel.listNum2;
        }
        else if (operation == 2) {
            floatFinalAnswer = calculatorPanel.listNum1 - calculatorPanel.listNum2;
        }
        else if (operation == 3 && calculatorPanel.listNum2 != 0) {
            floatFinalAnswer = (float) calculatorPanel.listNum1 / (float) calculatorPanel.listNum2;
        } else if (operation == 3){
            g2.setFont(g2.getFont().deriveFont(40f));
            drawSubWindow(650, 550, 400, 70);
            g2.drawString("You cant divide by 0", 660, 600);
        }
        else if (operation == 4) {
            floatFinalAnswer = calculatorPanel.listNum1 * calculatorPanel.listNum2;
            if (floatFinalAnswer >= 2147483647) {
                g2.setFont(g2.getFont().deriveFont(50f));
                g2.drawString("Big number", 670, 490);
            }
        }
        else if (operation == 5) {
            floatFinalAnswer = (float) Math.pow(calculatorPanel.listNum1, calculatorPanel.listNum2);
        }
        else if (operation == 7) {
            floatFinalAnswer = (float) Math.sqrt(calculatorPanel.listNum1);
        }
        else if (operation == 6) {
            g2.setFont(g2.getFont().deriveFont(70f));

            if (calculatorPanel.listNum1 >= 100) {
                g2.setFont(g2.getFont().deriveFont(50f));
                g2.drawString("Big number", 670, 490);
            } else {
                NumberFormat numFormat = new DecimalFormat();
                numFormat = new DecimalFormat("0.####E0");

                int n = calculatorPanel.listNum1;
                BigInteger result = BigInteger.ONE;
                for (int i = 2; i <= n; i++)
                    result = result.multiply(BigInteger.valueOf(i));
                String answer2 = (numFormat.format(result));
                g2.drawString(answer2, 670, 500);
            }
        }
        if (operation != 6) {
            String answer = String.valueOf(floatFinalAnswer);
            g2.drawString(answer, 670, 500);
        }

        g2.setFont(g2.getFont().deriveFont(40f));
        drawNumberWindow(700, 700, 400, 60);
        drawNumberWindow(800, 800, 200, 60);
        g2.drawString("New calculation", 750, 750);
        g2.drawString("Quit", 860, 840);
    }
    public int getXforCenteredText(String text) {
        int lenght = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = calculatorPanel.screenWidth / 2 - lenght / 2;

        return x;
    }

    public int getXforAlignToRightText(String text, int tailX) {
        int lenght = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = tailX - lenght;

        return x;
    }
    public void drawSubWindow(int x, int y, int width, int height) {
        Color c = new Color(255, 255, 255, 210);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(0, 0, 0, 210);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x, y, width, height, 25, 25);

    }
    public void drawNumberWindow(int x, int y, int width, int height) {
        Color c = new Color(255, 255, 255, 210);
        g2.setColor(c);
        g2.fillRect(x, y, width, height);

        c = new Color(0, 0, 0, 210);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRect(x, y, width, height);

    }
}

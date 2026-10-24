package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorPanel extends JPanel implements Runnable{
    // SCREEN SETTINGS
    public final int screenWidth = 1200;
    public final int screenHeight = 900;

    // FPS
    int FPS = 60;

    // SYSTEM
    public KeyHandler keyHandler = new KeyHandler(this);
    public MouseHandler mouseHandler = new MouseHandler(this);
    public UI ui = new UI(this);
    public List<Integer> number1 = new ArrayList<>();
    public List<Integer> number2 = new ArrayList<>();
    Thread calculatorThread;

    // STATE
    public int calculatorState;
    public final int titleState = 0;
    public final int mainState = 1;
    public final int answerState = 2;

    // COUNTER
    public int timeCounter = 0;
    public int cooldown = 0;

    public int listNum1;
    public int listNum2;

    public CalculatorPanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);

        number1.add(0);
        number2.add(0);
    }
    public void setupCalculator() {
        calculatorState = titleState;
        addMouseListener(mouseHandler);
    }
    public void startThread() {
        calculatorThread = new Thread(this);
        calculatorThread.start();
    }
    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (calculatorThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
                if (timeCounter < 10) {
                    timeCounter++;
                }
                if (cooldown < 60) {
                    cooldown++;
                }
            }

            if (timer >= 1000000000) {
                //System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    public void update() {
        listNum1 = mergeToInt(number1);
        listNum2 = mergeToInt(number2);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        ui.draw(g2);

        g2.dispose();

    }
    public int mergeToInt(List<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number);
        }
        return Integer.parseInt(sb.toString());
    }
}

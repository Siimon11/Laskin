package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    CalculatorPanel calculatorPanel;

    public KeyHandler(CalculatorPanel calculatorPanel) {
        this.calculatorPanel = calculatorPanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // TITLE
        if (calculatorPanel.calculatorState == calculatorPanel.titleState) {
            titleState(code);
        }
        // MAIN
        if (calculatorPanel.calculatorState == calculatorPanel.mainState) {
            mainState(code);
        }
        // ANSWER
        if (calculatorPanel.calculatorState == calculatorPanel.answerState) {
            answerState(code);
        }
    }
    public void titleState(int code) {
        if (code == KeyEvent.VK_W) {
            calculatorPanel.ui.commandNumber--;
            if (calculatorPanel.ui.commandNumber < 0) {
                calculatorPanel.ui.commandNumber = 1;
            }
        }
        if (code == KeyEvent.VK_S) {
            calculatorPanel.ui.commandNumber++;
            if (calculatorPanel.ui.commandNumber > 1) {
                calculatorPanel.ui.commandNumber = 0;
            }
        }
        if (code == KeyEvent.VK_ENTER) {
            if (calculatorPanel.calculatorState == calculatorPanel.titleState) {
                if (calculatorPanel.ui.commandNumber == 0) {
                    calculatorPanel.calculatorState = calculatorPanel.mainState;
                    calculatorPanel.timeCounter = 0;
                }
            }
            if (calculatorPanel.calculatorState == calculatorPanel.titleState) {
                if (calculatorPanel.ui.commandNumber == 1) {
                    System.exit(0);
                }
            }
        }
    }
    public void mainState(int code) {

        if (calculatorPanel.timeCounter == 10) {
            calculatorPanel.ui.number1ChoosingEnabled = true;
            calculatorPanel.ui.number2ChoosingEnabled = true;
        }
        if (calculatorPanel.ui.padState == 1) {
            if (code == KeyEvent.VK_N) {
                calculatorPanel.ui.padState = 0;
            }
        }
        if (calculatorPanel.ui.padState == 0 && calculatorPanel.ui.number1ChoosingEnabled && calculatorPanel.ui.number2ChoosingEnabled) {
            if (code == KeyEvent.VK_W) {
                calculatorPanel.ui.numberChooser--;
                if (calculatorPanel.ui.numberChooser < 0) {
                    calculatorPanel.ui.numberChooser = 0;
                }
            }
            if (code == KeyEvent.VK_S) {
                calculatorPanel.ui.numberChooser++;
                if (calculatorPanel.ui.numberChooser > 1) {
                    calculatorPanel.ui.numberChooser = 1;
                }
            }
            if (code == KeyEvent.VK_1) {
                if (calculatorPanel.ui.numberChooser == 0) {
                    if (calculatorPanel.listNum1 <= 10000) {
                        calculatorPanel.number1.add(1);}

                }
                if (calculatorPanel.ui.numberChooser == 1) {
                    if (calculatorPanel.listNum2 <= 10000) {
                        calculatorPanel.number2.add(1);
                    }
                }
            }
            if (code == KeyEvent.VK_2) {
                if (calculatorPanel.ui.numberChooser == 0) {
                    if (calculatorPanel.listNum1 <= 10000) {
                        calculatorPanel.number1.add(2);
                    }
                }
                if (calculatorPanel.ui.numberChooser == 1) {
                    if (calculatorPanel.listNum2 <= 10000) {
                        calculatorPanel.number2.add(2);
                    }
                }
            }
            if (code == KeyEvent.VK_3) {
                if (calculatorPanel.ui.numberChooser == 0) {
                    if (calculatorPanel.listNum1 <= 10000) {
                        calculatorPanel.number1.add(3);
                    }
                }
                if (calculatorPanel.ui.numberChooser == 1) {
                    if (calculatorPanel.listNum2 <= 10000) {
                        calculatorPanel.number2.add(3);
                    }
                }
            }
            if (code == KeyEvent.VK_4) {
                if (calculatorPanel.ui.numberChooser == 0) {
                    if (calculatorPanel.listNum1 <= 10000) {
                        calculatorPanel.number1.add(4);
                    }
                }
                if (calculatorPanel.ui.numberChooser == 1) {
                    if (calculatorPanel.listNum2 <= 10000) {
                        calculatorPanel.number2.add(4);
                    }
                }
            }
            if (code == KeyEvent.VK_5) {
                if (calculatorPanel.ui.numberChooser == 0) {
                    if (calculatorPanel.listNum1 <= 10000) {
                        calculatorPanel.number1.add(5);
                    }
                }
                if (calculatorPanel.ui.numberChooser == 1) {
                    if (calculatorPanel.listNum2 <= 10000) {
                        calculatorPanel.number2.add(5);
                    }
                }
            }
            if (code == KeyEvent.VK_6) {
                if (calculatorPanel.ui.numberChooser == 0) {
                    if (calculatorPanel.listNum1 <= 10000) {
                        calculatorPanel.number1.add(6);
                    }
                }
                if (calculatorPanel.ui.numberChooser == 1) {
                    if (calculatorPanel.listNum2 <= 10000) {
                        calculatorPanel.number2.add(6);
                    }
                }
            }
            if (code == KeyEvent.VK_7) {
                if (calculatorPanel.ui.numberChooser == 0) {
                    if (calculatorPanel.listNum1 <= 10000) {
                        calculatorPanel.number1.add(7);
                    }
                }
                if (calculatorPanel.ui.numberChooser == 1) {
                    if (calculatorPanel.listNum2 <= 10000) {
                        calculatorPanel.number2.add(7);
                    }
                }
            }
            if (code == KeyEvent.VK_8) {
                if (calculatorPanel.ui.numberChooser == 0) {
                    if (calculatorPanel.listNum1 <= 10000) {
                        calculatorPanel.number1.add(8);
                    }
                }
                if (calculatorPanel.ui.numberChooser == 1) {
                    if (calculatorPanel.listNum2 <= 10000) {
                        calculatorPanel.number2.add(8);
                    }
                }
            }
            if (code == KeyEvent.VK_9) {
                if (calculatorPanel.ui.numberChooser == 0) {
                    if (calculatorPanel.listNum1 <= 10000) {
                        calculatorPanel.number1.add(9);
                    }
                }
                if (calculatorPanel.ui.numberChooser == 1) {
                    if (calculatorPanel.listNum2 <= 10000) {
                        calculatorPanel.number2.add(9);
                    }
                }
            }
            if (code == KeyEvent.VK_0) {
                if (calculatorPanel.ui.numberChooser == 0) {
                    if (calculatorPanel.listNum1 <= 10000) {
                        calculatorPanel.number1.add(0);
                    }
                }
                if (calculatorPanel.ui.numberChooser == 1) {
                    if (calculatorPanel.listNum2 <= 10000) {
                        calculatorPanel.number2.add(0);
                    }
                }
            }
            if (code == KeyEvent.VK_B) {
                calculatorPanel.ui.padState = 1;
            }
        }
        if (calculatorPanel.ui.padState == 1) {
            if (code == KeyEvent.VK_PLUS) {
                calculatorPanel.ui.operation = 1;
            }
            if (code == KeyEvent.VK_MINUS) {
                calculatorPanel.ui.operation = 2;
            }
            if (code == KeyEvent.VK_SLASH) {
                calculatorPanel.ui.operation = 3;
            }
            if (code == 106) {
                calculatorPanel.ui.operation = 4;
            }
            if (code == KeyEvent.VK_CIRCUMFLEX) {
                calculatorPanel.ui.operation = 5;
            }
            if (code == KeyEvent.VK_EXCLAMATION_MARK) {
                calculatorPanel.ui.operation = 6;
            }
        }
        if (code == KeyEvent.VK_M) {
            calculatorPanel.mouseHandler.finalFirstNumber = String.valueOf(calculatorPanel.listNum1);
            calculatorPanel.mouseHandler.finalSecondNumber = String.valueOf(calculatorPanel.listNum2);

            calculatorPanel.calculatorState = calculatorPanel.answerState;
            calculatorPanel.cooldown = 0;
        }
        if (code == KeyEvent.VK_BACK_SPACE) {
            if (calculatorPanel.ui.numberChooser == 0) {
                if (calculatorPanel.number1.size() > 1) {
                    calculatorPanel.number1.removeLast();
                }
            }
            if (calculatorPanel.ui.numberChooser == 1) {
                if (calculatorPanel.number2.size() > 1) {
                    calculatorPanel.number2.removeLast();
                }
            }
        }
    }
    public void answerState(int code) {
        if (code == KeyEvent.VK_R) {
            calculatorPanel.ui.restart();
        }
        if (code == KeyEvent.VK_Q) {
            System.exit(0);
        }
        if (code == KeyEvent.VK_P) {
            System.out.println(calculatorPanel.listNum1);
            System.out.println(calculatorPanel.listNum2);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
    }
}

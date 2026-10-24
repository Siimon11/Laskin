package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
    CalculatorPanel calculatorPanel;
    public String finalFirstNumber;
    public String finalSecondNumber;

    public MouseHandler(CalculatorPanel calculatorPanel) {
        this.calculatorPanel = calculatorPanel;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int clickX =e.getX();
        int clickY =e.getY();
        if (calculatorPanel.calculatorState == calculatorPanel.titleState) {
            if (clickX >= 470 && clickX <= 732 && clickY >= 540 && clickY <= 600) {
                calculatorPanel.calculatorState = calculatorPanel.mainState;
                calculatorPanel.timeCounter = 0;
            }
            if (clickX >= 520 && clickX <= 680 && clickY >= 610 && clickY <= 660) {
                System.exit(0);
            }
        }
        if (calculatorPanel.timeCounter == 10) {
            calculatorPanel.ui.number1ChoosingEnabled = true;
            calculatorPanel.ui.number2ChoosingEnabled = true;
        }
        if (calculatorPanel.calculatorState == calculatorPanel.mainState && calculatorPanel.ui.number1ChoosingEnabled && calculatorPanel.ui.number2ChoosingEnabled) {
            if (clickX >= 38 && clickX <= 420 && clickY >= 268 && clickY <= 332) {
                // FIRST NUMBER
                calculatorPanel.ui.numberChooser = 0;
            }
            if (clickX >= 38 && clickX <= 420 && clickY >= 469 && clickY <= 530) {
                // SECOND NUMBER
                calculatorPanel.ui.numberChooser = 1;
            }
            if (clickX >= 550 && clickX <= 700 && clickY >= 200 && clickY <= 349) {
                if (calculatorPanel.ui.padState == 0) {
                    if (calculatorPanel.ui.numberChooser == 0) {
                        if (calculatorPanel.listNum1 <= 10000) {
                            calculatorPanel.number1.add(1);
                        }
                    }
                    if (calculatorPanel.ui.numberChooser == 1) {
                        if (calculatorPanel.listNum2 <= 10000) {
                            calculatorPanel.number2.add(1);
                        }
                    }
                }
            }
            if (clickX >= 701 && clickX <= 850 && clickY >= 200 && clickY <= 349) {
                if (calculatorPanel.ui.padState == 0) {
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
            }
            if (clickX >= 851 && clickX <= 1000 && clickY >= 200 && clickY <= 349) {
                if (calculatorPanel.ui.padState == 0) {
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
            }
            if (clickX >= 550 && clickX <= 700 && clickY >= 350 && clickY <= 500) {
                if (calculatorPanel.ui.padState == 0) {
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
                if (calculatorPanel.ui.padState == 1) {
                    calculatorPanel.ui.operation = calculatorPanel.ui.plusOperation;
                }

            }
            if (clickX >= 701 && clickX <= 850 && clickY >= 350 && clickY <= 500) {
                if (calculatorPanel.ui.padState == 0) {
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
                if (calculatorPanel.ui.padState == 1) {
                    calculatorPanel.ui.operation = calculatorPanel.ui.minusOperation;
                }

            }
            if (clickX >= 851 && clickX <= 1000 && clickY >= 350 && clickY <= 500) {
                if (calculatorPanel.ui.padState == 0) {
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
                if (calculatorPanel.ui.padState == 1) {
                    calculatorPanel.ui.operation = calculatorPanel.ui.divideOperation;
                }

            }
            if (clickX >= 550 && clickX <= 700 && clickY >= 501 && clickY <= 650) {
                if (calculatorPanel.ui.padState == 0) {
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
                if (calculatorPanel.ui.padState == 1) {
                    calculatorPanel.ui.operation = calculatorPanel.ui.multiplicationOperation;
                }

            }
            if (clickX >= 701 && clickX <= 850 && clickY >= 501 && clickY <= 650) {
                if (calculatorPanel.ui.padState == 0) {
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
                if (calculatorPanel.ui.padState == 1) {
                    calculatorPanel.ui.operation = calculatorPanel.ui.powerOperation;
                }

            }
            if (clickX >= 851 && clickX <= 1000 && clickY >= 501 && clickY <= 650) {
                if (calculatorPanel.ui.padState == 0) {
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
                if (calculatorPanel.ui.padState == 1) {
                    calculatorPanel.ui.operation = calculatorPanel.ui.factorialOperation;
                }

            }
            if (calculatorPanel.ui.padState == 0 && clickX >= 550 && clickX <= 700 && clickY >= 651 && clickY <= 800) {
                calculatorPanel.ui.padState = 1;

            }else if (calculatorPanel.ui.padState == 1 && clickX >= 550 && clickX <= 700 && clickY >= 651 && clickY <= 800) {
                calculatorPanel.ui.padState = 0;

            }

            if (clickX >= 701 && clickX <= 850 && clickY >= 651 && clickY <= 800) {
                if (calculatorPanel.ui.padState == 0) {
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
                if (calculatorPanel.ui.padState == 1) {
                    calculatorPanel.ui.operation = calculatorPanel.ui.rootOperation;
                }
            }
            if (clickX >= 851 && clickX <= 1000 && clickY >= 651 && clickY <= 800) {
                finalFirstNumber = String.valueOf(calculatorPanel.listNum1);
                finalSecondNumber = String.valueOf(calculatorPanel.listNum2);


                calculatorPanel.calculatorState = calculatorPanel.answerState;
                calculatorPanel.cooldown = 0;
            }
        }
        if (calculatorPanel.calculatorState == calculatorPanel.answerState) {
            if (clickX >= 700 && clickX <= 1100 && clickY >= 700 && clickY <= 760 && calculatorPanel.cooldown == 60) {
                calculatorPanel.ui.restart();
            }
            if (clickX >= 800 && clickX <= 1000 && clickY >= 800 && clickY <= 860) {
                System.exit(0);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}

package tictactoe;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/**
 * <applet code="MainApplet" width="700" heigth="800"></applet>
 */

public class MainApplet extends Applet {

      GameLogic game;

      //This shows the current status of which turn it is.
      int turn = 1;
      boolean isGameOn = true;

      //This shows which blocks from the 9 blocks formed by 3x3 matrix are filled.
      boolean isTicked[] = new boolean[9];

      //Giving Random and Distinct values to block other than 0 and 1.
      //if the block is filled with 'X' sign then it will assign 1 to that block, else it will assign 0.
      int shape[] = {2,3,4,5,6,7,8,9,10};

      public void init() {
            addMouseListener(new Mouse(this));
            this.setSize(700,800);
            game = new GameLogic(this,turn);
      }

      public void update(Graphics g) {
            paint(g);
      }

      public void paint(Graphics g) {
            g.setFont(new Font("TimesRoman",Font.PLAIN,24));
            g.drawLine(300,300,300,600);
            g.drawLine(400,300,400,600);
            g.drawLine(200,400,500,400);
            g.drawLine(200,500,500,500);
            for(int i=0 ; i<9 ; i++) {
                  if(isTicked[i]) {
                        //update the applet with respective symbol.
                        if(shape[i] == 1) {
                              g.drawLine(200+(i%3)*100+25,300+(i/3)*100+25,200+(i%3)*100+75,300+(i/3)*100+75);
                              g.drawLine(200+(i%3)*100+75,300+(i/3)*100+25,200+(i%3)*100+25,300+(i/3)*100+75);
                        }
                        else {
                              g.drawOval(200+(i%3)*100+25,300+(i/3)*100+25,50,50);
                        }
                  }
            }
            if(game.isGameOver(turn-1)) {
                  if((turn-1)%2==1)
                        g.drawString("Player " + 1 + ": won",200,200);
                  else
                        g.drawString("Player " + 2 + ": won",200,200);
                  isGameOn = false;
            }
            else if(turn == 10) {
                  g.drawString("Tie",200,200);
                  isGameOn = false;
            }
      }
}

class Mouse extends MouseAdapter {
      MainApplet m;
      int x,y;
      Mouse(MainApplet m) {
            this.m = m;
      }
      @Override
      public void mouseClicked(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            if(m.isGameOn && m.turn<=9 && x>200 && x<500 && y>300 && y<600) {
                  //First Row
                  if(y>300 && y<=400) {
                        //First Column
                        if(x>200 && x<=300 && !m.isTicked[0]) {
                              m.isTicked[0] = true;
                              if(m.turn%2==1)
                                    m.shape[0] = 1;
                              else
                                    m.shape[0] = 0;
                              m.turn++;
                        }
                        //Second Column
                        else if(x>300 && x<=400 && !m.isTicked[1]) {
                              m.isTicked[1] = true;
                              if(m.turn%2==1)
                                    m.shape[1] = 1;
                              else
                                    m.shape[1] = 0;
                              m.turn++;
                        }
                        //Third Column
                        else if(x>400 && x<=500 && !m.isTicked[2]) {
                              m.isTicked[2] = true;
                              if(m.turn%2==1)
                                    m.shape[2] = 1;
                              else
                                    m.shape[2] = 0;
                              m.turn++;
                        }
                  }

                  //Second Row
                  else if(y>400 && y<=500) {
                        //First Column
                        if(x>200 && x<=300 && !m.isTicked[3]) {
                              m.isTicked[3] = true;
                              if(m.turn%2==1)
                                    m.shape[3] = 1;
                              else
                                    m.shape[3] = 0;
                              m.turn++;
                        }
                        //Second Column
                        else if(x>300 && x<=400  && !m.isTicked[4]) {
                              m.isTicked[4] = true;
                              if(m.turn%2==1)
                                    m.shape[4] = 1;
                              else
                                    m.shape[4] = 0;
                              m.turn++;
                        }
                        //Third Column
                        else if(x>400 && x<=500 && !m.isTicked[5]) {
                              m.isTicked[5] = true;
                              if(m.turn%2==1)
                                    m.shape[5] = 1;
                              else
                                    m.shape[5] = 0;
                              m.turn++;
                        }
                  }

                  //Third Row
                  else {
                        //First Column
                        if(x>200 && x<=300 && !m.isTicked[6]) {
                              m.isTicked[6] = true;
                              if(m.turn%2==1)
                                    m.shape[6] = 1;
                              else
                                    m.shape[6] = 0;
                              m.turn++;
                        }
                        //Second Column
                        else if(x>300 && x<=400 && !m.isTicked[7]) {
                              m.isTicked[7] = true;
                              if(m.turn%2==1)
                                    m.shape[7] = 1;
                              else
                                    m.shape[7] = 0;
                              m.turn++;
                        }
                        //Third Column
                        else if(x>400 && x<=500 && !m.isTicked[8]) {
                              m.isTicked[8] = true;
                              if(m.turn%2==1)
                                    m.shape[8] = 1;
                              else
                                    m.shape[8] = 0;
                              m.turn++;
                        }
                  }
            }
            m.repaint();
      }
}
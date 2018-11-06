package tictactoe;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
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
      boolean isTicked[][] = new boolean[3][3];

      //Giving Random and Distinct values to block other than 0 and 1.
      //if the block is filled with 'X' sign then it will assign 1 to that block, else it will assign 0.
      int shape[][] = {{2,3,4},{5,6,7},{8,9,10}};

      public void init() {
            setBackground(Color.lightGray);
            setForeground(Color.BLACK);
            addMouseListener(new Mouse(this));
            this.setSize(700,800);
            game = new GameLogic(this);
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
            for(int i=0 ; i<3 ; i++) {
                  for(int j=0 ; j<3 ; j++) {
                        if(isTicked[i][j]) {
                              //update the applet with respective symbol.
                              if(shape[i][j] == 1) {
                                    g.drawLine(200+j*100+25,300+i*100+25,200+j*100+75,300+i*100+75);
                                    g.drawLine(200+j*100+75,300+i*100+25,200+j*100+25,300+i*100+75);
                              }
                              else {
                                    g.drawOval(200+j*100+25,300+i*100+25,50,50);
                              }
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
      private MainApplet m;
      Mouse(MainApplet m) {
            this.m = m;
      }
      @Override
      public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            if(m.isGameOn && m.turn<=9 && x>200 && x<500 && y>300 && y<600) {
                  //First Row
                  if(y>300 && y<=400) {
                        //First Column
                        if(x>200 && x<=300 && !m.isTicked[0][0]) {
                              m.isTicked[0][0] = true;
                              if(m.turn%2==1)
                                    m.shape[0][0] = 1;
                              else
                                    m.shape[0][0] = 0;
                              m.turn++;
                        }
                        //Second Column
                        else if(x>300 && x<=400 && !m.isTicked[0][1]) {
                              m.isTicked[0][1] = true;
                              if(m.turn%2==1)
                                    m.shape[0][1] = 1;
                              else
                                    m.shape[0][1] = 0;
                              m.turn++;
                        }
                        //Third Column
                        else if(x>400 && x<=500 && !m.isTicked[0][2]) {
                              m.isTicked[0][2] = true;
                              if(m.turn%2==1)
                                    m.shape[0][2] = 1;
                              else
                                    m.shape[0][2] = 0;
                              m.turn++;
                        }
                  }

                  //Second Row
                  else if(y>400 && y<=500) {
                        //First Column
                        if(x>200 && x<=300 && !m.isTicked[1][0]) {
                              m.isTicked[1][0] = true;
                              if(m.turn%2==1)
                                    m.shape[1][0] = 1;
                              else
                                    m.shape[1][0] = 0;
                              m.turn++;
                        }
                        //Second Column
                        else if(x>300 && x<=400  && !m.isTicked[1][1]) {
                              m.isTicked[1][1] = true;
                              if(m.turn%2==1)
                                    m.shape[1][1] = 1;
                              else
                                    m.shape[1][1] = 0;
                              m.turn++;
                        }
                        //Third Column
                        else if(x>400 && x<=500 && !m.isTicked[1][2]) {
                              m.isTicked[1][2] = true;
                              if(m.turn%2==1)
                                    m.shape[1][2] = 1;
                              else
                                    m.shape[1][2] = 0;
                              m.turn++;
                        }
                  }

                  //Third Row
                  else {
                        //First Column
                        if(x>200 && x<=300 && !m.isTicked[2][0]) {
                              m.isTicked[2][0] = true;
                              if(m.turn%2==1)
                                    m.shape[2][0] = 1;
                              else
                                    m.shape[2][0] = 0;
                              m.turn++;
                        }
                        //Second Column
                        else if(x>300 && x<=400 && !m.isTicked[2][1]) {
                              m.isTicked[2][1] = true;
                              if(m.turn%2==1)
                                    m.shape[2][1] = 1;
                              else
                                    m.shape[2][1] = 0;
                              m.turn++;
                        }
                        //Third Column
                        else if(x>400 && x<=500 && !m.isTicked[2][2]) {
                              m.isTicked[2][2] = true;
                              if(m.turn%2==1)
                                    m.shape[2][2] = 1;
                              else
                                    m.shape[2][2] = 0;
                              m.turn++;
                        }
                  }
            }
            m.repaint();
      }
}

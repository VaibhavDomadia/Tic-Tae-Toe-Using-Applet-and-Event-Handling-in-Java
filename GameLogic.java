package tictactoe;

public class GameLogic {
      MainApplet m;
      GameLogic(MainApplet m , int turn) {
            this.m = m;
      }
      boolean isGameOver(int turn) {
            //Game will never end till you don't give five inputs
            if(turn<5) {
                  return false;
            }
            else {
                  //Check Rows

                  //Checking Row1
                  if(m.shape[0] == m.shape[1] && m.shape[0] == m.shape[2])
                        return true;
                  //Checking Row2
                  else if(m.shape[3] == m.shape[4] && m.shape[3] == m.shape[5])
                        return true;
                  //Checking Row3
                  else if(m.shape[6] == m.shape[7] && m.shape[6] == m.shape[8])
                        return true;

                  //Checking Columns

                  //Checking Column1
                  else if(m.shape[0] == m.shape[3] && m.shape[0] == m.shape[6])
                        return true;
                  //Checking Column2
                  else if(m.shape[1] == m.shape[4] && m.shape[1] == m.shape[7])
                        return true;
                  //Checking Column3
                  else if(m.shape[2] == m.shape[5] && m.shape[2] == m.shape[8])
                        return true;

                  //Checking Diagonals

                  else if(m.shape[0] == m.shape[4] && m.shape[0] == m.shape[8])
                        return true;
                  else if(m.shape[2] == m.shape[4] && m.shape[2] == m.shape[6])
                        return true;

                  //Return false if all condition fails.
                  else
                        return false;
            }
      }
}

package tictactoe;

class GameLogic {
      private MainApplet m;
      GameLogic(MainApplet m) {
            this.m = m;
      }
      boolean isGameOver(int turn) {
            //Game will never end till you don't give five inputs
            if(turn<5) {
                  return false;
            }
            else {
                  //Checking Rows
                  for(int i=0 ; i<3 ; i++) {
                        if(m.shape[i][0] == m.shape[i][1] && m.shape[i][0] == m.shape[i][2])
                              return true;
                  }

                  //Checking Columns
                  for(int j=0 ; j<3 ; j++) {
                        if(m.shape[0][j] == m.shape[1][j] && m.shape[0][j] == m.shape[2][j])
                              return true;
                  }

                  //Checking Diagonals
                  if(m.shape[0][0] == m.shape[1][1] && m.shape[0][0] == m.shape[2][2])
                        return true;
                  else if(m.shape[0][2] == m.shape[1][1] && m.shape[0][2] == m.shape[2][0])
                        return true;

                  //Return false if all condition fails.
                  else
                        return false;
            }
      }
}

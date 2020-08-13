/**
 * Thank you to internet alias LyndonArmitage for the help with the Tic Tac Toe code!
 * Link to the code: https://github.com/LyndonArmitage/NaughtsAndCrosses
 */

package com.samkough.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private Button aboutB;
    // Representing the game state:
    private boolean noughtsTurn = false; // Who's turn is it? false = X true = O
    private char board[][] = new char[3][3]; // we represent the board as an array of characters


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupOnClickListeners();
        resetButtons();

        aboutB = (Button) findViewById(R.id.aboutButton);
        aboutB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);

                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });
    }

    /**
     * Called when you press new game.
     *
     * @param view the New Game Button
     */
    public void newGame(View view)
    {
        noughtsTurn = false;
        board = new char[3][3];
        resetButtons();
    }

    /**
     * Reset each button in the grid to be blank and enabled.
     */
    private void resetButtons()
    {
        TableLayout T = (TableLayout) findViewById(R.id.tableLayout);
        for (int y = 0; y < T.getChildCount(); y++)
        {
            if (T.getChildAt(y) instanceof TableRow)
            {
                TableRow R = (TableRow) T.getChildAt(y);
                for (int x = 0; x < R.getChildCount(); x++)
                {
                    if (R.getChildAt(x) instanceof Button)
                    {
                        Button B = (Button) R.getChildAt(x);
                        B.setText("");
                        B.setEnabled(true);
                    }
                }
            }
        }

        TextView t = (TextView) findViewById(R.id.titleText);
        t.setText(R.string.title);
    }

    /**
     * Method that returns true when someone has won and false when nobody has.<br />
     * It also display the winner on screen.
     *
     * @return
     */
    private boolean checkWin()
    {

        char winner = '\0';
        if (checkWinner(board, 3, 'X'))
        {
            winner = 'X';
        } else if (checkWinner(board, 3, 'O'))
        {
            winner = 'O';
        }

        if (winner == '\0')
        {
            return false; // nobody won
        }
        else
        {
            // display winner
            TextView T = (TextView) findViewById(R.id.titleText);
            T.setText(winner + " wins");
            return true;
        }
    }


    /**
     * This is a generic algorithm for checking if a specific player has won on a tic tac toe board of any size.
     *
     * @param board  the board itself
     * @param size   the width and height of the board
     * @param player the player, 'X' or 'O'
     * @return true if the specified player has won
     */
    private boolean checkWinner(char[][] board, int size, char player)
    {
        // check each column
        for (int x = 0; x < size; x++)
        {
            int total = 0;
            for (int y = 0; y < size; y++)
            {
                if (board[x][y] == player)
                {
                    total++;
                }
            }
            if (total >= size)
            {
                return true; // they win
            }
        }

        // check each row
        for (int y = 0; y < size; y++)
        {
            int total = 0;
            for (int x = 0; x < size; x++)
            {
                if (board[x][y] == player)
                {
                    total++;
                }
            }
            if (total >= size)
            {
                return true; // they win
            }
        }

        // forward diag
        int total = 0;
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                if (x == y && board[x][y] == player)
                {
                    total++;
                }
            }
        }
        if (total >= size)
        {
            return true; // they win
        }

        // backward diag
        total = 0;
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                if (x + y == size - 1 && board[x][y] == player)
                {
                    total++;
                }
            }
        }
        if (total >= size)
        {
            return true; // they win
        }

        return false; // nobody won
    }

    /**
     * Disables all the buttons in the grid.
     */
    private void disableButtons()
    {
        TableLayout T = (TableLayout) findViewById(R.id.tableLayout);
        for (int y = 0; y < T.getChildCount(); y++)
        {
            if (T.getChildAt(y) instanceof TableRow)
            {
                TableRow R = (TableRow) T.getChildAt(y);
                for (int x = 0; x < R.getChildCount(); x++)
                {
                    if (R.getChildAt(x) instanceof Button)
                    {
                        Button B = (Button) R.getChildAt(x);
                        B.setEnabled(false);
                    }
                }
            }
        }
    }

    /**
     * This will add the OnClickListener to each button inside out TableLayout
     */
    private void setupOnClickListeners()
    {
        TableLayout T = (TableLayout) findViewById(R.id.tableLayout);
        for (int y = 0; y < T.getChildCount(); y++)
        {
            if (T.getChildAt(y) instanceof TableRow)
            {
                TableRow R = (TableRow) T.getChildAt(y);
                for (int x = 0; x < R.getChildCount(); x++)
                {
                    View V = R.getChildAt(x); // In our case this will be each button on the grid
                    V.setOnClickListener(new PlayOnClick(x, y));
                }
            }
        }
    }

    /**
     * Custom OnClickListener for Noughts and Crosses<br />
     * Each Button for Noughts and Crosses has a position we need to take into account
     *
     * @author Lyndon Armitage
     */
    private class PlayOnClick implements View.OnClickListener
    {

        private int x = 0;
        private int y = 0;

        public PlayOnClick(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        @Override
        public void onClick(View view)
        {
            if (view instanceof Button)
            {
                Button B = (Button) view;
                board[x][y] = noughtsTurn ? 'O' : 'X';
                B.setText(noughtsTurn ? "O" : "X");
                B.setEnabled(false);
                noughtsTurn = !noughtsTurn;

                // check if anyone has won
                if (checkWin())
                {
                    disableButtons();
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

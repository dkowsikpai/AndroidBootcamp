package com.example.ticktack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean player1 = true;
    int red = 0, yellow = 0, draw=0;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, butt;
    TextView redplayer, yellowplayer, drawevent;
    Selected play = new Selected();
    int[][] win = {{R.id.b1, R.id.b2, R.id.b3},
                    {R.id.b1, R.id.b4, R.id.b7},
                    {R.id.b1, R.id.b5, R.id.b9},
                    {R.id.b2, R.id.b5, R.id.b8},
                    {R.id.b3, R.id.b6, R.id.b9},
                    {R.id.b3, R.id.b5, R.id.b7},
                    {R.id.b4, R.id.b5, R.id.b6},
                    {R.id.b7, R.id.b8, R.id.b9}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);

        redplayer = findViewById(R.id.redplayer);
        yellowplayer = findViewById(R.id.yellowplayer);
        drawevent = findViewById(R.id.draw);

        View.OnClickListener click_event= new View.OnClickListener() {
            public void onClick(View v) {
                butt = findViewById(v.getId());
                if (player1){
                    butt.setAlpha(0.5f);
                    butt.setBackgroundResource(R.drawable.redpad);
                    butt.animate().alpha(1f).setDuration(1000);
                    butt.setEnabled(false);
                    play.click(v.getId(), -100);
                    if(play.win()){
                        Toast.makeText(getApplicationContext(), "Congrats !!! Red Wins the Tick Tack Toe", Toast.LENGTH_LONG).show();
                        red += 1;
                        String temp = "Red: " + toString().valueOf(red);
                        redplayer.setText(temp);
                        b1.setEnabled(false);
                        b2.setEnabled(false);
                        b3.setEnabled(false);
                        b4.setEnabled(false);
                        b5.setEnabled(false);
                        b6.setEnabled(false);
                        b7.setEnabled(false);
                        b8.setEnabled(false);
                        b9.setEnabled(false);
                    }

                    if(play.draw() && !play.win()){
                        Toast.makeText(getApplicationContext(), "Its a Draw", Toast.LENGTH_LONG).show();
                        draw += 1;
                        String temp = "Draw: " + toString().valueOf(draw);
                        drawevent.setText(temp);
                        b1.setEnabled(false);
                        b2.setEnabled(false);
                        b3.setEnabled(false);
                        b4.setEnabled(false);
                        b5.setEnabled(false);
                        b6.setEnabled(false);
                        b7.setEnabled(false);
                        b8.setEnabled(false);
                        b9.setEnabled(false);
                    }

                    player1 = false;
                } else {
                    butt.setAlpha(0.5f);
                    butt.setBackgroundResource(R.drawable.yelpad);
                    butt.animate().alpha(1f).setDuration(1000);
                    butt.setEnabled(false);
                    play.click(v.getId(), -200);
                    Log.i("wongame", toString().valueOf(play.win()));
                    if(play.win()){
                        Toast.makeText(getApplicationContext(), "Congrats !!! Yellow Wins the Tick Tack Toe", Toast.LENGTH_LONG).show();
                        yellow += 1;
                        String temp = "Yellow: " + toString().valueOf(yellow);
                        yellowplayer.setText(temp);
                        b1.setEnabled(false);
                        b2.setEnabled(false);
                        b3.setEnabled(false);
                        b4.setEnabled(false);
                        b5.setEnabled(false);
                        b6.setEnabled(false);
                        b7.setEnabled(false);
                        b8.setEnabled(false);
                        b9.setEnabled(false);
                    }

                    if(play.draw() && !play.win()){
                        Toast.makeText(getApplicationContext(), "Its a Draw", Toast.LENGTH_LONG).show();
                        draw += 1;
                        String temp = "Draw: " + toString().valueOf(draw);
                        drawevent.setText(temp);
                        b1.setEnabled(false);
                        b2.setEnabled(false);
                        b3.setEnabled(false);
                        b4.setEnabled(false);
                        b5.setEnabled(false);
                        b6.setEnabled(false);
                        b7.setEnabled(false);
                        b8.setEnabled(false);
                        b9.setEnabled(false);
                    }
                    player1 = true;
                }

                        Log.i("hhhhhhhh", toString().valueOf(win.length) +"--"+ toString().valueOf(win[0].length)+"--"+ toString().valueOf(win[1].length)+"--"+ toString().valueOf(win[2].length));

            }

        };

        b1.setOnClickListener(click_event);
        b2.setOnClickListener(click_event);
        b3.setOnClickListener(click_event);
        b4.setOnClickListener(click_event);
        b5.setOnClickListener(click_event);
        b6.setOnClickListener(click_event);
        b7.setOnClickListener(click_event);
        b8.setOnClickListener(click_event);
        b9.setOnClickListener(click_event);


    }

    public void resetgame(View view) {
        win[0][0] = R.id.b1;
        win[0][1] = R.id.b2;
        win[0][2] = R.id.b3;
        win[1][0] = R.id.b1;
        win[1][1] = R.id.b4;
        win[1][2] = R.id.b7;
        win[2][0] = R.id.b1;
        win[2][1] = R.id.b5;
        win[2][2] = R.id.b9;
        win[3][0] = R.id.b2;
        win[3][1] = R.id.b5;
        win[3][2] = R.id.b8;
        win[4][0] = R.id.b3;
        win[4][1] = R.id.b6;
        win[4][2] = R.id.b9;
        win[5][0] = R.id.b3;
        win[5][1] = R.id.b5;
        win[5][2] = R.id.b7;
        win[6][0] = R.id.b4;
        win[6][1] = R.id.b5;
        win[6][2] = R.id.b6;
        win[7][0] = R.id.b7;
        win[7][1] = R.id.b8;
        win[7][2] = R.id.b9;

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);

        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);

        b1.setBackgroundResource(R.drawable.button_st1);
        b2.setBackgroundResource(R.drawable.button_st1);
        b3.setBackgroundResource(R.drawable.button_st1);
        b4.setBackgroundResource(R.drawable.button_st1);
        b5.setBackgroundResource(R.drawable.button_st1);
        b6.setBackgroundResource(R.drawable.button_st1);
        b7.setBackgroundResource(R.drawable.button_st1);
        b8.setBackgroundResource(R.drawable.button_st1);
        b9.setBackgroundResource(R.drawable.button_st1);

        player1 = true;

    }

    class Selected{
        void click(int rep, int val){
            for(int i = 0; i < win.length; i++){
                for (int j = 0; j < win[i].length; j++){
                    if (win[i][j] == rep){
                        win[i][j] = val;
                        Log.i("third", toString().valueOf(i) +"--"+ toString().valueOf(j) +"--"+ toString().valueOf(rep) +"--"+ toString().valueOf(val));
                    }
                }
            }

        }

        boolean win(){
            boolean endgame = false;
            for (int[] ints : win) {
                endgame = ints[0] == ints[1] && ints[0] == ints[2];
                if(endgame)return endgame;
            }
            return false;
        }

        boolean draw(){
            boolean endgame = false;
            int counter = 0;
            for(int[] i : win){
                for (int j : i){
                    if(j == -100 || j==-200){
                        counter++;
                    }
                }
            }
            endgame = counter == 24;
            return endgame;
        }
    }
}

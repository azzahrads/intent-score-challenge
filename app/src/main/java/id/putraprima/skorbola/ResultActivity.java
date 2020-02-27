package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

import id.putraprima.skorbola.model.Match;

public class ResultActivity extends AppCompatActivity {

    private static final String DATA_KEY = "data";
    TextView tvWinner, tvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tvWinner = findViewById(R.id.tv_winner);
        tvList = findViewById(R.id.tv_list);

        Bundle extras = getIntent().getExtras();
        Match match = getIntent().getParcelableExtra(DATA_KEY);
        if (extras != null) {
            String name = "";
            if(match.resultScore().equals(match.getHomeTeam())) {
                for (String win : match.getHomeScorer()) {
                    name += win + "\n";
                    Log.d("who?", "list of scorer " + win);
                }
                tvWinner.setText("The winner is "+ match.resultScore());
                tvList.setText(name);
            }else if(match.resultScore().equals(match.getAwayTeam())) {
                for (String win : match.getAwayScorer()) {
                    name += win + "\n";
                    Log.d("who?", "list of scorer " + win);
                }
                tvWinner.setText("The winner is "+ match.resultScore());
                tvList.setText(name);
            }else{
                tvWinner.setText(match.resultScore());
                tvList.setText("");
            }
        }
    }
}

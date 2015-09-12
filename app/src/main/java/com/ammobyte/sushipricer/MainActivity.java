package com.ammobyte.sushipricer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

/*
    yellow: $1.75
    blue: $2.25
    green: $2.75
    red: $3.25
    purple: $3.75
    orange: $4.25

 */
public class MainActivity extends AppCompatActivity {

    int cost = 0;   //combined cost of dishes in cents
    int plates = 0; //plates in current order
    final int MAX_PLATES = 20;  //maximum plates that can be calculated (to prevent overflow)
    TextView sub, tax, tot;
    Button yel, blu, grn, red, pur, org;
    DecimalFormat df = new DecimalFormat("'$'0.00");
    View.OnClickListener clickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("click");
                if(plates<MAX_PLATES) {
                    switch (v.getId()) {
                        case R.id.yellow:
                            cost+=175;
                            break;
                        case R.id.blue:
                            cost+=225;
                            break;
                        case R.id.green:
                            cost+=275;
                            break;
                        case R.id.red:
                            cost+=325;
                            break;
                        case R.id.purple:
                            cost+=375;
                            break;
                        case R.id.orange:
                            cost+=425;
                            break;
                    }
                    System.out.println(cost+", "+plates);
                    plates++;
                    System.out.println(plates);

                    sub.setText(df.format(cost/100));
                    int taxI = cost/10000;
                    taxI*=8.25;
                    tax.setText(df.format(taxI));
                    tot.setText(df.format((cost/100)+taxI));
                }
            }
        };

        //text
        sub = (TextView)findViewById(R.id.textView3);
        tax = (TextView)findViewById(R.id.textView5);
        tot = (TextView)findViewById(R.id.textView7);

        //button initialization and listener
        this.yel = (Button) findViewById(R.id.yellow);
        yel.setOnClickListener(clickListener);

        this.blu = (Button) findViewById(R.id.blue);
        blu.setOnClickListener(clickListener);

        this.grn = (Button) findViewById(R.id.green);
        grn.setOnClickListener(clickListener);

        this.red = (Button) findViewById(R.id.red);
        red.setOnClickListener(clickListener);

        this.pur = (Button) findViewById(R.id.purple);
        pur.setOnClickListener(clickListener);

        this.org = (Button) findViewById(R.id.orange);
        org.setOnClickListener(clickListener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

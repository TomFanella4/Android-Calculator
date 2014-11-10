package edu.purdue.tom.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CalculatorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        final Button[] buttons = new Button[14];
        Button clear = (Button) findViewById(R.id.clear);
        Button equals = (Button) findViewById(R.id.equ);
        final TextView result = (TextView) findViewById(R.id.review);

        buttons[0] = (Button) findViewById(R.id.num0);
        buttons[1] = (Button) findViewById(R.id.num1);
        buttons[2] = (Button) findViewById(R.id.num2);
        buttons[3] = (Button) findViewById(R.id.num3);
        buttons[4] = (Button) findViewById(R.id.num4);
        buttons[5] = (Button) findViewById(R.id.num5);
        buttons[6] = (Button) findViewById(R.id.num6);
        buttons[7] = (Button) findViewById(R.id.num7);
        buttons[8] = (Button) findViewById(R.id.num8);
        buttons[9] = (Button) findViewById(R.id.num9);
        buttons[10] = (Button) findViewById(R.id.add);
        buttons[11] = (Button) findViewById(R.id.sub);
        buttons[12] = (Button) findViewById(R.id.mul);
        buttons[13] = (Button) findViewById(R.id.div);

        for (final Button currentButton : buttons) {
            currentButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String currentText = result.getText().toString();
                    if (result.getText().toString().equals("0"))
                        result.setText("");
                    String numValue = currentButton.getText().toString();
                    if (numValue.equals("+") || numValue.equals("-") || numValue.equals("*") || numValue.equals("/"))
                        if (numValue.equals("-"))
                        if (currentText.length() > 0 && !numValue.equals(currentText.substring(currentText.length() - 1)))
                            result.setText(result.getText() + numValue);

                }
            });
        }

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("0");
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r = result.getText().toString();
                String operation = "";
                for (int i = 10; i < buttons.length; i++) {
                    if (r.indexOf(buttons[i].getText().toString()) > 0)
                        operation = buttons[i].getText().toString();
                }
                int num1 = Integer.parseInt(r.substring(0, r.indexOf(operation)));
                int num2 = Integer.parseInt(r.substring(r.indexOf(operation) + 1));
                if (operation.equals("+"))
                    result.setText(Integer.toString(num1 + num2));
                if (operation.equals("-"))
                    result.setText(Integer.toString(num1 - num2));
                if (operation.equals("*"))
                    result.setText(Integer.toString(num1 * num2));
                if (operation.equals("/"))
                    result.setText(Integer.toString(num1 / num2));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

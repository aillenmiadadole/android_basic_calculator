package com.miaapp.calcapp;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.util.*;

public class MainActivity extends Activity implements View.OnClickListener
{
	Context context;
	Button btn1;
	Button btn2;
	Button btn3;
	Button btn4;
	Button btn5;
	Button btn6;
	Button btn7;
	Button btn8;
	Button btn9;
	Button btn0;
	Button btnEquals;
	Button btnPlus;
	Button btnMinus;
	Button btnTimes;
	Button btnDivide;
	Button btnClr;
	Button btnDot;
	TextView input_field;
	TextView answer_field;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		context=this;
		input_field=(TextView)findViewById(R.id.editTextInput);
	//	input_field.setTextDirection(
		answer_field=(TextView)findViewById(R.id.textViewAnswer);
		btn1=(Button)findViewById(R.id.buttonNo1);
		btn2=(Button)findViewById(R.id.buttonNo2);
		btn3=(Button)findViewById(R.id.buttonNo3);
		btn4=(Button)findViewById(R.id.buttonNo4);
		btn5=(Button)findViewById(R.id.buttonNo5);
		btn6=(Button)findViewById(R.id.buttonNo6);
		btn7=(Button)findViewById(R.id.buttonNo7);
		btn8=(Button)findViewById(R.id.buttonNo8);
		btn9=(Button)findViewById(R.id.buttonNo9);
		btn0=(Button)findViewById(R.id.buttonNo0);
		btnEquals=(Button)findViewById(R.id.buttonNoEquals);
		btnPlus=(Button)findViewById(R.id.buttonPlus);
		btnMinus=(Button)findViewById(R.id.buttonMinus);
		btnTimes=(Button)findViewById(R.id.buttonTimes);
		btnDivide=(Button)findViewById(R.id.buttonDivide);
		btnClr=(Button)findViewById(R.id.buttonClr);
		btnDot=(Button)findViewById(R.id.buttonDot);
		
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		btn6.setOnClickListener(this);
		btn7.setOnClickListener(this);
		btn8.setOnClickListener(this);
		btn9.setOnClickListener(this);
		btn0.setOnClickListener(this);
		btnEquals.setOnClickListener(this);
		btnPlus.setOnClickListener(this);
		btnMinus.setOnClickListener(this);
		btnTimes.setOnClickListener(this);
		btnDivide.setOnClickListener(this);
		btnClr.setOnClickListener(this);
		btnDot.setOnClickListener(this);
    }
	
	@Override
	public void onClick(View p1)
	{
		// TODO: Implement this method
		Button p=(Button)p1;
		String val=p.getText().toString();
		String t=input_field.getText().toString();
		double values[];
		String input="";
		switch (val) {
			case "1":
				input_field.setText(t+"1");
			break;
			case "2":
				input_field.setText(t+"2");
			break;
			case "3":
				input_field.setText(t+"3");
				break;
			case "4":
				input_field.setText(t+"4");
				break;
			case "5":
				input_field.setText(t+"5");
				break;
			case "6":
				input_field.setText(t+"6");
				break;
			case "7":
				input_field.setText(t+"7");
				break;
			case "8":
				input_field.setText(t+"8");
				break;
			case "9":
				input_field.setText(t+"9");
				break;
			case "0":
				input_field.setText(t+"0");
				break;
			case "+":
				if (notEmpty())
				input_field.setText(t+"+");
				break;
			case "-":
				if (notEmpty())
				input_field.setText(t+"-");
				break;
			case "×":
				if (notEmpty())
				input_field.setText(t+"×");
				break;
			case "÷":
				if (notEmpty())
				input_field.setText(t+"÷");
				break;
			case ".":
					input_field.setText(t+".");
				break;
			case "Clear":
				input_field.setText(null);
				values=new double[0];
				input="";
				answer_field.setText("");
				break;
			case "=":
				try {
				if (notEmpty()) {
					input=input_field.getText().toString();
					String temp=input;
					StringTokenizer tokens=new StringTokenizer(temp, "1234567890");
					String operators="";
					double total=0.0;
					while (tokens.hasMoreTokens()) {
						operators+=tokens.nextToken();
					}
					//Toast.makeText(context, operators, Toast.LENGTH_SHORT).show();
			        tokens=new StringTokenizer(input,"+-×÷");
					String te="";
                    int l=1;
					while (tokens.hasMoreTokens()) {
						double d=Double.parseDouble(tokens.nextToken());
						te+=Double.toString(d) + "-";
						l++;
					}
					tokens=new StringTokenizer(te, "-");
					values=new double[l];
					int count=0;
					while (tokens.hasMoreTokens()) {
						values[count]=Double.parseDouble(tokens.nextToken());
						count++;
					}
					
					total=calculate(values, operators);
					String nn=Double.toString(total);
					if (String.valueOf(nn.charAt(nn.length()-1)).equals("0")) {
						answer_field.setText(Integer.toString((int)total));
					}
					else {
						answer_field.setText(Double.toString(total));
					}
				}
				}catch(Exception e) {
					input_field.setText("Syntax Error");
				}
			break;
		}
	}
	private boolean notEmpty() {
		boolean isempty=true;
		if (input_field.getText().toString().equals(" ") || input_field.getText() == null || input_field.getText().toString().trim().length() < 1) {
			isempty=false;
		}
		return isempty;
	}
	public double calculate(double values[], String ops) {
		double total =0.0;
		try {
		total=values[0];
		for (int i=0; i<ops.length(); i++) {
			if (ops.charAt(i) == '+') {
				total+=values[i+1];
			}
			else if (ops.charAt(i) == '-') {
				total-=values[i+1];
			}
			else if (ops.charAt(i) == '×') {
				total*=values[i+1];
			}
			else {
				total/=values[i+1];
			}
		}
		}catch(Exception e) {
			input_field.setText("Syntax Error");
		}
		return total;
	}
}

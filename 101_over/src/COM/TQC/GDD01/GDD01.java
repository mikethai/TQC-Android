package COM.TQC.GDD01;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class GDD01 extends Activity {
    /** Called when the activity is first created. */
	
	   //第一部曲:魔族的宣告
   private Button submit;
   private EditText input_lend;
   private EditText input_rate;
   private EditText input_number;
   private TextView amount;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
   
   
   //第二部曲:魔族世界的連結     
    submit = (Button) findViewById(R.id.submit);
    input_lend = (EditText) findViewById(R.id.input_lend);
    input_rate = (EditText) findViewById(R.id.input_rate);
    input_number = (EditText) findViewById(R.id.input_number);
    amount= (TextView) findViewById(R.id.amount);
 
   //第三部曲:開始動作 
    submit.setOnClickListener(caclcMoney);
    }
 
   
   private Button.OnClickListener caclcMoney= new Button.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		DecimalFormat nf =new DecimalFormat("0");
		double lend =Double.parseDouble(input_lend.getText().toString());
		double rate =Double.parseDouble(input_rate.getText().toString())/12/100;
		double number =Double.parseDouble(input_number.getText().toString());
		
		double total = Math.floor(lend*Math.pow(1+rate, number));
		
		amount.setText("本利和為:"+nf.format(total));
		
	}
};
    
}
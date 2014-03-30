package COM.TQC.GDD01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class GDD01 extends Activity {
 
	protected TextView MyOutcome;
	protected int volt;
	private EditText input_a,input_hr,input_m;
	private Spinner field_v;
	private Button submit;
	private TextView respond;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        field_v= (Spinner) findViewById(R.id.option_v);
        input_a=(EditText) findViewById(R.id.input_a);     
        input_hr=(EditText) findViewById(R.id.input_hr);
        input_m=(EditText) findViewById(R.id.input_m);
        submit=(Button) findViewById(R.id.submit);
        respond=(TextView) findViewById(R.id.respond);
       
        
        ///////////////////Spinner觸發監聽器///////////////////////////////////
        field_v.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				if(arg2 == 0 ) volt= 110;
				else volt=220;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
        /////////////////////Button觸發監聽器///////////////////////////////////
        
        submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				double a = Double.parseDouble(input_a.getText().toString());
				double hr = Double.parseDouble(input_hr.getText().toString());
				double m = Double.parseDouble(input_m.getText().toString());
				double w = (int)a*volt;
				int result= (int) Math.round(w/1000 *hr *30 * m);
				respond.setText("$ "+result);
				
				
				
			}
		});
       ///////////////////////////////////////////////////////////////////////// 
    }
	
	
}
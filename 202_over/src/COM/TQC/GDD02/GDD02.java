package COM.TQC.GDD02;
/*
�D�ػ����G
�^�` = ���� * 3.28
���� = �^�` * 0.3048
*/

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class GDD02 extends Activity {

	private double ed_value=0,pas_value=0;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
  
        Button submit01 = (Button) findViewById(R.id.submit01);
        Button submit02 = (Button) findViewById(R.id.submit02);
        submit01.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText intput_value = (EditText) findViewById(R.id.input_value);
				ed_value = Double.parseDouble(intput_value.getText().toString());
				DecimalFormat df1= new DecimalFormat("0.0");
				DecimalFormat df2= new DecimalFormat("0.00");
				pas_value=ed_value*3.28;
				TextView result = (TextView) findViewById(R.id.result);
				result.setText(df1.format(ed_value)+"���� = "+df2.format(pas_value)+"�^�`");
			}
		});
        submit02.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText intput_value = (EditText) findViewById(R.id.input_value);
				ed_value = Double.parseDouble(intput_value.getText().toString());
				DecimalFormat df1= new DecimalFormat("0.0");
				DecimalFormat df2= new DecimalFormat("0.00");
				pas_value=ed_value*0.3048;
				TextView result = (TextView) findViewById(R.id.result);
				result.setText(df1.format(ed_value)+"�^�` = "+df2.format(pas_value)+"����");
			}
		});
        
    }

    @Override 
    public boolean 
    onCreateOptionsMenu(Menu menu) 
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);    
        return true;
    }
    
    public boolean 
    onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId()){
        
        case R.id.menu_reset:
        	ResetValue();
        	break;
        	
        }
        return true;
    }
    
    private void
    ResetValue()
    {
    	EditText intput_value = (EditText) findViewById(R.id.input_value);
    	intput_value.setText("");
    	TextView result = (TextView) findViewById(R.id.result);
    	result.setText("");
    }
}
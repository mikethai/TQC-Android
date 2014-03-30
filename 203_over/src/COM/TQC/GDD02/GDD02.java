package COM.TQC.GDD02;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GDD02 extends Activity {
	public static final String PREF_ExchangeRate = "Exchange_Rate" ;
    private Button calcbutton ;
	private EditText fieldExchangeRate ;
	private EditText fieldNTD ;
	private TextView textv;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       
        calcbutton=(Button) findViewById(R.id.button1);
        fieldExchangeRate=(EditText) findViewById(R.id.editText1);
		fieldNTD=(EditText) findViewById(R.id.editText2);
		textv=(TextView) findViewById(R.id.textView3);
        
        restorePrefs();
        
        calcbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				double rate,ntw,result;
				
				rate=Double.parseDouble(fieldExchangeRate.getText().toString());
				ntw=Double.parseDouble(fieldNTD.getText().toString());
				result=ntw/rate;
				
				DecimalFormat df= new DecimalFormat("0.00");
				
				textv.setText(getString(R.string.usd_result)+df.format(result));
				
			}
		});
       
       

       
    }
    
    public void onStop() {
    	super.onStop() ;
    	SharedPreferences settings = getSharedPreferences(PREF_ExchangeRate, 0);
    	settings.edit().putString(PREF_ExchangeRate, fieldExchangeRate.getText().toString()).commit() ;
    	
    }
   

    private void restorePrefs(){
    	
    	SharedPreferences settings = getSharedPreferences(PREF_ExchangeRate, 0);
    	
    	String pref_rate=settings.getString(PREF_ExchangeRate, "");
    	if(pref_rate!=""){
    		fieldExchangeRate.setText(pref_rate);  //設定值到匯率
    		fieldNTD.requestFocus();     //直接把焦點帶到新台幣那格
    		
    	}
    	
    	
    }
    
    










}


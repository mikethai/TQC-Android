package COM.TQC.GDD01;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class GDD01 extends Activity {
	
	private EditText et1;
	private CheckBox cb;
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    
    et1=(EditText) findViewById(R.id.mPassword);
    cb=(CheckBox) findViewById(R.id.mCheck);
    
    cb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			// TODO Auto-generated method stub
			if(cb.isChecked()){
		    	et1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
		    }else{
		    	et1.setTransformationMethod(PasswordTransformationMethod.getInstance());
		    }	
		}
	});
    
    
    
  }
}
package COM.TQC.GDD01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class GDD01 extends Activity {
  private String[] types={"½Ð¿ï¾Ü","HTC HERO","HTC MAGIC","HTC TATTOO",
      "NEXUS ONE","SONY X10","MOTO MILESTONE"};
  private Spinner sp ;
  private TextView text;
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);    
    
    sp = (Spinner) findViewById(R.id.mySpinner);
    text = (TextView) findViewById(R.id.text1);
    
    ArrayAdapter<String> adp =new ArrayAdapter<String>(GDD01.this, R.layout.myspinner_layout, types);
    sp.setAdapter(adp);
    sp.setOnItemSelectedListener(new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			if (arg2==0){
				text.setText(getString(R.string.str1));
			}else{
					text.setText(getString(R.string.str1)+types[arg2]);	
				}
				
			
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	});
  }
  
 
}
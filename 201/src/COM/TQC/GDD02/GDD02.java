package COM.TQC.GDD02;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class GDD02 extends Activity {
    /** Called when the activity is first created. */

	//private EditText input_number;
	private Button submit;
	private TextView respond;
	
	private int a,b,c,A,B;
	//private String userans;
	//private int userans_a,userans_b,userans_c;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main201);
        
       // input_number = (EditText) findViewById(R.id.input_number);
        submit = (Button) findViewById(R.id.submit);
        respond = (TextView) findViewById(R.id.respond);
        getnum();
        submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			respond.setText("1="+a+",2="+b+",3="+c);	
				
			}
		});
        
        
    }

	public void getnum(){
		int get_a,get_b,get_c;
		get_a= (int) Math.random()*10;
		get_b= (int) Math.random()*10;
		get_c= (int) Math.random()*10;
		
		while(get_a==get_b){
			get_b= (int) Math.random()*10;
			while(get_b==get_c){
				get_c= (int) Math.random()*10;
			}
		}
		
		a=get_a;
		b=get_b;
		c=get_a;
	}



}
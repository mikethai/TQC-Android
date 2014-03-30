package COM.TQC.GDD01;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class GDD01 extends Activity {
  private EditText et;
  private RadioButton rb1;
  private RadioButton rb2;
  private CheckBox cb1;
  private CheckBox cb2;
  private CheckBox cb3;
  private Button button;
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    et = (EditText) findViewById(R.id.name);
    rb1 = (RadioButton) findViewById(R.id.rButton1);
    rb2 = (RadioButton) findViewById(R.id.rButton2);
    cb1 = (CheckBox) findViewById(R.id.cBox1);
    cb2 = (CheckBox) findViewById(R.id.cBox2);
    cb3 = (CheckBox) findViewById(R.id.cBox3);
    button = (Button) findViewById(R.id.button1);
        
    
    
    button.setOnClickListener(new Button.OnClickListener(){
      @Override
      public void onClick(View v){
    	  
    	  Builder ad =new AlertDialog.Builder(GDD01.this);
    	    ad.setTitle("結果");
    	  
    	  String s="";
    	  if(!et.getText().toString().equals("")){
    		  s+="姓名: "+et.getText().toString()+"\n";
    	  }else{
    		  s+="姓名: 未填\n";
    	  }
    	  
    	  if(rb1.isChecked()){
    		  s+="性別: "+rb1.getText().toString()+"\n";
    	  }else{
    		  s+="性別: "+rb2.getText().toString()+"\n";
    	  }
    	  s+="興趣:";
          int cnt=0;
          if(cb1.isChecked()){
        	  s+=cb1.getText().toString()+",";
        	  cnt++;
          }
          if(cb2.isChecked()){
        	  s+=cb2.getText().toString()+",";
        	  cnt++;
          }
          if(cb3.isChecked()){
        	  s+=cb3.getText().toString()+",";
        	  cnt++;
          }
          if(cnt==0){
        	  s+="未選擇";
          }
          
          ad.setMessage(s);
          ad.setPositiveButton("離開", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		});
          
          ad.show();
      }
    });
  }
}
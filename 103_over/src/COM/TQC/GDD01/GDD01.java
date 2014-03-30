package COM.TQC.GDD01;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GDD01 extends Activity {
  private Button button1;
  private TextView text1;
  private String[] s1={"美味蟹堡","義式香腸堡","蔬菜水果堡","香蕉潛艇堡","香烤雞肉堡"};
  private boolean[] if_check={false,false,false,false,false};
  
  private OnMultiChoiceClickListener ad_di = new DialogInterface.OnMultiChoiceClickListener() {	
		@Override
		public void onClick(DialogInterface dialog, int which, boolean isChecked) {
			// TODO Auto-generated method stub
			if(isChecked)
				if_check[which]=true;
		}
	};
  private OnClickListener pos_btnlsr = new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			String Temp="";
			for(int i=0; i<if_check.length;i++){
				if(if_check[i]){
					Temp=Temp+s1[i]+"\n";
				}
			}
		 text1.setText(getResources().getString(R.string.str2)+"\n"+Temp);	
		}
	};	
 private OnClickListener neg_btnlsr = new DialogInterface.OnClickListener() {
			
		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
				
		}
	}; 
	
	
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    
    button1 = (Button) findViewById(R.id.button1);
    text1 = (TextView) findViewById(R.id.text1);
    
    button1.setOnClickListener(new Button.OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
    	 Builder ad= new AlertDialog.Builder(GDD01.this);
    	 ad.setTitle(getResources().getString(R.string.str2));
    	 ad.setMultiChoiceItems(s1, if_check, ad_di); 
    	 ad.setPositiveButton("確認", pos_btnlsr);
    	 ad.setNegativeButton("離開", neg_btnlsr);
    	 ad.show();
      }
    });
  
    
  }//oncreate
  
}//Activity
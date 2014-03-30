package COM.TQC.GDD01 ;

import java.text.DecimalFormat;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GDD01_child extends Activity 
{
  Bundle bundle;
  Intent intent;
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) 
  {
    super.onCreate(savedInstanceState);
    
    
    setContentView(R.layout.mylayout);
    
    
    intent=this.getIntent();
    bundle = intent.getExtras();
    
   
    String Sex = bundle.getString("Sex");
    double height = bundle.getDouble("height");
    double weight = bundle.getDouble("weight");
      
    
    String BMI_result = this.getBMI(height,weight);
    String BMI_advice = this.getAdvice(Sex,height,weight);
    
    TextView tvBMI=(TextView) findViewById(R.id.tvBMI);
    tvBMI.setText(BMI_result);
    TextView tvAdvice=(TextView) findViewById(R.id.tvAdvice);
    tvAdvice.setText(BMI_advice);
    
  
    Button b1 = (Button) findViewById(R.id.button1);
    b1.setOnClickListener(new Button.OnClickListener()
    {
      public void onClick(View v)
      {          
    	 
    	  GDD01_child.this.setResult(RESULT_OK, intent);
    	  
    	 
    	  GDD01_child.this.finish();
      }
    });
  }
  
 //BMI�Ȯ榡��
  private String format(double num)
  {
      DecimalFormat nf = new DecimalFormat("0.00");
	  String s =nf.format(num);
	  return s;
  }
  //���oBMI��
  private String getBMI (double height, double weight)
  {
	  double BMI=weight/(height*height);
	  return getString(R.string.report_result)+format(BMI);
	  
  }
  //��BMI�Ȩ��o��ĳ
  private String getAdvice (String Sex, double height, double weight)
  {
	 double BMI_MAX,BMI_MIN;
	 double BMI=weight/(height*height);
	 if(Sex.equals("M")){
		 BMI_MAX=25;
		 BMI_MIN=20;
	 }else{
		 BMI_MAX=22;
		 BMI_MIN=18;
	 }
	 
	 if(BMI >BMI_MAX){
		 return getString(R.string.advice_heavy);
	 }else if(BMI <BMI_MIN ){
		 return getString(R.string.advice_light);
	 }else{
		 return getString(R.string.advice_average);
	 }
	  
  }

}
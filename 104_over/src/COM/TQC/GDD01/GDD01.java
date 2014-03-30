package COM.TQC.GDD01;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class GDD01 extends Activity 
{
  private EditText etheight;
  private EditText etweight;
  private RadioButton rb1;
  private RadioButton rb2;
    
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) 
  {
    super.onCreate(savedInstanceState);
    
    setContentView(R.layout.main);
    
    etheight = (EditText) findViewById(R.id.editText1);
    etweight = (EditText) findViewById(R.id.editText2);
    rb1 = (RadioButton) findViewById(R.id.radio0);
    rb2 = (RadioButton) findViewById(R.id.radio1);
    Button b1 = (Button) findViewById(R.id.button1);
    b1.setOnClickListener(new Button.OnClickListener()
    {
      public void onClick(View v)
      {
    	  
      
        //�q��J���������X�F�������B�魫�ȡA�n�N�����B�魫�ȶǰe�� child_Activity ��@�p��
    	  double height = Double.parseDouble(etheight.getText().toString());
    	  double weight = Double.parseDouble(etweight.getText().toString());
    	  String Sex="";
    	  if(rb1.isChecked()){
    		  Sex="M";
    	  }else{
    		  Sex="F";
    	  }  
        //�o�Ǫ��[�b Intent �W���T�����x�s�b Bundle ����
        Intent intent =new Intent();
        intent.setClass(GDD01.this, GDD01_child.class);        
        Bundle b = new Bundle();
        b.putDouble("height", height);
        b.putDouble("weight", weight);
        b.putString("Sex", Sex);
    	//�z�L�uintent.putExtras(bundle)�v�ԭz�A�N�ubundle�v ������[�b Intent �W�A�H�� Intent �e�X�Ӱe�X    	
        intent.putExtras(b);
        startActivity(intent);   	  
      }
    });
  }
  
  
  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data)
  {
    switch (resultCode)
    { 
      case RESULT_OK:
    
        Bundle bundle = data.getExtras();
        String Sex = bundle.getString("Sex");
        double height = bundle.getDouble("height");
        double weight = bundle.getDouble("weight");
        
        etheight.setText("" + height);
        etweight.setText("" + weight);
        if(Sex.equals("M"))
        {
          rb1.setChecked(true);
        }else
        {
          rb2.setChecked(true);
        }
        break;       
      default: 
        break; 
     } 
   } 
}
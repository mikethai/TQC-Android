package COM.TQC.GDD02;


import java.io.File;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GDD02 extends Activity
{
  
  private ImageView mImageView;
  private Button mButton;
  private TextView mTextView;
  private String fileName="/data/data/COM.TQC.GDD02/png001.PNG";
  
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    
    setContentView(R.layout.main);
    
    
    mButton = (Button)findViewById(R.id.mButton);
    mButton.setOnClickListener(new Button.OnClickListener()
    {
      public void onClick(View v)
      {
    	
        mImageView = (ImageView)findViewById(R.id.mImageView);
        mTextView=(TextView)findViewById(R.id.mTextView);
        
        File f=new File(fileName);   
        if(f.exists()) 
        { 
        	/* ����Bitmap����A�é�JmImageView�� */
            Bitmap bp = BitmapFactory.decodeFile(fileName);
            mImageView.setImageBitmap(bp);
            mTextView.setText(fileName);
        	
        	
        	
        } 
        else 
        {  
          mTextView.setText("�ɮפ��s�b"); 
        } 
      } 
    });
  }
}
package COM.TQC.GDD01;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class GDD01 extends Activity 
{
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) 
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    Gallery g= (Gallery) findViewById(R.id.mygallery);
    g.setAdapter(new ImageAdapter(GDD01.this));
    g.setOnItemSelectedListener(new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			Toast.makeText(GDD01.this, getString(R.string.my_gallery_text_pre)+arg2+getString(R.string.my_gallery_text_post), Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	});
    
  } 
      

  public class ImageAdapter extends BaseAdapter 
  {
    
	  Context mycontext;
    
    //建構子只有一個參數，即要儲存的Context
	  public ImageAdapter(Context c) 
	    {
		  mycontext=c;
	    }
	    
    
    //回傳所有已定義的圖片總數量
    public int getCount() 
    {
      
    	return pics.length;
    }
    
    
    public Object getItem(int position) 
    {
      return position;
    }
    
    //取得圖片編號
    public long getItemId(int position) 
    {
      return position;
    }


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageView i = new ImageView(mycontext);
		i.setImageResource(pics[position]);
		i.setScaleType(ScaleType.FIT_XY);
		i.setLayoutParams(new Gallery.LayoutParams(236,188));
		return i;
	}
    
  }
  
//使用android.R.drawable裡的圖片當成圖庫來源
  public Integer[] pics ={
		  R.drawable.png001,
		  R.drawable.png002,
		  R.drawable.png003,
		  R.drawable.png004,
		  R.drawable.png005,
		  R.drawable.png006,
		  R.drawable.png007,
		  R.drawable.png008,
		  R.drawable.png009,
		  R.drawable.png010,
		  R.drawable.png011
		  
  };
	  
	  
  }
  
  
   
    
    


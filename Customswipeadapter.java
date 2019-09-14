package com.example.innu.imageslider;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Innu on 12-08-2019.
 */

public class Customswipeadapter extends PagerAdapter {
   private int[] image_resources={R.drawable.gec1,R.drawable.gec2,R.drawable.gec3,R.drawable.gec4,R.drawable.gec5};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public Customswipeadapter(Context ctx){
        this.ctx=ctx;
    }
    @Override
    public int getCount() {

        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
      boolean b1= Boolean.parseBoolean(null);
        b1=view == (LinearLayout) object;
        return b1;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view=layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageView=(ImageView)item_view.findViewById(R.id.image_view);
        TextView textView=(TextView)item_view.findViewById(R.id.image_count);
        imageView.setImageResource(image_resources[position]);
        textView.setText("image:"+position);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
container.removeView((LinearLayout)object);
    }
}

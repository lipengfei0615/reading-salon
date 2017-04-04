package com.readingsalon;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.R;
class imageAdapter extends BaseAdapter {
    //声明Context
    private Context context;
    //图片源数组
    private Integer[] imageInteger={
            R.drawable.contemporary, R.drawable.crime, R.drawable.detective,
            R.drawable.fairytale, R.drawable.humor, R.drawable.mythology, R.drawable.romance,
            R.drawable.science, R.drawable.thrillers
    };

    //声明 ImageAdapter
    public imageAdapter(Context c){
        context = c;
    }

    @Override
    //获取图片的个数
    public int getCount() {
        return imageInteger.length;
    }

    @Override
    //获取图片在库中的位置
    public Object getItem(int position) {

        return position;
    }

    @Override
    //获取图片在库中的位置
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView = new ImageView(context);
        //给ImageView设置资源
        imageView.setImageResource(imageInteger[position]);
        //设置比例类型
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        //设置布局 图片128x192显示
        imageView.setLayoutParams(new GridView.LayoutParams(30, 30));
        return imageView;
    }
}

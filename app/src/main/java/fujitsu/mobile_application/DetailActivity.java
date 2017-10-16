package fujitsu.mobile_application;

import android.content.Intent;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.borjabravo.readmoretextview.ReadMoreTextView;
import com.dmallcott.dismissibleimageview.DismissibleImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView txtProduct = (TextView) findViewById(R.id.textView4);
//        TextView txtDetail = (TextView) findViewById(R.id.textView5);
//        ImageView txtImg = (ImageView) findViewById(R.id.imageView);
        ImageView txtHead = (ImageView) findViewById(R.id.imageView1);
        //test readmore
        ReadMoreTextView txtReadmore = (ReadMoreTextView) findViewById(R.id.readmore);
        //test imagePopup
        DismissibleImageView txtDismissible = (DismissibleImageView) findViewById(R.id.imageMain);

        //test zoom
//        PhotoViewAttacher photoView = new PhotoViewAttacher(txtImg);
//        photoView.update();
//        PhotoViewAttacher photoView2 = new PhotoViewAttacher(txtDismissible);
//        photoView2.update();

        Intent i = getIntent();
        // getting attached intent data
        String product = i.getStringExtra("Play");
        String Detail = i.getStringExtra("Detail");
        String img = i.getStringExtra("Img");
        String cat = i.getStringExtra("Category");
        txtProduct.setText(product);
//        txtDetail.setText(Detail+getString(R.string.tab)+getString(R.string.tab)+getString(R.string.tab));
//        txtImg.setImageResource(Integer.parseInt(img));

        //testreadmore
        txtReadmore.setText(Detail);
        //testImagepop
        txtDismissible.setImageResource(Integer.parseInt(img));

        //changing head photo
        if (cat.equals("Environment")){
            txtHead.setImageResource(R.drawable.environment1);
        }else if (cat.equals("Diversity")){
            txtHead.setImageResource(R.drawable.diversity1);
        }else if (cat.equals("Community")){
            txtHead.setImageResource(R.drawable.community);
        }else if (cat.equals("Operating")){
            txtHead.setImageResource(R.drawable.operating1);
        }else if (cat.equals("WellBeing")){
            txtHead.setImageResource(R.drawable.wellbeing1);
        }
        else{
            Toast.makeText(getApplicationContext(),"Cant read", Toast.LENGTH_SHORT).show();
        }
    }
}

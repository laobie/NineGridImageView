package com.jaeger.ninegridimgdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import com.jaeger.ninegridimageview.NineGridImageView;
import com.jaeger.ninegridimgdemo.R;
import com.jaeger.ninegridimgdemo.adapter.PostAdapter;
import com.jaeger.ninegridimgdemo.entity.Post;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jaeger on 16/2/24.
 *
 * Email: chjie.jaeger@gamil.com
 * GitHub: https://github.com/laobie
 */
public class GridStyleActivity extends AppCompatActivity {

    private RecyclerView mRvPostLister;
    private PostAdapter mNineImageAdapter;

    private List<Post> mPostList;
    private String[] IMG_URL_LIST = {
        "http://ac-QYgvX1CC.clouddn.com/36f0523ee1888a57.jpg",
        "http://ac-QYgvX1CC.clouddn.com/07915a0154ac4a64.jpg",
        "http://ac-QYgvX1CC.clouddn.com/9ec4bc44bfaf07ed.jpg",
        "http://ac-QYgvX1CC.clouddn.com/fa85037f97e8191f.jpg",
        "http://ac-QYgvX1CC.clouddn.com/de13315600ba1cff.jpg",
        "http://ac-QYgvX1CC.clouddn.com/15c5c50e941ba6b0.jpg",
        "http://ac-QYgvX1CC.clouddn.com/10762c593798466a.jpg",
        "http://ac-QYgvX1CC.clouddn.com/eaf1c9d55c5f9afd.jpg",
        "http://ac-QYgvX1CC.clouddn.com/ad99de83e1e3f7d4.jpg",
        "http://ac-QYgvX1CC.clouddn.com/233a5f70512befcc.jpg",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        mRvPostLister = (RecyclerView) findViewById(R.id.rv_post_list);
        mRvPostLister.setLayoutManager(new LinearLayoutManager(this));

        mPostList = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            List<String> imgUrls = new ArrayList<>();
            imgUrls.addAll(Arrays.asList(IMG_URL_LIST).subList(0, i % 9 + 1));
            Post post = new Post("this is a post, i am text content", imgUrls);
            mPostList.add(post);
        }

        mNineImageAdapter = new PostAdapter(this, mPostList, NineGridImageView.STYLE_GRID);
        mRvPostLister.setAdapter(mNineImageAdapter);
    }
}


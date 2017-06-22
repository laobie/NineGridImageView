package com.jaeger.ninegridimgdemo.activity;

import android.os.Bundle;
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

import static com.jaeger.ninegridimageview.NineGridImageView.BOTTOMCOLSPAN;
import static com.jaeger.ninegridimageview.NineGridImageView.LEFTROWSPAN;
import static com.jaeger.ninegridimageview.NineGridImageView.NOSPAN;
import static com.jaeger.ninegridimageview.NineGridImageView.TOPCOLSPAN;

/**
 * Created by Jaeger on 16/2/24.
 *
 * Email: chjie.jaeger@gmail.com
 * GitHub: https://github.com/laobie
 */
public class FillStyleActivity extends BaseActivity {

    public static final String CONTENT = "看图，字不重要。想看大图？抱歉我还没做这个 ( •̀ .̫ •́ )";
    private RecyclerView mRvPostLister;
    private PostAdapter mPostAdapter;

    private List<Post> mPostList;
    private String[] IMG_URL_LIST = {
        "https://pic4.zhimg.com/02685b7a5f2d8cbf74e1fd1ae61d563b_xll.jpg",
        "https://pic4.zhimg.com/fc04224598878080115ba387846eabc3_xll.jpg",
        "https://pic3.zhimg.com/d1750bd47b514ad62af9497bbe5bb17e_xll.jpg",
        "https://pic4.zhimg.com/da52c865cb6a472c3624a78490d9a3b7_xll.jpg",
        "https://pic3.zhimg.com/0c149770fc2e16f4a89e6fc479272946_xll.jpg",
        "https://pic1.zhimg.com/76903410e4831571e19a10f39717988c_xll.png",
        "https://pic3.zhimg.com/33c6cf59163b3f17ca0c091a5c0d9272_xll.jpg",
        "https://pic4.zhimg.com/52e093cbf96fd0d027136baf9b5cdcb3_xll.png",
        "https://pic3.zhimg.com/f6dc1c1cecd7ba8f4c61c7c31847773e_xll.jpg",
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        setContentView(R.layout.activity_recycler);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        mRvPostLister = (RecyclerView) findViewById(R.id.rv_post_list);
        mRvPostLister.setLayoutManager(new LinearLayoutManager(this));

        fummuyData();
        mPostAdapter = new PostAdapter(this, mPostList, NineGridImageView.STYLE_FILL);
        mRvPostLister.setAdapter(mPostAdapter);
    }

    private void fummuyData() {
        mPostList = new ArrayList<>();
        //单张
        mPostList.add(fummuyPost(1,NOSPAN));
        //2张
        mPostList.add(fummuyPost(2,NOSPAN));

        //3张,不跨行不跨列
        mPostList.add(fummuyPost(3,NOSPAN));
        //3张,首行跨列
        mPostList.add(fummuyPost(3,TOPCOLSPAN));
        //3张,末行跨列
        mPostList.add(fummuyPost(3,BOTTOMCOLSPAN));
        //3张,首列跨行
        mPostList.add(fummuyPost(3,LEFTROWSPAN));

        //4张,不跨行不跨列
        mPostList.add(fummuyPost(4,NOSPAN));
        //4张,首行跨列
        mPostList.add(fummuyPost(4,TOPCOLSPAN));
        //4张,末行跨列
        mPostList.add(fummuyPost(4,BOTTOMCOLSPAN));
        //4张,首列跨行
        mPostList.add(fummuyPost(4,LEFTROWSPAN));

        //5张,不跨行不跨列
        mPostList.add(fummuyPost(5,NOSPAN));
        //5张,首行跨列
        mPostList.add(fummuyPost(5,TOPCOLSPAN));
        //5张,末行跨列
        mPostList.add(fummuyPost(5,BOTTOMCOLSPAN));
        //5张,首列跨行
        mPostList.add(fummuyPost(5,LEFTROWSPAN));

        //6张,不跨行不跨列
        mPostList.add(fummuyPost(6,NOSPAN));
        //6张,首行跨列
        mPostList.add(fummuyPost(6,TOPCOLSPAN));
        //6张,末行跨列
        mPostList.add(fummuyPost(6,BOTTOMCOLSPAN));
        //6张,首列跨行
        mPostList.add(fummuyPost(6,LEFTROWSPAN));
    }

    private Post fummuyPost(int num, int spanType) {
        List<String> imgUrls = new ArrayList<>();
        imgUrls.addAll(Arrays.asList(IMG_URL_LIST).subList(0, num % 9));
        return new Post(CONTENT, spanType, imgUrls);
    }
}

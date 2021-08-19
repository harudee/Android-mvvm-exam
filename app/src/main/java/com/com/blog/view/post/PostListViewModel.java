package com.com.blog.view.post;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.com.blog.model.Post;
import com.com.blog.service.PostService;
import com.com.blog.service.dto.CMRespDto;
import com.com.blog.util.MyConvert;
import com.com.blog.view.post.adapter.PostListAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostListViewModel extends ViewModel {

    private static final String TAG = "PostListViewModel";
    private PostListViewModel mContext = PostListViewModel.this;
    private PostListAdapter postListAdapter;

    private PostService postService;
    private Post post;


    // LiveData 변경법
    // 1. 서버의 DB에 Data 변경요청, 2. 변경된 데이터 다운, 3. UI 적용
    // MutableLiveData 변경법
    // 1. 데이터 변경, 2 UI 적용  -> 서버의 DB의 Data 값은 변동없다
    // 공통점 : 데이터변경시 UI 자동변경

    private MutableLiveData<List<Post>> mPosts = new MutableLiveData<>();

    public MutableLiveData<List<Post>> getPost(){
        return mPosts;
    }

    //1. 얘가 init() : 기존데이터
    public void init(){ //null이래.... 왜그래 너 진쫘

        mPosts.setValue((List<Post>) postService.findAll());
    }


    //2.얘가 updateNote : 바뀌는 데이터
    public void updateData(){

    }

    //3. 초기화... 초기화는 어댑터에서 할걸...?ㅇㅇ 아마
    public void initializer(){
        List<Post> posts = new ArrayList<>();
        mPosts.setValue(posts);

    }

}

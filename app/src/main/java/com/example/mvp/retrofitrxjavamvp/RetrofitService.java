package com.example.mvp.retrofitrxjavamvp;

import com.example.mvp.retrofitrxjavamvp.entity.Book;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mc wu on 2017/12/4.
 */

public interface RetrofitService {

    @GET("book/search")
    Observable<Book> getService(@Query("q")String name,@Query("tag")String tag,
                                @Query("start")int start,@Query("count")int count);


}

package com.khoabug.coffeshop.common.repository;

import com.khoabug.coffeshop.common.model.Post;
import com.khoabug.coffeshop.common.paging.Pageable;

import java.util.List;

public interface PostRepository extends Repository<Post> {
    List<Post> findAll(Pageable pageable);

    void save(Post post);
}

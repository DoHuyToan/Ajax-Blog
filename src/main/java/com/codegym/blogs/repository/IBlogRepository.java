package com.codegym.blogs.repository;

import com.codegym.blogs.model.Blog;
import com.codegym.blogs.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog, Long> {

    Iterable<Blog> findAllByCategory(Category category);
}

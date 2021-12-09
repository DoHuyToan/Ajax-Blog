package com.codegym.blogs.repository;

import com.codegym.blogs.model.Blog;
import com.codegym.blogs.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICategoryRepository extends PagingAndSortingRepository<Category, Long> {
    Iterable<Category> findAllByBlog(Blog blog);
}

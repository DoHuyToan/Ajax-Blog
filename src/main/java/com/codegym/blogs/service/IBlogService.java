package com.codegym.blogs.service;

import com.codegym.blogs.model.Blog;
import com.codegym.blogs.model.Category;

public interface IBlogService extends IGeneralService<Blog>{

    Iterable<Blog> findAllByCategory(Category category);
}

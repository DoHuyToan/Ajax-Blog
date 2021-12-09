package com.codegym.blogs.formatter;

import com.codegym.blogs.model.Blog;
import com.codegym.blogs.service.IBlogService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class BlogFormatter implements Formatter<Blog> {

    private IBlogService blogService;


    @Override
    public Blog parse(String text, Locale locale) throws ParseException {
        Optional<Blog> blogOptional = blogService.findById(Long.parseLong(text));
        return blogOptional.orElse(null);
    }

    @Override
    public String print(Blog object, Locale locale) {
        return "[" + object.getId() + "]";
    }
}

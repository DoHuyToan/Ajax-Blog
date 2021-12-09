package com.codegym.blogs.controller;

import com.codegym.blogs.model.Blog;
import com.codegym.blogs.model.Category;
import com.codegym.blogs.service.IBlogService;
import com.codegym.blogs.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<Iterable<Category>> listAllCategory(){
        List<Category> categoryList = (List<Category>) categoryService.findAll();
        if(categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable Long id) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        categoryService.save(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }



//    @GetMapping("/view/{id}")
//    public ModelAndView viewCategory(@PathVariable ("id") Long id){
//        Optional<Category> categoryOptional = categoryService.findById(id);
//        if(!categoryOptional.isPresent()){
//            return new ModelAndView("/error");
//        }
//
//        Iterable<Blog> blogList = blogService.findAllByCategory(categoryOptional.get());
//
//        ModelAndView modelAndView = new ModelAndView("/category/view");
//        modelAndView.addObject("category", categoryOptional.get());
//        modelAndView.addObject("blogList", blogList);
//        return modelAndView;
//    }

//    @GetMapping("/create")
//    public ModelAndView showCreateForm(){
//        ModelAndView modelAndView = new ModelAndView("/category/create");
//        modelAndView.addObject("category", new Category());
//        return modelAndView;
//    }
//
//    @PostMapping("/create")
//    public ModelAndView saveCategory(@ModelAttribute("category") Category category){
//        categoryService.save(category);
//        ModelAndView modelAndView = new ModelAndView("/category/create");
//        modelAndView.addObject("category", new Category());
//        modelAndView.addObject("message", "New category create successfully!");
//        return modelAndView;
//    }



}

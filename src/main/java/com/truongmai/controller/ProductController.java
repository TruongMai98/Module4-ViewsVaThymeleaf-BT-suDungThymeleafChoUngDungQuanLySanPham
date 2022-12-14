package com.truongmai.controller;

import com.truongmai.model.Product;
import com.truongmai.service.IProductService;
import com.truongmai.service.ProductService;
import groovyjarjarantlr4.v4.codegen.model.SrcOp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping({"/", "products"})
public class ProductController {
    private final IProductService productService = new ProductService();

    @GetMapping("")
    public ModelAndView index(String keyword) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Product> products;
        if (keyword == null) {
            products = productService.findAll();
        } else {
            products = productService.findByName(keyword);
        }
        modelAndView.addObject("products", products);
        return modelAndView;
    }

   @GetMapping("/create")
    public ModelAndView create(Product product){
        return new ModelAndView("create", "product", product);
   }

   @PostMapping("/save")
    public ModelAndView save(Product product) {
//        product.setId(String.valueOf(Math.floor(Math.random() * 1000)));
        productService.save(product);
        return new ModelAndView( "redirect:/products");
   }

   @GetMapping("/edit")
    public ModelAndView edit(@RequestParam String id) {
       System.out.println("------------------------"+productService.findById(id));
        return new ModelAndView("edit", "product", productService.findById(id));
   }

   @PostMapping("/update")
    public ModelAndView update(Product product) {
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        productService.update(product.getId(), product);
        return modelAndView;
   }

   @GetMapping("/delete")
   public ModelAndView delete(@RequestParam String id) {
        return new ModelAndView("delete", "product",productService.findById(id));
   }

   @PostMapping("/delete")
    public ModelAndView delete(Product product, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        productService.remote(product.getId());
        redirectAttributes.addAttribute("mess","product has been delete successfully");
        return modelAndView;
   }

   @GetMapping("/view")
    public ModelAndView view(@RequestParam String id) {
        return new ModelAndView("view","product",productService.findById(id));
   }
}

package product_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import product_management.entity.Product;
import product_management.service.ProductService;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ModelAndView listProducts() {
        List<Product> productList = productService.findAll();
        return new ModelAndView("list","productList",productList);
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        return new ModelAndView("create","product",new Product());
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        return new ModelAndView("edit","product",productService.findById(id));
    }

    @PostMapping("edit")
    public String update(@ModelAttribute Product product) {
        productService.save(product);

        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        productService.remove(id);

        return "redirect:/products";
    }
}

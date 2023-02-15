package peaksoft.spring_security_db.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import peaksoft.spring_security_db.entity.Product;
import peaksoft.spring_security_db.service.ProductService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ProductService service;
    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Product> productList = service.getAllProduct();
        model.addAttribute("product_list",productList);
            return "product_page";
    }
    @RequestMapping("/new")
    public String showNewPage(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "new_product";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product")Product product){
    service.save(product);
    return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable(name = "id")long id){
    ModelAndView view = new ModelAndView("edit_product");
    Product product = service.getById(id);
    view.addObject("product",product);
    return view;
    }
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id")long id){
        service.delete(id);
        return "redirect:/";
    }
}

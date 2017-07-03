package br.com.caelum.fj27.loja.controller;

import br.com.caelum.fj27.loja.models.BookType;
import br.com.caelum.fj27.loja.models.Product;
import br.com.caelum.fj27.loja.repositories.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;

/**
 * Created by nando on 02/07/17.
 */
@Controller
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @GetMapping("/products/form")
    public ModelAndView form(Product product){
        ModelAndView view = new ModelAndView("products/form");

        view.addObject("types", BookType.values());

        return view;
    }

    @GetMapping("/products")
    public ModelAndView list(){
        ModelAndView view = new ModelAndView("products/list");

        view.addObject("products", productDao.list());

        return view;
    }

    @PostMapping("/products")
    @Transactional
    public ModelAndView save(@Valid Product product, BindingResult result, RedirectAttributes redirectAttributes){

        ModelAndView view = new ModelAndView("redirect:/products");

        if (result.hasErrors()) return form(product);

        productDao.save(product);

        redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");

        return view;
    }
}

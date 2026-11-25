package tacos.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;

import tacos.TacoOrder;

@Controller
@RequestMapping("/cart")
@SessionAttributes("tacoOrder")
public class CartController {

  @GetMapping
  public String showCart(Model model) {
    return "cart";
  }

  @PostMapping("/remove/{index}")
  public String removeTaco(@PathVariable("index") int index,
                           @ModelAttribute TacoOrder tacoOrder) {
    if (index >= 0 && index < tacoOrder.getTacos().size()) {
      tacoOrder.getTacos().remove(index);
    }
    return "redirect:/cart";
  }
}
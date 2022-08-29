package com.shopping.demo.controller;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.demo.model.CreditCard;
import com.shopping.demo.model.CreditCardStrategy;
import com.shopping.demo.model.Item;
import com.shopping.demo.model.PayPal;
import com.shopping.demo.model.PaypalStrategy;
import com.shopping.demo.model.ShoppingCart;
import com.shopping.demo.service.CreditCardService;
import com.shopping.demo.service.CreditCardStrategyService;
import com.shopping.demo.service.ItemService;
import com.shopping.demo.service.PayPalService;
import com.shopping.demo.service.PayPalStrategyService;
import com.shopping.demo.service.ShoppingCartService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class ShoppingController {

	@Autowired
	PayPalService payPalService;

	@Autowired
	CreditCardService creditCardService;

	@Autowired
	ItemService itemService;

	@Autowired
	ShoppingCartService shoppingCartService;

	@Autowired
	PayPalStrategyService payPalStrategyService;
	
	@Autowired
	CreditCardStrategyService creditCardStrategyService;

	@GetMapping("/")
	public ModelAndView fun() {
		log.info("Requesting the model: home page ");
		ModelAndView mav = new ModelAndView("homePage");
		log.info("Displaying the home page ");
		return mav;
	}

	@GetMapping("/item")
	public ModelAndView viewEmployee() {
		log.info("Requesting the model: item + List of the items ");
		ModelAndView mav = new ModelAndView("Item");
		List<Item> items = itemService.findAll();
		mav.addObject("items", items);
		log.info("Displaying the item page ");
		return mav;
	}
	
	@GetMapping("/payment")
	public ModelAndView viewPayment() {
		log.info("Requesting the model: item + List of the items ");
		ModelAndView mav = new ModelAndView("Payment");
		log.info("Displaying the item page ");
		return mav;
	}

	@GetMapping("/account")
	public ModelAndView viewAccount() {
		log.info("Requesting the model: account + List of the account ");
		ModelAndView mav = new ModelAndView("Accounts");
		List<PayPal> paypals = payPalService.findAll();
		mav.addObject("paypals", paypals);
		List<CreditCard> creditcards = creditCardService.findAll();
		mav.addObject("creditcards", creditcards);
		log.info("Displaying the account page ");
		return mav;
	}

	@GetMapping(path = "/item/{upoCode}")
	public ModelAndView editItem(@PathVariable("upoCode") @Valid @NotNull @RequestBody String upoCode) {
		log.info("Requesting the model: item page for editing");
		ModelAndView mav = new ModelAndView("ItemEdit");
		log.info("Get the item by upoCode");
		Item item = itemService.findById(upoCode);
		mav.addObject("item", item);
		log.info("Displaying the item page for editing");
		return mav;
	}

	@PostMapping("/item")
	public ModelAndView saveItem(@ModelAttribute("Item") @Valid @NotNull @RequestBody Item item) {
		log.info("Requesting the save method for saving the item");
		itemService.save(item);
		ModelAndView mav = new ModelAndView("Item");
		List<Item> items = itemService.findAll();
		mav.addObject("items", items);
		log.info("Displaying the item page");
		return mav;
	}

	@PostMapping("/paypal")
	public ModelAndView savePaypal(@ModelAttribute("PayPal") @Valid @NotNull @RequestBody PayPal payPal) {
		log.info("Requesting the save method for saving the payPal account");
		payPalService.save(payPal);
		ModelAndView mav = new ModelAndView("homePage");
		log.info("Displaying the homePage page");
		return mav;
	}

	@PostMapping("/creditcard")
	public ModelAndView saveCreditCard(
			@ModelAttribute("CreditCard") @Valid @NotNull @RequestBody CreditCard creditCard) {
		log.info("Requesting the save method for saving the creditCard account");
		creditCardService.save(creditCard);
		ModelAndView mav = new ModelAndView("homePage");
		log.info("Displaying the homePage page");
		return mav;
	}

	@PostMapping("/shopping")
	public ModelAndView saveShopping(
			@ModelAttribute("ShoppingCart") @Valid @NotNull @RequestBody ShoppingCart shoppingCart) {
		log.info("Requesting the save method for saving the shoppingCart");
		shoppingCartService.save(shoppingCart);
		ModelAndView mav = new ModelAndView("Payment");
		log.info("Displaying the Payment page");
		return mav;
	}

	@DeleteMapping(path = "/item/delete/{upoCode}")
	public String DeleteItem(@PathVariable("upoCode") String upoCode) {
		log.info("Requesting the delete method for deleting the item by upoCode");
		itemService.delete(upoCode);
		return "redirect:/";
	}

	@GetMapping("/item/insertion")
	public ModelAndView addItem() {
		log.info("Requesting the model: item page for inserting new item");
		ModelAndView mav = new ModelAndView("ItemEdit");
		mav.addObject("item", new Item());
		log.info("Displaying the item page");
		return mav;
	}

	@GetMapping("/paypal/insertion")
	public ModelAndView addPayPal() {
		log.info("Requesting the model: payPal page for inserting new payPal");
		ModelAndView mav = new ModelAndView("Paypal");
		mav.addObject("paypal", new PayPal());
		log.info("Displaying the paypal page");
		return mav;
	}

	@GetMapping("/creditcard/insertion")
	public ModelAndView addCreditCard() {
		log.info("Requesting the model: creditcard page for inserting new creditcard");
		ModelAndView mav = new ModelAndView("Creditcard");
		mav.addObject("creditcard", new CreditCard());
		log.info("Displaying the creditcard page");
		return mav;
	}

	@GetMapping("/shopping/insertion")
	public ModelAndView addShoppingCart() {
		log.info("Requesting the model: shoppingCart page for inserting new shoppingCart");
		ModelAndView mav = new ModelAndView("ShoppingCart");
		List<Item> items = itemService.findAll();
		mav.addObject("items",items);
		mav.addObject("shoppingCart", new ShoppingCart());
		log.info("Displaying the shoppingCart page");
		return mav;
	}
	
	
	@GetMapping("/payment/paypal")
	public ModelAndView payPayPal() {
		log.info("Requesting the model: payPal payment page for paying through payPal");
		ModelAndView mav = new ModelAndView("PaypalPayment");
		mav.addObject("paypalstrategy", new PaypalStrategy());
		List<ShoppingCart> carts = shoppingCartService.findAll();
		mav.addObject("carts", carts);
		log.info("Displaying the paypal payment page");
		return mav;
	}
	
	@GetMapping("/payment/creditcard")
	public ModelAndView payCreditCard() {
		log.info("Requesting the model: credit card payment page for paying through credit card");
		ModelAndView mav = new ModelAndView("CreditCardPayment");
		mav.addObject("creditcardstrategy", new CreditCardStrategy());
		List<ShoppingCart> carts = shoppingCartService.findAll();
		mav.addObject("carts", carts);
		log.info("Displaying the credit card payment page");
		return mav;
	}
	
	@PostMapping("/payment/paypal/result")
	public ModelAndView savePayPalPayment(
			@ModelAttribute("PaypalStrategy") @Valid @NotNull @RequestBody PaypalStrategy paypalStrategy) {
		log.info("Requesting the save method for saving the paypal payment");
		payPalStrategyService.save(paypalStrategy);
		ShoppingCart sc = paypalStrategy.getCart();
		int total = sc.calculateTotal();
		log.info(total);
		String result = payPalService.pay(paypalStrategy, total);
		log.info(result);
		ModelAndView mav = new ModelAndView("PaymentResult");
		mav.addObject("result",result);
		log.info("Displaying the PayPal Payment result page");
		return mav;
	}

	@PostMapping("/payment/creditcard/result")
	public ModelAndView saveCreditCardPayment(
			@ModelAttribute("CreditCardStrategy") @Valid @NotNull @RequestBody CreditCardStrategy creditCardStrategy) {
		log.info("Requesting the save method for saving the credit Card payment");
		creditCardStrategyService.save(creditCardStrategy);
		ShoppingCart sc = creditCardStrategy.getCart();
		int total = sc.calculateTotal();
		log.info(total);
		String result = creditCardService.pay(creditCardStrategy, total);
		log.info(result);
		ModelAndView mav = new ModelAndView("PaymentResult");
		mav.addObject("result",result);
		log.info("Displaying the credit card Payment result page");
		return mav;
	}
	
}

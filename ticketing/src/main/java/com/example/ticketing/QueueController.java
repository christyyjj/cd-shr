package com.example.ticketing;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class QueueController {
	
	TicketingQueue customer = new TicketingQueue();
	
	@RequestMapping("/customerView")
	public ModelAndView customer(){
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("customerView");
	    return mv;
	}
	
	@RequestMapping("/managementView")
	public ModelAndView management(){
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("managementView");
	    return mv;
	}
	
	@RequestMapping(value = "/number")
	public int getNum() {
		return customer.takeNum();
	}
	
	@RequestMapping(value = "/now_serving")
	public int nowServe() {
		return customer.nowServing();
	}
	
	@RequestMapping(value = "/call_next")
	public int callNext() {
		return customer.callNext();
	}
}


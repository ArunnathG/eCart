package com.shopping;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.model.Videos;
import com.shopping.services.getVideosService;

@Controller
public class UserHomeController {

	@RequestMapping("/userHome")
	public ModelAndView userHome() 
	{
		getVideosService getVideosService = new getVideosService();
		List<Videos> videos = getVideosService.getVideos();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userHome.jsp");
		mv.addObject("videos", videos);
		return mv;
	}
}

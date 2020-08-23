package com.shopping.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.model.Videos;

public class getVideosService {

	public List<Videos> getVideos()
	{
		

		List<Videos> videos = new ArrayList<Videos>();
		Videos video = new Videos();
		video.setId("0");
		video.setName("Hindi Songs");
		video.setPrice(25);
		        
		Videos video2 = new Videos();
		video2.setId("1");
		video2.setName("Tamil songs");
		video2.setPrice(35);
		
		Videos video3 = new Videos();
		video3.setId("2");
		video3.setName("English songs");
		video3.setPrice(45);
		
		Videos video4 = new Videos();
		video4.setId("3");
		video4.setName("Beat songs");
		video4.setPrice(145);
		        
		videos.add(video);
		videos.add(video2);
		videos.add(video3);
		videos.add(video4);
		
		return videos;
		
		}
}
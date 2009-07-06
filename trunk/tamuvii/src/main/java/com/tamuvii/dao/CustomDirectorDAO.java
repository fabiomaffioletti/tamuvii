package com.tamuvii.dao;

import java.util.List;

import com.tamuvii.pojo.DirectorDetail;
import com.tamuvii.pojo.SocialMovie;

public interface CustomDirectorDAO {
	
	public DirectorDetail getDirectorDetail(Integer director);
	
	public List<SocialMovie> getDirectorDetailSocialMovieList(Integer director);

}
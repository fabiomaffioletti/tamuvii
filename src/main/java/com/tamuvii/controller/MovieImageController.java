package com.tamuvii.controller;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.directwebremoting.json.JsonObject;
import org.directwebremoting.json.JsonString;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.ApplicationConstants;
import com.tamuvii.model.Movie;
import com.tamuvii.service.MovieManager;
import com.tamuvii.util.MD5Utils;

public class MovieImageController extends ApplicationController implements Controller {
	private MovieManager movieManager = null;
	private JsonObject jsonObj = null;
	private JsonString jsonString = null;
	private String md5FileName = null;

	public void setMovieManager(MovieManager movieManager) {
		this.movieManager = movieManager;
	}



	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		jsonObj = new JsonObject();
		try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("myfile");
			String uploadDirT = ApplicationConstants.MOVIE_IMAGES_FOLDER_T;
			String uploadDirM = ApplicationConstants.MOVIE_IMAGES_FOLDER_M;
			String uploadDirB = ApplicationConstants.MOVIE_IMAGES_FOLDER_B;
			
			InputStream stream = file.getInputStream();
			
			String movie_id = request.getParameter("movie_id");
			
			Movie movie = movieManager.getMovieById(Long.parseLong(movie_id));
			
			File fileToDeleteT = new File(uploadDirT + "/" + movie.getImage());
			File fileToDeleteM = new File(uploadDirM + "/" + movie.getImage());
			File fileToDeleteB = new File(uploadDirB + "/" + movie.getImage());
			
			String newFileName = file.getOriginalFilename();
			md5FileName = MD5Utils.MD5(newFileName+(new Date()).toString());
			
			BufferedImage bi = ImageIO.read(stream);
			
			BufferedImage bdest_t = new BufferedImage(ApplicationConstants.MOVIE_IMAGES_FOLDER_T_WIDTH, ApplicationConstants.MOVIE_IMAGES_FOLDER_T_HEIGHT, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = bdest_t.createGraphics();
			AffineTransform at = AffineTransform.getScaleInstance((double)ApplicationConstants.MOVIE_IMAGES_FOLDER_T_WIDTH/bi.getWidth(), (double)ApplicationConstants.MOVIE_IMAGES_FOLDER_T_HEIGHT/bi.getHeight());
			g.drawRenderedImage(bi, at);
			ImageIO.write(bdest_t, "JPG", new File(uploadDirT + "/" + md5FileName+".jpg"));
			
			BufferedImage bdest_m = new BufferedImage(ApplicationConstants.MOVIE_IMAGES_FOLDER_M_WIDTH, ApplicationConstants.MOVIE_IMAGES_FOLDER_M_HEIGHT, BufferedImage.TYPE_INT_RGB);
			g = bdest_m.createGraphics();
			at = AffineTransform.getScaleInstance((double)ApplicationConstants.MOVIE_IMAGES_FOLDER_M_WIDTH/bi.getWidth(), (double)ApplicationConstants.MOVIE_IMAGES_FOLDER_M_HEIGHT/bi.getHeight());
			g.drawRenderedImage(bi, at);
			ImageIO.write(bdest_m, "JPG", new File(uploadDirM + "/" + md5FileName+".jpg"));
			
			BufferedImage bdest_b = new BufferedImage(ApplicationConstants.MOVIE_IMAGES_FOLDER_B_WIDTH, ApplicationConstants.MOVIE_IMAGES_FOLDER_B_HEIGHT, BufferedImage.TYPE_INT_RGB);
			g = bdest_b.createGraphics();
			at = AffineTransform.getScaleInstance((double)ApplicationConstants.MOVIE_IMAGES_FOLDER_B_WIDTH/bi.getWidth(), (double)ApplicationConstants.MOVIE_IMAGES_FOLDER_B_HEIGHT/bi.getHeight());
			g.drawRenderedImage(bi, at);
			ImageIO.write(bdest_b, "JPG", new File(uploadDirB + "/" + md5FileName+".jpg"));
			
			
			if(!movie.getImage().equals(ApplicationConstants.MOVIE_DEFAULT_IMAGE)) {
				if(fileToDeleteT.delete()) {
					log.debug("deleted file t: "+movie.getImage());
				}
				else {
					log.warn("impossible to delete file t: "+movie.getImage());
				}
				if(fileToDeleteM.delete()) {
					log.debug("deleted file m: "+movie.getImage());
				}
				else {
					log.warn("impossible to delete file m: "+movie.getImage());
				}
				if(fileToDeleteB.delete()) {
					log.debug("deleted file b: "+movie.getImage());
				}
				else {
					log.warn("impossible to delete file b: "+movie.getImage());
				}
			}
			
			movie.setImage(md5FileName+".jpg");
			movieManager.updateMovieImage(movie);
			
			jsonString = new JsonString(md5FileName+".jpg");
			
		} catch (Exception e) {
			log.error("Error in saving new image, manipulating image or deleting previous image. New image filename: " + md5FileName);
			jsonString = new JsonString("ko");
			
		}
		
		jsonObj.put("result", jsonString);

		response.setContentType("text/plain; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.write(jsonObj.toString());
		out.close();
		
		return null;
	}
}

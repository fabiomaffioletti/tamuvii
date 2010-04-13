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
import com.tamuvii.model.User;
import com.tamuvii.service.UserManager;
import com.tamuvii.util.MD5Utils;

public class ProfileImageController extends ApplicationController implements Controller {
	private UserManager userManager = null;
	private JsonObject jsonObj = null;
	private JsonString jsonString = null;
	private String md5FileName = null;

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		jsonObj = new JsonObject();
		try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("myfile");
			String uploadDir = ApplicationConstants.USER_IMAGES_FOLDER;
			InputStream stream = file.getInputStream();
			
			String user_id = request.getParameter("user_id");
			User user = userManager.getUserById(user_id);
			
			File fileToDelete = new File(uploadDir + "/" + user.getAvatar()); 
			String newFileName = file.getOriginalFilename();

			md5FileName = MD5Utils.MD5(newFileName+(new Date()).toString());
			
			BufferedImage bi = ImageIO.read(stream);
			BufferedImage bdest = new BufferedImage(ApplicationConstants.USER_IMAGES_WIDTH, ApplicationConstants.USER_IMAGES_HEIGHT, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = bdest.createGraphics();
			AffineTransform at = AffineTransform.getScaleInstance((double)ApplicationConstants.USER_IMAGES_WIDTH/bi.getWidth(), (double)ApplicationConstants.USER_IMAGES_HEIGHT/bi.getHeight());
			g.drawRenderedImage(bi,at);
			ImageIO.write(bdest,"JPG",new File(uploadDir + "/" + md5FileName+".jpg"));
			
			if(!user.getAvatar().equals(ApplicationConstants.USER_DEFAULT_AVATAR)) {
				if(fileToDelete.delete()) {
					log.debug("deleted file: "+user.getAvatar());
				}
				else {
					log.warn("impossible to delete file: "+user.getAvatar());
				}
			}
			
			user.setAvatar(md5FileName+".jpg");
			userManager.updateUserAvatar(user);
			
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

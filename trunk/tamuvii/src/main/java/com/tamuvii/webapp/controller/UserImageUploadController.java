package com.tamuvii.webapp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tamuvii.service.AppUserManager;
import com.tamuvii.util.TamuviiConstants;

public class UserImageUploadController extends TamuviiFormController {
	private AppUserManager appUserManager = null;

    public void setAppUserManager(AppUserManager appUserManager) {
		this.appUserManager = appUserManager;
	}


    public UserImageUploadController() {
        setCommandName("userImage");
        setCommandClass(UserImage.class);
    }
    
    @SuppressWarnings("unchecked")
	protected Map referenceData(HttpServletRequest request) throws Exception {
    	Map ref = new HashMap();
    	ref.put("user", appUserManager.getUserPublicInfo(request.getRemoteUser()));
		return ref;
	}
    
    
    
    public ModelAndView processFormSubmission(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        if (request.getParameter("cancel") != null) {
            return new ModelAndView(getCancelView());
        }
        return super.processFormSubmission(request, response, command, errors);
    }

    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
    	UserImage image = (UserImage) command;

        // validate a file was entered
        if (image.getFile().length == 0) {
            Object[] args = new Object[] { getText("uploadForm.file", request.getLocale()) };
            errors.rejectValue("file", "errors.required", args, "File");
            
            return showForm(request, response, errors);
        }

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("file");

        // the directory to upload to
        String uploadDir = getServletContext().getRealPath(TamuviiConstants.USER_PROFILE_IMAGE_UPLOAD_DIRECTORY) + "/";

        // Create the directory if it doesn't exist
        File dirPath = new File(uploadDir);

        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }

        InputStream stream = file.getInputStream();
        OutputStream bos = new FileOutputStream(uploadDir + file.getOriginalFilename());
        int bytesRead;
        byte[] buffer = new byte[8192];

        while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }

        bos.close();
        stream.close();
        
        //TODO Cancellare il file precedente
        //TODO creare un nome file univoco sulla base dei millisecondi in cui è stato fatto l'upload
        saveTamuviiSuccessMessage(request, "L'immagine è stata caricata correttamente");
        appUserManager.updateProfileImagePath(request.getRemoteUser(), TamuviiConstants.USER_PROFILE_IMAGE_UPLOAD_DIRECTORY + "/" + file.getOriginalFilename());

        return new ModelAndView(getSuccessView());
    }
}

package com.tamuvii;

public class ApplicationConstants {
	
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String ROLE_USER = "ROLE_USER";

	public static final String INFO_MESSAGES = "infoMessages";
	public static final String SUCCESS_MESSAGES = "successMessages";
	public static final String ERROR_MESSAGES = "errorMessages";
	
	public static final Integer SHELF_ITEMS_PER_PAGE = 2;
	public static final Integer SEARCH_ITEMS_PER_PAGE = 2;
	public static final Integer MOVIE_DIRECTOR_ITEMS_PER_PAGE = 2;
	public static final Integer FRIENDS_ITEMS_SHELF = 5;
	public static final Integer NEARBIES_ITEMS_SHELF = 5;
	public static final Integer MOVIE_USERS_MOVIE_ITEM_PAGE = 5;
	public static final Integer MOVIE_REVIEW_ITEMS_PER_PAGE = 10;
	public static final Integer FRIENDS_ITEMS_PER_PAGE = 2;
	
	public static final Integer HOME_LAST_INSERTED = 3;
	public static final Integer HOME_LAST_REGISTERED = 3;
	public static final Integer HOME_LAST_ADDED = 3;
	
	public static final String ORDER_RANDOM = "order by rand()";
	public static final String ORDER_DATE_ADDED_DESC = "order by date_added desc";
	public static final String ORDER_USERNAME_ASC = "order by username asc";
	public static final String ORDER_USERNAME_DESC = "order by username desc";
	
	public static final String REGISTRATION_SUCCESS_EMAIL_SUBJECT = " attiva il tuo profilo e inizia subito a costruire la tua videoteca!";
	public static final String FRIEND_ADDED_EMAIL_SUBJECT = " ti ha aggiunto come amico!";
	public static final String NEARBIE_ADDED_EMAIL_SUBJECT = " ti ha aggiunto come vicino!";
	public static final String RELATIONSHIP_CHANGED_EMAIL_SUBJECT = " ha modificato il modo di seguirti";
	public static final String REVIEW_VOTED_POSITIVE_EMAIL_SUBJECT = " una tua recensione ha ricevuto un voto positivo!";
	public static final String REVIEW_VOTED_NEGATIVE_EMAIL_SUBJECT = " una tua recensione ha ricevuto un voto negativo";
	public static final String OPINION_WROTE_EMAIL_SUBJECT = " è stato aggiunto un commento a una tua recensione";
	public static final String INVITATION_SENT_EMAIL_SUBJECT = " ti ha invitato a taMuvii!";
	
	public static final String USER_IMAGES_FOLDER = "D:/tam/user_images";
	public static final String USER_DEFAULT_AVATAR = "avatar.jpg";
	public static final int USER_IMAGES_WIDTH = 48;
	public static final int USER_IMAGES_HEIGHT = 48;
	
	public static final String MOVIE_IMAGES_FOLDER_T = "D:/tam/movie_images/t";
	public static final int MOVIE_IMAGES_FOLDER_T_WIDTH = 100;
	public static final int MOVIE_IMAGES_FOLDER_T_HEIGHT = 143;
	
	public static final String MOVIE_IMAGES_FOLDER_M = "D:/tam/movie_images/m";
	public static final int MOVIE_IMAGES_FOLDER_M_WIDTH = 300;
	public static final int MOVIE_IMAGES_FOLDER_M_HEIGHT = 429;
	
	public static final String MOVIE_IMAGES_FOLDER_B = "D:/tam/movie_images/b";
	public static final int MOVIE_IMAGES_FOLDER_B_WIDTH = 600;
	public static final int MOVIE_IMAGES_FOLDER_B_HEIGHT = 857;
	
	public static final String MOVIE_DEFAULT_IMAGE = "movie_placeholder.jpg";
	
	public static final String DATE_FORMAT = "dd/MM/yyyy";
	
	
	// COSTANTI DELLA TABELLA CONFIG
	public static final String INVITATION_ENABLED = "INVITATION_ENABLED";
	public static final String INVITATIONS_PER_USER = "INVITATIONS_PER_USER";
	
}

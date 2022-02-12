package fr.orsys.kingsley.ecommerce.exception;

public class ArticleNotFoundException extends RuntimeException {
	public ArticleNotFoundException(String exMessage) {
		super(exMessage);
	}
}

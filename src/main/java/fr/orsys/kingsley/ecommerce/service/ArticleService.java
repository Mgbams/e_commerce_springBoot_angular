package fr.orsys.kingsley.ecommerce.service;

import java.util.List;
import java.util.Optional;

import fr.orsys.kingsley.ecommerce.business.Article;

public interface ArticleService {
	//GifDistant ajouterGifDistant(LocalDate idJour, String url, Utilisateur utilisateur);

	//GifDistant ajouterGifDistant(GifDistant gifDistant, Utilisateur utilisateur);
	 boolean deleteArticleById(Long id);

	Optional<Article> findArticleById(Long id);
	
	List<Article> findAllArticles();

	Article createArticle(Article article);

}

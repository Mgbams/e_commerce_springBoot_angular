package fr.orsys.kingsley.ecommerce.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.orsys.kingsley.ecommerce.business.Article;
import fr.orsys.kingsley.ecommerce.dao.ArticleDao;
import fr.orsys.kingsley.ecommerce.exception.ArticleNotFoundException;
import fr.orsys.kingsley.ecommerce.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	private ArticleDao articleDao;
	

	public ArticleServiceImpl(ArticleDao articleDao) {
		super();
		this.articleDao = articleDao;
	}
	
	@Override
	public List<Article> findAllArticles() {
		return articleDao.findAll();
	}
	
	@Override
	public Article createArticle(Article article) {
		return articleDao.save(article);
	}
	
	@Override
	public boolean deleteArticleById(Long id) {
		Article article = findArticleById(id).get();
		if (article == null) {
			return false;
		}
		articleDao.delete(article);
		return true;
		
	}

	@Override
	public Optional<Article> findArticleById(Long id) {
		return Optional.ofNullable(articleDao.findArticleById(id).orElseThrow(() -> new ArticleNotFoundException("The article with the id: " + id + " does not exist")));
	}

}

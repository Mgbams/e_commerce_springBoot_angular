package fr.orsys.kingsley.ecommerce.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.orsys.kingsley.ecommerce.business.Article;

public interface ArticleDao extends JpaRepository<Article, Long> {
	// void deleteArticleById(Long id);

	Optional<Article> findArticleById(Long id);
}

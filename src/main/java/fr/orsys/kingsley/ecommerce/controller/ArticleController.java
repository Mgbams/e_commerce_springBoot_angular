package fr.orsys.kingsley.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.orsys.kingsley.ecommerce.business.Article;
import fr.orsys.kingsley.ecommerce.service.ArticleService;

@RestController
@RequestMapping("/api/articles")

public class ArticleController {
	private final ArticleService articleService;
	
	public ArticleController(ArticleService articleService) {
		super();
		this.articleService = articleService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Article>> getAllArticles() {
		List<Article> articles = this.articleService.findAllArticles();

		return new ResponseEntity<>(articles, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Article>> getArticleById(@PathVariable("id") Long id) {
		Optional<Article> article = this.articleService.findArticleById(id);

		return new ResponseEntity<>(article, HttpStatus.OK);
	}

	@PostMapping("/{article}")
	public ResponseEntity<Article> createArticle(@RequestBody Article article) {
		Article newArticle = this.articleService.createArticle(article);

		return new ResponseEntity<>(newArticle, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteArticle(@PathVariable Long id) {
		this.articleService.deleteArticleById(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}
}

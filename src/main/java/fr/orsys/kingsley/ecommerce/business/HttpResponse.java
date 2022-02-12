package fr.orsys.kingsley.ecommerce.business;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HttpResponse {
  private int httpStatusCode; // 200, 201, 400, 500
  private HttpStatus httpStatus;
  private String reason;
  private String message;

}

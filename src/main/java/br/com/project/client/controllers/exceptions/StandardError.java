package br.com.project.client.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardError {
    
    private Long timestamp;
    private Integer status;
    private String error;

}

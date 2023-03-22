package br.com.project.client.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDTO {
    
    @NotBlank(message = "name is required")
    @Size(min = 3, max = 30, message = "Min 3 and max 30 characters")
    private String name;
    
    @NotNull(message = "age is required")
    private Integer age;
    
    @NotBlank(message = "city is required")
    @Size(min = 3, max = 30, message = "Min 3 and max 30 characters")
    private String city;

}

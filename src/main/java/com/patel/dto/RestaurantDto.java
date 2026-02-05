package com.patel.dto;

import com.patel.model.Address;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Data
@Embeddable
public class RestaurantDto {

    @Schema(description = "Name of the restaurant", example = "Ananta Pure Veg Restaurant")
    private String title;
    @Column(length = 1000)
    private List<String> images;
    private String description;
    private Long id;
}

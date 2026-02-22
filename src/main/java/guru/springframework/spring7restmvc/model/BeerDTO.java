package guru.springframework.spring7restmvc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tools.jackson.databind.annotation.JsonDeserialize;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@JsonDeserialize(builder = BeerDTO.BeerDTOBuilder.class)
@Builder
@Data
public class BeerDTO {
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("version")
    private Integer version;

    @JsonProperty("beerName")
    @NotBlank
    @NotNull
    private String beerName;

    @JsonProperty("beerStyle")
    @NotNull
    private BeerStyle beerStyle;

    @JsonProperty("upc")
    @NotBlank
    @NotNull
    private String upc;

    @JsonProperty("quantityOnHand")
    private Integer quantityOnHand;

    @JsonProperty("price")
    @NotNull
    private BigDecimal price;
    @JsonProperty("createDate")
    private LocalDateTime createDate;
    @JsonProperty("updateDate")
    private LocalDateTime updateDate;
}

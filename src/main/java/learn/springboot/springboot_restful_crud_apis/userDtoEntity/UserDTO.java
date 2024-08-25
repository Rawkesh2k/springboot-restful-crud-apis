package learn.springboot.springboot_restful_crud_apis.userDtoEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "User DTO model information")
public class UserDTO {

    private int id;

    //Let's say client has the requirements as:
    //fName, lName, email shouldn't be empty, not null, email should be valid
    //We use following annotations to handle the requirements above

    @NotEmpty(message = "User first name SHOULD NOT be empty")
    @Schema(description = "User first name")
    private String firstName;

    @NotEmpty(message = "User last name SHOULD NOT be empty")
    @Schema(description = "User last name")
    private String lastName;

    @NotEmpty(message = "User email SHOULD NOT be null or empty")
    @Email(message = "User email SHOULD be valid")
    @Schema(description = "User email  address")
    private String email;
}

package com.noobdev.dailyblog.dailyblog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

    private int id;
    @NotEmpty
    @Size(min =4, message = "Name should be more that 4 characters")
    private String name;

    @Email
    private String email;
    @NotEmpty
    @Size(min = 8, message = "Password should contain at least 8 Characters")
    private String password;
    private String about;
}

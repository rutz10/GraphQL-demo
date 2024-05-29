package com.graphql_spring.demo;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class UserDataFetcher {
    private final UserService userService;

    public UserDataFetcher(UserService userService) {
        this.userService = userService;
    }

    @QueryMapping
    public UserConnection users(@Argument Integer first, @Argument String after) {
        return userService.getUsers(first != null ? first : 10, after);
    }
}


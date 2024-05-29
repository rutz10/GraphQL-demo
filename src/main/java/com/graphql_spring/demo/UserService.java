package com.graphql_spring.demo;
import org.bson.types.ObjectId;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserConnection getUsers(int first, String after) {
        Pageable pageable = PageRequest.of(0, first, Sort.by(Sort.Direction.ASC, "_id"));
        ObjectId cursorId = after != null ? new ObjectId(after) : null;

        List<User> users = cursorId != null
                ? userRepository.findBy_idGreaterThan(cursorId, pageable)
                : userRepository.findAll(pageable).getContent();

        List<UserEdge> edges = users.stream()
                .map(user -> new UserEdge(user.get_id(), user))
                .collect(Collectors.toList());

        ObjectId endCursor = edges.size() > 0 ? edges.get(edges.size() - 1).getCursor() : null;
        boolean hasNextPage = users.size() == first;

        PageInfo pageInfo = new PageInfo(endCursor, hasNextPage);

        return new UserConnection(edges, pageInfo);
    }
}

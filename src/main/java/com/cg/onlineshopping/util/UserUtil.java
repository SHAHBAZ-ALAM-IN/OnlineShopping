package com.cg.onlineshopping.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;
import com.cg.onlineshopping.entities.User;
import com.cg.onlineshopping.modal.UserDetails;

@Component
public class UserUtil {
	public List<UserDetails> toDetails(Collection<User> users) {
		List<UserDetails> desired = new ArrayList<>();
		for (User add : users) {
			UserDetails details = toDetails(add);
			desired.add(details);
		}
		return desired;
	}
	public UserDetails toDetails(User user) {
		return new UserDetails(user.getUserId(),user.getPassword(), user.getRole());
	}
}

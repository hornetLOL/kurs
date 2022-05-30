package ru.maks.kurs.web.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.maks.kurs.web.dto.AccountUserDto;

import java.util.HashMap;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@Slf4j
@RequestMapping("/login")
public class AuthenticationController {

//	private final UserLoginService userService;
	private final AuthenticationManager authenticationManager;

//	@PostMapping
//	public String handlePost(AccountUserDto accountUserDto) throws Exception {
//		final String username = accountUserDto.getUsername();
//		AccountUser accountUser = userLoginService.find(username, accountUserDto.getPassword());
//		if (accountUser != null) {
//			userLoginService.login(accountUser);
//			return "redirect:/";
//		} else {
//			return "redirect:/login-error";
//		}
//	}

//	@PostMapping
//	public ResponseEntity<?> handlePost(AccountUserDto accountUserDto) {
//		final String username = accountUserDto.getUsername();
//		authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(
//						username,
//						accountUserDto.getPassword()
//				));
//		Optional<AccountUser> accountUserOptional = userService.findByUsername(username);
//		if (accountUserOptional.isPresent()) {
////			String jwtToken = jwtTokenProvider.createToken(username, accountUserOptional.get().getRoles());
//
//			HashMap<Object, Object> response = new HashMap<>();
//			response.put("username", username);
////			response.put("token", jwtToken);
//			return ResponseEntity.ok(response);
//		} else {
//			throw  new BadCredentialsException("Invalid username or password");
//		}
//	}

	@GetMapping
	public String loginUser(Model model){
		model.addAttribute("user" ,new AccountUserDto());
		return "loginPage";
	}
}
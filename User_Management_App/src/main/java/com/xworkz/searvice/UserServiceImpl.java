package com.xworkz.searvice;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.model.UserDtls;
import com.xworkz.repository.UserRepository;

import jakarta.mail.internet.MimeMessage;

//import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncode;

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public UserDtls createUser(UserDtls user, String url) {

		user.setPassword(passwordEncode.encode(user.getPassword()));
		user.setRole("ROLE_USER");

		user.setEnabled(false);
//		RandomString rn = new RandomString();

		String rn = UUID.randomUUID().toString();
		user.setVerificationCode(rn);

		UserDtls us = userRepo.save(user);

		sendVerficationMail(user, url);

		return us;
	}

	@Override
	public boolean checkEmail(String email) {

		return userRepo.existsByEmail(email);
	}

	public void sendVerficationMail(UserDtls user, String url) {

		String from = "daspabitra55@gmail.com";
		String to = user.getEmail();
		String subject = "Account Verfication";
		String content = "Dear [[name]],<br>" + "Please click the link below to verify your registration:<br>"
				+ "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>" + "Thank you,<br>" + "Becoder";

		try {

			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);

			helper.setFrom(from, "Becoder");
			helper.setTo(to);
			helper.setSubject(subject);

			content = content.replace("[[name]]", user.getFullName());

			String siteUrl = url + "/verify?code=" + user.getVerificationCode();

			content = content.replace("[[URL]]", siteUrl);

			helper.setText(content, true);

			mailSender.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean verifyAccount(String code) {

		UserDtls user = userRepo.findByVerificationCode(code);

		if (user != null) {
			user.setEnabled(true);
			user.setVerificationCode(null);
			userRepo.save(user);

			return true;
		}

		return false;
	}
}

package com.iiiotwms.identity.service;

import com.iiiotwms.identity.model.User;
import com.iiiotwms.identity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class AuthService {
    @Autowired private UserRepository userRepo;
    @Autowired private JwtUtil jwtUtil;
    @Autowired private JavaMailSender mailSender;

    private Map<String, String> otpStore = new HashMap<>();

    public String login(String email, String password) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found"));
        if (!user.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }
        return jwtUtil.generateToken(email);
    }

    public void sendOtp(String email) {
        userRepo.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        String otp = String.format("%06d", new Random().nextInt(1000000));

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setSubject("Password Reset OTP");
        msg.setText("Your OTP is: " + otp);

        try {
            mailSender.send(msg);
            otpStore.put(email, otp);
        } catch (MailException ex) {
            otpStore.put(email, otp);
            System.err.println("SMTP delivery failed; development OTP for " + email + ": " + otp);
        }
    }

    public void resetPassword(String email, String otp, String newPassword) {
        if (!otp.equals(otpStore.get(email))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid or expired OTP");
        }
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        user.setPassword(newPassword);
        userRepo.save(user);
        otpStore.remove(email);
    }
}

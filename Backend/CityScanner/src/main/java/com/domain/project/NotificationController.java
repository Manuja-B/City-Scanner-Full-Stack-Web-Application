package com.domain.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.domain.project.entities.NotificationEntity;
import com.domain.project.repositories.NotificationRepository;

@RestController
@ComponentScan
public class NotificationController {
	@Autowired
	NotificationRepository notificationRepository;

	@Autowired
	private JavaMailSender javaMailSender;

	@CrossOrigin
	@PostMapping("/addUserForNotifications")
	public void addUserForNotifications(@RequestBody NotificationEntity object) {
		notificationRepository.save(object);
	}

	// Method to get all users for current city and notification type
	@CrossOrigin
	@PostMapping("/sendHousingNotifications")
	public List<NotificationEntity> sendHousingNotifications(@RequestBody NotificationEntity object) {
		// get list of all users that satisfy given city and type
		List<NotificationEntity> usersList = notificationRepository.findUsers(object.getNotificationType(),
				object.getCityName());
		sendHousingNotificationEmails(usersList);
		return usersList;
	}

	// Method to send Email notifications for housing
	public void sendHousingNotificationEmails(List<NotificationEntity> usersList) {
		for (NotificationEntity user : usersList) {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(user.getEmail());
			msg.setSubject("New Post!");
			msg.setText("There's a new post on CityScanner. Check it out!");
			javaMailSender.send(msg);
		}
	}

}

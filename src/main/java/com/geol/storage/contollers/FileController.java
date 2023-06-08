package com.geol.storage.contollers;

import jakarta.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {

	private String uploadDir = "/Users/geol";

	@PostMapping("/upload")
	public void uploadFile(HttpServletRequest request,
			@RequestParam("file-upload") MultipartFile uploadedFile) throws IOException {

		LocalDate currentDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();
		LocalDateTime DateTime = LocalDateTime.of(currentDate, currentTime);
		String today = DateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-hhmmssSSSSSS"));

		String fileName = StringUtils.cleanPath(uploadedFile.getOriginalFilename());
		File targetFile = new File(uploadDir + File.separator + fileName);
		uploadedFile.transferTo(targetFile);

	}
}

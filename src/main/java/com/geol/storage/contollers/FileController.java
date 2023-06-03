package com.geol.storage.contollers;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

	@Autowired
	ServletContext servletContext;

	public String RealPath() {
		return "/public";
	}

	@PostMapping("/upload")
	public void uploadFile(HttpServletRequest request,
													@RequestParam("file-upload") MultipartFile uploadedFile) {
		LocalDate currentDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();
		LocalDateTime DateTime = LocalDateTime.of(currentDate, currentTime);

		String targetDirectory = servletContext.getRealPath( this.RealPath() );
		String today = DateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd-hh-mm-ss"));
		String saveFile = targetDirectory + File.separator + today;

		File folder = new File(saveFile);

	}
}

package com.geol.storage.contollers;

import jakarta.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class FileController {

	private String uploadDir = null;

	private final Logger log = LoggerFactory.getLogger(getClass());


	@PostMapping("/upload")
	public RedirectView uploadFile(HttpServletRequest request,
			@RequestParam("file-upload") MultipartFile uploadedFile) throws IOException {

		LocalDate currentDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();
		LocalDateTime DateTime = LocalDateTime.of(currentDate, currentTime);
		String today = DateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-hhmmssSSSSSS"));

		uploadDir = System.getProperty("user.dir");
		String targetDir = "/../data/";
		String ext = null;

		try {
			String fileName = StringUtils.cleanPath(
					Objects.requireNonNull(uploadedFile.getOriginalFilename()));
			String[] extArr = fileName.split("\\.");
			ext = extArr[1];

			File targetFile = new File(uploadDir + targetDir + today + "." + ext);
			uploadedFile.transferTo(targetFile);

		} catch (RuntimeException e) {
			log.info("INFO : 파일 저장 중 알 수 없는 에러가 발생하였습니다.");
		}

		return new RedirectView("/view/" + today + "." + ext);
	}
}

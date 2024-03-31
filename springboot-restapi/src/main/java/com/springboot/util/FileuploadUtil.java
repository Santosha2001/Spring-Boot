package com.springboot.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileuploadUtil {

	// static file path
//	public final String FILE_UPLOAD_DIR = "C:\\Users\\HP\\Desktop\\git repositories\\Spring-Boot\\springboot-restapi\\src\\main\\resources\\static\\image";

	// dynamic file path
	public final String FILE_UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath();

	public FileuploadUtil() throws IOException {
		System.out.println("FileuploadUtil");
	}

	public boolean fileUpload(MultipartFile multipartFile) {

		boolean flag = false;

		try {
			// older way
			// InputStream inputStream = multipartFile.getInputStream();
			// byte[] data = new byte[inputStream.available()];
			// inputStream.read(data);

			// FileOutputStream outputStream = new FileOutputStream(FILE_UPLOAD_DIR +
			// File.separator + multipartFile.getOriginalFilename());
			// outputStream.write(data);
			// outputStream.flush();
			// outputStream.close();

			// new way
			Files.copy(multipartFile.getInputStream(),
					Paths.get(FILE_UPLOAD_DIR + java.io.File.separator + multipartFile),
					StandardCopyOption.REPLACE_EXISTING);

			flag = true;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;

	}

}

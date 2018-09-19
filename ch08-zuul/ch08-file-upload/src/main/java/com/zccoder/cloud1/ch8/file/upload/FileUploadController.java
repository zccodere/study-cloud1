package com.zccoder.cloud1.ch8.file.upload;

import java.io.File;
import java.io.IOException;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @title 控制器类
 * @describe 文件上传
 * @author zc
 * @version 1.0 2017-12-11
 */
@RestController
public class FileUploadController {
	
	@GetMapping("/upload")
	public String handleFileUpload(@RequestParam(value="file",required=true) MultipartFile file)throws IOException{
		byte[] bytes = file.getBytes();
		File fileToSave = new File(file.getOriginalFilename());
		FileCopyUtils.copy(bytes, fileToSave);
		return fileToSave.getAbsolutePath();
	}
}

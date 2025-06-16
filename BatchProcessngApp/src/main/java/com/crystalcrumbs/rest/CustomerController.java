package com.crystalcrumbs.rest;

import java.io.File;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class CustomerController {
	
	@Autowired
	private Job job;
	
	@Autowired
	private JobLauncher jobLaucher;
	
	//private final String uploadDir = "uploads/";
	private final String uploadDir = System.getProperty("user.dir") + File.separator + "uploads" + File.separator;

	
	@GetMapping("/import")
	public void loadData() {
		JobParameters jobParameters=new JobParametersBuilder()
				.addLong("Starts At", System.currentTimeMillis()).toJobParameters();
		try {
			jobLaucher.run(job, jobParameters);
		} catch (JobExecutionAlreadyRunningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobRestartException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@GetMapping("/run-job")
	public ResponseEntity<String> runJob(@RequestParam String fileName) {
		JobParameters jobParameters=new JobParametersBuilder()
				.addString("fileName", fileName)
				.addLong("Starts At", System.currentTimeMillis()).toJobParameters();
		try {
			jobLaucher.run(job, jobParameters);
		} catch (JobExecutionAlreadyRunningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobRestartException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Job Completed",HttpStatus.CREATED);
	}
	
	
	@PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            // Ensure upload directory exists
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // Save the file
            String fileOrigName = file.getOriginalFilename();
            String filePath = uploadDir + fileOrigName;
            File destFile = new File(filePath);
            file.transferTo(destFile);

            // Trigger the job with full path
            JobParameters jobParameters = new JobParametersBuilder()
                    .addString("fileName", destFile.getAbsolutePath())
                    .addLong("startAt", System.currentTimeMillis())
                    .toJobParameters();

            jobLaucher.run(job, jobParameters);

            return ResponseEntity.ok("File uploaded and job started: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to upload and start job: " + e.getMessage());
        }
    }
}

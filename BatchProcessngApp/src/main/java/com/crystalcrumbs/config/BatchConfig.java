package com.crystalcrumbs.config;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.batch.core.Job;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.crystalcrumbs.model.CustomCustomersFieldSetMapper;
import com.crystalcrumbs.model.Customers;
import com.crystalcrumbs.repo.ICustomersRepo;

@Configuration
public class BatchConfig {
	
	@Autowired
	private ICustomersRepo repo;
	
	@Autowired
	private JobRepository jobRepo;

	@Autowired
	private PlatformTransactionManager transactionManager;
	
	//item Reader
//	@Bean
//	@StepScope
//	public FlatFileItemReader<Customers> itemReader(@Value("#{jobParameters['fileName']}") String fileName){
//		FlatFileItemReader <Customers>reader = new FlatFileItemReader<>();
//		
////		reader.setResource(new FileSystemResource("src/main/resource/StudentRecords.csv"));
//		reader.setResource(new FileSystemResource("src/main/resources/"+fileName));
//		reader.setName("csvReader");
//		reader.setLinesToSkip(1);
//		reader.setLineMapper(lineMapper());
//		return reader;
//		
//	}
	
	@Bean
	@StepScope
	public FlatFileItemReader<Customers> itemReader(@Value("#{jobParameters['fileName']}") String filePath){
		FlatFileItemReader <Customers>reader = new FlatFileItemReader<>();
		
//		reader.setResource(new FileSystemResource("src/main/resource/StudentRecords.csv"));
		reader.setResource(new FileSystemResource(filePath));
		reader.setName("csvReader");
		reader.setLinesToSkip(1);
		reader.setLineMapper(lineMapper());
		return reader;
		
	}

	private LineMapper<Customers> lineMapper() {
		DefaultLineMapper<Customers> lineMapper= new DefaultLineMapper<>();
		DelimitedLineTokenizer tokenizer= new DelimitedLineTokenizer();
		
		tokenizer.setDelimiter(",");
		tokenizer.setStrict(false);
		//tokenizer.setNames("studentID","firstName", "lastName", "gender", "dateOfBirth","email","phone", "Class", "department", "enrollmentYear");
		tokenizer.setNames("StudentID","FirstName","LastName","Gender","DateOfBirth","Email","Phone","Class","Department","EnrollmentYear");
		//BeanWrapperFieldSetMapper<Customers> beanWrapper = new BeanWrapperFieldSetMapper<>();
		//beanWrapper.setTargetType(Customers.class);
		//lineMapper.setFieldSetMapper(new CustomCustomersFieldSetMapper());
		lineMapper.setLineTokenizer(tokenizer);
		lineMapper.setFieldSetMapper(new CustomCustomersFieldSetMapper());
		//lineMapper.setFieldSetMapper(beanWrapper);
		return lineMapper;
		
	}
	
	
	//Item Processor
	@Bean
	public CustomersProcessor processCustData() {
		return new CustomersProcessor();
	}
	
	
	//Item Writer
	@Bean
	public RepositoryItemWriter<Customers> itemWriter(){
		RepositoryItemWriter<Customers> writer = new RepositoryItemWriter<>();
		writer.setRepository(repo);
		writer.setMethodName("save");
		return writer;
		
	}
	
	//Step
	@Bean
	public Step step() {
		return new StepBuilder("step-1",jobRepo).<Customers,Customers>chunk(100, transactionManager)
				.reader(itemReader(null))
				.processor(processCustData())
				.writer(itemWriter())
				.build();
		
	}
	
	//Job
	@Bean
	public Job job() {
		return new JobBuilder("customers-upl-job", jobRepo)
				.start(step())
				.build();	
	}

}

package com.simpleapplication.hrjoblisting.Business;

import java.io.IOException;

import javax.management.StringValueExp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.simpleapplication.hrjoblisting.DataAccess.DBFileRepository;
import com.simpleapplication.hrjoblisting.Entities.DBFile;
import com.simpleapplication.hrjoblisting.Exception.FileStorageException;
import com.simpleapplication.hrjoblisting.Exception.MyFileNotFoundException;


@Service
public class DBFileStorageService {
	
	 @Autowired
	    private DBFileRepository dbFileRepository;

	    public DBFile storeFile(MultipartFile file) {
	        // Normalize file name
	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

	        try {
	            // Check if the file's name contains invalid characters
	            if(fileName.contains("..")) {
	                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
	            }

	            DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());

	            return dbFileRepository.save(dbFile);
	        } catch (IOException ex) {
	            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
	        }
	    }

	    public DBFile getFile(int id) {
	    	System.out.println("-----logg");
	        return dbFileRepository.findById(id)
	                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + toString()));
	    }

}

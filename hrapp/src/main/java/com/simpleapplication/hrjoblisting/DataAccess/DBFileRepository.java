package com.simpleapplication.hrjoblisting.DataAccess;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simpleapplication.hrjoblisting.Entities.DBFile;
@Repository

public interface DBFileRepository extends JpaRepository <DBFile,Integer>{

}

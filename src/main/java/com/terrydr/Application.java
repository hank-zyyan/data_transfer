package com.terrydr;

import com.terrydr.service.EYEDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
@EnableTransactionManagement
public class Application {


    private static EYEDataService eyeDataService;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        runEye();
    }

    private static void runEye(){
        eyeDataService.importCommonData();
    }


    @Autowired
    public void setEYEDataService(EYEDataService eyeDataService){
        Application.eyeDataService = eyeDataService;
    }

}

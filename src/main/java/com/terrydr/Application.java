package com.terrydr;

import com.terrydr.service.ECGDataService;
import com.terrydr.service.EYEDataService;
import com.terrydr.service.PathologyDataService;
import org.mybatis.spring.annotation.MapperScan;
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

    private static ECGDataService ecgDataService;

    private static EYEDataService eyeDataService;

    private static PathologyDataService pathologyDataService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        if (args.length == 2 && args[1] != null){
            String flag1 = args[1];
            String flag0 = args[0];
            if((flag1 != null && "--ecg".equals(flag1)) || (flag0 != null && "--ecg".equals(flag0))){
                ecgDataService.importMedicalData();
            }else if ((flag1 != null && "--eye".equals(flag1)) || (flag0 != null && "--eye".equals(flag0))){
                runEye();
            }else if ((flag1 != null && "--pathology".equals(flag1)) || (flag0 != null && "--pathology".equals(flag0))){
                runPathology();
            }else{
                runALL();
            }
        }else{
            runALL();
        }
    }

    private static void runEye(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                eyeDataService.importCommonData();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                eyeDataService.importMedicalData();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                eyeDataService.importReportData();
                eyeDataService.importConsultationData();
            }
        }).start();
    }

    private static void runPathology(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                pathologyDataService.importCommonData();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                pathologyDataService.importMedicalData();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                pathologyDataService.importReportData();
            }
        }).start();
    }

    private static void runALL(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                ecgDataService.importMedicalData();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                runEye();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                runPathology();
            }
        }).start();
    }

    @Autowired
    public void setECGDataService(ECGDataService ecgDataService){
        Application.ecgDataService = ecgDataService;
    }

    @Autowired
    public void setEYEDataService(EYEDataService eyeDataService){
        Application.eyeDataService = eyeDataService;
    }

    @Autowired
    public void setPathologyDataService(PathologyDataService pathologyDataService){
        Application.pathologyDataService = pathologyDataService;
    }
}

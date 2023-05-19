package com.example.demo;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.UrlFilenameViewController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@RestController

// Class
public class DepartmentController {

//    private Logger logger = LoggerFactory.getLogger(File.class);

    // Annotation
    @Autowired
    private DepartmentService departmentService;

//    @PostMapping("/add-department")
//    public Department saveDepartment()

    @PostMapping("/department-files")
    public ResponseEntity<?> uploadMultiples(
            @RequestParam("files")MultipartFile[] files
            ){
        
        return ResponseEntity.ok("uploaded");
    }

    // Save operation
    @PostMapping("/departments")
    public Department saveDepartment(
            @RequestBody Department department)
    {

        return departmentService.saveDepartment(department);
    }

    // Read operation
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList()
    {

        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/")
    public String fetchBase()
    {

        return "Hello";
    }

//    @GetMapping("/departments/{id}")
//    public List<Department> fetchDepartmentById()
//    {
//
//        return departmentService.fetchDepartmentById();
//    }

    // Update operation
    @PutMapping("/departments/{id}")
    public Department
    updateDepartment(@RequestBody Department department,
                     @PathVariable("id") Long departmentId)
    {

        return departmentService.updateDepartment(
                department, departmentId);
    }

    // Delete operation
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id")
                                       Long departmentId)
    {

        departmentService.deleteDepartmentById(
                departmentId);
        return "Deleted Successfully";
    }

    @PostMapping("excel")
    public String excelReader(@RequestParam("file") MultipartFile excel) {
        List<Department> tempStudentList = new ArrayList<Department>();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(excel.getInputStream());
            XSSFSheet sheet = workbook.getSheetAt(0);

            for(int i=0; i<sheet.getPhysicalNumberOfRows();i++) {
                Department tempStudent = new Department();
                XSSFRow row = sheet.getRow(i);

                tempStudent.setDepartmentId((long) row.getCell(0).getNumericCellValue());
                tempStudent.setDepartmentName(row.getCell(1).getStringCellValue());
                tempStudent.setDepartmentAddress(row.getCell(2).getStringCellValue());
                tempStudent.setDepartmentCode(row.getCell(3).getStringCellValue());
                System.out.println("");
                tempStudentList.add(tempStudent);

            }
            departmentService.saveAllDepartment(tempStudentList);
            //working now

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "Success";
    }
}

//    @PostMapping("/imports")
//    public void uploadExcel(
//            @RequestParam("file") MultipartFile reapExcelDataFile
//    ) throws IOException {
//
//        List<Department> tempStudentList = new ArrayList<Department>();
//        Department tempStudent = new Department();
//        XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
//        XSSFSheet worksheet = workbook.getSheetAt(0);
//        for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
////            Department tempStudent = new Department();
//
//            XSSFRow row = worksheet.getRow(i);
//
//            tempStudent.setDepartmentId((long) row.getCell(0).getNumericCellValue());
//            tempStudent.setDepartmentName(row.getCell(1).getStringCellValue());
//            tempStudent.setDepartmentAddress(row.getCell(2).getStringCellValue());
//            tempStudent.setDepartmentCode(row.getCell(3).getStringCellValue());
//
//            tempStudentList.add(tempStudent);
//        }
//        departmentService.saveDepartment(tempStudent);
//    }



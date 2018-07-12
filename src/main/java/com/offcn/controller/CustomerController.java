package com.offcn.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.offcn.pojo.Customer;
import com.offcn.service.CustomerService;

@Controller
public class CustomerController {
	private @Autowired CustomerService customerService;

	@RequestMapping("getCustomerList.action")
	public ModelAndView getCustomerLIst() {
		List<Customer> list = customerService.getCustomerList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("customerList", list);
		mav.setViewName("customer-data");
		return mav;
	}

	@RequestMapping("getCustomerListByName.action")
	public ModelAndView getCustomerLIstByName(String job){
		List<Customer> list = customerService.getCustomerListByName(job);
		ModelAndView mav = new ModelAndView();
		mav.addObject("job",job);
		mav.addObject("customerList", list);
		mav.setViewName("customer-data");
		return mav;
	}

	@RequestMapping("customerImport.action")
	public String customerImport(@RequestParam MultipartFile exel) {
		try (InputStream is = exel.getInputStream(); XSSFWorkbook wb = new XSSFWorkbook(is);) {

			XSSFSheet sheet = wb.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();
			for (int i = 1; i < rows; i++) {
				XSSFRow row = sheet.getRow(i);

				Customer c = new Customer();
				c.setName(row.getCell(0).getStringCellValue());
				c.setJob(row.getCell(1).getStringCellValue());
				c.setCompany(row.getCell(2).getStringCellValue());
				row.getCell(3).setCellType(CellType.STRING);
				c.setTel(row.getCell(3).getStringCellValue());
				row.getCell(4).setCellType(CellType.STRING);
				c.setAge(row.getCell(4).getStringCellValue());
				c.setBirthday(row.getCell(5).getStringCellValue());
				c.setAddress(row.getCell(6).getStringCellValue());
				customerService.saveCustomer(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:getCustomerList.action";
	}

	@RequestMapping("exelExport.action")
	@ResponseBody
	public String exelExport() throws Exception {
		
		List<Customer> customerList = customerService.getCustomerList();
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet();
		// ��һ�еĴ���
		XSSFRow rowHeader = sheet.createRow(0);
		rowHeader.createCell(0).setCellValue("�ͻ�����");
		rowHeader.createCell(1).setCellValue("ְ��");
		rowHeader.createCell(2).setCellValue("������λ");
		rowHeader.createCell(3).setCellValue("��ϵ��ʽ");
		rowHeader.createCell(4).setCellValue("����");
		rowHeader.createCell(5).setCellValue("�ͻ�����");
		rowHeader.createCell(6).setCellValue("��ͥסַ");
		// �����еĴ���
		for (int i = 0; i < customerList.size(); i++) {
			Customer customer = customerList.get(i);
			String name = customer.getName();
			String job = customer.getJob();
			String company = customer.getCompany();
			String tel = customer.getTel();
			String age = customer.getAge();
			String birthday = customer.getBirthday();
			String address = customer.getAddress();
			// ÿһ���������
			XSSFRow row = sheet.createRow(i + 1);
			row.createCell(0).setCellValue(name);
			row.createCell(1).setCellValue(job);
			row.createCell(2).setCellValue(company);
			row.createCell(3).setCellValue(tel);
			row.createCell(4).setCellValue(age);
			row.createCell(5).setCellValue(birthday);
			row.createCell(6).setCellValue(address);
		}
		// ������ļ�
		FileOutputStream fos = new FileOutputStream("C:\\Users\\admin\\Desktop\\�ͻ����ϱ���.xlsx");
		wb.write(fos);
		return "ok";
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsax;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import testsax.Employee;

public class XMLParserSAX {
    
    /*
    SET THE WORKING DIRECTORY TO .../testSAX/src/testsax TO OPEN FILES 
    */

    public static void main(String[] args) {
    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    try {
        // goes through both regular and ENTITY file
        String[] filenames = {"employee_ENTITY.xml", "employees.xml"};
        
        for (String s : filenames) {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            TestSAX handler = new TestSAX();
            saxParser.parse(new File("employee_ENTITY.xml"), handler);
            //Get Employees list
            List<Employee> empList = handler.getEmpList();
            
            System.out.println("-------------------------------------------------");
            System.out.println("FILENAME: " + s);
            //print employee information
            for(Employee emp : empList)
                System.out.println(emp);
            System.out.println("-------------------------------------------------");
        }// end for
    } catch (ParserConfigurationException | SAXException | IOException e) {
        e.printStackTrace();
    }
    }

}

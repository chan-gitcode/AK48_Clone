package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.module.FindException;
import java.util.*;
import java.util.stream.Collectors;

public class TableTest {
    /*TC05: Web Table: Validate largest due person from a table
    Open browser
    Navigate to https://the-internet.herokuapp.com/tables
    Focus on table 1
    The person who has largest due is "Doe Jacson"*/

    @Test
    void tc05(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
      /* 1. get row index of max due -> get lastname/firstname of max due
      * due column xpath //table[@id='table1']/tbody/tr/td[4] => row_index
      * lastname column xpath //table[@id='table1']/tbody/tr[row_index]/td[1]
      * firstname column xpath //table[@id='table1']/tbody/tr[row_index]/td[1]*/

        List<Double> dueList = driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .map(cell->Double.valueOf(cell.getText().replace("$","")))
                .collect(Collectors.toList());

        double maxDue = Collections.max(dueList);
        int rowIndex = dueList.indexOf(maxDue) + 1;

        String lastName = driver
                .findElement(By.xpath("//table[@id='table1']/tbody/tr["+ rowIndex +"]/td[1]")).getText();
        String firstName = driver
                .findElement(By.xpath("//table[@id='table1'/tbody/tr["+rowIndex+"]/td[2]")).getText();

        Assert.assertEquals(String.format("%s %s", firstName, lastName),"Jacson Doe");
        driver.quit();

        //todo: select 7/4/2025
        /*driver.findElements(By.cssSelector(".ui-datepicker-group-first a")).stream()
                .filter(el->el.getText().equals("7"))
                .findFirst()
                .get()
                .click();*/
    }

    @Test
    void tc06(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        List<Person> personList = new ArrayList<>();

        driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"))
                .forEach(row->{
                    String lastName = row.findElement(By.xpath(".//td[1]")).getText();
                    String firstName = row.findElement(By.xpath("./td[2]")).getText();
                    double due = Double.parseDouble(row
                            .findElement(By.xpath(".//td[4]")).getText().replace("$",""));
                    personList.add(new Person(firstName, lastName, due));
                        });

//        personList.forEach(Person::info);
//        String maxDuePersonFullName = personList.stream()
//                .max(Comparator.comparing(Person::getDue))
//                .get()
//                .getFullname();

        double maxDue = personList.stream().max(Comparator.comparing(Person::getDue)).get().getDue();
        List<String> listPersonHaveMaxDue = personList.stream().filter(person -> person.getDue() == maxDue )
                .map(Person::getFullname).toList();

        Assert.assertEquals(listPersonHaveMaxDue,List.of("Jason Doe"));

        driver.quit();
    }

    @Test
    void tc07(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        List<Person> personList = new ArrayList<>();

        driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"))
                .forEach(row->{
                    String lastName = row.findElement(By.xpath(".//td[1]")).getText();
                    String firstName = row.findElement(By.xpath("./td[2]")).getText();
                    double due = Double.parseDouble(row
                            .findElement(By.xpath(".//td[4]")).getText().replace("$",""));
                    personList.add(new Person(firstName, lastName, due));
                });

        double minDue = personList.stream().min(Comparator.comparing(Person::getDue)).get().getDue();
        List<String> listPersonHaveMinDue = personList.stream().filter(person -> person.getDue() == minDue )
                .map(Person::getFullname).toList();

        Assert.assertEquals(listPersonHaveMinDue,List.of("John Smith","Tim Conway"));

        driver.quit();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;
import java.time.LocalDate;
import person.Host;
import person.Lecturer;
import person.Participant;
/**
 *
 * @author Casper
 */
public class Lecture extends Event{ //predavanja
    private String subject;
    private Lecturer lecturer;
    private String content;

    public Lecture(String subject, Lecturer lecturer, String content, String name, LocalDate startDate, LocalDate endDate, String description, Host host) {
        super(name, startDate, endDate, description, host);
        this.subject = subject;
        this.lecturer = lecturer;
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String toCSV(){
        return "Lecture;"+super.getName()+";"+super.getStartDate()+";"+super.getEndDate()+";"+super.getDescription()+
                ";"+super.getHost()+";"+super.getListOfSubEvents()+";"+this.getSubject()+";"+this.getLecturer()+";"+this.getContent();
    }
    
}

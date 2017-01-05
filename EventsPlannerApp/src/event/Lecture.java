/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;
import java.util.ArrayList;
import java.util.Date;
import person.Person;
import person.Host;
import person.Participant;
/**
 *
 * @author Casper
 */
public class Lecture extends Event{ //predavanja
    private String subject;
    private Person lecturer;
    private String content;

    public Lecture(String subject, Person lecturer, String content, String name, Date startDate, Date endDate, String description, Host host, ArrayList<Participant> participants) {
        super(name, startDate, endDate, description, host, participants);
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

    public Person getLecturer() {
        return lecturer;
    }

    public void setLecturer(Person lecturer) {
        this.lecturer = lecturer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    
}

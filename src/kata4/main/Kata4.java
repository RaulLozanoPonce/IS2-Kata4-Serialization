package kata4.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;

public class Kata4 {
    
    private final String fileName;
    private List<Mail> mailList;
    private Histogram<String> histogram;
    
    public Kata4(String fileName){
        this.fileName = fileName;
        mailList = new ArrayList<>();
    }
    
    public static void main(String[] args) throws IOException{
        Kata4 kata4 = new Kata4("email.txt");
        kata4.execute();
    }

    private void execute() throws IOException{
        input();
        process();
        output();
    }
    
    private void input() throws IOException {
        mailList = new MailListReader().read(fileName);
    }

    private void process() {
        histogram = new MailHistogramBuilder().build(mailList);
    }

    private void output() {
        new HistogramDisplay(histogram).execute();
    }
}

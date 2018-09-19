class Card {
	Card
}class Card {
	private String title;
	 public String gettitle(){
	  return title;
	 }
	 
	 public void settitle(String title){
	  this.title = title;
	 }
	private String author;
	 public String getauthor(){
	  return author;
	 }
	 
	 public void setauthor(String author){
	  this.author = author;
	 }
	 private String subject;
	  public String getsubject(){
	   return subject;
	  }
	  
	  public void setsubject(String subject){
	   this.subject = subject;
	  }
	Card (String tb, String ab, String sb) {
		title = tb;
		author = ab;
		subject = sb;
	}
}
public class Catalog {
	
	Catalog() {

	}
}
package model;

public class Questions {
  
  // string of a question
  private String question;
  // string of an answer for the question
  private String answer;
  
  //an array list holds answers of all questions 
  private ArrayList<String> answers; 
  
  public Questions () {
    this.question = question;
    this.answer = answer;
    this.answers = answers;
  }

  public String getQuestion() {
    return question;
  }
  public String getAnswer() {
    return answer;
  }

  public ArrayList<String> getAnswers() {
    return answers;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    
    sb.append("Question: " + question + "/n");
    sb.append("Answer: " + answer + "/n");
    sb.append("All answers: " + answers.toString());
    
    return sb.toString();

  }

}

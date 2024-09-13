package mg.moni.triviamg.data;



import java.util.ArrayList;

import mg.moni.triviamg.model.Questions;


public interface AnswerListAsyncResponse {
    void processFinished(ArrayList<Questions> questionArrayList);
}

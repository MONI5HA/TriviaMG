package mg.moni.triviamg.data;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;


import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import mg.moni.triviamg.controller.AppContoller;
import mg.moni.triviamg.model.Questions;

public class Repository {
    ArrayList<Questions> questionArrayList = new ArrayList<>();

    String url = "https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements-data.json";

    public List<Questions> getQuestions( final AnswerListAsyncResponse callBack) {

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                url, null, response -> {
            for (int i = 0; i < response.length(); i++) {

                try {
                    Questions question = new Questions(response.getJSONArray(i).get(0).toString(),
                            response.getJSONArray(i).getBoolean(1));

                    //Add questions to arraylist/list
                    questionArrayList.add(question);

                    //Log.d("Hello", "getQuestions: " + questionArrayList);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (null != callBack) callBack.processFinished(questionArrayList);



        }, error -> {

        });

        AppContoller.getInstance().addToRequestQueue(jsonArrayRequest);

        return questionArrayList;
    }

}

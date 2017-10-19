package com.jonmid.segundoparcial.Parser;

import com.jonmid.segundoparcial.Model.TeamModelSalasAlejandra;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aula7 on 17/10/17.
 */

public class TeamJsonSalasAlejandra {

    public static List<TeamModelSalasAlejandra> getData(String content) throws JSONException {
        JSONObject jsonObject = new JSONObject(content);
        JSONArray jsonArray = jsonObject.getJSONArray("teams");
        List<TeamModelSalasAlejandra> teamModelSalasAlejandrasList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = jsonArray.getJSONObject(i);
            TeamModelSalasAlejandra cardView = new TeamModelSalasAlejandra();
            cardView.setName(item.getString("name"));
            cardView.setCode(item.getString("code"));
            teamModelSalasAlejandrasList.add(cardView);
        }
        return teamModelSalasAlejandrasList;
    }


}

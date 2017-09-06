package kiilian.android.apiretorno.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class Giras {
    private String Id;
    private String Data;
    private String Descricao;

    public Giras(JSONObject object){
        try{
            this.Id = object.getString("EventosId");
            this.Data = object.getString("DataEvento");
            this.Descricao = object.getString("Descricao");
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public Giras(String Data, String Descricao){
        this.Data = Data;
        this.Descricao = Descricao;
    }

    public String getId(){
        return this.Id;
    }

    public String getData(){
        return this.Data;
    }
    public String getDescricao(){
        return this.Descricao;
    }

    public void setData(String Data){
        this.Data = Data;
    }
    public void setDescricao(String Descricao){
        this.Descricao = Descricao;
    }
}

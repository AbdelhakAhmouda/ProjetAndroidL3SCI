package sci.iam.learnapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.random;

public class ModuleAdapter extends ArrayAdapter {

    List<Module> items = new ArrayList<>();


    public ModuleAdapter(Context context, int item_module) {
        super(context,item_module);


    }

    static class ModuleHandler{
        TextView accronym;
        TextView name;
        TextView description;
        TextView credit;
    }

    public Object getItem(int position){
        return this.items.get(position);
    }

    public void add(Module object){
        super.add(object);
        items.add(object);
    }


    public View getView(int position, View convertView, ViewGroup parent){
        View row;
        row = convertView;
        ModuleHandler moduleHandler;
        if(convertView == null){
            LayoutInflater inflater = ((ModulesActivity)this.getContext()).getLayoutInflater();
            row = inflater.inflate(R.layout.item_module,parent,false);

            moduleHandler = new ModuleHandler();
            moduleHandler.accronym = row.findViewById(R.id.accronym);
            moduleHandler.name = row.findViewById(R.id.name);
            moduleHandler.credit = row.findViewById(R.id.credit);
            row.setTag(moduleHandler);
        }
        else{
            moduleHandler = (ModuleHandler) row.getTag();
        }

        Module module;
        module = (Module) this.getItem(position);

        moduleHandler.accronym.setText(module.getAccronym());
        moduleHandler.name.setText(module.getName());
        moduleHandler.credit.setText(module.getCredit());

        int type=position;

        switch(type){
            case 0:
                row.setBackgroundColor(Color.parseColor("#563a2d"));
                break;
            case 1:
                row.setBackgroundColor(Color.parseColor("#261666"));
                break;
            case 2:
                row.setBackgroundColor(Color.parseColor("#536438"));
                break;
            case 3:
                row.setBackgroundColor(Color.parseColor("#7f6d5c"));
                break;
            case 4:
                row.setBackgroundColor(Color.parseColor("#206c63"));
                break;
            default:
                Random rnd = new Random();
                row.setBackgroundColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
                break;
        }

        return row;
    }


}

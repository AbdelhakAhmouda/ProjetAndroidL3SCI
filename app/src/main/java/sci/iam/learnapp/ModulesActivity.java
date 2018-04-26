package sci.iam.learnapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ModulesActivity extends AppCompatActivity {


    //TextView welcome_text;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules);

        //welcome_text = findViewById(R.id.welcome);

        final GridView gridView = findViewById(R.id.grid);

        final String [] items = {"Application mobiles","Intelligent System","Compilation","Paradigmes de programmation","Recherche opérationnelle"};
        final String [] accronymItems = {"DAM","IS","COMP","PARA","RO"};
        final String [] creditItems = {"5","5","5","4","5"};
        final String [] descriptionItems = {"Ce module est destiné essentiellement aux étudiants de Licence 3,en informatique. Son objectif est l'acquisition par tout étudiant, des connaissances et des compétences pour le développement des applications mobiles sous l'OS Android, ainsi que la maîtrise des outils nécessaires pour ce type de développement.",
                                            "Ce module est destiné essentiellement aux étudiants de Licence 3,en informatique. Son objectif est l'acquisition par tout étudiant, des connaissances et des compétences pour l'inteligent System, ainsi que la maîtrise des outils nécessaires.",
                                            "Ce module est destiné essentiellement aux étudiants de Licence 3,en informatique. Son objectif est l'acquisition par tout étudiant, des connaissances et des compétences pour la compilation, ainsi que la maîtrise des outils nécessaires.",
                                            "Ce module est destiné essentiellement aux étudiants de Licence 3,en informatique. Son objectif est l'acquisition par tout étudiant, des connaissances et des compétences pour les paradigmes de programmation, ainsi que la maîtrise des outils nécessaires.",
                                            "Ce module est destiné essentiellement aux étudiants de Licence 3,en informatique. Son objectif est l'acquisition par tout étudiant, des connaissances et des compétences pour le recherche opérationnelle, ainsi que la maîtrise des outils nécessaires."};

        final ModuleAdapter adapter = new ModuleAdapter(ModulesActivity.this ,R.layout.item_module);
        gridView.setAdapter(adapter);

        int position =0;
        while(position<items.length) {
            Module module = new Module(
                    accronymItems[position],items[position],creditItems[position],descriptionItems[position]);
            adapter.add(module);
            adapter.notifyDataSetChanged();
            position++;
        }



        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Toast.makeText(ModulesActivity.this , items[i] ,Toast.LENGTH_SHORT).show();
                SyllabusDialog syllabusDialog =  new SyllabusDialog(ModulesActivity.this);
                syllabusDialog.show();
                syllabusDialog.name.setText(items[i]);
                syllabusDialog.credit.setText(creditItems[i]);
                syllabusDialog.description.setText(descriptionItems[i]);


            }
        });

        FloatingActionButton floatButton = findViewById(R.id.update);
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ModulesActivity.this, "Updating..",Toast.LENGTH_SHORT).show();
                gridView.setAdapter( adapter);
            }});


//        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
//
//        String username = bundle.getString("username");
//        String password = bundle.getString("password");


        //welcome_text.setText("Welcome '"+username+"', your Password '"+password+"'");

    }



}

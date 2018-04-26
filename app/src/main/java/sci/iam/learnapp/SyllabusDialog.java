package sci.iam.learnapp;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SyllabusDialog extends Dialog{

    TextView name;
    TextView credit;
    TextView description;

    public SyllabusDialog(@NonNull Context context) {
        super(context);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_syllabus);

        name = findViewById(R.id.name);
        credit = findViewById(R.id.credit);
        description = findViewById(R.id.description);

        Button contenu = findViewById(R.id.contenu);
        contenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Coming Soon!!" ,Toast.LENGTH_SHORT).show();
            }
        });

    }
}

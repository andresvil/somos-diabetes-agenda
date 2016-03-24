package com.example.andresvil.agenda;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button mesButton;
    Button consultasButton;
    ListView eventosList;
    ListView consultasList;
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Find list, buttons and their textviews
        mesButton = (Button) findViewById(R.id.buttonMes);
        consultasButton = (Button) findViewById(R.id.buttonConsultas);
        TextView mesText = (TextView) findViewById(R.id.buttonMes);
        TextView consultasText = (TextView) findViewById(R.id.buttonConsultas);
        eventosList = (ListView) findViewById(R.id.eventosList);
        consultasList = (ListView) findViewById(R.id.consultasList);
        calendarView = (CalendarView) findViewById(R.id.calendarView);

        // Populate nombreEventos arrayList
        ArrayList<String> nombreEventos = new ArrayList<>();
        nombreEventos.add("Visita al Oftalmólogo");
        nombreEventos.add("Entrenamiento");
        nombreEventos.add("Visita al Cardiólogo");
        nombreEventos.add("Entrenamiento");
        nombreEventos.add("Visita al Endocrinólogo");
        nombreEventos.add("Examen de Vista");

        // Populate fechaEventos
        ArrayList<String> fechaEventos = new ArrayList<>();
        fechaEventos.add("20 de Febrero del 2016; 4:00 PM");
        fechaEventos.add("29 de Febrero del 2016; 6:30 PM");
        fechaEventos.add("3 de Marzo del 2016; 7:00 PM");
        fechaEventos.add("11 de Marzo del 2016; 4:00 PM");
        fechaEventos.add("15 de Marzo del 2016; 6:00 PM");
        fechaEventos.add("2 de Abril del 2016; 5:30 PM");

        // Populate lugarEventos
        ArrayList<String> lugarEventos = new ArrayList<>();
        lugarEventos.add("Lugar: Clínica NOVA");
        lugarEventos.add("Lugar: Clínica NOVA");
        lugarEventos.add("Lugar: Hospital Muguerza");
        lugarEventos.add("Lugar: Clínica NOVA");
        lugarEventos.add("Lugar: Clínicas del Azúcar");
        lugarEventos.add("Lugar: Clínica NOVA");

        // Create and set adapter
        AgendaAdapter adapter = new AgendaAdapter(getApplicationContext(), R.layout.eventos_row_layout);
        eventosList.setAdapter(adapter);
        consultasList.setAdapter(adapter);

        // Load arrayLists into Evento and into AgendaAdapter
        for (int i = 0; i < nombreEventos.size(); i++)
        {
            Evento e = new Evento(nombreEventos.get(i), fechaEventos.get(i), lugarEventos.get(i));
            adapter.add(e);
        }


        // Load font
        AssetManager am = this.getApplicationContext().getAssets();
        Typeface myFont = Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "AvenirLTStd-Roman_0.otf"));

        // Set TextViews to myFont
        mesText.setTypeface(myFont);
        consultasText.setTypeface(myFont);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // When Consultas Button is clicked
    public void toConsultas(View v)
    {
        // Change buttons
        consultasButton.setEnabled(false);
        consultasButton.setAlpha(1);
        mesButton.setEnabled(true);
        mesButton.setAlpha(0.5f);

        // Change visible Views
        consultasList.setVisibility(View.VISIBLE);
        eventosList.setVisibility(View.INVISIBLE);
        calendarView.setVisibility(View.INVISIBLE);
    }

    // When Mes Button is clicked
    public void toMes(View v)
    {
        // Change buttons
        consultasButton.setEnabled(true);
        consultasButton.setAlpha(0.5f);
        mesButton.setEnabled(false);
        mesButton.setAlpha(1);

        // Change visible Views
        consultasList.setVisibility(View.INVISIBLE);
        eventosList.setVisibility(View.VISIBLE);
        calendarView.setVisibility(View.VISIBLE);
    }
}

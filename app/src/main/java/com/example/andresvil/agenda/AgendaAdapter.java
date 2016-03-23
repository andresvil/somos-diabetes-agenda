package com.example.andresvil.agenda;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by andresvil on 3/23/16.
 */
public class AgendaAdapter extends ArrayAdapter {

    private List myList = new ArrayList();

    public AgendaAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(Evento evento)
    {
        myList.add(evento);
        super.add(evento);
    }

    static class Holder
    {
        TextView NOMBRE;
        TextView FECHA;
        TextView LUGAR;
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int position) {
        return myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        final Holder holder;

        if (row == null)
        {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.eventos_row_layout, parent, false);
            holder = new Holder();
            holder.NOMBRE = (TextView) row.findViewById(R.id.nombreText);
            holder.FECHA = (TextView) row.findViewById(R.id.fechaText);
            holder.LUGAR = (TextView) row.findViewById(R.id.lugarText);

            row.setTag(holder);
        }

        else
        {
            holder = (Holder) row.getTag();
        }

        Evento e = (Evento) getItem(position);

        // Set textViews to Evento text
        holder.NOMBRE.setText(e.getNombreEvento());
        holder.FECHA.setText(e.getFecha());
        holder.LUGAR.setText(e.getLugar());

        // Load font
        AssetManager am = getContext().getApplicationContext().getAssets();
        Typeface myFont = Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "AvenirLTStd-Roman_0.otf"));

        // Set textviews to myFont
        holder.NOMBRE.setTypeface(myFont);
        holder.FECHA.setTypeface(myFont);
        holder.NOMBRE.setTypeface(myFont);

        // Set OnClickListener
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Item Clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        return row;
    }
}

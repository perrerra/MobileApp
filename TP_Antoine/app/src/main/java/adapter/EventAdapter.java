package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.pierre.tp_antoine.R;
import java.util.List;
import model.Event;

/**
 * Created by Pierre on 12/04/2017.
 */

public class EventAdapter extends ArrayAdapter<Event> {


    //tweets est la liste des models à afficher
    public EventAdapter(Context context, List<Event> events) {
        super(context, 0, events);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        //Android nous fournit un convertView null lorsqu'il nous demande de la créer
        //dans le cas contraire, cela veux dire qu'il nous fournit une vue recyclée
        if(convertView == null){
            //Nous récupérons notre row_tweet via un LayoutInflater,
            //qui va charger un layout xml dans un objet View
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_event,parent, false);
        }

        EventViewHolder viewHolder = (EventViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new EventViewHolder();
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.categorie = (TextView) convertView.findViewById(R.id.categorie);
            viewHolder.startDate = (TextView) convertView.findViewById(R.id.start_date);
            viewHolder.city = (TextView) convertView.findViewById(R.id.city);
            convertView.setTag(viewHolder);
        }

        Event event = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.title.setText(event.getName());
        viewHolder.categorie.setText(event.getCat().getName());
        viewHolder.startDate.setText(event.getStartDate().toString());
        viewHolder.city.setText(event.getPlace().getAdress().getCity());

        //nous renvoyons notre vue à l'adapter, afin qu'il l'affiche
        //et qu'il puisse la mettre à recycler lorsqu'elle sera sortie de l'écran
        return convertView;
    }

}

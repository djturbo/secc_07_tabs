package tabtoolbar.fjarquellada.es.tabtoolbar.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import tabtoolbar.fjarquellada.es.tabtoolbar.R;
import tabtoolbar.fjarquellada.es.tabtoolbar.adapter.PersonAdapter;
import tabtoolbar.fjarquellada.es.tabtoolbar.interfaces.OnPersonCreated;
import tabtoolbar.fjarquellada.es.tabtoolbar.model.Country;
import tabtoolbar.fjarquellada.es.tabtoolbar.model.Person;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    private List<Person> persons;
    private ListView listView;
    private PersonAdapter adapter;

    public ListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        persons = new ArrayList<Person>();
        listView = view.findViewById(R.id.listViewPerson);
        adapter = new PersonAdapter(getContext(), R.layout.list_view_item_person, persons);
        listView.setAdapter(adapter);

        return view;
    }

    public void addPerson(Person person) {
        this.persons.add(person);
        adapter.notifyDataSetChanged();
    }


}

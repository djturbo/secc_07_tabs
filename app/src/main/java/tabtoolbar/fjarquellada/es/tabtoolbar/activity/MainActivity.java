package tabtoolbar.fjarquellada.es.tabtoolbar.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import tabtoolbar.fjarquellada.es.tabtoolbar.R;
import tabtoolbar.fjarquellada.es.tabtoolbar.adapter.ViewPagerAdapter;
import tabtoolbar.fjarquellada.es.tabtoolbar.fragment.ListFragment;
import tabtoolbar.fjarquellada.es.tabtoolbar.interfaces.OnPersonCreated;
import tabtoolbar.fjarquellada.es.tabtoolbar.model.Person;

public class MainActivity extends AppCompatActivity implements OnPersonCreated {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private ViewPagerAdapter adapter;

    // Índice de posición de los fragments
    public static final int PERSON_FORM_FRAGMENT = 0;
    public static final int PERSON_LIST_FRAGMENT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        setToolbar();
        setTabLayout();
        setViewPager();
        setListenerTabLayout(viewPager);
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
    }

    private void setTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText("Form"));
        tabLayout.addTab(tabLayout.newTab().setText("List"));
    }

    private void setViewPager() {
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), this, tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    private void setListenerTabLayout(final ViewPager viewPager) {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }

    @Override
    public void createPerson(Person person) {
        // Obtenemos el fragment deseado, ListFragment, a través de
        // getSupportFragmentManager(), y posteriormente pasamos el índice de posición
        // de dicho fragment
        ListFragment fragment = (ListFragment) getSupportFragmentManager().getFragments().get(PERSON_LIST_FRAGMENT);
        // Llamamos al método de nuestro fragment
        fragment.addPerson(person);
        // Movemos el viewpager hacia el ListFragment para ver la persona añadida en el listView
        viewPager.setCurrentItem(PERSON_LIST_FRAGMENT);
    }
}

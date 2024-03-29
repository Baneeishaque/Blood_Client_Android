package bank.blood.ndk.user;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class User_Home extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private static Context sContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_home);

        sContext = getApplicationContext();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_user_home, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    /**
     * A placeholder fragment containing a simple view.
     */
//    public static class PlaceholderFragment extends Fragment {
//        /**
//         * The fragment argument representing the section number for this
//         * fragment.
//         */
//        private static final String ARG_SECTION_NUMBER = "section_number";
//
//        public PlaceholderFragment() {
//        }
//
//        /**
//         * Returns a new instance of this fragment for the given section
//         * number.
//         */
//        public static PlaceholderFragment newInstance(int sectionNumber) {
//            PlaceholderFragment fragment = new PlaceholderFragment();
//            Bundle args = new Bundle();
//            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//            fragment.setArguments(args);
//            return fragment;
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.fragment_user_home, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
//            return rootView;
//        }
//    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {
                case 0:
                    return Pending_Works_Fragment.newInstance();

                case 1:
                    return Finished_Works_Fragment.newInstance();

                default:
                    return Upcoming_Works_Fragment.newInstance();


            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

//        @Override
//        public CharSequence getPageTitle(int position) {
//            switch (position) {
//                case 0:
//                    return "Records";
//                case 1:
//                    return "Searchs";
//                case 2:
//                    return "Contacts Us";
//            }
//            return null;
//        }
    }
    static ProgressDialog pd;
    static void get_sales_thread() {

//        pd = ProgressDialog.show(this, "", "Please wait...");
        new Thread(new Runnable() {
            public void run() {
                get_sales();

            }


        }).start();

    }


    static Sortable_Donor_TableView donor_tableView_sortable;
    private static void get_sales() {
//        try {
//            httpcnt = new DefaultHttpClient();
//            httpost = new HttpPost("http://" + General_Data.SERVER_IP_ADDRESS + "/android/get_sale_scheme.php");
//            nvp = new ArrayList<NameValuePair>(2);
//
//            nvp.add(new BasicNameValuePair("date", current_date));
//
//            nvp.add(new BasicNameValuePair("scheme", extras.getString("scheme")));
//
//            httpost.setEntity(new UrlEncodedFormEntity(nvp));
//            ResponseHandler<String> s = new BasicResponseHandler();
//            response = httpcnt.execute(httpost, s);
//            runOnUiThread(new Runnable() {
//
//                @Override
//                public void run() {
//                    Log.d(General_Data.TAG, response);
//                    pd.dismiss();
//                    try {
//
//                        JSONArray json_array = new JSONArray(response);
//                        if (json_array.getJSONObject(0).getString("sum").equals("null")) {
//                            buttonSales.setText("0");
//                        } else {
//                            buttonSales.setText(json_array.getJSONObject(0).getString("sum"));
//                        }
//                        List<Lottery_ticket> lottery_tickets = new ArrayList<>();
//                        for (int i = 1; i < json_array.length(); i++) {
//
//
//                            Lottery_ticket lottery_ticket = new Lottery_ticket(String.valueOf(i),"", json_array.getJSONObject(i).getString("serial"), json_array.getJSONObject(i).getString("count"), json_array.getJSONObject(i).getString("agent"), json_array.getJSONObject(i).getString("name"));
//
//                            lottery_tickets.add(lottery_ticket);
//
//
//                        }
//
//                        if (sales_tableView != null) {
//                            final Lottery_Ticket_Table_Data_Adapter lottery_ticket_table_data_adapter = new Lottery_Ticket_Table_Data_Adapter(getApplicationContext(), lottery_tickets, sales_tableView);
//                            sales_tableView.setDataAdapter(lottery_ticket_table_data_adapter);
//
//                        }
//
//
//                    } catch (JSONException e) {
//                        Toast.makeText(Sales.this, "Error : " + e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
//                        Log.d(General_Data.TAG, e.getLocalizedMessage());
//                    }
//
//
//                }
//            });
//        } catch (final Exception e) {
//            runOnUiThread(new Runnable() {
//
//                @Override
//                public void run() {
//                    Toast.makeText(Sales.this, "Error : " + e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
//                    Log.d(General_Data.TAG, e.getLocalizedMessage());
//                    pd.dismiss();
//                }
//            });
//        }

        List<Donor> donors = new ArrayList<>();
        donors.add(new Donor("A+","AddressAddressAddressAddressAddressAddressAddressAddressAddressAddress",1,"9895204814","Name"));
        donors.add(new Donor("A+","Address",1,"9895204814","Name"));
        donors.add(new Donor("A+","Address",1,"9895204814","Name"));
        donors.add(new Donor("A+","Address",1,"9895204814","Name"));
        donors.add(new Donor("A+","Address",1,"9895204814","Name"));
        if (donor_tableView_sortable != null) {
//                            final Lottery_Ticket_Table_Data_Adapter lottery_ticket_table_data_adapter = new Lottery_Ticket_Table_Data_Adapter(getApplicationContext(), lottery_tickets, sales_tableView);
                            donor_tableView_sortable.setDataAdapter(new Sortable_Donor_Table_Data_Adapter(sContext,donors,donor_tableView_sortable));
//
                        }
    }



//    DefaultHttpClient httpcnt;
//    HttpPost httpost;
//    ArrayList<NameValuePair> nvp;
//    String response;

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class Pending_Works_Fragment extends Fragment {


        public Pending_Works_Fragment() {

        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Pending_Works_Fragment newInstance() {
            Pending_Works_Fragment fragment = new Pending_Works_Fragment();
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {



            View rootView = inflater.inflate(R.layout.fragment_pending_works, container, false);

     donor_tableView_sortable = (Sortable_Donor_TableView) rootView.findViewById(R.id.tableView);
            get_sales_thread();
            //            donor_tableView_sortable.setColumnCount(5);
//            String[][] DATA_TO_SHOW = { { "This", "is", "a", "test","" },
//                    { "and", "a", "second", "test","" } };
//            donor_tableView_sortable.setDataAdapter(new SimpleTableDataAdapter(this, DATA_TO_SHOW));

//            recyclerView = rootView.findViewById(R.id.recycler_view);
//
//            mAdapter = new MoviesAdapter(movieList);
//            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
//            recyclerView.setLayoutManager(mLayoutManager);
//            recyclerView.setItemAnimator(new DefaultItemAnimator());
//            recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
//            recyclerView.setAdapter(mAdapter);
//
//            recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
//                @Override
//                public void onClick(View view, int position) {
//                    Movie movie = movieList.get(position);
//                    Toast.makeText(getContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(getContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
//                    Intent i=new Intent(getContext(),Work.class);
//                    i.putExtra("work",movie.getTitle());
//                    startActivity(i);
//                }
//
//                @Override
//                public void onLongClick(View view, int position) {
//
//                }
//            }));
//
//            if (pen_data_flag == 0) {
//                prepareMovieData();
//            }

            return rootView;
        }

//        private List<Movie> movieList = new ArrayList<>();
//        private RecyclerView recyclerView;
//        private MoviesAdapter mAdapter;
//
//        private void prepareMovieData() {
//            Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
//            movieList.add(movie);
//
//            movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
//            movieList.add(movie);
//
//            movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
//            movieList.add(movie);
//
//            movie = new Movie("Shaun the Sheep", "Animation", "2015");
//            movieList.add(movie);
//
//            movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
//            movieList.add(movie);
//
//            movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
//            movieList.add(movie);
//
//            mAdapter.notifyDataSetChanged();
//
//            pen_data_flag=1;
//        }
    }



    /**
     * A placeholder fragment containing a simple view.
     */
    public static class Finished_Works_Fragment extends Fragment {

        public Finished_Works_Fragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Finished_Works_Fragment newInstance() {
            Finished_Works_Fragment fragment = new Finished_Works_Fragment();
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_finished_works, container, false);

//            recyclerView = rootView.findViewById(R.id.recycler_view);
//
//            mAdapter = new MoviesAdapter(movieList);
//            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
//            recyclerView.setLayoutManager(mLayoutManager);
//            recyclerView.setItemAnimator(new DefaultItemAnimator());
//            recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
//            recyclerView.setAdapter(mAdapter);
//
//            recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
//                @Override
//                public void onClick(View view, int position) {
//                    Movie movie = movieList.get(position);
//                    Toast.makeText(getContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
//                }
//
//                @Override
//                public void onLongClick(View view, int position) {
//
//                }
//            }));
//
//            if (fin_data_flag == 0) {
//                prepareMovieData();
//            }

            return rootView;
        }

//        private List<Movie> movieList = new ArrayList<>();
//        private RecyclerView recyclerView;
//        private MoviesAdapter mAdapter;
//
//        private void prepareMovieData() {
//
//
//            Movie movie = new Movie("Up", "Animation", "2009");
//            movieList.add(movie);
//
//            movie = new Movie("Star Trek", "Science Fiction", "2009");
//            movieList.add(movie);
//
//            movie = new Movie("The LEGO Movie", "Animation", "2014");
//            movieList.add(movie);
//
//            movie = new Movie("Iron Man", "Action & Adventure", "2008");
//            movieList.add(movie);
//
//            movie = new Movie("Aliens", "Science Fiction", "1986");
//            movieList.add(movie);
//
//
//            mAdapter.notifyDataSetChanged();
//
//            fin_data_flag=1;
//        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class Upcoming_Works_Fragment extends Fragment {

        public Upcoming_Works_Fragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Upcoming_Works_Fragment newInstance() {
            Upcoming_Works_Fragment fragment = new Upcoming_Works_Fragment();
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_upcoming_works, container, false);

//            recyclerView = rootView.findViewById(R.id.recycler_view);
//
//            mAdapter = new MoviesAdapter(movieList);
//            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
//            recyclerView.setLayoutManager(mLayoutManager);
//            recyclerView.setItemAnimator(new DefaultItemAnimator());
//            recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
//            recyclerView.setAdapter(mAdapter);
//
//            recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
//                @Override
//                public void onClick(View view, int position) {
//                    Movie movie = movieList.get(position);
//                    Toast.makeText(getContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
//                }
//
//                @Override
//                public void onLongClick(View view, int position) {
//
//                }
//            }));
//
//            if (up_data_flag == 0) {
//                prepareMovieData();
//            }

            return rootView;
        }

//        private List<Movie> movieList = new ArrayList<>();
//        private RecyclerView recyclerView;
//        private MoviesAdapter mAdapter;
//
//        private void prepareMovieData() {
//
//
//            Movie movie = new Movie("Chicken Run", "Animation", "2000");
//            movieList.add(movie);
//
//            movie = new Movie("Back to the Future", "Science Fiction", "1985");
//            movieList.add(movie);
//
//            movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
//            movieList.add(movie);
//
//            movie = new Movie("Goldfinger", "Action & Adventure", "1965");
//            movieList.add(movie);
//
//            movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
//            movieList.add(movie);
//
//            mAdapter.notifyDataSetChanged();
//
//            up_data_flag=1;
//        }
    }
}

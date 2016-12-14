package hu.py82c7.homework.app.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import hu.py82c7.homework.Drawer;
import hu.py82c7.homework.DrawerBuilder;
import hu.py82c7.homework.app.R;
import hu.py82c7.homework.app.utils.Food;


/**
 * A simple {@link Fragment} subclass.
 * This is just a demo fragment with a long scrollable view of editTexts. Don't see this as a reference for anything
 */
public class DrawerFragment extends Fragment {
    private static final String KEY_TITLE = "title";

    private Drawer result;
    private Spinner categorySpinner, foodSpinner, countSpinner;
    private TextView payText;
    private Button payBtn, orderBtn;
    private int bill;
    private static int bill_id1,bill_id2,bill_id3,bill_id4,bill_id5,bill_id6;
    private ArrayList<Food> food_list = new ArrayList<>();

    public DrawerFragment() {
        // Required empty public constructor
    }

    public static DrawerFragment newInstance(String title) {
        DrawerFragment f = new DrawerFragment();

        Bundle args = new Bundle();

        args.putString(KEY_TITLE, title);
        f.setArguments(args);

        return (f);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // don't look at this layout it's just a listView to show how to handle the keyboard
        final View view = inflater.inflate(hu.py82c7.homework.app.R.layout.fragment_sample, container, false);
        setUpList();
        updateBill();
        result = new DrawerBuilder()
                .withActivity(getActivity())
                .withRootView((ViewGroup) view.findViewById(hu.py82c7.homework.app.R.id.rootView))
                .withDisplayBelowStatusBar(false)
                .withSavedInstance(savedInstanceState)
                .buildForFragment();

        TextView textView = (TextView) view.findViewById(hu.py82c7.homework.app.R.id.title);
        textView.setText(getArguments().getString(KEY_TITLE));

        result.getDrawerLayout().setFitsSystemWindows(false);
        result.getSlider().setFitsSystemWindows(false);
        categorySpinner = (Spinner)view.findViewById(R.id.category_spinner);
        foodSpinner =(Spinner)view.findViewById(R.id.food_spinner);
        countSpinner = (Spinner) view.findViewById(R.id.count_spinner);
        payText = (TextView) view.findViewById(R.id.paytxt);
        payBtn = (Button) view.findViewById(R.id.paybtn);
        orderBtn= (Button) view.findViewById(R.id.orderbtn);
        payText.setText(String.valueOf(bill));

        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    List<String> spinnerArray =  new ArrayList<String>();
                    spinnerArray = getNamesFromCategory("leves");

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                            getContext(), android.R.layout.simple_spinner_item, spinnerArray);

                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    foodSpinner.setAdapter(adapter);

                }
                if(i==1){
                    List<String> spinnerArray =  new ArrayList<String>();
                    spinnerArray = getNamesFromCategory("chef");

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                            getContext(), android.R.layout.simple_spinner_item, spinnerArray);

                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    foodSpinner.setAdapter(adapter);
                }
                if(i==2){
                    List<String> spinnerArray =  new ArrayList<String>();
                    spinnerArray = getNamesFromCategory("dessert");

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                            getContext(), android.R.layout.simple_spinner_item, spinnerArray);

                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    foodSpinner.setAdapter(adapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                payText.setText("No owing");
                bill=0;
                Toast.makeText(getContext(),"we pay the bill, thank you", Toast.LENGTH_LONG).show();
            }
        });

        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String foodstr = foodSpinner.getSelectedItem().toString();
                int food_count = Integer.parseInt(countSpinner.getSelectedItem().toString());

                int price = getPriceFromName(foodstr);
                price *=food_count;
                bill+=price;

                payText.setText(String.valueOf(bill));
            }
        });

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        //add the values which need to be saved from the drawer to the bundle
        outState = result.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onPause() {
        super.onPause();

        switch (getArguments().getString(KEY_TITLE)){
            case "First table":
                bill_id1 = bill;

                break;
            case "Second table":
                bill_id2=bill;

                break;
            case "Third table":
                bill_id3=bill;

                break;
            case "Fourth table":
                bill_id4=bill;

                break;
            case "Fifth table":
                bill_id5=bill;

                break;
            case "Sixth table":
                bill_id6=bill;
                
                break;
        }
    }

    int getPriceFromName(String foodname){
        for (ListIterator<Food> iter = food_list.listIterator(); iter.hasNext(); ) {
            Food element = iter.next();

            if(element.getName()==foodname){
                return element.getPrice();
            }
        }
        return 0;
    }

    ArrayList<String> getNamesFromCategory(String category){
        ArrayList<String> temp = new ArrayList<>();
        for (ListIterator<Food> iter = food_list.listIterator(); iter.hasNext(); ) {
            Food element = iter.next();

            if(element.getCategory()==category){
                temp.add(element.getName());
            }
        }
        return temp;
    }
    public void setUpList(){
        Food f = new Food("erdei gyümolcsleves tejszínhabbal","leves",550);
        food_list.add(f);
        f = new Food("csontleves csigatésztával","leves",430);
        food_list.add(f);
        f= new Food("tejfölös-tárkonyos pulyka raguleves","leves", 650);
        food_list.add(f);
        f= new Food("mórahalmi gazdagleves","leves",780);
        food_list.add(f);
        f= new Food("gulyásleves","leves",880);
        food_list.add(f);
        f= new Food("jókai bableves kolbásszal","leves",830);
        food_list.add(f);
        f=new Food("francia hagymaleves","leves",660);
        food_list.add(f);
        f= new Food("brokkolikrémleves","leves",620);
        food_list.add(f);

        f = new Food("csongrádi töltött sertésszelet","chef",1480);
        food_list.add(f);
        f= new Food("brokkolis csirkemell csőben sütve","chef",1380);
        food_list.add(f);
        f= new Food("zöldfűszeres sajtkrémes csirkemell","chef",1550);
        food_list.add(f);
        f=new Food("aszalt szilvával, sajttal töltött pulyka","chef",1580);
        food_list.add(f);
        f=new Food("hölgyek kedvence","chef",1100);
        food_list.add(f);
        f=new Food("füsti-karaj","chef",1450);
        food_list.add(f);
        f=new Food("hátszín-szelet gombás raguval","chef",1850);
        food_list.add(f);
        f= new Food("baconos szűzérme","chef",1650);
        food_list.add(f);
        f=new Food("hátszín vaslapon lyoni hagymával","chef",1800);
        food_list.add(f);
        f=new Food("vasalt csirkecomb filé","chef",1300);
        food_list.add(f);
        f=new Food("rozmaringos kacsacomb burgonyával","chef",2580);
        food_list.add(f);
        f=new Food("vidéki töltött sertésszelet rántva","chef",1480);
        food_list.add(f);
        f=new Food("homoki-tál","chef",2100);
        food_list.add(f);

        f=new Food("somlói galuska","dessert",580);
        food_list.add(f);
        f=new Food("bountys palacsinta","dessert",480);
        food_list.add(f);
        f=new Food("szatmári palacsinta","dessert",480);
        food_list.add(f);
        f=new Food("ízes palacsinta","dessert",320);
        food_list.add(f);
        f=new Food("kakaós palacsinta","dessert",320);
        food_list.add(f);
        f=new Food("nutellás palacsinta","dessert",380);
        food_list.add(f);
        f=new Food("gesztenyepüré","dessert",420);
        food_list.add(f);
        f=new Food("őszibarack-befőtt","dessert",420);
        food_list.add(f);
    }

    private void updateBill(){
        switch (getArguments().getString(KEY_TITLE)){
            case "First table":
                bill = bill_id1;
                break;
            case "Second table":
                bill=bill_id2;
                break;
            case "Third table":
                bill=bill_id3;
                break;
            case "Fourth table":
                bill=bill_id4;
                break;
            case "Fifth table":
                bill=bill_id5;
                break;
            case "Sixth table":
                bill=bill_id6;
                break;
        }
    }
}

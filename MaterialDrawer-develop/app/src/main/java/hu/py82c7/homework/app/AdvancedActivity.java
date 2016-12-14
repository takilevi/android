package hu.py82c7.homework.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;

import hu.py82c7.homework.AccountHeader;
import hu.py82c7.homework.AccountHeaderBuilder;
import hu.py82c7.homework.Drawer;
import hu.py82c7.homework.DrawerBuilder;
import hu.py82c7.homework.app.drawerItems.OverflowMenuDrawerItem;
import hu.py82c7.homework.app.fragment.DrawerFragment;
import hu.py82c7.homework.app.fragment.SecondDrawerFragment;
import hu.py82c7.homework.login.LoginActivity;
import hu.py82c7.homework.model.PrimaryDrawerItem;
import hu.py82c7.homework.model.ProfileDrawerItem;
import hu.py82c7.homework.model.SecondaryDrawerItem;
import hu.py82c7.homework.model.interfaces.IDrawerItem;
import hu.py82c7.homework.model.interfaces.IProfile;

public class AdvancedActivity extends AppCompatActivity {
    private static final int PROFILE_SETTING = 1;
    public static int admin = 0;
    public static String email = "levi.takacs@gmail.com";
    public static String username = "Takács Levente";

    //save our header or result
    private AccountHeader headerResult = null;
    private Drawer result = null;
    private FrameLayout fl;
    private IProfile profile;
    private IProfile profile2;
    private ImageView iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sample);
        Intent i=new Intent(AdvancedActivity.this,LoginActivity.class);
        AdvancedActivity.this.startActivity(i);


        iv= (ImageView)findViewById(R.id.image_view);
        iv.setImageResource(R.drawable.etlap);
        fl =  (FrameLayout)findViewById(R.id.fragment_container);

        // Handle Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.drawer_item_order_handler);

        // Create a few sample profile
        profile = new ProfileDrawerItem().withName("Hi dear stranger").withEmail("please click Update Profile!!").withIcon(getResources().getDrawable(R.drawable.profile5));
        profile2 = new ProfileDrawerItem().withName(username).withEmail(email).withIcon(getResources().getDrawable(R.drawable.profile5)).withIdentifier(2);

        // Create the AccountHeader
        buildHeader(false, savedInstanceState);

        //Create the drawer
        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult) //set the AccountHeader we created earlier for the header
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.drawer_item_home).withIcon(FontAwesome.Icon.faw_home).withIdentifier(1),
                        //here we use a customPrimaryDrawerItem we defined in our sample app
                        //this custom DrawerItem extends the PrimaryDrawerItem so it just overwrites some methods
                        new OverflowMenuDrawerItem().withName(R.string.drawer_order).withDescription("Select the table ID for order").withIdentifier(2).withMenu(R.menu.fragment_menu).withOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                fl.setVisibility(View.VISIBLE);
                                switch (item.getItemId()){
                                    case R.id.menu_1:
                                        iv.setImageResource(R.drawable.empty_back);

                                        Fragment f = DrawerFragment.newInstance("First table");
                                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();
                                        return true;
                                    case R.id.menu_2:
                                        iv.setImageResource(R.drawable.empty_back);

                                        Fragment f2 = DrawerFragment.newInstance("Second table");
                                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f2).commit();
                                        return true;
                                    case R.id.menu_3:
                                        iv.setImageResource(R.drawable.empty_back);

                                        Fragment f3 = DrawerFragment.newInstance("Third table");
                                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f3).commit();
                                        return true;
                                    case R.id.menu_4:
                                        iv.setImageResource(R.drawable.empty_back);

                                        Fragment f4 = DrawerFragment.newInstance("Fourth table");
                                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f4).commit();
                                        return true;
                                    case R.id.menu_5:
                                        iv.setImageResource(R.drawable.empty_back);

                                        Fragment f5 = DrawerFragment.newInstance("Fifth table");
                                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f5).commit();
                                        return true;
                                    case R.id.menu_6:
                                        iv.setImageResource(R.drawable.empty_back);

                                        Fragment f6 = DrawerFragment.newInstance("Sixth table");
                                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f6).commit();
                                        return true;
                                    case android.R.id.home:
                                        onBackPressed();
                                        return true;
                                }
                                Toast.makeText(AdvancedActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                                return false;
                            }
                        }).withIcon(GoogleMaterial.Icon.gmd_filter_center_focus),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_menu).withDescription("This is the menu list").withIcon(FontAwesome.Icon.faw_eye).withIdentifier(3)
                ) // add the items we want to use with our Drawer
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        //check if the drawerItem is set.
                        //there are different reasons for the drawerItem to be null
                        //--> click on the header
                        //--> click on the footer
                        //those items don't contain a drawerItem

                        if (drawerItem != null) {
                            Intent intent = null;
                            if (drawerItem.getIdentifier() == 1) {

                                iv.setImageDrawable(null);
                                iv.setImageResource(R.drawable.tables_pic);
                                iv.bringToFront();
                                fl.setVisibility(View.INVISIBLE);
                                Fragment f = SecondDrawerFragment.newInstance("");
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();

                            }
                            if(drawerItem.getIdentifier()==2){
                                fl.setVisibility(View.VISIBLE);
                                iv.setImageResource(R.drawable.empty_back);

                                Fragment f = SecondDrawerFragment.newInstance("");
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();
                                Toast.makeText(AdvancedActivity.this, "click one of the menu points", Toast.LENGTH_SHORT).show();
                            }
                            if(drawerItem.getIdentifier()==3){
                                if(admin==1){
                                    iv.setImageResource(0);

                                    Fragment f = SecondDrawerFragment.newInstance("");
                                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();

                                    iv.setImageResource(R.drawable.etlap);


                                    iv.bringToFront();
                                    fl.setVisibility(View.INVISIBLE);

                                }
                                else{
                                    Toast.makeText(AdvancedActivity.this, "sorry, no admin permission", Toast.LENGTH_SHORT).show();

                                }
                            }
                            if(drawerItem.getIdentifier()==10){
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=0BxWzvEfSXRS7YThMR0NrU1pYTVE"));
                                startActivity(browserIntent);
                            }
                            if(drawerItem.getIdentifier()==11){
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/takilevi/android"));
                                startActivity(browserIntent);
                            }
                        }

                        return false;
                    }
                })
                .withOnDrawerNavigationListener(new Drawer.OnDrawerNavigationListener() {
                    @Override
                    public boolean onNavigationClickListener(View clickedView) {
                        //this method is only called if the Arrow icon is shown. The hamburger is automatically managed by the MaterialDrawer
                        //if the back arrow is shown. close the activity
                        AdvancedActivity.this.finish();
                        //return true if we have consumed the event
                        return true;
                    }
                })
                .addStickyDrawerItems(
                        new SecondaryDrawerItem().withName(R.string.drawer_menu_display).withIcon(FontAwesome.Icon.faw_cart_plus).withIdentifier(10),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_open_source).withIcon(FontAwesome.Icon.faw_github).withIdentifier(11)
                )
                .withSavedInstance(savedInstanceState)
                .build();


    }


    private void buildHeader(boolean compact, Bundle savedInstanceState) {
        // Create the AccountHeader
        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .withCompactStyle(compact)
                .addProfiles(
                        profile,
                        profile2
                )
                .withSavedInstance(savedInstanceState)
                .build();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_1:
                //update the profile
                profile.withName(username);
                profile.withEmail(email);
                profile.withIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_android).backgroundColorRes(R.color.accent).sizeDp(48).paddingDp(4));

                headerResult.updateProfileByIdentifier(profile);
                return true;
            case R.id.menu_2:
                //show the arrow icon
                result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(false);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                return true;
            case R.id.menu_3:
                //we want to replace our current header with a compact header
                //build the new compact header
                buildHeader(true, null);
                //set the view to the result
                result.setHeader(headerResult.getView());
                //set the drawer to the header (so it will manage the profile list correctly)
                headerResult.setDrawer(result);
                return true;
            case R.id.menu_4:
                //we want to replace our current header with a normal header
                //build the new compact header
                buildHeader(false, null);
                //set the view to the result
                result.setHeader(headerResult.getView());
                //set the drawer to the header (so it will manage the profile list correctly)
                headerResult.setDrawer(result);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //add the values which need to be saved from the drawer to the bundle
        outState = result.saveInstanceState(outState);
        //add the values which need to be saved from the accountHeader to the bundle
        outState = headerResult.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (result != null && result.isDrawerOpen()) {
            result.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }



}

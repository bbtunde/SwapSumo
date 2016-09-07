package swampsumo.com.swapsumo;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import swampsumo.com.adapters.DashboardPagerAdapter;
import swampsumo.com.fragments.DashboardFragment;
import swampsumo.com.fragments.FeedbackFragment;
import swampsumo.com.fragments.SettingsFragment;
import swampsumo.com.utils.u.helpers.Constants;

public class MainActivity extends AppCompatActivity implements
        DashboardFragment.OnFragmentInteractionListener,
        SettingsFragment.OnFragmentInteractionListener,
        FeedbackFragment.OnFragmentInteractionListener{
    private static final int DRAWER_ITEM_DASHBOARD = 1;
    private static final int DRAWER_ITEM_SEARCH = 2;
    private static final int DRAWER_ITEM_MYITEM = 3;
    private static final int DRAWER_ITEM_MESSAGES = 4;
    private static final int DRAWER_ITEM_BROWSE = 8;
    private static final int DRAWER_ITEM_VENDORS = 6;
    private static final int DRAWER_ITEM_MYTRADES = 7;

    private Drawer drawer;
    private String title = "SwapSumo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(
                new ProfileDrawerItem().withName("Rehan Malik").withEmail("rehanmalik99@gmail.com").withIcon(getResources().getDrawable(R.drawable.dcoli, null))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();
        PrimaryDrawerItem dashboard_item = new PrimaryDrawerItem().withIdentifier(DRAWER_ITEM_DASHBOARD).withName("Dashboard").withIcon(FontAwesome.Icon.faw_tachometer);
        SecondaryDrawerItem search_item = new SecondaryDrawerItem().withIdentifier(DRAWER_ITEM_SEARCH).withName("Search").withIcon(FontAwesome.Icon.faw_search);
        SecondaryDrawerItem my_item = new SecondaryDrawerItem().withIdentifier(DRAWER_ITEM_MYITEM).withName("My Items").withIcon(FontAwesome.Icon.faw_list);
        SecondaryDrawerItem messages_item = new SecondaryDrawerItem().withIdentifier(DRAWER_ITEM_MESSAGES).withName("Messages").withIcon(FontAwesome.Icon.faw_envelope);
        SecondaryDrawerItem my_trades_item = new SecondaryDrawerItem().withIdentifier(DRAWER_ITEM_MYTRADES).withName("My Trades").withIcon(FontAwesome.Icon.faw_shopping_cart);
        SecondaryDrawerItem vendors_item = new SecondaryDrawerItem().withIdentifier(DRAWER_ITEM_VENDORS).withName("Vendors").withIcon(FontAwesome.Icon.faw_users);
        SecondaryDrawerItem browse_item = new SecondaryDrawerItem().withIdentifier(DRAWER_ITEM_BROWSE).withName("Browse").withIcon(FontAwesome.Icon.faw_list_alt);


        DrawerBuilder builder = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        dashboard_item,
                        new DividerDrawerItem(),
                        my_item,
                        search_item,
                        messages_item,
                        my_trades_item,
                        vendors_item,
                        browse_item

                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        displayView(position);
                        return false;
                    }

                })
                .withSelectedItem(-1)
                .withSavedInstance(savedInstanceState);

        drawer = builder.build();
        displayView(-1);

    }


    private void displayView(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;


        switch (position) {
            case DRAWER_ITEM_DASHBOARD:
                //startActivity(new Intent(this, HomeActivity.class));
                break;
            default:
                fragment = new DashboardFragment().newInstance("","");
                title = "Dashboard";
                break;
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.addToBackStack(null);
            ft.replace(R.id.container, fragment).commit();
            setTitle(title);
        }

        drawer.closeDrawer();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (drawer != null) {
            outState = drawer.saveInstanceState(outState);
        }
        super.onSaveInstanceState(outState);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onDashboardFragmentInteraction(Uri uri) {

    }

    @Override
    public void onSettingsFragmentInteraction(Uri uri) {

    }

    @Override
    public void onFeedbackFragmentInteraction(Uri uri) {

    }
}

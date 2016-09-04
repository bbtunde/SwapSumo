package swampsumo.com.swapsumo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

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

public class MainActivity extends AppCompatActivity {
    private static final int DRAWER_ITEM_DASHBOARD = 0;
    private static final int DRAWER_ITEM_SEARCH = 1;
    private static final int DRAWER_ITEM_MYITEM = 2;
    private static final int DRAWER_ITEM_MESSAGES = 3;
    private static final int DRAWER_ITEM_BROWSE = 4;
    private static final int DRAWER_ITEM_VENDORS = 5;
    private static final int DRAWER_ITEM_MYTRADES = 6;

    private Drawer drawer;

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
                        return false;
                    }

                })
                .withSelectedItem(-1)
                .withSavedInstance(savedInstanceState);

        drawer = builder.build();

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
}

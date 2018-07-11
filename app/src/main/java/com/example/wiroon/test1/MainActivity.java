package com.example.wiroon.test1;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.Toast;

import com.example.wiroon.test1.Fragment.ChangeFragment;
import com.example.wiroon.test1.Fragment.ContentFragment;
import com.example.wiroon.test1.Fragment.CountingFragment;
import com.example.wiroon.test1.Fragment.InguiryFragment;
import com.example.wiroon.test1.Fragment.PickingFragment;
import com.example.wiroon.test1.Fragment.RecievingFragment;
import com.example.wiroon.test1.Fragment.ReturnFragment;
import com.example.wiroon.test1.Fragment.ShippingFragment;
import com.example.wiroon.test1.Fragment.TransitFragment;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private NavigationView navigationView;
    private FragmentTransaction transaction;
    public static String FragmentName;
    public static ActionBarDrawerToggle toggle;
    public static DrawerLayout drawer;
    Button btn_recieving, btn_transit, btn_inguiry, btn_change, btn_picking, btn_shipping ,btn_return, btn_counting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        btn_recieving = findViewById(R.id.btn_recieving); //id = 1
        btn_recieving.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                btn_recieving.setId(1);
                chang_fragment(btn_recieving.getId());
            }
        });

        btn_transit = findViewById(R.id.btn_transit);
        btn_transit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                btn_transit.setId(2);
                chang_fragment(btn_transit.getId());
            }
        });

        btn_inguiry = findViewById(R.id.btn_inguiry);
        btn_inguiry.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                btn_inguiry.setId(3);
                chang_fragment(btn_inguiry.getId());
            }
        });

        btn_change = findViewById(R.id.btn_change);
        btn_change.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                btn_change.setId(4);
                chang_fragment(btn_change.getId());
            }
        });

        btn_picking = findViewById(R.id.btn_picking);
        btn_picking.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                btn_picking.setId(5);
                chang_fragment(btn_picking.getId());
            }
        });

        btn_shipping = findViewById(R.id.btn_shipping);
        btn_shipping.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                btn_shipping.setId(6);
                chang_fragment(btn_shipping.getId());
            }
        });

        btn_return = findViewById(R.id.btn_return);
        btn_return.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                btn_return.setId(7);
                chang_fragment(btn_return.getId());
            }
        });

        btn_counting = findViewById(R.id.btn_counting);
        btn_counting.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                btn_counting.setId(8);
                chang_fragment(btn_counting.getId());
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_menu_home) {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        } else if(id == R.id.nav_menu_receivng){
//            setNavMenuItemThemeColors(this.getResources().getColor(R.color.colorPrimary));
            RecievingFragment fragment = new RecievingFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content, fragment);
            ft.commit();
        } else if(id == R.id.nav_menu_transit){
            TransitFragment fragment = new TransitFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content, fragment);
            ft.commit();
        } else if(id == R.id.nav_menu_inguiry){
            InguiryFragment fragment = new InguiryFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content, fragment);
            ft.commit();
        } else if(id == R.id.nav_menu_change){
            ChangeFragment fragment = new ChangeFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content, fragment);
            ft.commit();
        } else if(id == R.id.nav_menu_picking){
            PickingFragment fragment = new PickingFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content, fragment);
            ft.commit();
        } else if(id == R.id.nav_menu_shipping){
            ShippingFragment fragment = new ShippingFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content, fragment);
            ft.commit();
        } else if(id == R.id.nav_menu_return){
            ReturnFragment fragment = new ReturnFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content, fragment);
            ft.commit();
        } else if(id == R.id.nav_menu_counting){
            CountingFragment fragment = new CountingFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content, fragment);
            ft.commit();
        } else if (id == R.id.nav_menu_signout){
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void chang_fragment(int id){
        if (id == 1) {
            RecievingFragment fragment = new RecievingFragment();
            transaction= getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.content, fragment, "tag_receiving").addToBackStack("MenuReceive").commit();
        }else if(id == 2){
            TransitFragment fragment = new TransitFragment();
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.content, fragment, "tag_receiving").addToBackStack("MenuReceive").commit();
        }else if(id == 3){
            InguiryFragment fragment = new InguiryFragment();
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.content, fragment, "tag_receiving").addToBackStack("MenuReceive").commit();
        }else if(id == 4){
            ChangeFragment fragment = new ChangeFragment();
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.content, fragment, "tag_receiving").addToBackStack("MenuReceive").commit();
        }else if(id == 5){
            PickingFragment fragment = new PickingFragment();
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.content, fragment, "tag_receiving").addToBackStack("MenuReceive").commit();
        }else if(id == 6){
            ShippingFragment fragment = new ShippingFragment();
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.content, fragment, "tag_receiving").addToBackStack("MenuReceive").commit();
        }else if(id == 7){
            ReturnFragment fragment = new ReturnFragment();
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.content, fragment, "tag_receiving").addToBackStack("MenuReceive").commit();
        }else if(id == 8){
            CountingFragment fragment = new CountingFragment();
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.content, fragment, "tag_receiving").addToBackStack("MenuReceive").commit();
        }

    }

    public void setNavMenuItemThemeColors(int color){
        //Setting default colors for menu item Text and Icon
        int navDefaultTextColor = Color.parseColor("#202020");
        int navDefaultIconColor = Color.parseColor("#737373");

        //Defining ColorStateList for menu item Text
        ColorStateList navMenuTextList = new ColorStateList(
                new int[][]{
                        new int[]{android.R.attr.state_checked},
                        new int[]{android.R.attr.state_enabled},
                        new int[]{android.R.attr.state_pressed},
                        new int[]{android.R.attr.state_focused},
                        new int[]{android.R.attr.state_pressed}
                },
                new int[] {
                        color,
                        navDefaultTextColor,
                        navDefaultTextColor,
                        navDefaultTextColor,
                        navDefaultTextColor
                }
        );

        //Defining ColorStateList for menu item Icon
        ColorStateList navMenuIconList = new ColorStateList(
                new int[][]{
                        new int[]{android.R.attr.state_checked},
                        new int[]{android.R.attr.state_enabled},
                        new int[]{android.R.attr.state_pressed},
                        new int[]{android.R.attr.state_focused},
                        new int[]{android.R.attr.state_pressed}
                },
                new int[] {
                        color,
                        navDefaultIconColor,
                        navDefaultIconColor,
                        navDefaultIconColor,
                        navDefaultIconColor
                }
        );

        navigationView.setItemTextColor(navMenuTextList);
        navigationView.setItemIconTintList(navMenuIconList);

    }

    public void restartApp() {
        Toast.makeText(this, "Session expire", Toast.LENGTH_SHORT).show();
        Intent i = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage(getBaseContext().getPackageName());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(i);
    }
}

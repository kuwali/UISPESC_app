package com.uispesc.app.uispesc_app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.uispesc.app.uispesc_app.fragment.AboutFragment;
import com.uispesc.app.uispesc_app.fragment.BroadcastFragment;
import com.uispesc.app.uispesc_app.fragment.HomeFragment;
import com.uispesc.app.uispesc_app.fragment.MembershipMainFragment;
import com.uispesc.app.uispesc_app.fragment.ProgramFragment;
import com.uispesc.app.uispesc_app.fragment.UIFragment;

/*
 * Copyright 2016 Kustiawanto Halim.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_content_frame, new HomeFragment()).commit();

        // Set navigation listener
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        // Check drawer on back-pressed
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        switch (id) {
            case R.id.about:
                fragment = new AboutFragment();
                break;
            case R.id.ui:
                fragment = new UIFragment();
                break;
            case R.id.program:
                fragment = new ProgramFragment();
                break;
            case R.id.membership:
                fragment = new MembershipMainFragment();
                break;
            case R.id.trivia:
                Toast.makeText(this,"Trivia",Toast.LENGTH_SHORT).show();
                break;
            case R.id.url:
                String url = "http://speuisc.org/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
                break;
            case R.id.broadcast:
                fragment = new BroadcastFragment();
                break;
            case R.id.instagram:
                url = "https://www.instagram.com/speuisc/";
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main_content_frame, fragment).commit();
        }

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}

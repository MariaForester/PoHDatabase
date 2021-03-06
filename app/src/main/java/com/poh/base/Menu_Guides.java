package com.poh.base;
//Masha
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class Menu_Guides extends Left_menu {
    GridView simpleGrid;
    int logos[] = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_guides_arts);

        simpleGrid = (GridView) findViewById(R.id.guidesGridView);
        simpleGrid.setNumColumns(3);

        Grid_adapter customAdapter = new Grid_adapter(getApplicationContext(), logos);
        simpleGrid.setAdapter(customAdapter);

        simpleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(Menu_Guides.this, Guide_1.class);
                    startActivity(intent);
                } if (position == 1) {
                    Intent intent = new Intent(Menu_Guides.this, Guide_2.class);
                    startActivity(intent);
                } if (position == 2) {
                    Intent intent = new Intent(Menu_Guides.this, Guide_3.class);
                    startActivity(intent);
                } if (position == 3) {
                    Intent intent = new Intent(Menu_Guides.this, Guide_4.class);
                    startActivity(intent);
                } if (position == 4) {
                    Intent intent = new Intent(Menu_Guides.this, Guide_5.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(Menu_Guides.this, Menu_PoHBase_Home.class);
            startActivity(intent);
            this.finish();
        }
        return false;
    }
}



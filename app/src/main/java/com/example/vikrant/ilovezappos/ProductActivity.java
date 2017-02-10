package com.example.vikrant.ilovezappos;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.vikrant.ilovezappos.databinding.ActivityProductBinding;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity implements View.OnClickListener{
    Product prod;
    private Boolean isFabOpen = false;
    private FloatingActionButton fab,fab1,fab2;
    private Animation fab_open,fab_close,rotate_forward,rotate_backward, rotate_done, close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityProductBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_product);
        if(getIntent().getExtras().containsKey("disp")){
            prod = (Product) getIntent().getExtras().getSerializable("disp");
        } else {
            prod = (Product) getIntent().getExtras().getSerializable("disp");
        }
        binding.setProduct(prod);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_backward);
        rotate_done = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_done);
        close = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.close);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton)findViewById(R.id.fab1);
        fab2 = (FloatingActionButton)findViewById(R.id.fab2);
        fab.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.fab:

                animateFAB();
                break;
            case R.id.fab1:
                Toast.makeText(this, "Sharing not available yet!", Toast.LENGTH_SHORT).show();
                doneFAB();
                break;
            case R.id.fab2:
                Toast.makeText(this, "Item added to Cart!", Toast.LENGTH_SHORT).show();
                doneFAB();
                break;
        }
    }

    public void doneFAB(){
        fab.startAnimation(rotate_done);
        fab1.startAnimation(fab_close);
        fab2.startAnimation(fab_close);
        fab1.setClickable(false);
        fab2.setClickable(false);
        isFabOpen = false;
    }

    public void animateFAB(){

        if(isFabOpen){

            fab.startAnimation(rotate_backward);
            fab1.startAnimation(fab_close);
            fab2.startAnimation(fab_close);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isFabOpen = false;

        } else {

            fab.startAnimation(rotate_forward);
            fab1.startAnimation(fab_open);
            fab2.startAnimation(fab_open);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isFabOpen = true;

        }
    }
}

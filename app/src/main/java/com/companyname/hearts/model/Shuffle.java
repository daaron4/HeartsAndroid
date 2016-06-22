package com.companyname.hearts.model;

/**
 * Created by John on 6/17/16.
 */

import android.content.Intent;

import com.companyname.hearts.activities.MainActivity;

import processing.core.PApplet;
import processing.core.PImage;

public class Shuffle extends PApplet {

    int start1 = 920;
    int start2 = 420;
    int start3 = 920;
    int start4 = 420;
    int counter = 0;

    PImage img;

    public void setup(){

        stroke(0);
        fill(255);
        img = loadImage("back.jpg");
    }

    public void draw(){
        background(39, 119, 20);
        doThing();

    }

    public void doThing(){
        int dx1 = 280;
        int dy1 = 280;
        int dx2 = 280;
        int dy2 = 280;

        image(img, 920, 420, 160, 200);

        if(counter <6){
            image(img, start1 += dx1, 420, 160, 200);
            rowSet();

            if (start1 >= 1900){
                image(img, 920, start2 -= dy1, 160, 200);
            }
            if(start2 <= 100){
                image(img, start3 -= dx2, 420, 160, 200);
            }
            if(start3 <=100 ){
                image(img,920, start4 += dy2, 160, 200);

            }
            if(start4 >=1900){
                start1 = 920;
                start2 = 420;
                start3 = 920;
                start4 = 420;
                counter++;
            }
        }else{
            Intent myIntent = new Intent(getActivity(), MainActivity.class);

            getActivity().startActivity(myIntent);
        }
    }
    public void rowSet(){

        for(int i = 1; i<counter +2; i++) {
            //right row
            image(img, 1900, 350 + (i*40), 200, 120);
            //top row
            image(img, 920 + (i*40), -100, 120, 200);
            //left row
            image(img, -100 , 350 + (i*40), 200, 120);
            // bottom row
            image(img, 920 + (i*40), 900 , 120, 200);

        }
    }
    public void settings() {  size(2000,1000);  smooth(); }
    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "Shuffle" };
        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }
    }
}

package com.example.pong_javafx.GUI;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
/**
 *
 * @author
 */
public class SlideButton extends MenuButton
{

    public SlideButton(String name,int zahl)
    {
        super(name,false,zahl);
    }
    /**
     *
     */
    @Override
    public void textDesgin()
    {
        Slider slider= new Slider();
        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(40);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(50);
        slider.setMinorTickCount(5);
        slider.setBlockIncrement(10);

        VBox vertickal = new VBox(10);
        Label low = new Label("Low");
        low.setFont(new Font("Arial", 18));
        Label high= new Label("High");
        high.setFont(new Font("Arial", 18));
        Label lName= new Label(name);
        lName.setFont(new Font("Arial", 24));
        HBox horizonal =new HBox(10);
        horizonal.getChildren().addAll(low,slider,high);
        vertickal.getChildren().addAll(lName,horizonal);
        getChildren().add(vertickal);
    }
}

package com.crap.game.model;

import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * Created by rebeccafinne on 16-05-20.
 */
public class InteractMascot {


    private Label currentLabel;
    private int currentLabelNbr;
    private Label[] labelsInScreen;
    private Label questionLabel;


    public InteractMascot(Label[] labelsInScreen, Label questionLabel){
        this.labelsInScreen = labelsInScreen;
        this.questionLabel = questionLabel;
        this.currentLabelNbr = 0;
        this.currentLabel = labelsInScreen[currentLabelNbr];


    }


    public void setCurrentLabel(String direction){
        int amountOfLabels = getAmountOfLabels() - 1;
        if(direction.equals("down")){
            if(currentLabelNbr == amountOfLabels){
                currentLabelNbr = 0;
            }else{
                currentLabelNbr++ ;
            }
        }if(direction.equals("up")){
            if(currentLabelNbr == 0){
                currentLabelNbr = 3;
            }else {
                currentLabelNbr--;
            }
        }
        currentLabel = labelsInScreen[currentLabelNbr];

    }

    public Label getCurrentLabel(){
        return this.currentLabel;
    }
    public void setQuestionLabel(Label label){
        this.questionLabel = label;
    }

    public Label getQuestionLabel(){
        return this.questionLabel;
    }
    public Label[] getLabelsInScreen(){
        return this.labelsInScreen;
    }

    public int getAmountOfLabels(){
        return labelsInScreen.length;
    }

    public int getCurrentLabelNbr(){
        return this.currentLabelNbr;
    }
}

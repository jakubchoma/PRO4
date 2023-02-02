package cz.spsmb.ctvrtak.f_pop.f_card_game;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.transform.Affine;
import javafx.scene.transform.NonInvertibleTransformException;
import javafx.scene.transform.Transform;


public enum Cards {
    HEA_A (1,1),
    HEA_2 (2,1),
    HEA_3 (3,1),
    HEA_4 (4,1),
    HEA_5 (5,1),
    HEA_6 (6,1),
    HEA_7 (7,1),
    HEA_8 (8,1),
    HEA_9 (9,1),
    HEA_10 (10,1),
    HEA_11 (11,1),
    HEA_12 (12,1),
    HEA_13 (13,1),
    DIA_A (1,2),
    DIA_2 (2,2),
    DIA_3 (3,2),
    DIA_4 (4,2),
    DIA_5 (5,2),
    DIA_6 (6,2),
    DIA_7 (7,2),
    DIA_8 (8,2),
    DIA_9 (9,2),
    DIA_10 (10,2),
    DIA_11 (11,2),
    DIA_12 (12,2),
    DIA_13 (13,2),
    SPA_A (1,3),
    SPA_2 (2,3),
    SPA_3 (3,3),
    SPA_4 (4,3),
    SPA_5 (5,3),
    SPA_6 (6,3),
    SPA_7 (7,3),
    SPA_8 (8,3),
    SPA_9 (9,3),
    SPA_10 (10,3),
    SPA_11 (11,3),
    SPA_12 (12,3),
    SPA_13 (13,3),
    CLU_A (1,4),
    CLU_2 (2,4),
    CLU_3 (3,4),
    CLU_4 (4,4),
    CLU_5 (5,4),
    CLU_6 (6,4),
    CLU_7 (7,4),
    CLU_8 (8,4),
    CLU_9 (9,4),
    CLU_10 (10,4),
    CLU_11 (11,4),
    CLU_12 (12,4),
    CLU_13 (13,4);
    public int num;
    public int type;
    static double width = 50;
    static double height = 100;
    private final static String [] PATH = {
            "m20 10c0.97-5 2.911-10 9.702-10 6.792 0 12.128 5 9.703 15-2.426 10-13.584 15-19.405 25-5.821-10-16.979-15-19.405-25-2.4254-10 2.9109-15 9.703-15 6.791 0 8.732 5 9.702 10z",
            "m20-3.5527e-15c4 11 9 16 20 20-11 4-16 9-20 20-4-11-9-16-20-20 11-4 16-9 20-20z",
            "m9.9958 40c7.2112-1.603 7.9872-5.826 8.5312-13.594-1.253 2.075-3.531 3.607-7.25 3.594-6.1124-0.021-10.207-3.576-8.75-11.25 1.4688-7.737 12.469-10.737 17.469-18.75 5 8.0128 16 11.013 17.469 18.75 1.456 7.674-2.469 11.228-8.75 11.25-3.719 0.013-5.997-1.519-7.25-3.594 0.544 7.768 1.319 11.991 8.531 13.594h-20z",
            "m20 0c-4.731 0-8.571 4.032-8.571 9 0.041 3.126 1.654 5.768 3.333 8.281-1.871-1.416-3.951-2.272-6.1906-2.281-4.7314 0-8.5714 4.032-8.5714 9s3.84 9 8.5714 9c3.8326-0.064 6.8986-2.746 9.9106-5-0.539 6.733-1.635 10.514-8.006 12h19.048c-6.371-1.486-7.467-5.267-8.006-12 2.977 2.552 6.1 4.717 9.911 5 4.731 0 8.571-4.032 8.571-9s-3.84-9-8.571-9c-2.297 0-4.281 1.057-6.191 2.281 1.9-2.487 3.151-5.17 3.333-8.281 0-4.968-3.84-9-8.571-9z"
    };
    Cards(int num, int type) {
        this.num=num;
        this.type=type;
    }
    private String getSymbol(){
        switch(this.num){
            case 1 -> {return "A";}
            case 11 -> {return "J";}
            case 12 -> {return "Q";}
            case 13 -> {return "K";}
            default -> {return Integer.toString(this.num);}
        }
    }
    public Pane getCard(){
        //https://edencoding.com/javafx-canvas/
        Canvas c = new Canvas(Cards.width, Cards.height);
        Pane r = new Pane(c);
        r.setOnDragEntered(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                System.out.println("entered");
            }
        });
        r.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("detected");
            }
        });
        r.setOnDragExited(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                System.out.println("exited");
            }
        });
        r.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                System.out.println("dropped");
            }
        });
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.setLineWidth(2.0);
        gc.setFill(this.type>2 ?Color.BLACK:Color.RED);

        gc.strokeRoundRect(0,0,Cards.width,Cards.height,10,10);
        gc.setStroke(this.type>2 ?Color.BLACK:Color.RED);

        gc.strokeText(this.getSymbol(), 3 , 15);
        gc.strokeText("ꓯ", 37 , 95);
        //r.getChildren().add(svg);
        //gc.setFill(svg.getFill());
        //gc.moveTo(10,60);
        //gc.transform(1,1,0,1,1,0);
        //gc.moveTo(-19,-19);
        Affine a0 = new Affine();
        //a0.appendTranslation(-19,-19);
        //a0.appendRotation(45);
        a0.appendTranslation(5,Cards.height-65);
        gc.transform(a0);
        gc.appendSVGPath(Cards.PATH[this.type-1]);
        gc.moveTo(Cards.width - 20, Cards.height - 20);
        try {
            gc.transform(a0.createInverse());
        } catch (NonInvertibleTransformException e) {
            e.printStackTrace();
        }
        Affine a1 = new Affine();
        gc.moveTo(19,5);
        a1.appendScale(0.3, 0.3);
        gc.transform(a1);
        //gc.moveTo(Cards.width - 20, Cards.height - 20);
        gc.appendSVGPath(Cards.PATH[this.type - 1]);

        Affine a2 = new Affine();
        a2.appendRotation(180);
        gc.moveTo(120,320);
        gc.transform(a2);
        gc.appendSVGPath(Cards.PATH[this.type - 1]);

        gc.fill();
        gc.stroke();
        return r;
    }
}
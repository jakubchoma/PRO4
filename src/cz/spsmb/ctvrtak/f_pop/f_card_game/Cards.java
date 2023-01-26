package cz.spsmb.ctvrtak.f_pop.f_card_game;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;


public enum Cards {
    HEA_A (1,1),
    HEA_2 (2,1),
    DIA_A (1,2),
    DIA_2 (2,2),
    SPA_A (1,3),
    SPA_2 (2,3),
    CLU_A (1,4),
    CLU_2 (2,4);
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
    public Pane getCard(){
        Canvas c = new Canvas(Cards.width, Cards.height);
        Pane r = new Pane(c);
        r.setLayoutX(20);
        r.setLayoutY(20);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.setLineWidth(2.0);
        gc.setFill(Color.BLACK);
        gc.strokeRoundRect(0,0,Cards.width,Cards.height,10,10);
        gc.strokeText("A", 10 , 85);
        SVGPath svg = new SVGPath();
        svg.setContent(Cards.PATH[this.type+1]);
        svg.setScaleX(0.3);
        svg.setScaleY(0.3);
        gc.appendSVGPath(svg.toString());
        System.out.println(svg.toString());
        gc.fill();
        gc.stroke();
        return r;
    }
}

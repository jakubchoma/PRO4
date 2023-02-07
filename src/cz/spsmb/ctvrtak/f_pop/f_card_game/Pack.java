package cz.spsmb.ctvrtak.f_pop.f_card_game;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Pack extends Pane {
    public Pack() {
        super(new Canvas(Cards.width,Cards.height));
        Canvas c = (Canvas) this.getChildren().get(0);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.setLineWidth(2.0);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.WHITE);
        gc.fillRoundRect(0,0,Cards.width,Cards.height,10,10);
        gc.strokeRoundRect(0,0,Cards.width,Cards.height,10,10);
        this.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                Dragboard db = dragEvent.getDragboard();
                if(dragEvent.getGestureSource() != this){
                    dragEvent.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                dragEvent.consume();
            }
        });
        this.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                Pane source = (Pane) dragEvent.getGestureSource();
                source.setLayoutX(Pack.this.getLayoutX());
                source.setLayoutY(Pack.this.getLayoutY());

                dragEvent.consume();
            }
        });

    }
}

package tp1;

import java.awt.*;
import java.util.ArrayList;

public final class LetterFactory {
    final static Double maxHeight = 200.0;
    final static Double maxWidth = maxHeight / 2.5;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 8;
    final static Double halfStripeThickness = stripeThickness / 2;

    // TODO
    public static BaseShape create_e() {
        BaseShape letterE = new BaseShape();
        Ellipse outerEllipse = new Ellipse(halfMaxWidth, halfMaxHeight);
        Rectangle rect = new Rectangle(maxWidth, stripeThickness);

        Double innerWidthRadius = halfMaxWidth - halfStripeThickness;
        Double innerHeigthRadius = halfMaxHeight - halfStripeThickness;

        ArrayList<Point2d> toRemove = new ArrayList<>();
        for(Point2d point : outerEllipse.getCoords()){
            if(Math.sqrt(Math.pow(point.X(), 2) / Math.pow(innerWidthRadius, 2) +
                    Math.pow(point.Y(), 2) / Math.pow(innerHeigthRadius, 2)) <= 1){
                toRemove.add(point);
            }else if(point.Y() >= 0){
                toRemove.add(point);
            }
        }
        outerEllipse.removeAll(toRemove);
        toRemove.clear();
        for(Point2d point : rect.getCoords()){
            if(point.Y() >= 0){
                toRemove.add(point);
            }
        }
        rect.removeAll(toRemove);
        BaseShape topHalf = outerEllipse.add(rect).clone();
        BaseShape bottomHalf = topHalf.clone().rotate(Math.PI);
        toRemove.clear();
        for(Point2d point : bottomHalf.getCoords()){
            if(point.Y() >= halfStripeThickness && point.Y() <= stripeThickness * 1.5 && point.X() > 0){
                toRemove.add(point);
            }
        }
        letterE.add(topHalf).add(bottomHalf.removeAll(toRemove));

        return letterE;
    }

    // TODO
    public static BaseShape create_a() {
        BaseShape letter_a = new BaseShape();
        Ellipse outerEllipse = new Ellipse(halfMaxWidth, halfMaxHeight);
        Double innerWidthRadius = halfMaxWidth - halfStripeThickness;
        Double innerHeigthRadius = halfMaxHeight - halfStripeThickness;
        ArrayList<Point2d> toRemove = new ArrayList<>();
        for(Point2d point : outerEllipse.getCoords()){
            if(Math.sqrt(Math.pow(point.X(), 2) / Math.pow(innerWidthRadius, 2) +
                    Math.pow(point.Y(), 2) / Math.pow(innerHeigthRadius, 2)) <= 1){
                toRemove.add(point);
            }
        }
        outerEllipse.removeAll(toRemove);

        Rectangle rectangle = new Rectangle(halfStripeThickness, maxHeight);
        rectangle.translate(new Point2d(halfMaxWidth, 0.0));

        letter_a.add(outerEllipse).add(rectangle);
        return letter_a;
    }

    // TODO
    public static BaseShape create_C() {
        return null;
    }

    // TODO
    public static BaseShape create_l() {
        return new BaseShape()
                .add(new Rectangle(halfStripeThickness, maxHeight));
    }

    // TODO
    public static BaseShape create_i() {
        return new BaseShape()
                .add(new Rectangle(halfStripeThickness, maxHeight * 3.0 / 4).translate(new Point2d(0.0, halfMaxHeight - (maxHeight * 3.0 / 8)))
                .add(new Ellipse(halfStripeThickness, halfStripeThickness).translate(new Point2d(0.0, -halfMaxHeight + halfStripeThickness))));
    }

    // TODO
    public static BaseShape create_A() {
        return null;
    }

    // TODO
    public static BaseShape create_V() {
        return new BaseShape()
                .add(new Rectangle(halfStripeThickness, maxHeight).rotate(Math.atan(halfMaxWidth / maxHeight)).translate(new Point2d(halfMaxWidth / 2, 0.0)))
                .add(new Rectangle(halfStripeThickness, maxHeight).rotate(-Math.atan(halfMaxWidth / maxHeight)).translate(new Point2d(-halfMaxWidth / 2, 0.0)));
    }

    // TODO
    public static BaseShape create_n() {
        return null;
    }

    // TODO
    public static BaseShape create_r() {
        return null;
    }

    // TODO
    public static BaseShape create_B() {
        BaseShape letterB = new BaseShape();
        Rectangle line = new Rectangle(halfStripeThickness, maxHeight);
        letterB.add(line);

        Double innerWidthRadius = halfMaxWidth - halfStripeThickness;
        Double innerHeigthRadius = (halfMaxHeight / 2) - halfStripeThickness;
        Ellipse topEllipse = new Ellipse(halfMaxWidth, halfMaxHeight / 2);
        ArrayList<Point2d> toRemove = new ArrayList<>();
        for(Point2d point : topEllipse.getCoords()){
            if(Math.sqrt(Math.pow(point.X(), 2) / Math.pow(innerWidthRadius, 2) +
                    Math.pow(point.Y(), 2) / Math.pow(innerHeigthRadius, 2)) <= 1){
                toRemove.add(point);
            }
        }
        topEllipse.translate(new Point2d(halfStripeThickness, 0.0));
        for(Point2d vertex : topEllipse.getCoords()){
            if(vertex.X() < 0) toRemove.add(vertex);
        }
        topEllipse.removeAll(toRemove);
        toRemove.clear();
        Ellipse bottomEllipse = topEllipse.clone();
        topEllipse.translate(new Point2d(0.0, -halfMaxHeight / 2));
        letterB.add(topEllipse);
        bottomEllipse.translate(new Point2d(0.0, halfMaxHeight / 2));
        letterB.add(bottomEllipse);

        return letterB;
    }
}

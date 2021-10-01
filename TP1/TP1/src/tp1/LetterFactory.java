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
        Ellipse outerEllipse = new Ellipse(halfMaxWidth, halfMaxHeight);

        Double innerWidthRadius = halfMaxWidth - halfStripeThickness;
        Double innerHeigthRadius = halfMaxHeight - halfStripeThickness;

        ArrayList<Point2d> toRemove = new ArrayList<>();
        for(Point2d point : outerEllipse.getCoords()){
            boolean inInnerEllipse = Math.sqrt(Math.pow(point.X(), 2) / Math.pow(innerWidthRadius, 2) +
                    Math.pow(point.Y(), 2) / Math.pow(innerHeigthRadius, 2)) <= 1;
            boolean rectToRemove = point.Y() >= halfStripeThickness && point.Y() <= stripeThickness * 1.5 && point.X() > 0;
            if(inInnerEllipse || rectToRemove){
                toRemove.add(point);
            }
        }

        return new BaseShape()
                .add(outerEllipse.clone().removeAll(toRemove))
                .add(new Rectangle(maxWidth, stripeThickness));
    }

    // TODO
    public static BaseShape create_a() {
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

        return new BaseShape()
                .add(outerEllipse.removeAll(toRemove))
                .add(new Rectangle(halfStripeThickness, maxHeight).translate(new Point2d(halfMaxWidth, 0.0)));
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
        Double innerWidthRadius = halfMaxWidth - halfStripeThickness;
        Double innerHeigthRadius = (halfMaxHeight / 2) - halfStripeThickness;

        Ellipse topEllipse = new Ellipse(halfMaxWidth, halfMaxHeight / 2);
        ArrayList<Point2d> toRemove = new ArrayList<>();
        for(Point2d point : topEllipse.getCoords()){
            boolean inInnerEllipse = Math.sqrt(Math.pow(point.X(), 2) / Math.pow(innerWidthRadius, 2) +
                    Math.pow(point.Y(), 2) / Math.pow(innerHeigthRadius, 2)) <= 1;
            boolean outsideBound = point.X() + halfStripeThickness < 0; //to compensate for the translation;
            if(inInnerEllipse || outsideBound){
                toRemove.add(point);
            }
        }

        return new BaseShape()
                .add(topEllipse.clone().removeAll(toRemove).translate(new Point2d(halfStripeThickness, -halfMaxHeight / 2)))
                .add(topEllipse.removeAll(toRemove).translate(new Point2d(halfStripeThickness, halfMaxHeight / 2)))
                .add(new Rectangle(halfStripeThickness, maxHeight));
    }
}

package tp1;

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
        letterE.add(new Ellipse(halfMaxWidth, halfMaxHeight));
        letterE.add(new Ellipse(halfMaxWidth - halfStripeThickness, halfMaxHeight - halfStripeThickness));
        letterE.add(new Ellipse(halfMaxWidth - halfStripeThickness / 2, halfMaxHeight - halfStripeThickness / 2));

        letterE.add(new Rectangle(maxWidth, stripeThickness));
        return letterE;
    }

    // TODO
    public static BaseShape create_a() {
        BaseShape letter_a = new BaseShape();
        letter_a.add(new Ellipse(halfMaxWidth, halfMaxHeight));
        letter_a.add(new Ellipse(halfMaxWidth - halfStripeThickness, halfMaxHeight - halfStripeThickness));
        letter_a.add(new Ellipse(halfMaxWidth - halfStripeThickness / 2, halfMaxHeight - halfStripeThickness / 2));

        Rectangle rectangle = new Rectangle(halfStripeThickness, maxHeight);
        rectangle.translate(new Point2d(halfMaxWidth, 0.0));
        letter_a.add(rectangle);
        return letter_a;
    }

    // TODO
    public static BaseShape create_C() {
        return null;
    }

    // TODO
    public static BaseShape create_l() {
        BaseShape letterL = new BaseShape();
        letterL.add(new Rectangle(halfStripeThickness, maxHeight));
        return letterL;
    }

    // TODO
    public static BaseShape create_i() {
        BaseShape letterI = new BaseShape();
        Double heightRation = 3.0 / 4.0;
        Double heightDiff = maxHeight * (1 - heightRation);
        BaseShape rectangle = new Rectangle(halfStripeThickness, maxHeight * heightRation);
        rectangle.translate(new Point2d(0.0, heightDiff));
        letterI.add(rectangle);

        Ellipse point = new Ellipse(halfStripeThickness, halfStripeThickness);
        point.translate(new Point2d(0.0, heightDiff - halfMaxHeight));
        letterI.add(point);
        return letterI;
    }

    // TODO
    public static BaseShape create_A() {
        return null;
    }

    // TODO
    public static BaseShape create_V() {
        BaseShape letterV = new BaseShape();
        Rectangle rigthArm = new Rectangle(halfStripeThickness, maxHeight);
        rigthArm.rotate(Math.atan(halfMaxWidth / maxHeight));
        rigthArm.translate(new Point2d(halfMaxWidth / 2 , 0.0));
        letterV.add(rigthArm);

        Rectangle leftArm = new Rectangle(halfStripeThickness, maxHeight);
        leftArm.rotate(-Math.atan(halfMaxWidth / maxHeight));
        leftArm.translate(new Point2d(-halfMaxWidth / 2, 0.0));
        letterV.add(leftArm);
        return letterV;
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

        Ellipse topEllipse = new Ellipse(halfMaxWidth, halfMaxHeight / 2);
        topEllipse.translate(new Point2d(halfStripeThickness / 2, -halfMaxHeight / 2));
        ArrayList<Point2d> toRemove = new ArrayList<>();
        for(Point2d vertex : topEllipse.getCoords()){
            if(vertex.X() < 0){
                toRemove.add(vertex);
            }
        }
        topEllipse.removeAll(toRemove);
        toRemove.clear();
        letterB.add(topEllipse);

        Ellipse bottomEllipse = new Ellipse(halfMaxWidth, halfMaxHeight / 2);
        bottomEllipse.translate(new Point2d(halfStripeThickness / 2, halfMaxHeight / 2));
        for (Point2d vertex : bottomEllipse.getCoords()){
            if(vertex.X() < 0){
                toRemove.add(vertex);
            }
        }
        bottomEllipse.removeAll(toRemove);
        letterB.add(bottomEllipse);
        return letterB;
    }
}

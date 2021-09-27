package tp1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Rectangle extends BaseShape {
    // TODO creer un rectangle avec une largeur et une longueur.
    public Rectangle(Double width, Double height) {
        int numPointPerLine = 40; // if too low ,gives low res image;
        Double deltaX = width / numPointPerLine;
        Double deltaY = height / numPointPerLine;
        Collection<Point2d> points = new ArrayList<Point2d>();
        for(int i = 0; i < numPointPerLine; i++){
            for(int j = 0; j < numPointPerLine; j++){
                points.add(new Point2d(-width / 2 + i * deltaX, -height / 2 + j * deltaY));
            }
        }
        addAll(points);
    }

    // TODO creer un rectangle avec les dimensions contenu dans un Point.
    public Rectangle(Point2d dimensions) {
        Double width = dimensions.X();
        Double height = dimensions.Y();
        int numPointPerLine = 5;
        Double deltaX = width / numPointPerLine;
        Double deltaY = height / numPointPerLine;
        Collection<Point2d> points = new ArrayList<Point2d>();
        for(int i = 0; i < numPointPerLine; i++){
            for(int j = 0; j < numPointPerLine; j++){
                points.add(new Point2d(-width / 2 + i * deltaX, -height / 2 + j * deltaY));
            }
        }
        addAll(points);
    }

    // TODO initialiser le parent.
    private Rectangle(Collection<Point2d> coords) {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Rectangle translate(Point2d point) {
        super.translate(point);
        return this;
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Rectangle rotate(Double angle) {
        super.rotate(angle);
        return this;
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Rectangle clone() {
        Rectangle rect = new Rectangle(getCoordsDeepCopy());
        return rect;
        //essayer de call clone, voir le line avec baseShape.clone();
    }
}

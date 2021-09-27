package tp1;

import java.util.ArrayList;
import java.util.Collection;

public class Ellipse extends BaseShape {
    // TODO creer une ellipse avec une largeur et une longueur.
    public Ellipse(Double widthRadius, Double heightRadius) {
        int numPoint = 200; // must be greater than 16;
        Collection<Point2d> points = new ArrayList<Point2d>();
        Double deltaX = (widthRadius * 2) / numPoint;
        for(int i = 0; i < numPoint; i++){
            Double x = -widthRadius + i * deltaX;
            Double firstY = Math.sqrt((1 - ((x * x) / (widthRadius * widthRadius))) * heightRadius * heightRadius);
            points.add(new Point2d(x, firstY));
            points.add(new Point2d(x, -firstY));
        }
        addAll(points);
    }

    // TODO creer une ellipse avec les dimensions contenu dans un Point.
    public Ellipse(Point2d dimensions) {
        Double widthRadius = dimensions.X();
        Double heightRadius = dimensions.Y();
        int numPoint = 18; // must be greater than 16;
        Collection<Point2d> points = new ArrayList<Point2d>();
        Double deltaX = (widthRadius * 2) / (numPoint / 2);
        for(int i = 0; i < numPoint / 2; i++){
            Double x = -widthRadius + i * deltaX;
            Double firstY = Math.sqrt((1 - ((x * x) / (widthRadius * widthRadius))) * heightRadius * heightRadius);
            points.add(new Point2d(x, firstY));
            points.add(new Point2d(x, -firstY));
        }
        addAll(points);
    }

    // TODO initialiser le parent.
    private Ellipse(Collection<Point2d> coords) {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Ellipse translate(Point2d point) {
        super.translate(point);
        return this;
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Ellipse rotate(Double angle) {
        super.rotate(angle);
        return this;
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Ellipse clone() {
        Ellipse newEllipse = new Ellipse(getCoordsDeepCopy());
        return newEllipse;
    }
}

package model;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Stroke;
import controller.iColorfulShape;
import controller.iShape;
import view.interfaces.PaintCanvasBase;

public class ellipse implements iShape {
    public Point startPoint;
    public Point endPoint;
    public PaintCanvasBase paintCanvas;
    public ShapeType shapeType;
    public int height = 0;
    public int width = 0;
    public ShapeColor primaryColor;
    public ShapeColor secondaryColor;
    ShapeShadingType shapeShadingType;
    public iColorfulShape primaryColorChose;
    public iColorfulShape secondaryColorChose;
    Stroke basicStroke = new BasicStroke(10);

    

    public ellipse(PaintCanvasBase paintCanvas, Point startPoint, Point endPoint, ShapeColor primaryColor, 
	    ShapeColor secondaryColor, ShapeShadingType shapeShadingType) {
        this.paintCanvas = paintCanvas;
	this.startPoint = startPoint;
	this.endPoint = endPoint;
	this.primaryColor = primaryColor;
	this.secondaryColor = secondaryColor;
        this.shapeShadingType = shapeShadingType;
	primaryColorChose = new iColorfulShape(primaryColor);
	secondaryColorChose = new iColorfulShape(secondaryColor);    }

    public Point startPoint() {
	return this.startPoint;
    }

    public Point endPoint() {
	return this.endPoint;
    }

    public ShapeType shapeType() {
	return ShapeType.ELLIPSE;
    }

    public int height() {
	if(this.height == 0) {
	    this.height = Math.abs(endPoint.getY() - startPoint.getY());
	}
	return this.height;
    }

    public int width() {
	if(this.width == 0) {
	    this.width = Math.abs(endPoint.getX() - startPoint.getX());
	}
	return this.width;
    }

    public ShapeColor primaryColor() {
	return primaryColor;
    }

    public ShapeColor secondaryColor() {
	return secondaryColor;
    }

    public ShapeShadingType shadeShadingType() {
	return shapeShadingType;
    }
@Override
    public void draw() {
	Graphics2D graphics2d = paintCanvas.getGraphics2D();
	if (shapeShadingType.equals(ShapeShadingType.FILLED_IN)) {

	    graphics2d.setColor(primaryColorChose.getColor(primaryColor));
	    System.out.println(startPoint.getX() + startPoint.getY() + width() +  height());
	    graphics2d.fillOval(startPoint.getX(), startPoint.getY(), width(), height());
	}
	else if (shapeShadingType.equals(ShapeShadingType.OUTLINE)) {

	    graphics2d.setColor(primaryColorChose.getColor(primaryColor));
	    graphics2d.setStroke(basicStroke);
	    graphics2d.drawOval(startPoint.getX(), startPoint.getY(), width(), height());
	}
	else if (shapeShadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
	    graphics2d.setColor(secondaryColorChose.getColor(secondaryColor));
	    graphics2d.setStroke(basicStroke);
	    graphics2d.drawOval((startPoint.getX()), (startPoint.getY()), width(), height());
	    graphics2d.setColor(primaryColorChose.getColor(primaryColor));
	    graphics2d.fillOval(startPoint.getX(), (startPoint.getY()), width(), height());

	}

    }

//@Override
//public void draw(SelectedShapesList selectedShapesList) {
//    Graphics2D graphics2d = paintCanvas.getGraphics2D();
//    Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
//    graphics2d.setStroke(stroke);
//    graphics2d.setColor(primaryColorChose.getColor(primaryColor));
//    width = width() + 5;
//    height = height() + 5;
//    graphics2d.drawOval(startPoint.getX(), startPoint.getY(), width(), height());
//    
//}

@Override
public StartAndEndPointMode seMode() {
    // TODO Auto-generated method stub
    return null;
}
}

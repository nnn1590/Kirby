package Kirby;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import jig.Entity;
import jig.ResourceManager;
import jig.Vector;

 class Kirby extends MovingEntity {
	
	public static final String[] facingImages = 
		{
			KirbyGame.KIRBY_LEFTIMG_RSC,
			KirbyGame.KIRBY_LEFTIMG_RSC,
			KirbyGame.KIRBY_LEFTIMG_RSC,
			KirbyGame.KIRBY_LEFTIMG_RSC
		};
	
	private boolean flowered;
	private boolean eaten;

	public Kirby(final float x, final float y) {
		super(x, y, facingImages, LEFT);
		setVelocity(new Vector(0, 0));
		flowered = false;
		eaten = false;
	}
	
	/**
	 * @return true if powered up with meat, false if not
	 */
	public boolean poweredUp() {
		return flowered || eaten;
	}
	
	public void setVertex(KirbyGame bg) {
		int xRemain = (int)getX() % 50;
		int yRemain = (int)getY() % 50;
		int xDiff = xRemain > 25 ? 50 - xRemain : -1 * xRemain;
		int yDiff = yRemain > 25 ? 50 - yRemain : -1 * yRemain;
		Vertex v = new Vertex((int)getX() + xDiff, (int)getY() + yDiff);
		if (bg.vPos.containsKey(v.toString())){
			setvPos((int)getX() + xDiff, (int)getY() + yDiff);
		}
	}
	
	public void render(Graphics g, float offsetX, float offsetY) throws SlickException {
		//super.render(g);
		Image i = new Image(facingImages[LEFT]);
		i.draw(super.getX() - 2 - offsetX, super.getY() - 2 - offsetY);
		//sprites.get(facing).draw(x-2-offset_x, y-2-offset_y);   
	}
	
	public void update(final int delta, float xOffset, float yOffset) {
		translate(getVelocity().scale(delta));
	}
	
	public void moveLeft(int delta){
		super.setPosition(super.getX() - (.15f*delta), super.getY());
    }
 
    public void moveRight(int delta){
    	super.setPosition(super.getX() + (.15f*delta), super.getY());
    }
	
}

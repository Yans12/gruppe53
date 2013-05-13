package progprak.gruppe53;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

abstract public class Sprite extends Rectangle2D.Double implements Drawable,Movable  {


	private static final long serialVersionUID = -3479809511724931446L;
	
	/*
	 * The Spriteimage (no Animation!!!!)
	 */
	BufferedImage image;
	String imagePath;
	protected int dx = 0;
	protected int dy = 0;
	
	
	public Sprite(int x, int y, String imagePath) {
		this.imagePath = imagePath;
		loadImage();
		this.x = x;
		this.y = y;
	}

	private void loadImage(){
		URL picUrl = getClass().getClassLoader().getResource(imagePath);
		try {
			image = ImageIO.read(picUrl);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(picUrl);
	}

	@Override
	public void drawObjects(Graphics g) {
		g.drawImage(image, (int)x, (int)y, null);
	}
	public void move(long delta){
		x = x+dx;
		y = y+dy;
	}
	
}
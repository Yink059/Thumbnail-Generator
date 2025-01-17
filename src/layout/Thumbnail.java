package layout;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

public class Thumbnail {

	String leftP, rightP, event, round, leftF, rightF, eventF, roundF, font, leftSc, rightSc, switchL;
	Integer distance, rise, distance2, rise2,distance3,rise3;
	String moveSc;

	File background;
	File leftI;
	File rightI;
	

	File overlayI;

	public Thumbnail() {
	}

	public Thumbnail(String left, String right, String event1, String round1, File background1, File leftf,
			File rightf) {
		leftP = left;
		rightP = right;
		event = event1;
		round = round1;
		background = background1;
		leftI = leftf;
		rightI = rightf;
	}

	public String createThumbnail() throws IOException {
		Image image = ImageIO.read(background).getScaledInstance(1280, 720, BufferedImage.SCALE_SMOOTH);
		BufferedImage overlay, left, right = null;
		// int w = image1.getWidth();
		// int h = image1.getHeight();
		BufferedImage combined = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_ARGB);
		double width, height;
		Integer n, scaleL, scaleR;
		Image imgL = null, imgR = null;
		scaleL = Integer.parseInt(leftSc);
		scaleR = Integer.parseInt(rightSc);
		Integer d = distance;
		Integer r = rise;
		Integer d2 = distance2;
		Integer r2 = rise2;
		Integer d3 = distance3;
		Integer r3 = rise3;
		
		Graphics g = combined.getGraphics();
		g.setFont(new Font(font, Font.PLAIN, Integer.parseInt(leftF)));
		g.drawImage(image, 0, 0, null);

		// left image
		if (!(leftI.getName().toString().equals(""))) {
			left = ImageIO.read(leftI);
			height = (double) (left.getHeight());
			width = (double) (left.getWidth());
			if (width >= height) {
				n = (int) (height * ((400 + scaleL) / width));
				imgL = left.getScaledInstance((400 + scaleL), n, BufferedImage.SCALE_SMOOTH);
			} else {
				n = (int) (width * ((375 + scaleL) / height));
				imgL = left.getScaledInstance(n, (375 + scaleL), BufferedImage.SCALE_SMOOTH);
			}
			g.drawImage(imgL, (image.getWidth(null) / 4) - (imgL.getWidth(null) / 2) - d,
					(image.getHeight(null) / 2) - (imgL.getHeight(null) / 2) - 25 - r, null);

		}

		// right image
		if (!(rightI.getName().toString().equals(""))) {
			right = ImageIO.read(rightI);
			height = right.getHeight();
			width = right.getWidth();
			if (width >= height) {
				n = (int) (height * ((400 + scaleR) / width));
				imgR = right.getScaledInstance((400 + scaleR), n, BufferedImage.SCALE_SMOOTH);
			} else {
				n = (int) (width * ((375 + scaleR) / height));
				imgR = right.getScaledInstance(n, (375 + scaleR), BufferedImage.SCALE_SMOOTH);
			}
			g.drawImage(imgR, ((image.getWidth(null) / 4) * 3) - (imgR.getWidth(null) / 2) + d,
					(image.getHeight(null) / 2) - (imgR.getHeight(null) / 2) - 25 - r, null);
		}

		if (!(overlayI.getName().toString().equals(""))) {
			overlay = ImageIO.read(overlayI);
			g.drawImage(overlay.getScaledInstance(1280, 720, BufferedImage.SCALE_SMOOTH), 0, 0, null);
		}

		if (!(leftI.getName().toString().equals(""))) {
			g.setFont(new Font(font, Font.PLAIN, Integer.parseInt(leftF)));
			printString(leftP, imgL.getWidth(null), (image.getWidth(null) / 4) - (imgL.getWidth(null) / 2) - d2,
					(image.getHeight(null) / 2) + (imgL.getHeight(null) / 2) + 55 - r2, g);
		}

		if (!(rightI.getName().toString().equals(""))) {
			g.setFont(new Font(font, Font.PLAIN, Integer.parseInt(rightF)));
			printString(rightP, imgR.getWidth(null), ((image.getWidth(null) / 4) * 3) - (imgR.getWidth(null) / 2) + d2,
					(image.getHeight(null) / 2) + (imgL.getHeight(null) / 2) + 55 - r2, g);
		}

		g.setFont(new Font(font, Font.PLAIN, (int) Integer.parseInt(eventF)));
		printString(event, 0, image.getWidth(null) / 2, (image.getHeight(null) / 5) - d3 - r3, g);

		g.setFont(new Font(font, Font.PLAIN, (int) Integer.parseInt(roundF)));
		printString(round, 0, image.getWidth(null) / 2, (image.getHeight(null) / 17) * 16 + 25 + d3 - r3, g);

		String name = "" + event + " " + round + " ft " + leftP + " vs " + rightP + ".png";
		ImageIO.write(combined, "PNG", new File("yinkTN\\saved", name));
		System.out.println("yinkTN" + name);
		return "yinkTN\\saved\\" + name;
	}

	public String createThumbnail(Boolean bool) throws IOException {
		Image image = ImageIO.read(background).getScaledInstance(1280, 720, BufferedImage.SCALE_SMOOTH);
		BufferedImage overlay, left, right = null;
		// int w = image1.getWidth();
		// int h = image1.getHeight();
		BufferedImage combined = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_ARGB);
		double width, height;
		Integer n, scaleL, scaleR;
		Image imgL = null, imgR = null;
		scaleL = Integer.parseInt(leftSc);
		scaleR = Integer.parseInt(rightSc);
		Integer d = distance;
		Integer r = rise;
		Integer d2 = distance2;
		Integer r2 = rise2;
		Integer d3 = distance3;
		Integer r3 = rise3;
		
		Graphics g = combined.getGraphics();
		g.setFont(new Font(font, Font.PLAIN, Integer.parseInt(leftF)));
		g.drawImage(image, 0, 0, null);

		// left image
		if (!(leftI.getName().toString().equals(""))) {
			left = ImageIO.read(leftI);
			height = (double) (left.getHeight());
			width = (double) (left.getWidth());
			if (width >= height) {
				n = (int) (height * ((400 + scaleL) / width));
				imgL = left.getScaledInstance((400 + scaleL), n, BufferedImage.SCALE_SMOOTH);
			} else {
				n = (int) (width * ((375 + scaleL) / height));
				imgL = left.getScaledInstance(n, (375 + scaleL), BufferedImage.SCALE_SMOOTH);
			}
			g.drawImage(imgL, (image.getWidth(null) / 4) - (imgL.getWidth(null) / 2) - d,
					(image.getHeight(null) / 2) - (imgL.getHeight(null) / 2) - 25 - r, null);

		}

		// right image
		if (!(rightI.getName().toString().equals(""))) {
			right = ImageIO.read(rightI);
			height = right.getHeight();
			width = right.getWidth();
			if (width >= height) {
				n = (int) (height * ((400 + scaleR) / width));
				imgR = right.getScaledInstance((400 + scaleR), n, BufferedImage.SCALE_SMOOTH);
			} else {
				n = (int) (width * ((375 + scaleR) / height));
				imgR = right.getScaledInstance(n, (375 + scaleR), BufferedImage.SCALE_SMOOTH);
			}
			g.drawImage(imgR, ((image.getWidth(null) / 4) * 3) - (imgR.getWidth(null) / 2) + d,
					(image.getHeight(null) / 2) - (imgR.getHeight(null) / 2) - 25 - r, null);
		}

		if (!(overlayI.getName().toString().equals(""))) {
			overlay = ImageIO.read(overlayI);
			g.drawImage(overlay.getScaledInstance(1280, 720, BufferedImage.SCALE_SMOOTH), 0, 0, null);
		}

		if (!(leftI.getName().toString().equals(""))) {
			g.setFont(new Font(font, Font.PLAIN, Integer.parseInt(leftF)));
			printString(leftP, imgL.getWidth(null), (image.getWidth(null) / 4) - (imgL.getWidth(null) / 2) - d2,
					(image.getHeight(null) / 2) + (imgL.getHeight(null) / 2) + 55 - r2, g);
		}

		if (!(rightI.getName().toString().equals(""))) {
			g.setFont(new Font(font, Font.PLAIN, Integer.parseInt(rightF)));
			printString(rightP, imgR.getWidth(null), ((image.getWidth(null) / 4) * 3) - (imgR.getWidth(null) / 2) + d2,
					(image.getHeight(null) / 2) + (imgL.getHeight(null) / 2) + 55 - r2, g);
		}

		g.setFont(new Font(font, Font.PLAIN, (int) Integer.parseInt(eventF)));
		printString(event, 0, image.getWidth(null) / 2, (image.getHeight(null) / 5) - d3 - r3, g);

		g.setFont(new Font(font, Font.PLAIN, (int) Integer.parseInt(roundF)));
		printString(round, 0, image.getWidth(null) / 2, (image.getHeight(null) / 17) * 16 + 25 + d3 - r3, g);

		String name = "temp.png";
		ImageIO.write(combined, "PNG", new File("yinkTN\\saved", name));
		System.out.println("yinkTN\\" + name);
		return "yinkTN\\saved\\" + name;
	}

	public BufferedImage createThumbnail(String leftP, String rightP, String event, String round, File Background,
			File leftI, File rightI) throws IOException {
		BufferedImage image = ImageIO.read(Background);

		return image;
	}

	private void printString(String s, int width, int XPos, int YPos, Graphics g) {
		int stringLen = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
		int start = width / 2 - stringLen / 2;
		g.drawString(s, start + XPos, YPos);
	}

	public String getLeftP() {
		return leftP;
	}

	public void setLeftP(String leftP) {
		this.leftP = leftP;
	}

	public String getRightP() {
		return rightP;
	}

	public void setRightP(String rightP) {
		this.rightP = rightP;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getRound() {
		return round;
	}

	public void setRound(String round) {
		this.round = round;
	}

	public File getBackground() {
		return background;
	}

	public void setBackground(File background) {
		this.background = background;
	}

	public File getLeftI() {
		return leftI;
	}

	public void setLeftI(File leftI) {
		this.leftI = leftI;
	}

	public File getRightI() {
		return rightI;
	}

	public void setRightI(File rightI) {
		this.rightI = rightI;
	}

	public String getLeftF() {
		return leftF;
	}

	public void setLeftF(String leftF) {
		this.leftF = leftF;
	}

	public String getRightF() {
		return rightF;
	}

	public void setRightF(String rightF) {
		this.rightF = rightF;
	}

	public String getEventF() {
		return eventF;
	}

	public void setEventF(String eventF) {
		this.eventF = eventF;
	}

	public String getRoundF() {
		return roundF;
	}

	public void setRoundF(String roundF) {
		this.roundF = roundF;
	}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}

	public File getOverlay() {
		return overlayI;
	}

	public void setOverlay(File overlayI) {
		this.overlayI = overlayI;
	}

	public String getLeftSc() {
		return leftSc;
	}

	public void setLeftSc(String leftSc) {
		this.leftSc = leftSc;
	}

	public String getRightSc() {
		return rightSc;
	}

	public void setRightSc(String rightSc) {
		this.rightSc = rightSc;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Integer getRise() {
		return rise;
	}

	public void setRise(Integer rise) {
		this.rise = rise;
	}
	
	public String getMoveSc() {
		return moveSc;
	}

	public Integer getDistance2() {
		return distance2;
	}

	public Integer getDistance3() {
		return distance3;
	}

	public void setDistance3(Integer distance3) {
		this.distance3 = distance3;
	}

	public Integer getRise3() {
		return rise3;
	}

	public void setRise3(Integer rise3) {
		this.rise3 = rise3;
	}

	public void setDistance2(Integer distance2) {
		this.distance2 = distance2;
	}

	public Integer getRise2() {
		return rise2;
	}

	public void setRise2(Integer rise2) {
		this.rise2 = rise2;
	}

	public void setMoveSc(String moveSc) {
		this.moveSc = moveSc;
	}
}

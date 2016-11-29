
package layout;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings({ "serial", "unused" })
public class ThumbnailMaker extends JPanel {
	// Name-constants to define the various dimensions
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;

	String leftI, rightI, eventS, roundS, background, leftS, rightS, leftF, rightF, eventF, roundF, fontS, overlayI;
	static String currentTn;
	static TextField left, right, event, round, leftSize, rightSize, eventSize, roundSize, font;
	private static JButton selectLeft, selectRight, selectBg, save, update, overlay;
	static JFrame frame;
	static JFileChooser fc;
	static Image thumbnail;
	static ImageIcon ii;
	static JLabel picLabel;

	public ThumbnailMaker() {
		
		Thumbnail tn = new Thumbnail();
		left = new TextField("Left Player", 20);
		right = new TextField("Right Player", 20);
		event = new TextField("event", 20);
		round = new TextField("round", 20);
		leftSize = new TextField("80", 3);
		rightSize = new TextField("80", 3);
		eventSize = new TextField("115", 3);
		roundSize = new TextField("90", 3);
		font = new TextField("Helvetica", 20);
		fc = new JFileChooser();
		fc.setCurrentDirectory(new File("yinkTN"));

		selectLeft = new JButton("Select Left Image...");
		selectRight = new JButton("Select Right Image...");
		selectBg = new JButton("Select Background Image...");
		save = new JButton("Save Current...");
		update = new JButton("Preview...");
		overlay = new JButton("Select Overlay...");

		leftI = "";
		rightI = "";
		background = "";
		overlayI = "";

		selectLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnValue = fc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fc.getSelectedFile();
					tn.setLeftI(selectedFile);
					leftI = selectedFile.getAbsolutePath();
					System.out.println(tn.getLeftI());
					Update(tn);
				}
			};
		});
		selectRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnValue = fc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fc.getSelectedFile();
					tn.setRightI(selectedFile);
					rightI = selectedFile.getAbsolutePath();
					System.out.println(selectedFile.getAbsolutePath());
					Update(tn);
				}
			};
		});
		selectBg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnValue = fc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fc.getSelectedFile();
					tn.setBackground(selectedFile);
					background = selectedFile.getAbsolutePath();
					System.out.println(selectedFile.getAbsolutePath());
					Update(tn);
				}
			};
		});
		overlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnValue = fc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fc.getSelectedFile();
					tn.setOverlay(selectedFile);
					overlayI = selectedFile.getAbsolutePath();
					System.out.println(selectedFile.getAbsolutePath());
					Update(tn);
				}
			};
		});
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Update(tn);
					currentTn = tn.createThumbnail();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				UpdateI();
			};
		});
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Update(tn);
					currentTn = tn.createThumbnail(true);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				UpdateI();
			};
		});

	}

	/**
	 * The entry main() method
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ii = null;
		Image windowIcon = ImageIO.read(new File("icon.jpg"));
		frame = new JFrame();
		ThumbnailMaker app = new ThumbnailMaker();
		frame.setContentPane(app);
		SpringLayout layout = new SpringLayout();
		frame.setLayout(layout);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Yink's Thumbnail Generator");
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT); // or pack()
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(windowIcon);
		
		frame.add(left);
		layout.putConstraint(SpringLayout.WEST, left, 5, SpringLayout.WEST, frame);
		layout.putConstraint(SpringLayout.NORTH, left, 5, SpringLayout.NORTH, frame);
		frame.add(leftSize);
		layout.putConstraint(SpringLayout.WEST, leftSize, 5, SpringLayout.EAST, left);
		layout.putConstraint(SpringLayout.NORTH, leftSize, 0, SpringLayout.NORTH, left);

		frame.add(right);
		layout.putConstraint(SpringLayout.EAST, right, frame.getWidth() - 35, SpringLayout.EAST, frame);
		layout.putConstraint(SpringLayout.NORTH, right, 5, SpringLayout.NORTH, frame);
		frame.add(rightSize);
		layout.putConstraint(SpringLayout.EAST, rightSize, -5, SpringLayout.WEST, right);
		layout.putConstraint(SpringLayout.NORTH, rightSize, 0, SpringLayout.NORTH, right);

		frame.add(event);
		layout.putConstraint(SpringLayout.NORTH, event, 5, SpringLayout.NORTH, frame);
		layout.putConstraint(SpringLayout.WEST, event, frame.getWidth() / 3, SpringLayout.WEST, frame);
		frame.add(eventSize);
		layout.putConstraint(SpringLayout.NORTH, eventSize, 0, SpringLayout.NORTH, event);
		layout.putConstraint(SpringLayout.WEST, eventSize, 5, SpringLayout.EAST, event);

		frame.add(round);
		layout.putConstraint(SpringLayout.NORTH, round, 50, SpringLayout.NORTH, event);
		layout.putConstraint(SpringLayout.WEST, round, frame.getWidth() / 3, SpringLayout.WEST, frame);
		frame.add(roundSize);
		layout.putConstraint(SpringLayout.NORTH, roundSize, 0, SpringLayout.NORTH, round);
		layout.putConstraint(SpringLayout.WEST, roundSize, 5, SpringLayout.EAST, round);
		
		frame.add(font);
		layout.putConstraint(SpringLayout.NORTH, font, 40, SpringLayout.NORTH, round);
		layout.putConstraint(SpringLayout.WEST, font, 0, SpringLayout.WEST, round);

		frame.add(new JLabel("Label: "));
		frame.setVisible(true);

		frame.add(ThumbnailMaker.selectLeft);
		layout.putConstraint(SpringLayout.WEST, selectLeft, 0, SpringLayout.WEST, left);
		layout.putConstraint(SpringLayout.NORTH, selectLeft, 50, SpringLayout.NORTH, left);
		frame.add(ThumbnailMaker.selectRight);
		layout.putConstraint(SpringLayout.EAST, selectRight, 0, SpringLayout.EAST, right);
		layout.putConstraint(SpringLayout.NORTH, selectRight, 50, SpringLayout.NORTH, right);
		frame.add(ThumbnailMaker.selectBg);
		layout.putConstraint(SpringLayout.NORTH, selectBg, 75, SpringLayout.NORTH, round);
		layout.putConstraint(SpringLayout.WEST, selectBg, 0, SpringLayout.WEST, round);
		frame.add(ThumbnailMaker.save);
		layout.putConstraint(SpringLayout.NORTH, save, 50, SpringLayout.NORTH, selectBg);
		layout.putConstraint(SpringLayout.WEST, save, 0, SpringLayout.WEST, selectBg);
		frame.add(ThumbnailMaker.update);
		layout.putConstraint(SpringLayout.NORTH, update, 50, SpringLayout.NORTH, save);
		layout.putConstraint(SpringLayout.WEST, update, 0, SpringLayout.WEST, save);
		frame.add(ThumbnailMaker.overlay);
		layout.putConstraint(SpringLayout.NORTH, overlay, 0, SpringLayout.NORTH, update);
		layout.putConstraint(SpringLayout.WEST, overlay, 15, SpringLayout.EAST, update);
		
		picLabel = new JLabel();
		frame.add(picLabel);
		layout.putConstraint(SpringLayout.NORTH, picLabel, 50, SpringLayout.NORTH, update);
		layout.putConstraint(SpringLayout.EAST, picLabel, 192, SpringLayout.EAST, update);

	}

	public void Update(Thumbnail tn) {
		// leftI, rightI, eventS, roundS, background, leftS, rightS;
		leftS = left.getText();
		rightS = right.getText();
		roundS = round.getText();
		eventS = event.getText();

		eventF = eventSize.getText();
		leftF = leftSize.getText();
		rightF = rightSize.getText();
		roundF = roundSize.getText();
		
		fontS = font.getText();
		
		tn.setBackground(new File(background));
		tn.setOverlay(new File(overlayI));
		tn.setLeftI(new File(leftI));
		tn.setRightI(new File(rightI));
		tn.setEvent(eventS);
		tn.setLeftP(leftS);
		tn.setRightP(rightS);
		tn.setRound(roundS);
		tn.setEventF(eventF);
		tn.setLeftF(leftF);
		tn.setRightF(rightF);
		tn.setRoundF(roundF);
		tn.setFont(fontS);
	}

	public void UpdateI() {
		Image image = null;
		System.out.println("UpdateI = " + currentTn);
		try {
			image = ImageIO.read(new File(currentTn));
			Image dimg = image.getScaledInstance(384, 216, Image.SCALE_SMOOTH);

			picLabel.setIcon(new ImageIcon(dimg));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

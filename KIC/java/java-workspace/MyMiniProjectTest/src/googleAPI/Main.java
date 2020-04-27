package googleAPI;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame
{
	private GoogleAPI googleAPI = new GoogleAPI();
	private String location = "서울";
	private JLabel googleMap;
	
	public Main()
	{		
		// TODO Auto-generated constructor stub
		googleAPI.downloadingMap(location);
		googleMap = new JLabel(googleAPI.getMap(location));
		googleAPI.fileDelete(location);
		add(googleMap);
		
		
		setTitle("Google Map");
		setVisible(true);
		pack();
	}
}

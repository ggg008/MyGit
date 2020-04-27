package _191211_network;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MyGeoMap extends JFrame
{

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try {
					MyGeoMap frame = new MyGeoMap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyGeoMap()
	{
		setResizable(false);
		setTitle(getClass().getName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 316, 74);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("검색");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				BufferedReader br = null;
				String searchLoc = textField.getText();
				searchLoc = searchLoc.replaceAll(" ", "+");
				
				String apiKey = "AIzaSyBY5uS2cynV0sgpZnm_AckCMriOfdG_NXc";
				
				if(searchLoc.equals("")) {
					JOptionPane.showMessageDialog(MyGeoMap.this, "값을 입력바랍니다");
					return;
				}
				
				
				String lat = "";
				String lng = "";
//				https://www.google.com/maps/search/%EA%B0%95%EB%82%A8%EC%97%AD/@37.4968281,126.9978994,12z/data=!3m1!4b1
//				String strSearchLoc = String.format("https://www.google.com/maps/place/%s", searchLoc);
				String strSearchLoc = String.format("https://maps.googleapis.com/maps/api/geocode/json?address=%s&key=%s", searchLoc, apiKey);
				
				try {
					URL url = new URL(strSearchLoc);
					br = new BufferedReader(new InputStreamReader(url.openStream()));
					
					String mapData = null;
					while((mapData = br.readLine()) != null) {
						if(mapData.contains("lat")) {
							String[] datas = mapData.split("\"");							
							String strLat = datas[2];
							
							strLat = strLat.replaceAll(":", "");
							strLat = strLat.replaceAll(",", "");
							strLat = strLat.replaceAll(" ", "");
							
							if(lat.equals("")) {
								lat = strLat;
//								System.out.println(lat);
							}
							
							
						} else if (mapData.contains("lng")) {
							String[] datas = mapData.split("\"");							
							String strLng = datas[2];
							
							strLng = strLng.replaceAll(":", "");
							strLng = strLng.replaceAll(",", "");
							strLng = strLng.replaceAll(" ", "");
							
							if(lng.equals("")) {
								lng = strLng;
//								System.out.println(lng);
							}
						}
							
						if(mapData.contains("status")) {
							String[] datas = mapData.split("\"");
							
							if(datas[3].equals("ZERO_RESULT")) {
								JOptionPane.showMessageDialog(MyGeoMap.this, "찾을수없는 지명입니다");
								return;
							} else if(!datas[3].equals("OK")) {
								JOptionPane.showMessageDialog(MyGeoMap.this, "ERROR : " + datas[3]);
								return;
							}
						}
						
//						System.out.println(mapData);
						
					}

					if(lat.equals("") || lng.equals("")) {
						return;
					}
						
					
					String strMap = String.format("https://www.google.com/maps/@%s,%s,17z", lat, lng);
					ProcessBuilder pb = new ProcessBuilder("C:\\Program Files\\Internet Explorer\\iexplore.exe", strMap);
					pb.start();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					if(br != null) try {
						br.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
				}
				
			}
		});
		btnNewButton.setBounds(199, 10, 97, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(12, 11, 175, 22);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}

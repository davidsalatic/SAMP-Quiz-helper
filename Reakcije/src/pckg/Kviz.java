package pckg;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Kviz extends JFrame {
	public static String path = "C:\\Users\\David\\Documents\\GTA San Andreas User Files\\SAMP\\chatlog.txt";
	private boolean run = true;
	private JTextField tfBrzinaReakcije;
	public static int brzinaReakcije = 1600;
	public static boolean uspesanUnos=false;
	public Kviz() {
		setSize(370, 134);
		setTitle("Quiz");
		setLocationRelativeTo(null);
		setResizable(false);
		JPanel jpMain = new JPanel();
		getContentPane().add(jpMain, BorderLayout.CENTER);
		jpMain.setLayout(null);

		JLabel lblUnesiUserRacunara = new JLabel("Unesi User racunara: ");
		lblUnesiUserRacunara.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUnesiUserRacunara.setBounds(10, 11, 176, 14);
		jpMain.add(lblUnesiUserRacunara);

		JTextField tfUser = new JTextField();
		tfUser.setBounds(196, 8, 89, 20);
		jpMain.add(tfUser);
		tfUser.setColumns(10);

		JLabel lblBrzinaReakcijeu = new JLabel("Minimalna brzina reakcije:");
		lblBrzinaReakcijeu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBrzinaReakcijeu.setBounds(10, 36, 176, 14);
		jpMain.add(lblBrzinaReakcijeu);

		tfBrzinaReakcije = new JTextField();
		tfBrzinaReakcije.setText("1800");
		tfBrzinaReakcije.setBounds(196, 33, 52, 20);
		jpMain.add(tfBrzinaReakcije);
		tfBrzinaReakcije.setColumns(10);

		JLabel lblMs = new JLabel("ms");
		lblMs.setBounds(258, 36, 27, 14);
		jpMain.add(lblMs);
		setVisible(true);

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int temp = Integer.parseInt(tfBrzinaReakcije.getText());
					if (temp >= 500 && temp <= 15000) {
						brzinaReakcije = temp - 200;
						uspesanUnos=true;
					} else {
						throw new IllegalAccessError();
					}
				}
				catch(IllegalArgumentException e)
				{
					JOptionPane.showMessageDialog(Kviz.this, "Moras uneti broj u polje 'Minimalna brzina reakcije'!","Greska!",JOptionPane.ERROR_MESSAGE);
				}
				catch(IllegalAccessError iae)
				{
					JOptionPane.showMessageDialog(Kviz.this, "Brzina reakcije mora biti izmedju 500 i 15000 ms!","Greska!",JOptionPane.ERROR_MESSAGE);
				}
				if(uspesanUnos==true)
				{
					if (tfUser.getText().isEmpty()) {
						JOptionPane.showMessageDialog(Kviz.this,
								"Unesi nesto u User polje! \nUser ime svog racunara mozes naci na vise nacina:\n1. U Command Prompt ukucaj: echo %username%\n2. U Task Manageru, klikom na Users\n3. U C:\\Users folderu",
								"Greska!", JOptionPane.ERROR_MESSAGE);
					} else {
						path = "C:\\Users\\" + tfUser.getText()
								+ "\\Documents\\GTA San Andreas User Files\\SAMP\\chatlog.txt"; //TEXT FILE PATH
						File f = new File(path);
						if (f.exists() && !f.isDirectory()) {
							while (run == true) { //INFINITE LOOP
								String line;
								FileReader fileReader;
								try {
									fileReader = new FileReader(path);
									BufferedReader bufferedReader = new BufferedReader(fileReader);
									while ((line = bufferedReader.readLine()) != null) {
										String[] lines = line.split(" ");
										for (int iter = 0; iter < lines.length; iter++) {
											if (lines[iter].equals("KVIZ:") && (lines[iter + 1].equals("{FFFFFF}Koji"))) { //TEXTFILE TRIGGER
												Robot rob = new Robot();
												rob.keyPress(KeyEvent.VK_ENTER);
												rob.keyRelease(KeyEvent.VK_ENTER);
												if (lines[iter + 6].equals("Kuvajt?"))
													Drzava("Kuvajt");
												else if (lines[iter + 6].equals("Moldavija?"))
													Drzava("Kisinjev");
												else if (lines[iter + 6].equals("Bosna") && lines[iter + 7].equals("i")
														&& lines[iter + 8].equals("Hercegovina?"))
													Drzava("Sarajevo");
												else if (lines[iter + 6].equals("Avganistan?"))
													Drzava("Kabul");
												else if (lines[iter + 6].equals("Albanija?"))
													Drzava("Tirana");
												else if (lines[iter + 6].equals("Alzir?"))
													Drzava("Alzir");
												else if (lines[iter + 6].equals("Angola?"))
													Drzava("Luanda");
												else if (lines[iter + 6].equals("Australija?"))
													Drzava("Kanbera");
												else if (lines[iter + 6].equals("Austrija?"))
													Drzava("Bec");
												else if (lines[iter + 6].equals("Azerbejdzan?"))
													Drzava("Baku");
												else if (lines[iter + 6].equals("Bahame?"))
													Drzava("Nasau");
												else if (lines[iter + 6].equals("Bahrein?"))
													Drzava("Manama");
												else if (lines[iter + 6].equals("Banglades?"))
													Drzava("Daka");
												else if (lines[iter + 6].equals("Barbados?"))
													Drzava("Bridztaun");
												else if (lines[iter + 6].equals("Belgija?"))
													Drzava("Brisel");
												else if (lines[iter + 6].equals("Belorusija?"))
													Drzava("Minsk");
												else if (lines[iter + 6].equals("Bolivija?"))
													Drzava("Sukre");
												else if (lines[iter + 6].equals("Brazil?"))
													Drzava("Brazilija");
												else if (lines[iter + 6].equals("Bugarska?"))
													Drzava("Sofija");
												else if (lines[iter + 6].equals("Danska?"))
													Drzava("Kopenhagen");
												else if (lines[iter + 6].equals("Egipat?"))
													Drzava("Kairo");
												else if (lines[iter + 6].equals("Filipini?"))
													Drzava("Manila");
												else if (lines[iter + 6].equals("Finska?"))
													Drzava("Helsinki");
												else if (lines[iter + 6].equals("Francuska?"))
													Drzava("Pariz");
												else if (lines[iter + 6].equals("Gana?"))
													Drzava("Akra");
												else if (lines[iter + 6].equals("Grcka?"))
													Drzava("Atina");
												else if (lines[iter + 6].equals("Gruzija?"))
													Drzava("Tbilisi");
												else if (lines[iter + 6].equals("Holandija?"))
													Drzava("Amsterdam");
												else if (lines[iter + 6].equals("Hrvatska?"))
													Drzava("Zagreb");
												else if (lines[iter + 6].equals("Indonezija?"))
													Drzava("Dzakarta");
												else if (lines[iter + 6].equals("Irak?"))
													Drzava("Bagdad");
												else if (lines[iter + 6].equals("Iran?"))
													Drzava("Teheran");
												else if (lines[iter + 6].equals("Irska?"))
													Drzava("Dablin");
												else if (lines[iter + 6].equals("Island?"))
													Drzava("Rejkjavik");
												else if (lines[iter + 6].equals("Italija?"))
													Drzava("Rim");
												else if (lines[iter + 6].equals("Izrael?"))
													Drzava("Jerusalim");
												else if (lines[iter + 6].equals("Japan?"))
													Drzava("Tokio");
												else if (lines[iter + 6].equals("Kanada?"))
													Drzava("Otava");
												else if (lines[iter + 6].equals("Katar?"))
													Drzava("Doha");
												else if (lines[iter + 6].equals("Kina?"))
													Drzava("Peking");
												else if (lines[iter + 6].equals("Kipar?"))
													Drzava("Nikozija");
												else if (lines[iter + 6].equals("Kuba?"))
													Drzava("Havana");
												else if (lines[iter + 6].equals("Libija?"))
													Drzava("Tripoli");
												else if (lines[iter + 6].equals("Lihtenstajn?"))
													Drzava("Vaduz");
												else if (lines[iter + 6].equals("Luksemburg?"))
													Drzava("Luksemburg");
												else if (lines[iter + 6].equals("Madjarska?"))
													Drzava("Budimpesta");
												else if (lines[iter + 6].equals("Makedonija?"))
													Drzava("Skoplje");
												else if (lines[iter + 6].equals("Malta?"))
													Drzava("Valeta");
												else if (lines[iter + 6].equals("Monako?"))
													Drzava("Monako");
												else if (lines[iter + 6].equals("Nemacka?"))
													Drzava("Berlin");
												else if (lines[iter + 6].equals("Norveska?"))
													Drzava("Oslo");
												else if (lines[iter + 6].equals("Pakistan?"))
													Drzava("Islambad");
												else if (lines[iter + 6].equals("Peru?"))
													Drzava("Lima");
												else if (lines[iter + 6].equals("Kolumbija?"))
													Drzava("Bogota");
												else if (lines[iter + 6].equals("Kenija?"))
													Drzava("Najrobi");
												else if (lines[iter + 6].equals("Poljska?"))
													Drzava("Varsava");
												else if (lines[iter + 6].equals("Portugal?"))
													Drzava("Lisabon");
												else if (lines[iter + 6].equals("Rumunija?"))
													Drzava("Bukurest");
												else if (lines[iter + 6].equals("Rusija?"))
													Drzava("Moskva");
												else if (lines[iter + 6].equals("Senegal?"))
													Drzava("Dakar");
												else if (lines[iter + 6].equals("Singapur?"))
													Drzava("Singaput");
												else if (lines[iter + 6].equals("Sirija?"))
													Drzava("Damask");
												else if (lines[iter + 6].equals("Slovacka?"))
													Drzava("Bratislava");
												else if (lines[iter + 6].equals("Slovenija?"))
													Drzava("Ljubljana");
												else if (lines[iter + 6].equals("Srbija?"))
													Drzava("Beograd");
												else if (lines[iter + 6].equals("Spanija?"))
													Drzava("Madrid");
												else if (lines[iter + 6].equals("Svajcarska?"))
													Drzava("Bern");
												else if (lines[iter + 6].equals("Svedska?"))
													Drzava("Stokholm");
												else if (lines[iter + 6].equals("Tajland?"))
													Drzava("Bangkok");
												else if (lines[iter + 6].equals("Tunis?"))
													Drzava("Tunis");
												else if (lines[iter + 6].equals("Turska?"))
													Drzava("Ankara");
												else if (lines[iter + 6].equals("Velika")
														&& lines[iter + 7].equals("Britanija?"))
													Drzava("London");
												else if (lines[iter + 6].equals("Ukrajina?"))
													Drzava("Kijev");
												else if (lines[iter + 6].equals("Urugvaj?"))
													Drzava("Montevideo");
												else if (lines[iter + 6].equals("Venecuela?"))
													Drzava("Karakas");
												else if (lines[iter + 6].equals("Vijetnam?"))
													Drzava("Hanoi");
												else if (lines[iter + 6].equals("Zimbabve?"))
													Drzava("Harare");
												else if (lines[iter + 6].equals("Zambija?"))
													Drzava("Lusaka");
												else if (lines[iter + 6].equals("Ceska?"))
													Drzava("Prag");
												else if (lines[iter + 6].equals("Jamajka?"))
													Drzava("Kingston");
												else if (lines[iter + 6].equals("Crna") && lines[iter + 7].equals("Gora?"))
													Drzava("Podgorica");
												else
													Overwrite();

											} /* MATH QUIZ (izbacen u igrici pa i ovde zakomentarisan) 
												 * else if (lines[iter].equals("QUIZ:") && (lines[iter +
												 * 1].equals("{FFFFFF}Ko") && lines[iter + 2].equals("prvi") && lines[iter +
												 * 3].equals("napise") && lines[iter + 4].equals("tacno") && lines[iter +
												 * 5].equals("resenje:"))) { Robot rob=new Robot();
												 * rob.keyPress(KeyEvent.VK_ENTER); rob.keyRelease(KeyEvent.VK_ENTER); int
												 * prviBroj = Integer.parseInt(lines[iter + 6].substring(1, lines[iter +
												 * 6].length())); int drugiBroj = Integer.parseInt(lines[iter + 8]); int
												 * treciBroj = Integer.parseInt(lines[iter + 10].substring(0, lines[iter +
												 * 10].length() - 1)); String prvaOperacija = lines[iter + 7]; String
												 * drugaOperacija = lines[iter + 9];
												 * 
												 * if (prvaOperacija.equals("+") && drugaOperacija.equals("+")) { int rez =
												 * prviBroj + drugiBroj + treciBroj; Ispisi(rez); } else
												 * if(prvaOperacija.equals("+")&&drugaOperacija.equals("-")) { int
												 * rez=prviBroj+drugiBroj-treciBroj; Ispisi(rez); } else
												 * if(prvaOperacija.equals("+")&&drugaOperacija.equals("*")) { int
												 * rez=prviBroj+drugiBroj*treciBroj; Ispisi(rez); } else
												 * if(prvaOperacija.equals("-")&&drugaOperacija.equals("+")) { int
												 * rez=prviBroj-drugiBroj+treciBroj; Ispisi(rez); } else
												 * if(prvaOperacija.equals("-")&&drugaOperacija.equals("-")) { int
												 * rez=prviBroj-drugiBroj-treciBroj; Ispisi(rez); } else
												 * if(prvaOperacija.equals("-")&&drugaOperacija.equals("*")) { int
												 * rez=prviBroj-drugiBroj*treciBroj; Ispisi(rez); } else
												 * if(prvaOperacija.equals("*")&&drugaOperacija.equals("+")) { int
												 * rez=prviBroj*drugiBroj+treciBroj; Ispisi(rez); } else
												 * if(prvaOperacija.equals("*")&&drugaOperacija.equals("-")) { int
												 * rez=prviBroj*drugiBroj-treciBroj; Ispisi(rez); } else
												 * if(prvaOperacija.equals("*")&&drugaOperacija.equals("*")) { int
												 * rez=prviBroj*drugiBroj*treciBroj; Ispisi(rez); } else
												 * System.out.println("Error"); }
												 */
										}
									}
									bufferedReader.close();
									Thread.sleep(100);

								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (NumberFormatException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (UnsupportedEncodingException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (AWTException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}

						else {
							JOptionPane.showMessageDialog(Kviz.this,
									"Nema tog User-a na racunaru. \nUser ime svog racunara mozes naci na vise nacina:\n1. U Command Prompt ukucaj: echo %username%\n2. U Task Manageru, klikom na Users\n3. U C:\\Users folderu",
									"Greska!", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				
			}
		});
		btnStart.setBounds(144, 71, 89, 23);
		jpMain.add(btnStart);

		JButton jbHelp = new JButton("??");
		jbHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(Kviz.this,
						"User ime svog racunara mozes naci na vise nacina:\n1. U Command Prompt ukucaj: echo %username%\n2. U Task Manageru, klikom na Users\n3. U C:\\Users folderu",
						"Info", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		jbHelp.setBounds(295, 7, 59, 23);
		jpMain.add(jbHelp);

	}

	public static void main(String[] args) throws IOException, AWTException, InterruptedException {
		Kviz kv = new Kviz();
	}

	public static void Drzava(String drzava)
			throws AWTException, InterruptedException, FileNotFoundException, UnsupportedEncodingException {
		Random rand = new Random();
		int n = rand.nextInt(3) + 1;
		if (n == 1) {
			Thread.sleep(brzinaReakcije); //RANDOMIZING TIME NEEDED TO PRINT OUT SOLUTION, TO REMOVE SUSPICION OF CHEATING
		} else if (n == 2) {
			Thread.sleep(brzinaReakcije + 50);
		} else if (n == 3) {
			Thread.sleep(brzinaReakcije + 80);
		} else {
			System.out.println("ERROR");
		}
		String text = drzava;
		StringSelection stringSelection = new StringSelection(text);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, stringSelection);
		Robot robot = new Robot(); //ROBOT DOES THE COPY-PASTE OF THE SOLUTION ON ITS OWN
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_T);
		robot.keyPress(KeyEvent.VK_SLASH);
		robot.keyRelease(KeyEvent.VK_SLASH);
		robot.keyPress(KeyEvent.VK_K);
		robot.keyRelease(KeyEvent.VK_K);
		robot.keyPress(KeyEvent.VK_SPACE);
		robot.keyRelease(KeyEvent.VK_SPACE);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(200);
		Overwrite();
	}

	public static void Overwrite() throws FileNotFoundException, UnsupportedEncodingException, InterruptedException {
		PrintWriter writer = new PrintWriter(path, "UTF-8");
		writer.close();
		Thread.sleep(100);
	}
}

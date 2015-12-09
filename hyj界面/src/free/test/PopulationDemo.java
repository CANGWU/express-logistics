package free.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import twaver.DataBoxQuickFinder;
import twaver.Element;
import twaver.ElementCallbackHandler;
import twaver.MovableFilter;
import twaver.TDataBox;
import twaver.TUIManager;
import twaver.TWaverConst;
import twaver.VisibleFilter;
import twaver.network.TNetwork;
import twaver.network.background.ImageBackground;
import twaver.swing.TableLayout;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;

public class PopulationDemo extends JPanel {

    static {
        TUIManager.registerAttachment("population", PopulationAttachment.class);
    }
    TDataBox box = new TDataBox();
    TNetwork network = new TNetwork(box);
    DataBoxQuickFinder finder = box.createJavaBeanFinder(TWaverConst.PROPERTYNAME_NAME);
    ImageBackground background = new ImageBackground("/free/test/usa.gif");

    public PopulationDemo() {
        this.setLayout(new BorderLayout());
        this.add(network, BorderLayout.CENTER);
        network.getToolbar().setBorder(null);

        // parse state elements
        try {
            box.parse("/free/test/population.xml");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // set background
        background.setTextureURL("/free/test/background.png");
        network.setBackground(background);

        createInternalFrame("ControlPane", network, createControlPane());

        box.addElementPropertyChangeListener(new PropertyChangeProcessor(network));

        // init data
        init("Alabama", 4447100d, 4527166d, 4596330d, 4663111d, 4728915d, 4800092d, 4874243d);
        init("Alaska", 626932d, 661110d, 694109d, 732544d, 774421d, 820881d, 867674d);
        init("Arizona", 5130632d, 5868004d, 6637381d, 7495238d, 8456448d, 9531537d, 10712397d);
        init("Arkansas", 2673400d, 2777007d, 2875039d, 2968913d, 3060219d, 3151005d, 3240208d);
        init("California", 33871648d, 36038859d, 38067134d, 40123232d, 42206743d, 44305177d, 46444861d);
        init("Colorado", 4301261d, 4617962d, 4831554d, 5049493d, 5278867d, 5522803d, 5792357d);
        init("Connecticut", 3405565d, 3503185d, 3577490d, 3635414d, 3675650d, 3691016d, 3688630d);
        init("Delaware", 783600d, 836687d, 884342d, 927400d, 963209d, 990694d, 1012658d);
        init("Dist of Columbia", 572059d, 551136d, 529785d, 506323d, 480540d, 455108d, 433414d);
        init("Florida", 15982378d, 17509827d, 19251691d, 21204132d, 23406525d, 25912458d, 28685769d);
        init("Georgia", 8186453d, 8925796d, 9589080d, 10230578d, 10843753d, 11438622d, 12017838d);
        init("Hawaii", 1211537d, 1276552d, 1340674d, 1385952d, 1412373d, 1438720d, 1466046d);
        init("Idaho", 1293953d, 1407060d, 1517291d, 1630045d, 1741333d, 1852627d, 1969624d);
        init("Illinois", 12419293d, 12699336d, 12916894d, 13097218d, 13236720d, 13340507d, 13432892d);
        init("Indiana", 6080485d, 6249617d, 6392139d, 6517631d, 6627008d, 6721322d, 6810108d);
        init("Iowa", 2926324d, 2973700d, 3009907d, 3026380d, 3020496d, 2993222d, 2955172d);
        init("Kansas", 2688418d, 2751509d, 2805470d, 2852690d, 2890566d, 2919002d, 2940084d);
        init("Kentucky", 4041769d, 4163360d, 4265117d, 4351188d, 4424431d, 4489662d, 4554998d);
        init("Louisiana", 4468976d, 4534310d, 4612679d, 4673721d, 4719160d, 4762398d, 4802633d);
        init("Maine", 1274923d, 1318557d, 1357134d, 1388878d, 1408665d, 1414402d, 1411097d);
        init("Maryland", 5296486d, 5600563d, 5904970d, 6208392d, 6497626d, 6762732d, 7022251d);
        init("Mass", 6349097d, 6518868d, 6649441d, 6758580d, 6855546d, 6938636d, 7012009d);
        init("Michigan", 9938444d, 10207421d, 10428683d, 10599122d, 10695993d, 10713730d, 10694172d);
        init("Minnesota", 4919479d, 5174743d, 5420636d, 5668211d, 5900769d, 6108787d, 6306130d);
        init("Mississippi", 2844658d, 2915696d, 2971412d, 3014409d, 3044812d, 3069420d, 3092410d);
        init("Missouri", 5595211d, 5765166d, 5922078d, 6069556d, 6199882d, 6315366d, 6430173d);
        init("Montana", 902195d, 933005d, 968598d, 999489d, 1022735d, 1037387d, 1044898d);
        init("Nebraska", 1711263d, 1744370d, 1768997d, 1788508d, 1802678d, 1812787d, 1820247d);
        init("Nevada", 1998257d, 2352086d, 2690531d, 3058190d, 3452283d, 3863298d, 4282102d);
        init("New Hampshire", 1235786d, 1314821d, 1385560d, 1456679d, 1524751d, 1586348d, 1646471d);
        init("New Jersey", 8414350d, 8745279d, 9018231d, 9255769d, 9461635d, 9636644d, 9802440d);
        init("New Mexico", 1819046d, 1902057d, 1980225d, 2041539d, 2084341d, 2106584d, 2099708d);
        init("New York", 18976457d, 19258082d, 19443672d, 19546699d, 19576920d, 19540179d, 19477429d);
        init("North Carolina", 8049313d, 8702410d, 9345823d, 10010770d, 10709289d, 11449153d, 12227739d);
        init("North Dakota", 642200d, 635468d, 636623d, 635133d, 630112d, 620777d, 606566d);
        init("Ohio", 11353140d, 11477557d, 11576181d, 11635446d, 11644058d, 11605738d, 11550528d);
        init("Oklahoma", 3450654d, 3521379d, 3591516d, 3661694d, 3735690d, 3820994d, 3913251d);
        init("Oregon", 3421399d, 3596083d, 3790996d, 4012924d, 4260393d, 4536418d, 4833918d);
        init("Pennsylvania", 12281054d, 12426603d, 12584487d, 12710938d, 12787354d, 12801945d, 12768184d);
        init("Rhode Island", 1048319d, 1086575d, 1116652d, 1139543d, 1154230d, 1157855d, 1152941d);
        init("South Carolina", 4012012d, 4239310d, 4446704d, 4642137d, 4822577d, 4989550d, 5148569d);
        init("South Dakota", 754844d, 771803d, 786399d, 796954d, 801939d, 801845d, 800462d);
        init("Tennessee", 5689283d, 5965317d, 6230852d, 6502017d, 6780670d, 7073125d, 7380634d);
        init("Texas", 20851820d, 22775044d, 24648888d, 26585801d, 28634896d, 30865134d, 33317744d);
        init("Utah", 2233169d, 2417998d, 2595013d, 2783040d, 2990094d, 3225680d, 3485367d);
        init("Vermont", 608827d, 630979d, 652512d, 673169d, 690686d, 703288d, 711867d);
        init("Virginia", 7078515d, 7552581d, 8010245d, 8466864d, 8917395d, 9364304d, 9825019d);
        init("Washington", 5894121d, 6204632d, 6541963d, 6950610d, 7432136d, 7996400d, 8624801d);
        init("West Virginia", 1808344d, 1818887d, 1829141d, 1822758d, 1801112d, 1766435d, 1719959d);
        init("Wisconsin", 5363675d, 5554343d, 5727426d, 5882760d, 6004954d, 6088374d, 6150764d);
        init("Wyoming", 493782d, 507268d, 519886d, 528005d, 530948d, 529031d, 522979d);

    }

    private static JInternalFrame createInternalFrame(String title, TNetwork network, JComponent mainPane) {
        JInternalFrame frame = new JInternalFrame();
        frame.getContentPane().add(mainPane);
        frame.setTitle(title);
        frame.pack();
        frame.setLocation(30, 30);
        frame.setVisible(true);
        network.getLayeredPane().add(frame, 0);
        return frame;
    }

    private JPanel createControlPane() {
        final JTextField quickSearch = new JTextField();
        final JSlider pSlider = new JSlider(0, 35, 0);
        final JLabel pLabel = new JLabel(pSlider.getValue() + "  million");
        final JSlider bSlider = new JSlider(0, 100, 100);
        final JLabel bLabel = new JLabel("background 1");
        final JSlider eSlider = new JSlider(0, 100, 100);
        final JLabel eLabel = new JLabel("element 1");
        final JCheckBox movable = new JCheckBox("Enable Moving Node");

        pSlider.setPaintLabels(true);
        pSlider.setPaintTicks(true);
        pSlider.setMinorTickSpacing(1);
        pSlider.setMajorTickSpacing(5);
        pSlider.setSnapToTicks(true);

        double[] rows = new double[]{TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED,};
        double[] columns = new double[]{TableLayout.PREFERRED, TableLayout.FILL,};

        TableLayout layout = new TableLayout(columns, rows);
        layout.setVGap(2);
        layout.setHGap(2);
        JPanel controlPane = new JPanel(layout);
        controlPane.add(new JLabel("Quick Search"), "0,0");
        controlPane.add(quickSearch, "1,0");
        controlPane.add(pLabel, "0,1");
        controlPane.add(pSlider, "1,1");
        controlPane.add(bLabel, "0,2");
        controlPane.add(bSlider, "1,2");
        controlPane.add(eLabel, "0,3");
        controlPane.add(eSlider, "1,3");
        controlPane.add(movable, "1,4");
        controlPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        quickSearch.addKeyListener(new KeyAdapter() {

            public void keyReleased(KeyEvent e) {
                box.getSelectionModel().clearSelection();
                final String text = quickSearch.getText();
                if (text != null && !text.trim().equals("")) {
                    final List elements = new ArrayList();
                    box.iterator(new ElementCallbackHandler() {

                        public boolean processElement(Element element) {
                            String name = element.getName();
                            if (name != null && network.isVisible(element) && name.toLowerCase().indexOf(text.toLowerCase()) >= 0) {
                                elements.add(element);
                            }
                            return true;
                        }
                    });
                    box.getSelectionModel().setSelection(elements);
                }
            }
        });

        network.addVisibleFilter(new VisibleFilter() {

            public boolean isVisible(Element element) {
                if (element instanceof StateNode) {
                    StateNode node = (StateNode) element;
                    return node.getC2000() > pSlider.getValue() * 1000000;
                } else {
                    return true;
                }
            }
        });
        network.addMovableFilter(new MovableFilter() {

            public boolean isMovable(Element element) {
                return movable.isSelected();
            }
        });
        pSlider.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                pLabel.setText(pSlider.getValue() + "  million");
                network.getCanvas().repaint();
            }
        });
        eSlider.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                eLabel.setText("element " + TWaverConst.DEFAULT_DOUBLE_FORMATER.format(eSlider.getValue() / 100f));
                final Float alpha = new Float(eSlider.getValue() / 100f);
                box.iterator(new ElementCallbackHandler() {

                    public boolean processElement(Element element) {
                        element.putClientProperty(TWaverConst.PROPERTYNAME_RENDER_ALPHA, alpha);
                        return true;
                    }
                });
            }
        });
        bSlider.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                bLabel.setText("background " + TWaverConst.DEFAULT_DOUBLE_FORMATER.format(bSlider.getValue() / 100f));
                background.setAlpha(bSlider.getValue() / 100f);
                network.getCanvas().repaint();
            }
        });

        return controlPane;
    }

    private void init(String stateName, double c2000, double p2005, double p2010, double p2015, double p2020, double p2025, double p2030) {
        StateNode node = (StateNode) finder.findFirst(stateName);
        node.putChartColor(Color.ORANGE);
        node.putChartInflexionStyle(TWaverConst.INFLEXION_STYLE_CIRCLE);
        node.init(c2000, p2005, p2010, p2015, p2020, p2025, p2030);
    }
}

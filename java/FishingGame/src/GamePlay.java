import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePlay extends JPanel implements KeyListener, ActionListener, MouseListener {
    int playerWidth = 150;
    int playerHeight = 150;
    int posX = 450;
    int posY = 900;
    int speedX = 10;
    int speedY = 10;
    int force = -1;
    private int DELAY = 40;
    private int sIndex = 0;
    private int rIndex = 0;
    private int silverIndex = 0;
    private int copperIndex = 0;
    private int goldIndex = 0;
    private int boatIndex = 0;
    private int tipIndex = 0;
    private int goalIndex = 0;
    private int splashIndex = 0;
    private int clickWaterIndex = 0;
    private int holdIndex = 0;
    private int pressXIndex = 0;
    private int plus20Index = 0;
    private int plus10Index = 0;
    private int plus30Index = 0;
    private int plus20posX;
    private int plus20posY;
    private int plus10posX;
    private int plus10posY;
    private int plus30posX;
    private int plus30posY;
    private int rodposX = 450;
    private int rodposY = 900;
    private int silverPosX = 800;
    private int silverPosY = 600;
    private int silverSpeedX = 4;
    private int copperPosX = 800;
    private int copperPosY = 130;
    private int copperSpeedX = 3;
    private int goldPosX = 800;
    private int goldPosY = 350;
    private int goldSpeedX = 2;
    private int tipPosX = -50;
    private int tipPosY = -50;
    private int loadPosX = 40;
    private int loadPosY = 400;
    private int goalPosX = 0;
    private int goalpoxY = 0;
    private int splashPosX = 0;
    private int splashPosY = 0;
    private int clickWposX = 0;
    private int clickWposY = 200;
    private int holdPosX = 0;
    private int holdPoxY = 200;
    private int pressxPosX = 0;
    private int pressxPosY = 200;
    private int goldWorth = 30;
    private int silverWorth = 20;
    private int copperWorth = 10;
    private int rightArrowPosX = 750;
    private int rightArrowPosY = 850;
    private int leftArrowPoxX = 100;
    private int leftArrowPosY = 850;
    private Image player = (new ImageIcon("player.png")).getImage();
    private Image o1 = (new ImageIcon("ocean0001.png")).getImage();
    private Image o2 = (new ImageIcon("ocean0002.png")).getImage();
    private Image o3 = (new ImageIcon("ocean0003.png")).getImage();
    private Image o4 = (new ImageIcon("ocean0004.png")).getImage();
    private Image o5 = (new ImageIcon("ocean0005.png")).getImage();
    private Image o6 = (new ImageIcon("ocean0006.png")).getImage();
    private Image o7 = (new ImageIcon("ocean0007.png")).getImage();
    private Image o8 = (new ImageIcon("ocean0008.png")).getImage();
    private Image o9 = (new ImageIcon("ocean0009.png")).getImage();
    private Image o10 = (new ImageIcon("ocean0010.png")).getImage();
    private Image o11 = (new ImageIcon("ocean0011.png")).getImage();
    private Image o12 = (new ImageIcon("ocean0012.png")).getImage();
    private Image o13 = (new ImageIcon("ocean0013.png")).getImage();
    private Image o14 = (new ImageIcon("ocean0014.png")).getImage();
    private Image o15 = (new ImageIcon("ocean0015.png")).getImage();
    private Image o16 = (new ImageIcon("ocean0016.png")).getImage();
    private Image o17 = (new ImageIcon("ocean0017.png")).getImage();
    private Image o18 = (new ImageIcon("ocean0018.png")).getImage();
    private Image o19 = (new ImageIcon("ocean0019.png")).getImage();
    private Image o20 = (new ImageIcon("ocean0020.png")).getImage();
    private Image o21 = (new ImageIcon("ocean0021.png")).getImage();
    private Image r01 = (new ImageIcon("r0001.png")).getImage();
    private Image r02 = (new ImageIcon("r0002.png")).getImage();
    private Image r03 = (new ImageIcon("r0003.png")).getImage();
    private Image r04 = (new ImageIcon("r0004.png")).getImage();
    private Image r05 = (new ImageIcon("r0005.png")).getImage();
    private Image r06 = (new ImageIcon("r0006.png")).getImage();
    private Image r07 = (new ImageIcon("r0007.png")).getImage();
    private Image r08 = (new ImageIcon("r0008.png")).getImage();
    private Image r09 = (new ImageIcon("r0009.png")).getImage();
    private Image r10 = (new ImageIcon("r0010.png")).getImage();
    private Image r11 = (new ImageIcon("r0011.png")).getImage();
    private Image r12 = (new ImageIcon("r0012.png")).getImage();
    private Image r13 = (new ImageIcon("r0013.png")).getImage();
    private Image r14 = (new ImageIcon("r0014.png")).getImage();
    private Image r15 = (new ImageIcon("r0015.png")).getImage();
    private Image r16 = (new ImageIcon("r0016.png")).getImage();
    private Image r17 = (new ImageIcon("r0017.png")).getImage();
    private Image r18 = (new ImageIcon("r0018.png")).getImage();
    private Image r19 = (new ImageIcon("r0019.png")).getImage();
    private Image r20 = (new ImageIcon("r0020.png")).getImage();
    private Image r21 = (new ImageIcon("r0021.png")).getImage();
    private Image r22 = (new ImageIcon("r0022.png")).getImage();
    private Image r23 = (new ImageIcon("r0023.png")).getImage();
    private Image r24 = (new ImageIcon("r0024.png")).getImage();
    private Image silver01 = (new ImageIcon("silver0001.png")).getImage();
    private Image silver02 = (new ImageIcon("silver0002.png")).getImage();
    private Image silver03 = (new ImageIcon("silver0003.png")).getImage();
    private Image silver04 = (new ImageIcon("silver0004.png")).getImage();
    private Image silver05 = (new ImageIcon("silver0005.png")).getImage();
    private Image silver06 = (new ImageIcon("silver0006.png")).getImage();
    private Image silver07 = (new ImageIcon("silver0007.png")).getImage();
    private Image silver08 = (new ImageIcon("silver0008.png")).getImage();
    private Image silver09 = (new ImageIcon("silver0009.png")).getImage();
    private Image silver10 = (new ImageIcon("silver0010.png")).getImage();
    private Image copper01 = (new ImageIcon("copper0001.png")).getImage();
    private Image copper02 = (new ImageIcon("copper0002.png")).getImage();
    private Image copper03 = (new ImageIcon("copper0003.png")).getImage();
    private Image copper04 = (new ImageIcon("copper0004.png")).getImage();
    private Image copper05 = (new ImageIcon("copper0005.png")).getImage();
    private Image copper06 = (new ImageIcon("copper0006.png")).getImage();
    private Image copper07 = (new ImageIcon("copper0007.png")).getImage();
    private Image copper08 = (new ImageIcon("copper0008.png")).getImage();
    private Image copper09 = (new ImageIcon("copper0009.png")).getImage();
    private Image copper10 = (new ImageIcon("copper0010.png")).getImage();
    private Image gold01 = (new ImageIcon("gold0001.png")).getImage();
    private Image gold02 = (new ImageIcon("gold0002.png")).getImage();
    private Image gold03 = (new ImageIcon("gold0003.png")).getImage();
    private Image gold04 = (new ImageIcon("gold0004.png")).getImage();
    private Image gold05 = (new ImageIcon("gold0005.png")).getImage();
    private Image gold06 = (new ImageIcon("gold0006.png")).getImage();
    private Image gold07 = (new ImageIcon("gold0007.png")).getImage();
    private Image gold08 = (new ImageIcon("gold0008.png")).getImage();
    private Image gold09 = (new ImageIcon("gold0009.png")).getImage();
    private Image gold10 = (new ImageIcon("gold0010.png")).getImage();
    private Image boat01 = (new ImageIcon("boat0001.png")).getImage();
    private Image boat02 = (new ImageIcon("boat0002.png")).getImage();
    private Image boat03 = (new ImageIcon("boat0003.png")).getImage();
    private Image boat04 = (new ImageIcon("boat0004.png")).getImage();
    private Image boat05 = (new ImageIcon("boat0005.png")).getImage();
    private Image boat06 = (new ImageIcon("boat0006.png")).getImage();
    private Image boat07 = (new ImageIcon("boat0007.png")).getImage();
    private Image boat08 = (new ImageIcon("boat0008.png")).getImage();
    private Image boat09 = (new ImageIcon("boat0009.png")).getImage();
    private Image boat10 = (new ImageIcon("boat0010.png")).getImage();
    private Image tip01 = (new ImageIcon("float0001.png")).getImage();
    private Image tip02 = (new ImageIcon("float0002.png")).getImage();
    private Image tip03 = (new ImageIcon("float0003.png")).getImage();
    private Image tip04 = (new ImageIcon("float0004.png")).getImage();
    private Image tip05 = (new ImageIcon("float0005.png")).getImage();
    private Image tip06 = (new ImageIcon("float0006.png")).getImage();
    private Image tip07 = (new ImageIcon("float0007.png")).getImage();
    private Image tip08 = (new ImageIcon("float0008.png")).getImage();
    private Image tip09 = (new ImageIcon("float0009.png")).getImage();
    private Image tip10 = (new ImageIcon("float0010.png")).getImage();
    private Image loading01 = (new ImageIcon("load0001.png")).getImage();
    private Image loading02 = (new ImageIcon("load0002.png")).getImage();
    private Image loading03 = (new ImageIcon("load0003.png")).getImage();
    private Image loading04 = (new ImageIcon("load0004.png")).getImage();
    private Image loading05 = (new ImageIcon("load0005.png")).getImage();
    private Image loading06 = (new ImageIcon("load0006.png")).getImage();
    private Image loading07 = (new ImageIcon("load0007.png")).getImage();
    private Image loading08 = (new ImageIcon("load0008.png")).getImage();
    private Image loading09 = (new ImageIcon("load0009.png")).getImage();
    private Image loading10 = (new ImageIcon("load0010.png")).getImage();
    private Image loading11 = (new ImageIcon("load0011.png")).getImage();
    private Image loading12 = (new ImageIcon("load0012.png")).getImage();
    private Image loading13 = (new ImageIcon("load0013.png")).getImage();
    private Image loading14 = (new ImageIcon("load0014.png")).getImage();
    private Image loading15 = (new ImageIcon("load0015.png")).getImage();
    private Image loading16 = (new ImageIcon("load0016.png")).getImage();
    private Image loading17 = (new ImageIcon("load0017.png")).getImage();
    private Image loading18 = (new ImageIcon("load0018.png")).getImage();
    private Image loading19 = (new ImageIcon("load0019.png")).getImage();
    private Image loading20 = (new ImageIcon("load0020.png")).getImage();
    private Image goal01 = (new ImageIcon("goal0001.png")).getImage();
    private Image goal02 = (new ImageIcon("goal0002.png")).getImage();
    private Image goal03 = (new ImageIcon("goal0003.png")).getImage();
    private Image goal04 = (new ImageIcon("goal0004.png")).getImage();
    private Image goal05 = (new ImageIcon("goal0005.png")).getImage();
    private Image goal06 = (new ImageIcon("goal0006.png")).getImage();
    private Image goal07 = (new ImageIcon("goal0007.png")).getImage();
    private Image goal08 = (new ImageIcon("goal0008.png")).getImage();
    private Image goal09 = (new ImageIcon("goal0009.png")).getImage();
    private Image goal10 = (new ImageIcon("goal0010.png")).getImage();
    private Image clickWater01 = (new ImageIcon("clickWater0001.png")).getImage();
    private Image clickWater02 = (new ImageIcon("clickWater0002.png")).getImage();
    private Image clickWater03 = (new ImageIcon("clickWater0003.png")).getImage();
    private Image clickWater04 = (new ImageIcon("clickWater0004.png")).getImage();
    private Image clickWater05 = (new ImageIcon("clickWater0005.png")).getImage();
    private Image clickWater06 = (new ImageIcon("clickWater0006.png")).getImage();
    private Image clickWater07 = (new ImageIcon("clickWater0007.png")).getImage();
    private Image clickWater08 = (new ImageIcon("clickWater0008.png")).getImage();
    private Image clickWater09 = (new ImageIcon("clickWater0009.png")).getImage();
    private Image clickWater10 = (new ImageIcon("clickWater0010.png")).getImage();
    private Image hold01 = (new ImageIcon("holdZ0001.png")).getImage();
    private Image hold02 = (new ImageIcon("holdZ0002.png")).getImage();
    private Image hold03 = (new ImageIcon("holdZ0003.png")).getImage();
    private Image hold04 = (new ImageIcon("holdZ0004.png")).getImage();
    private Image hold05 = (new ImageIcon("holdZ0005.png")).getImage();
    private Image hold06 = (new ImageIcon("holdZ0006.png")).getImage();
    private Image hold07 = (new ImageIcon("holdZ0007.png")).getImage();
    private Image hold08 = (new ImageIcon("holdZ0008.png")).getImage();
    private Image hold09 = (new ImageIcon("holdZ0009.png")).getImage();
    private Image hold10 = (new ImageIcon("holdZ0010.png")).getImage();
    private Image pressx01 = (new ImageIcon("pressx0001.png")).getImage();
    private Image pressx02 = (new ImageIcon("pressx0002.png")).getImage();
    private Image pressx03 = (new ImageIcon("pressx0003.png")).getImage();
    private Image pressx04 = (new ImageIcon("pressx0004.png")).getImage();
    private Image pressx05 = (new ImageIcon("pressx0005.png")).getImage();
    private Image pressx06 = (new ImageIcon("pressx0006.png")).getImage();
    private Image pressx07 = (new ImageIcon("pressx0007.png")).getImage();
    private Image pressx08 = (new ImageIcon("pressx0008.png")).getImage();
    private Image pressx09 = (new ImageIcon("pressx0009.png")).getImage();
    private Image pressx10 = (new ImageIcon("pressx0010.png")).getImage();
    private Image plus20s01 = (new ImageIcon("20plus0001.png")).getImage();
    private Image plus20s02 = (new ImageIcon("20plus0002.png")).getImage();
    private Image plus20s03 = (new ImageIcon("20plus0003.png")).getImage();
    private Image plus20s04 = (new ImageIcon("20plus0004.png")).getImage();
    private Image plus20s05 = (new ImageIcon("20plus0005.png")).getImage();
    private Image plus20s06 = (new ImageIcon("20plus0006.png")).getImage();
    private Image plus20s07 = (new ImageIcon("20plus0007.png")).getImage();
    private Image plus20s08 = (new ImageIcon("20plus0008.png")).getImage();
    private Image plus20s09 = (new ImageIcon("20plus0009.png")).getImage();
    private Image plus20s10 = (new ImageIcon("20plus0010.png")).getImage();
    private Image plus10s01 = (new ImageIcon("10plus0001.png")).getImage();
    private Image plus10s02 = (new ImageIcon("10plus0002.png")).getImage();
    private Image plus10s03 = (new ImageIcon("10plus0003.png")).getImage();
    private Image plus10s04 = (new ImageIcon("10plus0004.png")).getImage();
    private Image plus10s05 = (new ImageIcon("10plus0005.png")).getImage();
    private Image plus10s06 = (new ImageIcon("10plus0006.png")).getImage();
    private Image plus10s07 = (new ImageIcon("10plus0007.png")).getImage();
    private Image plus10s08 = (new ImageIcon("10plus0008.png")).getImage();
    private Image plus10s09 = (new ImageIcon("10plus0009.png")).getImage();
    private Image plus10s10 = (new ImageIcon("10plus0010.png")).getImage();
    private Image plus30s01 = (new ImageIcon("30plus0001.png")).getImage();
    private Image plus30s02 = (new ImageIcon("30plus0002.png")).getImage();
    private Image plus30s03 = (new ImageIcon("30plus0003.png")).getImage();
    private Image plus30s04 = (new ImageIcon("30plus0004.png")).getImage();
    private Image plus30s05 = (new ImageIcon("30plus0005.png")).getImage();
    private Image plus30s06 = (new ImageIcon("30plus0006.png")).getImage();
    private Image plus30s07 = (new ImageIcon("30plus0007.png")).getImage();
    private Image plus30s08 = (new ImageIcon("30plus0008.png")).getImage();
    private Image plus30s09 = (new ImageIcon("30plus0009.png")).getImage();
    private Image plus30s10 = (new ImageIcon("30plus0010.png")).getImage();
    private Image rightarrow = (new ImageIcon("rightarrow.png")).getImage();
    private Image leftarrow = (new ImageIcon("leftarrow.png")).getImage();
    private Image loadDefault = (new ImageIcon("loadDefault.png")).getImage();
    private Image f01 = (new ImageIcon("floordown.png")).getImage();
    private Image fl01 = (new ImageIcon("floorleft.png")).getImage();
    private Image fc01 = (new ImageIcon("floorcorner.png")).getImage();
    private Image[] silverArr;
    private Image[] copperArr;
    private Image[] goldArr;
    private Image[] bg;
    private Image[] rod;
    private Image[] boatArr;
    private Image[] tip;
    private Image[] loading;
    private Image[] goal;
    private Image[] clickWater;
    private Image[] hold;
    private Image[] pressx;
    private Image[] plus20;
    private Image[] plus10;
    private Image[] plus30;
    private Image newImage;
    private int i;
    private Timer timer;
    private boolean firsttime;
    private boolean startFishing;
    private int squareDiameter;
    private int rodSquareDiameter;
    private int pullingForceToBoat;
    private int pullingForceToRod;
    private int maxThrowX;
    private int maxThrowY;
    private int loadingIndex;
    private int power;
    private boolean thrown;
    private boolean charging;
    private boolean readyToLoad;
    private boolean markedDown;
    private static int points = 0;
    private static int balance = 0;
    private boolean pullingGold;
    private boolean pullingSilver;
    private boolean pullingCopper;
    private boolean startSplash;
    private boolean displayClickWater;
    private boolean displayHold;
    private boolean displayPressX;
    private boolean showPlus20;
    private boolean showPlus10;
    private boolean showPlus30;
    private boolean keepPressX;
    private boolean keepHoldZ;
    private boolean keepClickWater;
    private boolean start;

    public GamePlay() {
        this.silverArr = new Image[]{this.silver01, this.silver02, this.silver03, this.silver04, this.silver05, this.silver06, this.silver07, this.silver08, this.silver09, this.silver10};
        this.copperArr = new Image[]{this.copper01, this.copper02, this.copper03, this.copper04, this.copper05, this.copper06, this.copper07, this.copper08, this.copper09, this.copper10};
        this.goldArr = new Image[]{this.gold01, this.gold02, this.gold03, this.gold04, this.gold05, this.gold06, this.gold07, this.gold08, this.gold09, this.gold10};
        this.bg = new Image[]{this.o1, this.o2, this.o3, this.o4, this.o5, this.o5, this.o6, this.o7, this.o8, this.o9, this.o10, this.o11, this.o12, this.o13, this.o14, this.o15, this.o16, this.o17, this.o18, this.o19, this.o20, this.o21};
        this.rod = new Image[]{this.r01, this.r02, this.r03, this.r04, this.r05, this.r06, this.r07, this.r08, this.r09, this.r10, this.r11, this.r12, this.r13, this.r14, this.r15, this.r16, this.r17, this.r18, this.r19, this.r20, this.r21, this.r22, this.r23, this.r24};
        this.boatArr = new Image[]{this.boat01, this.boat02, this.boat03, this.boat04, this.boat05, this.boat06, this.boat07, this.boat08, this.boat09, this.boat10};
        this.tip = new Image[]{this.tip01, this.tip02, this.tip03, this.tip04, this.tip05, this.tip06, this.tip07, this.tip08, this.tip09, this.tip10};
        this.loading = new Image[]{this.loading01, this.loading02, this.loading03, this.loading04, this.loading05, this.loading06, this.loading07, this.loading08, this.loading09, this.loading10, this.loading11, this.loading12, this.loading13, this.loading14, this.loading15, this.loading16, this.loading17, this.loading18, this.loading19, this.loading20};
        this.goal = new Image[]{this.goal01, this.goal02, this.goal03, this.goal04, this.goal05, this.goal06, this.goal07, this.goal08, this.goal09, this.goal10};
        this.clickWater = new Image[]{this.clickWater01, this.clickWater02, this.clickWater03, this.clickWater04, this.clickWater05, this.clickWater06, this.clickWater07, this.clickWater08, this.clickWater09, this.clickWater10};
        this.hold = new Image[]{this.hold01, this.hold02, this.hold03, this.hold04, this.hold05, this.hold06, this.hold07, this.hold08, this.hold09, this.hold10};
        this.pressx = new Image[]{this.pressx01, this.pressx02, this.pressx03, this.pressx04, this.pressx05, this.pressx06, this.pressx07, this.pressx08, this.pressx09, this.pressx10};
        this.plus20 = new Image[]{this.plus20s01, this.plus20s02, this.plus20s03, this.plus20s03, this.plus20s04, this.plus20s05, this.plus20s06, this.plus20s07, this.plus20s08, this.plus20s09, this.plus20s10};
        this.plus10 = new Image[]{this.plus10s01, this.plus10s02, this.plus10s03, this.plus10s03, this.plus10s04, this.plus10s05, this.plus10s06, this.plus10s07, this.plus10s08, this.plus10s09, this.plus10s10};
        this.plus30 = new Image[]{this.plus30s01, this.plus30s02, this.plus30s03, this.plus30s03, this.plus30s04, this.plus30s05, this.plus30s06, this.plus30s07, this.plus30s08, this.plus30s09, this.plus30s10};
        this.newImage = this.player.getScaledInstance(this.playerWidth, this.playerHeight, 2);
        this.i = 0;
        this.firsttime = true;
        this.startFishing = false;
        this.squareDiameter = 15;
        this.rodSquareDiameter = 20;
        this.pullingForceToBoat = -15;
        this.pullingForceToRod = -5;
        this.maxThrowX = 0;
        this.maxThrowY = 0;
        this.loadingIndex = 0;
        this.power = 1;
        this.thrown = false;
        this.charging = false;
        this.readyToLoad = false;
        this.markedDown = false;
        this.pullingGold = false;
        this.pullingSilver = false;
        this.pullingCopper = false;
        this.startSplash = false;
        this.displayClickWater = true;
        this.displayHold = false;
        this.displayPressX = false;
        this.showPlus20 = false;
        this.showPlus10 = false;
        this.showPlus30 = false;
        this.keepPressX = false;
        this.keepHoldZ = false;
        this.keepClickWater = false;
        this.start = false;
        this.timer = new Timer(this.DELAY, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GamePlay.this.i++;
                GamePlay.this.sIndex++;
                GamePlay.this.rIndex++;
                GamePlay.this.silverIndex++;
                GamePlay.this.copperIndex++;
                GamePlay.this.goldIndex++;
                GamePlay.this.boatIndex++;
                GamePlay.this.tipIndex++;
                if (GamePlay.this.showPlus20) {
                    GamePlay.this.plus20Index++;
                    if (GamePlay.this.plus20Index == 10) {
                        GamePlay.this.plus20Index = 0;
                        GamePlay.this.showPlus20 = false;
                    }
                }

                if (GamePlay.this.showPlus10) {
                    GamePlay.this.plus10Index++;
                    if (GamePlay.this.plus10Index == 10) {
                        GamePlay.this.plus10Index = 0;
                        GamePlay.this.showPlus10 = false;
                    }
                }

                if (GamePlay.this.showPlus30) {
                    GamePlay.this.plus30Index++;
                    if (GamePlay.this.plus30Index == 10) {
                        GamePlay.this.plus30Index = 0;
                        GamePlay.this.showPlus30 = false;
                    }
                }

                if (GamePlay.this.startSplash) {
                    GamePlay.this.splashIndex++;
                    if (GamePlay.this.splashIndex == 20) {
                        GamePlay.this.splashIndex = 0;
                        GamePlay.this.startSplash = false;
                    }
                }

                if (GamePlay.this.displayHold) {
                    GamePlay.this.holdIndex++;
                    if (GamePlay.this.holdIndex == 10) {
                        GamePlay.this.keepHoldZ = true;
                        GamePlay.this.displayHold = false;
                        GamePlay.this.holdIndex = 0;
                    }
                }

                if (GamePlay.this.displayPressX) {
                    GamePlay.this.pressXIndex++;
                    if (GamePlay.this.pressXIndex == 10) {
                        GamePlay.this.pressXIndex = 0;
                        GamePlay.this.keepPressX = true;
                        GamePlay.this.displayPressX = false;
                    }
                }

                if (GamePlay.this.markedDown) {
                    GamePlay.this.goalIndex++;
                    if (GamePlay.this.goalIndex == 10) {
                        GamePlay.this.goalIndex = 0;
                    }
                }

                if (GamePlay.this.tipIndex == 10) {
                    GamePlay.this.tipIndex = 0;
                }

                if (GamePlay.this.rodposX > GamePlay.this.posX + GamePlay.this.squareDiameter / 2) {
                    GamePlay.this.rodposX = GamePlay.this.rodposX + GamePlay.this.pullingForceToBoat;
                }

                if (GamePlay.this.rodposX < GamePlay.this.posX - GamePlay.this.squareDiameter / 2) {
                    GamePlay.this.rodposX = GamePlay.this.rodposX - GamePlay.this.pullingForceToBoat;
                }

                if (GamePlay.this.rodposY > GamePlay.this.posY + GamePlay.this.squareDiameter / 2) {
                    GamePlay.this.rodposY = GamePlay.this.rodposY + GamePlay.this.pullingForceToBoat;
                }

                if (GamePlay.this.rodposY < GamePlay.this.posY - GamePlay.this.squareDiameter / 2) {
                    GamePlay.this.rodposY = GamePlay.this.rodposY - GamePlay.this.pullingForceToBoat;
                }

                if (GamePlay.this.startFishing) {
                    if (GamePlay.this.tipPosX > GamePlay.this.rodposX + GamePlay.this.rodSquareDiameter / 2) {
                        GamePlay.this.tipPosX = GamePlay.this.tipPosX + GamePlay.this.pullingForceToRod;
                    }

                    if (GamePlay.this.tipPosX < GamePlay.this.rodposX - GamePlay.this.rodSquareDiameter / 2) {
                        GamePlay.this.tipPosX = GamePlay.this.tipPosX - GamePlay.this.pullingForceToRod;
                    }

                    if (GamePlay.this.tipPosY > GamePlay.this.rodposY - 265 + GamePlay.this.rodSquareDiameter / 2) {
                        GamePlay.this.tipPosY = GamePlay.this.tipPosY + GamePlay.this.pullingForceToRod;
                    }

                    if (GamePlay.this.tipPosY < GamePlay.this.rodposY - 265 - GamePlay.this.rodSquareDiameter / 2) {
                        GamePlay.this.tipPosY = GamePlay.this.tipPosY - GamePlay.this.pullingForceToRod;
                    }
                }

                if (GamePlay.this.tipPosX >= GamePlay.this.rodposX - GamePlay.this.rodSquareDiameter / 2 && GamePlay.this.tipPosX <= GamePlay.this.rodposX + GamePlay.this.rodSquareDiameter / 2 && GamePlay.this.tipPosY <= GamePlay.this.rodposY - 265 + GamePlay.this.rodSquareDiameter / 2 && GamePlay.this.tipPosY >= GamePlay.this.rodposY - 265 - GamePlay.this.rodSquareDiameter / 2) {
                    GamePlay.this.thrown = false;
                    GamePlay.this.startFishing = false;
                    GamePlay.this.displayClickWater = true;
                    GamePlay.this.charging = false;
                    if (!GamePlay.this.pullingGold && !GamePlay.this.pullingCopper && !GamePlay.this.pullingSilver) {
                        GamePlay.this.tipPosX = -50;
                        GamePlay.this.tipPosY = -50;
                    }

                    if (GamePlay.this.pullingSilver) {
                        GamePlay.this.showPlus20 = true;
                        GamePlay.this.plus20posX = GamePlay.this.silverPosX - 20;
                        GamePlay.this.plus20posY = GamePlay.this.silverPosY - 60;
                        GamePlay.this.tipPosX = -50;
                        GamePlay.this.tipPosY = -50;
                        GamePlay.this.pullingSilver = false;
                        GamePlay.this.IncreaseBalance((double)GamePlay.this.silverWorth);
                        GamePlay.this.silverPosX = 800;
                        GamePlay.this.silverPosY = 600;
                        System.out.println(GamePlay.points);
                    }

                    if (GamePlay.this.pullingGold) {
                        GamePlay.this.showPlus30 = true;
                        GamePlay.this.plus30posX = GamePlay.this.goldPosX - 20;
                        GamePlay.this.plus30posY = GamePlay.this.goldPosY - 60;
                        GamePlay.this.tipPosX = -50;
                        GamePlay.this.tipPosY = -50;
                        GamePlay.this.pullingGold = false;
                        GamePlay.this.IncreaseBalance((double)GamePlay.this.goldWorth);
                        GamePlay.this.goldPosX = 800;
                        GamePlay.this.goldPosY = 200;
                    }

                    if (GamePlay.this.pullingCopper) {
                        GamePlay.this.showPlus10 = true;
                        GamePlay.this.plus10posX = GamePlay.this.copperPosX - 20;
                        GamePlay.this.plus10posY = GamePlay.this.copperPosY - 60;
                        GamePlay.this.tipPosX = -50;
                        GamePlay.this.tipPosY = -50;
                        GamePlay.this.pullingCopper = false;
                        GamePlay.this.IncreaseBalance((double)GamePlay.this.copperWorth);
                        GamePlay.this.copperPosX = 800;
                        GamePlay.this.copperPosY = 130;
                    }
                }

                if (GamePlay.this.i == 20) {
                    GamePlay.this.i = 0;
                }

                if (GamePlay.this.sIndex == 13) {
                    GamePlay.this.sIndex = 0;
                }

                if (GamePlay.this.rIndex == 24) {
                    GamePlay.this.rIndex = 0;
                }

                if (GamePlay.this.silverIndex == 10) {
                    GamePlay.this.silverIndex = 0;
                }

                if (GamePlay.this.copperIndex == 10) {
                    GamePlay.this.copperIndex = 0;
                }

                if (GamePlay.this.goldIndex == 10) {
                    GamePlay.this.goldIndex = 0;
                }

                if (GamePlay.this.boatIndex == 10) {
                    GamePlay.this.boatIndex = 0;
                }

                GamePlay.this.tipPosX = GamePlay.this.tipPosX + GamePlay.this.force;
                if (GamePlay.this.tipPosX < 160) {
                    GamePlay.this.tipPosX = 160;
                }

                if (GamePlay.this.tipPosX > 900) {
                    GamePlay.this.tipPosX = 900;
                }

                if (GamePlay.this.posX < 160) {
                    GamePlay.this.posX = 160;
                }

                if (GamePlay.this.posX > 880) {
                    GamePlay.this.posX = 880;
                }

                if (GamePlay.this.posY > 1000) {
                    GamePlay.this.posY = 1000;
                }

                if (GamePlay.this.posY < 880) {
                    GamePlay.this.posY = 880;
                }

                if (!GamePlay.this.pullingSilver) {
                    GamePlay.this.silverPosX = GamePlay.this.silverPosX - GamePlay.this.silverSpeedX;
                    if (GamePlay.this.silverPosX < 160) {
                        GamePlay.this.silverPosX = 800;
                    }
                }

                if (!GamePlay.this.pullingCopper) {
                    GamePlay.this.copperPosX = GamePlay.this.copperPosX - GamePlay.this.copperSpeedX;
                    if (GamePlay.this.copperPosX < 160) {
                        GamePlay.this.copperPosX = 800;
                    }
                }

                if (!GamePlay.this.pullingGold) {
                    GamePlay.this.goldPosX = GamePlay.this.goldPosX - GamePlay.this.goldSpeedX;
                    if (GamePlay.this.goldPosX < 160) {
                        GamePlay.this.goldPosX = 800;
                    }
                }

                GamePlay.this.pullGold();
                GamePlay.this.pullCopper();
                GamePlay.this.pullSilver();
                GamePlay.this.repaint();
                if (GamePlay.this.displayClickWater) {
                    GamePlay.this.clickWaterIndex++;
                    if (GamePlay.this.clickWaterIndex == 10) {
                        GamePlay.this.displayClickWater = false;
                        GamePlay.this.keepClickWater = true;
                        GamePlay.this.clickWaterIndex = 0;
                    }
                }

            }
        });
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getX() < GamePlay.this.posX + GamePlay.this.squareDiameter / 2 && e.getX() > GamePlay.this.posX - GamePlay.this.squareDiameter / 2 && e.getY() < GamePlay.this.posY + GamePlay.this.squareDiameter / 2 && e.getY() > GamePlay.this.posY - GamePlay.this.squareDiameter / 2) {
                    GamePlay.this.rodposX = e.getX();
                    GamePlay.this.rodposY = e.getY();
                }

                if (!GamePlay.this.thrown && e.getY() < GamePlay.this.rodposY - 250 && e.getX() > GamePlay.this.rodposX - 120 && e.getX() < GamePlay.this.rodposX + 120) {
                    GamePlay.this.keepClickWater = false;
                    GamePlay.this.displayClickWater = false;
                    GamePlay.this.displayHold = true;
                    GamePlay.this.loadingIndex = 0;
                    GamePlay.this.charging = false;
                    GamePlay.this.maxThrowX = e.getX();
                    GamePlay.this.maxThrowY = e.getY();
                    GamePlay.this.goalPosX = GamePlay.this.maxThrowX;
                    GamePlay.this.goalpoxY = GamePlay.this.maxThrowY;
                    GamePlay.this.markedDown = true;
                    GamePlay.this.readyToLoad = true;
                }

            }
        });
        this.addKeyListener(this);
        this.setFocusable(true);
    }

    public void IncreaseBalance(double b) {
        Main.processDepositFromGame(b);
    }

    public void pullGold() {
        if (this.tipPosX < this.goldPosX + 80 && this.tipPosX > this.goldPosX && this.tipPosY < this.goldPosY + 80 && this.tipPosY > this.goldPosY) {
            this.pullingGold = true;
        }

        if (this.pullingGold) {
            this.goldPosX = this.tipPosX - 40;
            this.goldPosY = this.tipPosY - 40;
        }

    }

    public void pullCopper() {
        if (this.tipPosX < this.copperPosX + 80 && this.tipPosX > this.copperPosX && this.tipPosY < this.copperPosY + 80 && this.tipPosY > this.copperPosY) {
            this.pullingCopper = true;
        }

        if (this.pullingCopper) {
            this.copperPosX = this.tipPosX - 40;
            this.copperPosY = this.tipPosY - 40;
        }

    }

    public void pullSilver() {
        if (this.tipPosX < this.silverPosX + 80 && this.tipPosX > this.silverPosX && this.tipPosY < this.silverPosY + 80 && this.tipPosY > this.silverPosY) {
            this.pullingSilver = true;
        }

        if (this.pullingSilver) {
            this.silverPosX = this.tipPosX - 40;
            this.silverPosY = this.tipPosY - 40;
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.bg[this.i], 0, 0, this);
        g.drawImage(this.rightarrow, this.rightArrowPosX - 80, this.rightArrowPosY, this);
        g.drawImage(this.leftarrow, this.leftArrowPoxX - 80, this.leftArrowPosY, this);
        g.setColor(new Color(0, 200, 255, 25));
        g.fillRect(this.posX - 100, this.posY - 250 - 1000, 200, 1000);
        g.setColor(new Color(255, 0, 0, 25));
        g.fillRect(this.posX - 100, this.posY - 250, 200, 400);
        g.drawImage(this.silverArr[this.silverIndex], this.silverPosX, this.silverPosY, this);
        g.drawImage(this.copperArr[this.copperIndex], this.copperPosX, this.copperPosY, this);
        g.drawImage(this.goldArr[this.goldIndex], this.goldPosX, this.goldPosY, this);
        g.drawImage(this.boatArr[this.boatIndex], this.posX - this.playerWidth / 2, this.posY - this.playerHeight / 2, this);
        if (this.showPlus20) {
            g.drawImage(this.plus20[this.plus20Index], this.plus20posX, this.plus20posY, this);
        }

        if (this.showPlus10) {
            g.drawImage(this.plus10[this.plus10Index], this.plus10posX, this.plus10posY, this);
        }

        if (this.showPlus30) {
            g.drawImage(this.plus30[this.plus30Index], this.plus30posX, this.plus30posY, this);
        }

        if (this.startFishing) {
            g.drawImage(this.rod[this.rIndex], this.rodposX - 32, this.rodposY - 280, this);
        } else {
            g.drawImage(this.r01, this.rodposX - 32, this.rodposY - 280, this);
        }

        if (this.thrown) {
            g.setColor(Color.black);
            g.drawImage(this.tip[this.tipIndex], this.tipPosX - 25, this.tipPosY - 25, this);
            g.drawLine(this.rodposX, this.rodposY - 265, this.tipPosX, this.tipPosY - 20);
        }

        g.drawImage(this.loading[0], this.loadPosX, this.loadPosY, this);
        if (this.charging) {
            g.drawImage(this.loading[this.loadingIndex], this.loadPosX, this.loadPosY, this);
        }

        if (this.markedDown) {
            g.drawImage(this.goal[this.goalIndex], this.goalPosX - 62, this.goalpoxY - 62, this);
        }

        if (this.displayClickWater) {
            g.drawImage(this.clickWater[this.clickWaterIndex], this.clickWposX, this.clickWposY, this);
        }

        if (this.displayHold) {
            g.drawImage(this.hold[this.holdIndex], this.holdPosX, this.holdPoxY, this);
        }

        if (this.keepHoldZ) {
            g.drawImage(this.hold[9], this.holdPosX, this.holdPoxY, this);
        }

        if (this.displayPressX) {
            g.drawImage(this.pressx[this.pressXIndex], this.pressxPosX, this.pressxPosY, this);
        }

        if (this.keepPressX) {
            g.drawImage(this.pressx[9], this.pressxPosX, this.pressxPosY, this);
        }

        if (this.keepClickWater) {
            g.drawImage(this.clickWater[9], this.clickWposX, this.clickWposY, this);
        }

        if (!this.start) {
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0, 0, 1000, 1000);
            g.setColor(Color.blue);
            g.setFont(new Font("TimesRoman", 1, 30));
            g.drawString("PRESS SPACE TO START", 300, 270);
        }

    }

    public Dimension getPreferredSize() {
        return new Dimension(1000, 1000);
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 32:
                if (this.firsttime) {
                    this.start = true;
                    this.timer.start();
                    this.firsttime = false;
                }
                break;
            case 37:
                this.posX -= this.speedX;
                break;
            case 38:
                this.posY -= this.speedY;
                break;
            case 39:
                this.posX += this.speedX;
                break;
            case 40:
                this.posY += this.speedY;
                break;
            case 67:
                if (!this.firsttime) {
                    this.startFishing = false;
                }
                break;
            case 88:
                if (this.thrown) {
                    this.keepPressX = false;
                    if (!this.firsttime) {
                        this.startFishing = true;
                    }
                }
                break;
            case 90:
                if (this.readyToLoad && !this.thrown) {
                    this.displayHold = false;
                    this.keepHoldZ = false;
                    ++this.loadingIndex;
                    ++this.power;
                    if (this.power == 21) {
                        this.power = 1;
                    }

                    if (this.loadingIndex == 20) {
                        this.loadingIndex = 0;
                    }

                    this.charging = true;
                }
        }

    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 90:
                if (!this.thrown) {
                    if (this.maxThrowX >= this.rodposX - this.rodSquareDiameter / 2 && this.maxThrowY <= this.rodposY - 265 - this.rodSquareDiameter / 2) {
                        this.tipPosX = this.rodposX - this.rodSquareDiameter / 2 + (this.maxThrowX - (this.rodposX - this.rodSquareDiameter / 2)) / 20 * this.power;
                        this.tipPosY = this.rodposY - 265 - this.rodSquareDiameter / 2 - (this.rodposY - 265 - this.rodSquareDiameter / 2 - this.maxThrowY) / 20 * this.power;
                        System.out.println(this.tipPosX);
                        System.out.println(this.tipPosY);
                    }

                    if (this.maxThrowX < this.rodposX - this.rodSquareDiameter / 2 && this.maxThrowY < this.rodposY - 265 - this.rodSquareDiameter / 2) {
                        this.tipPosX = this.rodposX - this.rodSquareDiameter / 2 - (this.rodposX - this.rodSquareDiameter / 2 - this.maxThrowX) / 20 * this.power;
                        this.tipPosY = this.rodposY - 265 - this.rodSquareDiameter / 2 - (this.rodposY - 265 - this.rodSquareDiameter / 2 - this.maxThrowY) / 20 * this.power;
                    }

                    this.power = 0;
                    this.thrown = true;
                    this.markedDown = false;
                    this.readyToLoad = false;
                    this.startSplash = true;
                    this.displayPressX = true;
                    String url = "file:splash.wav";

                    try {
                        PlaySound.myPlay(url);
                        System.out.println("sound?");
                    } catch (InterruptedException var4) {
                        System.out.println(var4);
                    }
                }
            default:
        }
    }

    public void actionPerformed(ActionEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}

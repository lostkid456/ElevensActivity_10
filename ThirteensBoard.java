import java.util.Iterator;
import java.util.List;

public class ThirteensBoard extends Board{
    //
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
    private static final int BOARD_SIZE = 10;
    private static final String[] RANKS = new String[]{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
    private static final String[] SUITS = new String[]{"spades", "hearts", "diamonds", "clubs"};
    private static final int[] POINT_VALUES = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private static final boolean I_AM_DEBUGGING = false;

    public ThirteensBoard() {
            super(10, RANKS, SUITS, POINT_VALUES);
        }
        public boolean isLegal(List<Integer> var1) {
        if (var1.size() == 2) {
            return this.containsPairSum13(var1);
        } else {
            return var1.size() == 1 ? this.containsK(var1) : false;
            }
        }

        public boolean anotherPlayIsPossible() {
            List var1 = this.cardIndexes();
            return this.containsPairSum13(var1) || this.containsK(var1);
        }

        private boolean containsPairSum13(List<Integer> var1) {
            for(int var2 = 0; var2 < var1.size(); ++var2) {
                int var3 = (Integer)var1.get(var2);

                for(int var4 = var2 + 1; var4 < var1.size(); ++var4) {
                    int var5 = (Integer)var1.get(var4);
                    if (this.cardAt(var3).pointValue() + this.cardAt(var5).pointValue() == 13) {
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean containsK(List<Integer> var1) {
            boolean var2 = false;
            Iterator var3 = var1.iterator();

            while(var3.hasNext()) {
                Integer var4 = (Integer)var3.next();
                if (this.cardAt(var4).rank().equals("king")) {
                    var2 = true;
                }
            }

            return var2;
        }
}


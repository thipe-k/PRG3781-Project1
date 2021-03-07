package ApplicationLayer;

import java.io.Serializable;

public class Decoration implements Serializable
{
   /**
    *
    */
   private static final long serialVersionUID = 5L;
   private Theme theme;
   private boolean balloons;
   private boolean candels;
   private int nrOfTables;

   public Decoration(Theme theme, boolean balloons, boolean candels, int nrOfTables) {
      this.theme = theme;
      this.balloons = balloons;
      this.candels = candels;
      this.nrOfTables = nrOfTables;
   }

   public Theme getTheme() {
      return this.theme;
   }

   public void setTheme(Theme theme) {
      this.theme = theme;
   }

   public boolean isBalloons() {
      return this.balloons;
   }

   public boolean getBalloons() {
      return this.balloons;
   }

   public void setBalloons(boolean balloons) {
      this.balloons = balloons;
   }

   public boolean isCandels() {
      return this.candels;
   }

   public boolean getCandels() {
      return this.candels;
   }

   public void setCandels(boolean candels) {
      this.candels = candels;
   }

   public int getNrOfTables() {
      return this.nrOfTables;
   }

   public void setNrOfTables(int nrOfTables) {
      this.nrOfTables = nrOfTables;
   }

   public Decoration() {
   }

   
}

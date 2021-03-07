package ApplicationLayer;
public class Decoration 
{
   private Theme theme;
   private boolean balloons;
   private boolean candels;
   private int nrOfTables;

   //theme
   public Theme GetTheme()
   {
      return this.theme;
   }

   public void SetEvent(Theme theme)
   {
      this.theme = theme;
   }

   //balloons
   public Boolean GetBalloons()
   {
      return this.balloons;
   }
   
   public void SetBalloons(boolean balloon)
   {
      this.balloons = balloon;
   }

   //candles
   public boolean GetCandles()
   {
      return this.candels;
   }

   public void SetCandles(boolean candle)
   {
      this.candels = candle;
   }

   //Tables
   public int GetTables()
   {
      return this.nrOfTables;
   }

   public void SetTables(int table)
   {
      this.nrOfTables = table;
   }
}

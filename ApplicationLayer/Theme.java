package ApplicationLayer;
public class Theme 
{
   private String color1;
   private String color2;
   private String eventTheme;

   //theme
   public String GetTheme()
   {
      return this.eventTheme;
   }

   public void SetTheme(String Etheme)
   {
      this.eventTheme = Etheme;
   }

   //color 1
   public String GetColor1()
   {
      return this.color1;
   }

   public void SetColor1(String col1)
   {
      this.color1 = col1;
   }

   //color 2
   public String GetColor2()
   {
      return this.color2;
   }

   public void SetColor2(String col2)
   {
      this.color2 = col2;
   }

}

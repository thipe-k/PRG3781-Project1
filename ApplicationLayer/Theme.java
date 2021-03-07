package ApplicationLayer;

import java.io.Serializable;

public class Theme  implements Serializable
{
   private static final long serialVersionUID = 20L;
   private String color1;
   private String color2;
   private String eventTheme;
   //the themes can also include actual theses, like a pirate theme or hawaii theme

   public Theme(String color1, String color2, String eventTheme) {
      this.color1 = color1;
      this.color2 = color2;
      this.eventTheme = eventTheme;
   }

   public Theme() {
   }

   public String getColor1() {
      return this.color1;
   }

   public void setColor1(String color1) {
      this.color1 = color1;
   }

   public String getColor2() {
      return this.color2;
   }

   public void setColor2(String color2) {
      this.color2 = color2;
   }

   public String getEventTheme() {
      return this.eventTheme;
   }

   public void setEventTheme(String eventTheme) {
      this.eventTheme = eventTheme;
   }

}

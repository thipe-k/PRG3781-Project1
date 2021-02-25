package FoodPackage;
public class Meal {
   private String _starter;
   private String _main;
   private String _desert;
   private String _drink;

   public Meal(String _starter, String _main, String _desert, String _drink) {
      this._starter = _starter;
      this._main = _main;
      this._desert = _desert;
      this._drink = _drink;
   }

   public String get_starter() {
      return this._starter;
   }

   public void set_starter(String _starter) {
      this._starter = _starter;
   }

   public String get_main() {
      return this._main;
   }

   public void set_main(String _main) {
      this._main = _main;
   }

   public String get_desert() {
      return this._desert;
   }

   public void set_desert(String _desert) {
      this._desert = _desert;
   }

   public String get_drink() {
      return this._drink;
   }

   public void set_drink(String _drink) {
      this._drink = _drink;
   }

}

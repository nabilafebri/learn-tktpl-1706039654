package id.ac.ui.cs.mobileprogramming.nabilafv.helloworld;

import java.util.HashMap;

public class RabbitsRepository {

    private String rabbits[];
    private HashMap<String, Rabbit> rabbitDetails;

    public String[] getRabbits() {
        if (rabbits == null) {
            rabbits = new String[9];
            rabbits[0] = "American Fuzzy Lop";
            rabbits[1] = "Blanc de Hotot";
            rabbits[2] = "Dutch";
            rabbits[3] = "English Angora";
            rabbits[4] = "Flemish Giant";
            rabbits[5] = "Holland Lop";
            rabbits[6] = "Lionhead";
            rabbits[7] = "Netherland Dwarf";
            rabbits[8] = "Rex";
        }
        return rabbits;
    }

    public Rabbit getRabbitDetails(String name) {
        if (rabbitDetails == null) {
            createRabbitDetailsMap();
        }
        return rabbitDetails.get(name);
    }

    public void createRabbitDetailsMap() {
        rabbitDetails = new HashMap<String, Rabbit>();

        Rabbit rabbit = new Rabbit();
        rabbit.setName("American Fuzzy Lop");
        rabbit.setPhoto(R.drawable.afl);
        rabbit.setDesc("The American Fuzzy Lop became a recognized breed in 1989. Known for its lopped ears, large head, and wooled coat, the AFL is a sweet tempered,  rabbit that is energetic and popular for beginning and seasoned exhibitors alike.");
        rabbit.setWeight("4 lbs");

        rabbitDetails.put("American Fuzzy Lop", rabbit);

        rabbit = new Rabbit();
        rabbit.setName("Blanc de Hotot");
        rabbit.setPhoto(R.drawable.bdh);
        rabbit.setDesc("Derived from Hotot-en-Auge, near the port of LeHavre in Northern France, came the name and the rabbits known as Blanc de Hotot (White of Hotot). From those humble beginnings at the turn of the 19th Century to their recognition by the ARBA in 1979, this snow white breed with the black eyeliner has enjoyed a steady and loyal following.");
        rabbit.setWeight("11 lbs");

        rabbitDetails.put("Blanc de Hotot", rabbit);

        rabbit = new Rabbit();
        rabbit.setName("Dutch");
        rabbit.setPhoto(R.drawable.dutch);
        rabbit.setDesc("Perhaps the most recognizable breed, the Dutch rabbit was developed in England during the 1830s. Breeders began selecting rabbits that bore the distinct markings that have become the hallmark of the breed we know today. Selecting for correct markings paired with type can be challenging, but the fact that the Dutch remains one of the top 10 most popular breeds, is evidence that many are up to this task.");
        rabbit.setWeight("5.5 lbs");

        rabbitDetails.put("Dutch", rabbit);

        rabbit = new Rabbit();
        rabbit.setName("English Angora");
        rabbit.setPhoto(R.drawable.ea);
        rabbit.setDesc("One of four breeds of Angora recognized by the ARBA. The English is the only breed of Angora that is classified as a compact breed. It possesses a silky, luxurious wool that is both beautiful and sought after for spinning.");
        rabbit.setWeight("7.5 lbs");

        rabbitDetails.put("English Angora", rabbit);

        rabbit = new Rabbit();
        rabbit.setName("Flemish Giant");
        rabbit.setPhoto(R.drawable.fg);
        rabbit.setDesc("Believed to have originated in Flanders, Belgium, the Flemish Giant was bred as early as the 16th Century. The breed was exported to America in the early 1890s to help improve the size of meat rabbits during the great “rabbit boom”. The docile personality of the Flemish Giant has earned it the nickname “Gentle Giant”, and its varied use as pet, show, breeding, meat, and fur have made it a universal rabbit.");
        rabbit.setWeight("over 20 lbs");

        rabbitDetails.put("Flemish Giant", rabbit);

        rabbit = new Rabbit();
        rabbit.setName("Holland Lop");
        rabbit.setPhoto(R.drawable.hl);
        rabbit.setDesc("Originally developed by Adriann de Cock of the Netherlands with the purpose of creating a dwarfed lop-eared rabbit that was smaller and easier to handle than the larger French Lop. The venture was long and challenging but ultimately, rewarding as the breed was recognized by the ARBA in 1979.  Today the Holland Lop is one of the top five most popular breeds in the ARBA. Its compact size paired with the large head and lopped ears makes it a beautiful addition to the rabbit world.");
        rabbit.setWeight("4 lbs");

        rabbitDetails.put("Holland Lop", rabbit);

        rabbit = new Rabbit();
        rabbit.setName("Lionhead");
        rabbit.setPhoto(R.drawable.lh);
        rabbit.setDesc("The most eye-catching feature of the Lionhead rabbit is the distinctive mane around its head giving it the look of a male lion, as the name implies.  While the Lionhead has only been a recognized breed in the United States since 2014, it is steadily gaining in popularity throughout the rabbit hobby. In 2018 the Lionhead roared; capturing its first ARBA Convention Best in Show!");
        rabbit.setWeight("3.75 lbs");

        rabbitDetails.put("Lionhead", rabbit);

        rabbit = new Rabbit();
        rabbit.setName("Netherland Dwarf");
        rabbit.setPhoto(R.drawable.nd);
        rabbit.setDesc("The enduring appeal of the Netherland Dwarf can be attributed to their diminutive size, variety of showable colors, and brachycephalic head. The Netherland Dwarf breed was first produced in the Netherlands in the early 20th century, and soon made its way to America. Since then their popularity has only grown and new color varieties have been recognized; bringing the total to 25.");
        rabbit.setWeight("2.5 lbs");

        rabbitDetails.put("Netherland Dwarf", rabbit);

        rabbit = new Rabbit();
        rabbit.setName("Rex");
        rabbit.setPhoto(R.drawable.rex);
        rabbit.setDesc("First shown publicly at the Paris International Rabbit Show in 1924, the Rex breed was recognized internationally as a breed to watch. Imported to the US in 1924 by John Fehr and Alfred Zimmerman. The popularity of the Rex is largely due to the mutation that produces a short, dense velvet-like quality to the fur. Today the Rex remains the number one breed used in fur production due to this unique coat quality. Today the  “King of the Rabbits” can be shown in 16 color varieties that showcase that plush and unforgettable fur.");
        rabbit.setWeight("10.5 lbs");

        rabbitDetails.put("Rex", rabbit);
    }
}

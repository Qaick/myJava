package play.spring.disinfection;
//import com.

public class Disinfectant // lol what??
{
    // what implementation?
    // how to configure?
    // TODO what was the third thing?
    private Announcer announcer = new AnnouncerImpl();

    public static void main(String[] args) {
//        ClassLoader.getSystemClassLoader();
//        ClassLoader.getPlatformClassLoader();

        new Disinfectant().disinfectRoom();
    }

    public void disinfectRoom() { // disinfect...
        announcer.announce("Disinfection of this room will start in 5 mins. Please, leave the room!");
        disinfect();
        announcer.announce("Disinfection is done. You can come in.");
    }

    private void disinfect()
    {
        System.out.println("Room being disinfected... Done.");
    }
}

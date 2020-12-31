package play.spring.disinfection;

public class AnnouncerImpl implements Announcer
{
	@Override
	public void announce(String s)
	{
		System.out.println("Announcement: " + s);
	}
}

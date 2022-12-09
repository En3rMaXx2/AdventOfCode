package days.day7;

public class File extends Element
{
    private final int size;

    public File(String name, int size)
    {
        super(name);
        this.size = size;
    }

    public int getSize()
    {
        return this.size;
    }
}
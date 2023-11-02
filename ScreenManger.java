import java.util.Stack;

public class ScreenManger {

    private Stack<Iscreen> screenStack;

    public ScreenManger()
    {
        screenStack = new Stack<>();
    }

    public void pushScreen(Iscreen newScreen)
    {
        screenStack.push( newScreen);
    }

    public Iscreen popScreen()
    {
       return screenStack.pop();
    }

    public Iscreen peekScreen()
    {
        return screenStack.peek();
    }

    public void clearScreens()
    {
        while(!screenStack.isEmpty())
        {
            screenStack.pop();
        }

    }

    public void goBack()
    {
        if(!screenStack.isEmpty())
        {
            screenStack.pop();
        }

        if(!screenStack.isEmpty())
        {
            peekScreen();
        }
    }

    public void displayStack()
    {
        for(Iscreen iscreen:screenStack)
        {
            System.out.println("Screen: " +iscreen);
        }
    }
}


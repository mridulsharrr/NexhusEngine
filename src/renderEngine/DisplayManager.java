package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

public class DisplayManager {

    private static final int Width = 1280;
    private static final int Height = 720;

    public static void createDisplay(){

        ContextAttribs attribs = new ContextAttribs(3,2);
        attribs.withForwardCompatible(true);
        attribs.withProfileCore(true);


        try {
            Display.setDisplayMode(new DisplayMode(Width,Height));
            Display.create(new PixelFormat(), attribs);
            Display.setTitle("NexhusEngine");
        } catch (LWJGLException e) {
            throw new RuntimeException(e);
        }

        GL11.glViewport(0, 0, Width, Height);

    }

    public static void updateDisplay(){
        Display.sync(120);
        Display.update();

    }

    public static void closeDisplay(){

        Display.destroy();
    }

}

package cappuccinoextraplusengine.engine;

public class GamePanel implements Runnable {

    private Thread thread;
    private Window window;
    private Renderer renderer;
    private Input input;

    public AbstractGame game;

    private boolean running = false;
    private final double update = 1.0/60.0;
    private int width, height;
    // Scale window 
    private float scale;
    private String title = "CappuccinoExtraPlusEnginev1.0";

    public GamePanel(AbstractGame game) {
        this.game = game;
    }

    public void startGame() {
        window = new Window(this);
        renderer = new Renderer(this);
        input = new Input(this);

        thread = new Thread(this);
        thread.start();
    }
    public void stopGame() {

    }
    @Override
    public void run() {
        running = true;

        boolean render;
        double firstTime;
        double lastTime = System.nanoTime() / 1000000000.0;
        double passedTime;
        double unprocessedTime = 0;

        double frameTime = 0;
        int frames = 0;
        @SuppressWarnings("unused")
        int FPS = 0;

        while (running) {
            render = false;

            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime += passedTime;
            frameTime += passedTime;

            while(unprocessedTime >= update) {
                unprocessedTime -= update;
                render = true;

                game.update(this, (float)update);

                // Input keys
                /* if (input.isKey(KeyEvent.VK_A)) {
                    // System.out.println("A is pressed!");
                } */
                // System.out.println(input.getScroll());

                input.update();

                // System.out.println("Rendering!");

                if (frameTime >= 1.0) {
                    frameTime = 0;
                    FPS = frames;
                    frames = 0;
                    // System.out.println("FPS: " + FPS); // FPS: approx. 60 
                }
            }

            if (render) {
                // Comment out renderer.clear(); for drawing with image effect 
                renderer.clear();
                game.render(this, renderer);
                renderer.process();
                // renderer.drawText("FPS:" + FPS, 0, 0, 0xff00ffff);
                window.update();
                frames++;
            }
            else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {}
            }
        }

        dispose();
    }
    public void dispose() {

    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }
}
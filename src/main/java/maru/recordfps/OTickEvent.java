package maru.recordfps;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;

import javax.swing.*;
import java.lang.reflect.Field;

public class OTickEvent {

    private long time = 0;
    private int count = 0;
    private OLineChart frame = new OLineChart();

    //Called when the server ticks. Usually 20 ticks a second.
    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {

        if (time == 0){
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBounds(10, 10, 500, 500);
            frame.setTitle("Record FPS");
            frame.setVisible(true);
        }

        if (Math.abs(System.currentTimeMillis() - time) > 1000){
            time = System.currentTimeMillis();
            count++;

            Minecraft minecraft = Minecraft.getMinecraft();

            try {
                Class<Minecraft> MClass = Minecraft.class;
                //debugFPS, field_71470_ab
                Field xNumField = MClass.getDeclaredField("field_71470_ab");
                xNumField.setAccessible(true);

                if (Minecraft.getMinecraft().getLimitFramerate() != 260) {
                    frame.data.addValue(Minecraft.getMinecraft().getLimitFramerate(), "Limit FPS", String.valueOf(count));
                }
                frame.data.addValue((double) xNumField.getInt(minecraft), "Current FPS", String.valueOf(count));
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

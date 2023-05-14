/**
package proclient.ui;

import net.lax1dude.eaglercraft.v1_8.internal.KeyboardConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import proclient.Dragon;
import proclient.module.Module;
import proclient.module.Category;

public class TabGui{

    public int current = 0;
    public boolean expanded;

    public void draw() {

        Gui.drawRect(5, 30.5, 70, 31.5+Category.values().length*16, 0x90000000);
        Gui.drawRect(7, 33+current*16, 68, 45+current*16, 0xff68159E);
        Minecraft.getMinecraft().fontRendererObj.drawString("DragonX V2", 8, 22, 0xffffffff);
        int offset = 0;
        for(Category c : Category.values()){
            Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(c.mname, 10, 35+offset, -1);
            offset += 16;
        }

        if(expanded){

            Category category = Category.values()[current];
            if(Dragon.moduleManager.modsInCategory(category).size() == 0)
                return;

            Gui.drawRect(70, 30.5, 138, 31.5+Dragon.moduleManager.modsInCategory(category).size()*16, 0x90000000);
            Gui.drawRect(70, 33+category.i*16, 136, 45+category.i*16, 0xff68159E);

            offset = 0;
            for(Module m : Dragon.moduleManager.modsInCategory(category)){
                Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(m.name, 73, 35+offset, -1);
                offset += 16;
            }
        }
    }

    public void onKey(int k){
        Category category = Category.values()[current];
        if (k ==KeyboardConstants.KEY_UP) {
            if(expanded){
                if(category.i <= 0){
                    category.i = Dragon.moduleManager.modsInCategory(category).size()-1;
                }else{
                    --category.i;
                }
            }else {
                if(current <= 0){
                    current = Category.values().length-1;
                }else {
                    --current;
                }
            }
        }
        if (k ==KeyboardConstants.KEY_DOWN) {
            if(expanded){
                if(category.i >= Dragon.moduleManager.modsInCategory(category).size() - 1){
                    category.i = 0;
                }else {
                    ++category.i;
                }
            }else {
                if(current >= Category.values().length-1){
                    current = 0;
                }else {
                    ++current;
                }
            }
        }
        if (k ==KeyboardConstants.KEY_RIGHT){
            if(expanded && Dragon.moduleManager.modsInCategory(category).size() != 0){
                Dragon.moduleManager.modsInCategory(category).get(category.i).toggle();
            }else {
                expanded = true;
            }
        }
        if (k ==KeyboardConstants.KEY_LEFT){
            expanded = false;
        }
    }
}
*/
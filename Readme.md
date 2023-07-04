
# DragonX

A Hack Client For EaglercraftX 1.8.x


## Installation

To Install This Client Or Compile it Run The Following Commands:
```bash
./CompileEPK.sh
./Gradlew teavmc
./MakeOfflineDownload.sh
```
    
## Authors

- [@FatalEagler](https://www.github.com/fataleagler)


## FAQ

#### Why Did I Get This Source?

1: I Open-Sourced The Code.

2: Peyton Got Mad At Me And Leaked It.   

#### Did You Skid Anything In This Client?

Yes, i did. Here is a list of the things that i skidded:

the module base

event system

command base

clickGUI





## Making Modules

To Make A Basic Module Do The Following:
```java
    package proclient.module.player;

    import proclient.module.Module;
    import Proclient.module.Category
    
    public class Fly extends Module {
        public Fly() {
            super("Fly", KeyboardConstants.KEY_NONE, Category.PLAYER)
        }
        
        public void onUpdate() {
            if(this.isToggled()) {
                Minecraft.getMinecraft().thePlayer.isFlying = true;
            }
        }
    }
        public void onDisable() {
            Minecraft.getMinecraft().thePlayer.isFlying = false;
        }
```


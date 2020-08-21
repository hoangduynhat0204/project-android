package com.fv.bestnh2019.repositories;


import com.fv.bestnh2019.R;
import com.fv.bestnh2019.models.Item;

import java.util.ArrayList;
import java.util.List;

public class ElementRepository {

    private int[] imageIds = {
            R.drawable.item_image1,
            R.drawable.item_image2,
            R.drawable.item_image3,
            R.drawable.item_image4,
            R.drawable.item_image5,
            R.drawable.item_image6,
    };

    private String[] titles = {
            "Ding Dong Ditch",
            "Radio",
            "Alarm Clock",
            "Telephone",
            "Fuse Box",
            "Milk"
    };

    private String[] contents = {
            "This tactic is the simplest and calls for minimal stealth in your behalf. start with the aid of the usage of ringing your neighbor's doorbell, then run decrease back indoors your property and close the door. this will have him open the front door and from this factor beforehand (so long as you aren't caught) that door might be unlocked and available. you can additionally use this tactic to draw your neighbor away from a positive part of the residence.",
            "In the bedroom with the broken window in the returned of the residence can be a radio. This object is wonderful on hand whilst trying to break into your neighbor's house. This technique is as an alternative easy due to the fact the item is quite clean to discover and pick up. Take the radio and vicinity it in a niche so as to advantage you outside your neighbor's home. flip it on the use of the movement button and region it down inside the the front of his door. sprint lower back to your home and watch as your neighbor opens his the the front door, options up the radio, and retreats again inner. you may now input his residence through the the front door. do this approach the use of the back or aspect of the residence as nicely, in case you want to shop for yourself some greater time.",
            "In the pre-alpha version of hiya Neighbor, there was an alarm clock you can locate inside the garbage strewn about your neighbor's lessen. This object has now been moved inner his domestic making this a bit more difficult to gain. The alarm clock is properly worth the danger seeing that it is an object you can re-use and it buys you extra time than all of the different gadgets in the game. you could take hold of the alarm clock internal of his residing room pretty without difficulty, so I propose grabbing it and walking back from your neighbor's domestic earlier than he notices. activate the alarm clock the use of the movement button, but handiest once youíve located the spot youíre going to set it down for the reason that it's going to burst off after a few seconds. attempt putting the alarm clock within the returned of the house as it will buy you even greater time to break in and undergo your neighborís things.",
            "A state-of-the-art object it really is been delivered to the alpha of howdy Neighbor is the cordless phone that now is living inner your bedroom. in case you pick out up this cellular phone and use it, you will discover upon closer research that it calls your neighbor's cellular phone. His smartphone is residing on pinnacle of the cloth cabinet in the hallway of his domestic. capture this cellular phone, area it elsewhere internal his house and phone it the usage of your own cellular telephone to serve as a distraction. The excellent seize with this object is that it simplest works indoors your neighbor's residence so that you should execute warning at the same time as using it.",
            "Inside the alpha of good day Neighbor, you may be aware that you now have get entry to to fuse bins that you can make use of to manipulate the power. The energy switch to your neighbor's domestic may be found all the manner in the returned of his house. notwithstanding the fact that this could now not function an entire lot of a distraction, it'll render the power interior of his domestic unusable.",
            "To your neighbor's kitchen counter you can find a gallon of milk. in case you hold into the rest room and open the medication cupboard, you will find out a bottle of napping drugs. grasp the drugs and head lower returned to the gallon of milk wherein you could contaminate the milk. the subsequent time your neighbor takes a massive swig of clean milk, he is going to be taking quite the prolonged nap. this will provide you with plenty of time to knock some gadgets off that listing from the manual on a way to attain The hello Neighbor finishing.",
    };

    private int[] details = {
            R.drawable.detail_image1,
            R.drawable.detail_image2,
            R.drawable.detail_image3,
            R.drawable.detail_image4,
            R.drawable.detail_image5,
            R.drawable.detail_image6,
    };

    public List<Item> getListGames() {
        List<Item> items = new ArrayList<>();

        for (int i = 0; i < imageIds.length; i++) {
            Item item = new Item(imageIds[i], titles[i], contents[i], details[i]);
            items.add(item);
        }
        return items;
    }

}

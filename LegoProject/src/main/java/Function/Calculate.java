/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.util.HashMap;

/**
 *
 * @author sofieamalielandt
 */
public class Calculate
{

    public HashMap<String, Integer> calcWall(int length, int height)
    {
        HashMap<String, Integer> wall = new HashMap<>();
        int remain = length - 2;
        wall.put("2x4", 0);
        wall.put("2x2", 0);
        wall.put("2x1", 0);
        wall.put("length", length);
        wall.put("height", height);

        if (remain > 4)
        {
            wall.replace("2x4", (((remain - remain % 4) / 4) * height));
            remain = remain % 4;
        }

        if (remain >= 2)
        {
            wall.replace("2x2", (((remain - remain % 2) / 2) * height));
            remain = remain % 2;
        }

        if (remain >= 1)
        {
            wall.replace("2x1", (remain * height));
        }

        return wall;
    }

    public HashMap<String, Integer> calcWallDoor(int length, int height)
    {
        HashMap<String, Integer> wallwithdoor = new HashMap<>();
        HashMap<String, Integer> rest = calcWall(length, height - 4);
        HashMap<String, Integer> door = new HashMap<>();
        //-8 to make room for door (4 dots long 4 bricks tall) and minus -2 for one 2x2 extra
        int remain = length - 8;
        wallwithdoor.put("2x4", 0);
        wallwithdoor.put("2x2", 0);
        wallwithdoor.put("2x1", 0);
        wallwithdoor.put("length", length);
        wallwithdoor.put("height", height);
        
        door.put("2x4", 0);
        door.put("2x2", 0);
        door.put("2x1", 0);

        if (remain > 4)
        {
            door.put("2x4", (((remain - remain % 4) / 4) * 4));
            remain = remain % 4;
        }

        if (remain >= 2)
        {
            door.put("2x2", (((remain - remain % 2) / 2) * 4));
            remain = remain % 2;
        }

        if (remain >= 1)
        {
            door.put("2x1", (remain * 4));
        }

        wallwithdoor.put("2x1", rest.get("2x1") + door.get("2x1"));
        wallwithdoor.put("2x2", rest.get("2x2") + (door.get("2x2") + 4));//+1 extra 2x2 for each row in the door height 4
        wallwithdoor.put("2x4", rest.get("2x4") + door.get("2x4"));

        return wallwithdoor;
    }

    public HashMap<String, Integer> calcWallWindow(int length, int height)
    {
        HashMap<String, Integer> wallwithwindow = new HashMap<>();
        HashMap<String, Integer> rest = calcWall(length, height - 2);
        HashMap<String, Integer> window = new HashMap<>();
        
        //-8 to make room for door (4 dots long 2 bricks tall) and minus -2 for one 2x2 extra
        int remain = length - 8;
        wallwithwindow.put("2x4", 0);
        wallwithwindow.put("2x2", 0);
        wallwithwindow.put("2x1", 0);
        wallwithwindow.put("length", length);
        wallwithwindow.put("height", height);
        
        window.put("2x4", 0);
        window.put("2x2", 0);
        window.put("2x1", 0);

        if (remain >= 4)
        {
            window.replace("2x4", (((remain - remain % 4) / 4) * 2));
            remain = remain % 4;
        }

        if (remain >= 2)
        {
            window.replace("2x2", (((remain - remain % 2) / 2) * 2)); //+1 the extra 2x2
            remain = remain % 2;
        }

        if (remain >= 1)
        {
            window.replace("2x1", (remain * 2));
        }

        wallwithwindow.put("2x1", rest.get("2x1") + window.get("2x1"));
        wallwithwindow.put("2x2", rest.get("2x2") + (window.get("2x2") + 2));//+1 extra 2x2 for each row in the window height 2
        wallwithwindow.put("2x4", rest.get("2x4") + window.get("2x4"));

        return wallwithwindow;
    }

    public HashMap<String, Integer> calcHouse(HashMap<String, Integer> wall1, HashMap<String, Integer> wall2, HashMap<String, Integer> wallwithdoor, HashMap<String, Integer> wallwithwindow)
    {
        HashMap<String, Integer> legohouse = new HashMap<>();

        legohouse.put("2x1", wall1.get("2x1") + wall2.get("2x1") + wallwithdoor.get("2x1") + wallwithwindow.get("2x1"));
        legohouse.put("2x2", wall1.get("2x2") + wall2.get("2x2") + wallwithdoor.get("2x2") + wallwithwindow.get("2x1"));
        legohouse.put("2x4", wall1.get("2x4") + wall2.get("2x4") + wallwithdoor.get("2x4") + wallwithwindow.get("2x4"));

        return legohouse;
    }
}

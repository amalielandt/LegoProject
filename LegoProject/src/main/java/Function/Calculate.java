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

    public HashMap<String, Integer> calcHouse( HashMap<String, Integer> wall1, HashMap<String, Integer> wall2)
    {
        HashMap<String, Integer> legohouse = new HashMap<>();


            legohouse.put("2x1", (wall1.get("2x1") * 2) + (wall2.get("2x1") * 2));
            legohouse.put("2x2", (wall1.get("2x2") * 2) + (wall2.get("2x2") * 2));
            legohouse.put("2x4", (wall1.get("2x4") * 2) + (wall2.get("2x4") * 2));

            return legohouse;
    }
}

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
public class ItemList
{
    private HashMap<String, Integer> legohouse;
    private HashMap<String, Integer> wall1;
    private HashMap<String, Integer> wall2;
    private HashMap<String, Integer> wallwithdoor;
    private HashMap<String, Integer> wallwithwindow;

    public ItemList(HashMap<String, Integer> legohouse, HashMap<String, Integer> wall1, HashMap<String, Integer> wall2, HashMap<String, Integer> wallwithdoor, HashMap<String, Integer> wallwithwindow)
    {
        this.legohouse = legohouse;
        this.wall1 = wall1;
        this.wall2 = wall2;
        this.wallwithdoor = wallwithdoor;
        this.wallwithwindow = wallwithwindow;
    }

    public HashMap<String, Integer> getLegohouse()
    {
        return legohouse;
    }

    public HashMap<String, Integer> getWall1()
    {
        return wall1;
    }
    
    public HashMap<String, Integer> getWall2()
    {
        return wall2;
    }

    public HashMap<String, Integer> getWallwithdoor()
    {
        return wallwithdoor;
    }

    public HashMap<String, Integer> getWallwithwindow()
    {
        return wallwithwindow;
    }
    
}

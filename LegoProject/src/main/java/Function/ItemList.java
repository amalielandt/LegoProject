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

    public ItemList(HashMap<String, Integer> legohouse)
    {
        this.legohouse = legohouse;
    }

    public HashMap<String, Integer> getLegohouse()
    {
        return legohouse;
    }

    public int get2x4()
    {
        return legohouse.get("2x4");
    }

    public int get2x2()
    {
        return legohouse.get("2x2");
    }

    public int get2x1()
    {
        return legohouse.get("2x1");
    }
    
}

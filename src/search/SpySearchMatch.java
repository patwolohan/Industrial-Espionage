/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import buildData.Build;
import buildData.SpyDataStore;

/**
 *
 * @author Pat Wolohan & Eanna Ryan
 */
public interface SpySearchMatch {

    /**
     *
     * @param b Build class object
     * @param s SpyDataStore class object
     */
    public void spySearchMatch(Build b, SpyDataStore s);
}

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
public interface SpySuspectMatch {

    /**
     *
     * @param b b Build class object
     * @param s b SpyDataStore class object
     */
    public void spySuspectMatch(Build b, SpyDataStore s);
}

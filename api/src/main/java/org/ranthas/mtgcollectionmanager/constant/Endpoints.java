package org.ranthas.mtgcollectionmanager.constant;

public class Endpoints {
    public static final String SETS = "/sets";
    public static final String SET_BY_CODE = SETS + "/{code}";
    public static final String SET_CARDS = SET_BY_CODE + "/cards";
    public static final String SET_STATS = SET_BY_CODE + "/stats";
    public static final String SET_CARD = SET_CARDS + "/{slug}";
}

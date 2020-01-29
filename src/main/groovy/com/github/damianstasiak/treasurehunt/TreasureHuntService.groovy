package com.github.damianstasiak.treasurehunt

interface TreasureHuntService {
    List<String> getPathToTreasure(String input, String startCoordinates)
}
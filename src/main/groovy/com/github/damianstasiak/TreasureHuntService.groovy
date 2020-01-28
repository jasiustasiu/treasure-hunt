package com.github.damianstasiak

interface TreasureHuntService {
    List<String> getPathToTreasure(String input, int startRow, int startColumn)
}
//
//  EmojiMemoryGame.swift
//  Memorise
//
//  Created by Yixuan Dai on 18/03/2024.
//

import SwiftUI

func createCardContent(forPairAtIndex index: Int) -> String {
    ["😅", "🥲", "🤡", "🐮", "✅", "👋", "🙂", "😇"][index]
}

class EmojiMemoryGame: ObservableObject {
    private static let emojis = ["😅", "🥲", "🤡", "🐮", "✅", "👋", "🙂", "😇"]
    
    @Published private var model = MemoryGame<String>(numberOfPairsOfCards: 4) { pairIndex in
        if emojis.indices.contains([pairIndex]) {
            return emojis[pairIndex]
        } else {
            return "❗️"
        }
    }
    
    var cards: Array<MemoryGame<String>.Card> {
        return model.cards
    }
    
    // MARK: - Intents
    
    func shuffle() {
        model.shuffle()
    }
    
    func choose(_ card: MemoryGame<String>.Card) {
        model.choose(card)
    }
}

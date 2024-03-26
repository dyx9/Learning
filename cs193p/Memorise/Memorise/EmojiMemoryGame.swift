//
//  EmojiMemoryGame.swift
//  Memorise
//
//  Created by Yixuan Dai on 18/03/2024.
//

import SwiftUI



class EmojiMemoryGame: ObservableObject {
    typealias Card = MemoryGame<String>.Card
    private static let emojis =
        ["😅", "🥲", "🤡", "🐮", "✅", "👋", "🙂", "😇", "🧐", "😵", "😟", "😍"]
    
    @Published private var model = MemoryGame<String>(numberOfPairsOfCards: 2) { pairIndex in
        if emojis.indices.contains([pairIndex]) {
            return emojis[pairIndex]
        } else {
            return "❗️"
        }
    }
    
    var cards: Array<Card> {
        model.cards
    }
    
    var color: Color {
        .orange
    }
    
    // MARK: - Intents
    
    func shuffle() {
        model.shuffle()
    }
    
    func choose(_ card: Card) {
        model.choose(card)
    }
}

//
//  EmojiArt.swift
//  EmojiArt
//
//  Created by Yixuan Dai on 27/03/2024.
//

import Foundation

struct EmojiArt {
    var background: URL?
    var emojis = [Emoji]()
    
    struct Emoji {
        let string: String
        var position: Position
        var size: Int
        
        struct Position {
            var x: Int
            var y: Int
        }
    }
}

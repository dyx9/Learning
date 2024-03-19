//
//  MemoriseApp.swift
//  Memorise
//
//  Created by Yixuan Dai on 18/03/2024.
//

import SwiftUI

@main
struct MemoriseApp: App {
    @StateObject var game = EmojiMemoryGame()
    
    var body: some Scene {
        WindowGroup {
            EmojiMemoryView(viewModel: game)
        }
    }
}

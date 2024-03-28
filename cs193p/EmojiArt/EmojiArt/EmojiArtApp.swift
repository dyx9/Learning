//
//  EmojiArtApp.swift
//  EmojiArt
//
//  Created by Yixuan Dai on 27/03/2024.
//

import SwiftUI

@main
struct EmojiArtApp: App {
    @StateObject var defaultDocument = EmojiArtDocument()
    
    var body: some Scene {
        WindowGroup {
            EmojiArtDocumentView(document: defaultDocument)
        }
    }
}

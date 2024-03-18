//
//  ContentView.swift
//  Memorise
//
//  Created by Yixuan Dai on 18/03/2024.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        HStack {
            CardView(isFaceUp: true)
            CardView()
            CardView()
            CardView()
        }
        .foregroundStyle(.orange)
        .padding()
    }
}

struct CardView: View {
    var isFaceUp: Bool = false
    
    var body: some View {
        ZStack {
            if isFaceUp {
                RoundedRectangle(cornerRadius: 25.0)
                    .foregroundColor(.white)
                RoundedRectangle(cornerRadius: 25.0)
                    .strokeBorder(lineWidth: 2)
                Text("🤡").font(.largeTitle)
            } else {
                RoundedRectangle(cornerRadius: 25.0)
            }
        }
    }
}


#Preview {
    ContentView()
}
